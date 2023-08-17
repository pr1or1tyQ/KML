package io.github.usafa_compsci350;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * Read_Network - Opens and parses network info file.
 *
 * @author Group 3
 */
public class ReadNetwork {
  private ArrayList<CityInfo> cities;
  private String path;
  private String fileName;

  public String getFileName() {
    return fileName;
  }

  /**
   * ReadNetwork - Blank constructor
   */
  public ReadNetwork() {

  }

  public String getPath() {
    return path;
  }

  /**
   * ReadNetwork - constructor with error handling.
   */
  public ReadNetwork(ArrayList<CityInfo> cities) throws Exception {
    fileName = "";
    //Error handling
    if (cities == null) {
      throw new Exception("The cities is null");
    } else if (cities.size() <= 0) {
      throw new Exception("The cities is empty.");
    }

    this.cities = cities;
    //Will find the txt file to read networks from
    fileBrowse();
    //Will read the txt file from path and add connected cities.
    assignConnections();
  }

  public ReadNetwork(ArrayList<CityInfo> cities,
                     String path) throws Exception {
    //Error handling
    if (cities == null) {
      throw new Exception("The cities is null");
    } else if (cities.isEmpty()) {
      throw new Exception("The cities is empty.");
    }
    //Will set the parameters
    this.cities = cities;
    this.path = path;
    //Will read the txt file from path and add connected cities.
    assignConnections();
  }

  /**
   * fileBrowse() - opens the file browser when button clicked in Windows.java.
   */
  public void fileBrowse() {
    // sets browser
    JFileChooser browser = new JFileChooser();

    // set filter for Excel only
    FileNameExtensionFilter filter =
            new FileNameExtensionFilter("Text", "txt");

    // adds filter to browser
    browser.setFileFilter(filter);

    // opens dialogue
    browser.showOpenDialog(null);
    this.path = browser.getSelectedFile()
            .getAbsolutePath(); //get path to selected txt file
    this.fileName = browser.getSelectedFile().getName();
    //System.out.println("Path: " + this.path);
    App.log.writeToLog("Opened Read_Network file browser");
  }

  /**
   * assignConnections - Will read in the .txt file for (this.path)
   * will iterate through every city and add their cities they are connected to
   * NOTE: It does not add the cityInfo object to curr city connection, rather it adds the name
   * (String) to the curr cities ArrayList<String> connections.
   * @throws Exception
   */
  private void assignConnections() throws Exception {
    //Scanner used to parse the data
    Scanner reader = null;
    //Used to grab lines of the txt file
    String line = "";
    //Used as a placeholder for storing city name
    String city = "";
    //Used to as a placeholder for current city index in arraylist
    int cityIndex = 0;
    // File variable is created
    File file = new File(this.path);
    // Creating an object of BuffferedReader class
    BufferedReader buffRead = new BufferedReader(new FileReader(file));
    //Will check if the file is empty
    boolean emptyFile = true;
    // Reads until there is no more data

    while ((line = buffRead.readLine()) != null) {
      emptyFile = false;
      reader = new Scanner(line);
      reader.useDelimiter(":");
      city = reader.next();
      //Find the city and save its index
      boolean cityFound = false;
      for (int i = 0; i < cities.size(); i++) {
        if (city.equalsIgnoreCase(cities.get(i).getCityName())) {
          cityIndex = i;
          cityFound = true;
        }
      }
      if (!cityFound) {
        throw new Exception("Improper file format!!!");
      }
      //Reads through connections, and
      // Adds the connections to the correct city
      reader.useDelimiter(",\0");
      //reader.next().charAt(0);
      //System.out.print("City: " + city + ", Connections: ");
      int x = 0;
      //Will go through the reader (will replace : with ""
      // " because it doesn't delete for some reason)
      while (reader.hasNext()) {
        String nextConnection = reader.next();
        if (x == 0) {
          nextConnection = nextConnection.replace(":", "");
          //System.out.println("Next Connection " + nextConnection);
        }
        //Will split the nextConnections by the commas
        String[] res = nextConnection.split("[,]", 0);
        for(String myStr: res) {
          cities.get(cityIndex).setCityRelation(myStr);
        }
        x++;
      }
      //System.out.println();
      App.log.writeToLog(
              "The connections have been added to the city: " + city);
    }
    if (emptyFile) {
      throw new Exception("The txt file is blank!!!");
    }

    reader.close();
    buffRead.close();
  }
}