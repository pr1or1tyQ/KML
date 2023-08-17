package io.github.usafa_compsci350;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Read_City - Opens and parses city info file.
 * @author Group 3
 */
public class ReadCity {
  String path; //path to the xcel file
  String fileName;

  public String getFileName() {
    return fileName;
  }

  public ReadCity() throws Exception {
    this.fileName = "";
    String path = fileBrowse();
    this.path = path;
  }

  public ReadCity(String path) {
    this.path = path;
  }

  /**
   * fileBrowse() - opens the file browser when button clicked in Windows.java.
   */
  public String fileBrowse() throws Exception {
    // sets browser
    JFileChooser browser = new JFileChooser();

    // set filter for Excel only
    FileNameExtensionFilter filter =
        new FileNameExtensionFilter("Excel", "xlsx");

    // adds filter to browser
    browser.setFileFilter(filter);

    // opens dialogue
    browser.showOpenDialog(null);
    App.log.writeToLog("Opened Read_City file browser");

    //extract selected file name and file path
    String path = browser.getSelectedFile()
        .getAbsolutePath(); //get path to selected excel file
    String fileName = browser.getSelectedFile().getName();
    this.fileName = fileName;

    //log selected file path and file name
    App.log.writeToLog("Selected File Path: " + path);
    App.log.writeToLog("Select File Name: " + fileName);
    return path;
  }

  /**
   * readFileInfo() - parses specified cityInformation file.
   * @return ArrayList of CityInfo objects containing
    * all parsed city information
   */
  public ArrayList<CityInfo> readFileInfo() throws Exception {
    ArrayList<CityInfo> arrayOfCities =
        new ArrayList<CityInfo>(); //create arrayList to store read cities

    try {

      FileInputStream excelFile = new FileInputStream(
          new File(path)); //give file stream absolute path to file
      Workbook workbook = new XSSFWorkbook(excelFile);
      Sheet datatypeSheet = workbook.getSheetAt(0);
      Iterator<Row> iterator = datatypeSheet.iterator();
      Boolean isHeader = true;
      while (iterator.hasNext()) {

        Row currentRow = iterator.next();
        Iterator<Cell> cellIterator = currentRow.iterator();
        CityInfo cityInfo =
            new CityInfo();
        //instantiate new CityInfo object to store parsed info
        int currentCellLocation =
            0; //0-3 cells per row in proper formatted file
        if (!isHeader) {
          while (cellIterator.hasNext()) {

            Cell currentCell = cellIterator.next();
            switch (currentCellLocation) {
              case 0: //first cell is City Name
                if (currentCell.getCellType() == CellType.STRING) {
                  cityInfo.setCityName(
                      currentCell.getStringCellValue());
                  //set cityName with first string
                } else {
                  App.log.writeToLog(
                      "Error: Invalid City Information -"
                          + "First Cell should be city name");
                  throw new Exception(
                      "Invalid City Information - First"
                          + " Cell should be city name");
                }
                break;

              case 1:
                if (currentCell.getCellType() == CellType.NUMERIC) {
                  int currentValInt = (int) currentCell.getNumericCellValue();
                  cityInfo.setCityPopulation(currentValInt); //set population
                } else {
                  App.log.writeToLog(
                      "Error: Invalid City Information -"
                          + "Second Cell should be city population");
                  throw new Exception(
                      "Invalid City Information - Second Cell"
                          + " should be city population");
                }
                break;

              case 2:
                if (currentCell.getCellType() == CellType.NUMERIC) {
                  cityInfo.setCityLongitude(
                      currentCell.getNumericCellValue()); //set longitude
                } else {
                  App.log.writeToLog(
                      "Error: Invalid City Information - "
                          + "Third Cell should be city longitude");
                  throw new Exception(
                      "Invalid City Information - Third Cell"
                          + " should be city longitude");
                }
                break;

              case 3:
                if (currentCell.getCellType() == CellType.NUMERIC) {
                  cityInfo.setCityLatitude(
                      currentCell.getNumericCellValue()); //set latitude
                } else {
                  App.log.writeToLog(
                      "Error: Invalid City Information - "
                          + "Fourth Cell should be city latitude");
                  throw new Exception(
                      "Invalid City Information - Fourth Cell"
                          + "should be city latitude");
                }
                break;

              default:
                break;
            }
            currentCellLocation++; //increment to next cell
          }
          //row has been read
          arrayOfCities.add(cityInfo); //add row (city) to arrayList
        } else {
          isHeader = false;
        }
      }
      //close fileStream
      excelFile.close();
    } catch (FileNotFoundException e) { //error handling
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


    App.log.writeToLog("Excel File Parsing Complete");

    return arrayOfCities; //return array containing all city info

  }


  public String getPath() {
    return path;
  }
}
