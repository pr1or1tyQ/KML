package io.github.usafa_compsci350;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * KmlWindow - creates introduction window GUI.
 *
 * @author Group 3
 */
public class KmlWindow {
  private JTextField fileName;
  private JList cityList;
  private JLabel fileNameLabel;
  private JLabel cityListLabel;
  private JPanel kmlPanel;
  private JButton selectCities;
  private JFrame frame;
  ArrayList<CityInfo> cityInfo;
  ArrayList<String> selectedCities;
  /**
   * KMLWindow - constructor that will set up the KML Window
   * @param cityInfo - the list of cities that can be used to make kml
   * @throws Exception
   */
  public KmlWindow(ArrayList<CityInfo> cityInfo) throws Exception{
    this.cityInfo = cityInfo;
    selectedCities = new ArrayList<String>();
    updateList();
    selectCities.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        try {
          updateCityConnections();  //update city connections based on selected
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null,
                  e.getMessage() + "\n Press Ok to close window",
                  "ERROR WITH GENERATE KML FILE",
                  JOptionPane.ERROR_MESSAGE);
          App.log.writeToLog("ERROR: " + e.getMessage());
        }
        GenerateKml kmlFile = null;
        try {
          kmlFile = new GenerateKml(cityInfo);  //generates the KML file
          String path = kmlFile.generateKml(fileName.getText());
          JOptionPane.showMessageDialog(null, "KML file created at: "
                  + path, "KML GENERATOR",
                  JOptionPane.INFORMATION_MESSAGE);
          System.exit(0);
        } catch (Exception error) {
          JOptionPane.showMessageDialog(null,
              error.getMessage() + "\n Press Ok to close the window",
              "ERROR WITH KML GENERATOR",
              JOptionPane.ERROR_MESSAGE);
          App.log.writeToLog("ERROR: " + error.getMessage());
        }
      }
    });
  }

  /**
   * openWindow - will open the KmlWindow GUI and set the JFrame
   */
  public void openWindow() {
    frame = new JFrame("City Selector");
    try {
      frame.setContentPane(new KmlWindow(cityInfo).kmlPanel);
    }catch(Exception e){
      JOptionPane.showMessageDialog(null,
              e.getMessage() + "\n Press Ok to close the program",
              "ERROR WITH KML GENERATOR",
              JOptionPane.ERROR_MESSAGE);
      App.log.writeToLog("ERROR: " + e.getMessage());
      System.exit(1);
    }
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    frame.setSize(250, 300);
  }

  /**
   * updateList() - Will add all cities from cityInfo into the Jlist and make all cities selected.
   */
  private void updateList() {
    DefaultListModel listModel = new DefaultListModel();
    for(int i = 0; i < cityInfo.size(); i++){
      listModel.addElement(cityInfo.get(i).getCityName());
    }
    cityList.setModel(listModel);
    //list.setSelectionInterval(begn, end);
    //Selects all the items first.
    cityList.setSelectionInterval(0, listModel.size()-1);
    cityList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    cityList.setLayoutOrientation(JList.VERTICAL);
  }

  /**
   * updateCityConnections() - Will update cityInfo to by removing connections
   * and cities that were not selected in the JList
   */
  private void updateCityConnections() throws Exception{
    List list = cityList.getSelectedValuesList();
    if(list == null || list.size() == 0){
      throw new Exception("ERROR: You didn't select a city!");
    }
    ArrayList<CityInfo> tempList = cityInfo;
    //Set the selectedCities with the names of the items selected
    for(int i = 0; i < list.size(); i++){
      selectedCities.add(list.get(i).toString());
      //System.out.println(selectedCities.get(i));
    }
    //Need to find all cities to remove
    ArrayList<CityInfo> citiesToRemove = new ArrayList<CityInfo>();
    Boolean isSelected = false;
    for(int i = 0; i < tempList.size(); i++){
      isSelected = false;
      for(int j = 0; j < selectedCities.size(); j++){
        //The city that will be checked if selected
        String currCity = tempList.get(i).getCityName();
        //The city that has been selected (and will be iterated through)
        String currSelectedCity = selectedCities.get(j);
        if(currCity.equalsIgnoreCase(currSelectedCity)){
          isSelected = true;
        }
      }
      if(!isSelected){
        citiesToRemove.add(tempList.get(i));
      }
    }
    //Will remove all cities that need to be removed.
    for(CityInfo city: citiesToRemove){
      tempList.remove(city);
    }
    //Will remove connection to cities not selected
    isSelected = false;
    //Will iterate through all cities that have been selected
    for(int i = 0; i < tempList.size(); i++){
      //The connections the currCity has
      ArrayList<String> connections = tempList.get(i).getCityRelationList();
      //A storage space for connections that will not be needed
      ArrayList<String> itemsToRemove = new ArrayList<String>();
      //Double loop that will find connections that are not needed
      for(String connectedCity: connections){
        isSelected = false;
        for(String selectCity: selectedCities){
          if(connectedCity.equalsIgnoreCase(selectCity)){
            isSelected = true;
          }
        }
        //Will add the not needed connection to remove array list
        if(!isSelected){
          itemsToRemove.add(connectedCity);
        }
      }
      //Remove all strings not connected to
      for(String removeItem: itemsToRemove){
        connections.remove(removeItem);
      }
    }
    //CAN BE USED TO SEE WHAT CONNECTIONS ARE LEFT!!!
    /*
    System.out.println("TEMPLIST STUFF!!!!");
    for(int i = 0; i < tempList.size(); i++){
      System.out.println(tempList.get(i));
    }
    */
  }
  {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
    $$$setupUI$$$();
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    kmlPanel = new JPanel();
    kmlPanel.setLayout(
        new GridLayoutManager(8, 3, new Insets(0, 0, 0, 0), -1, -1));
    fileName = new JTextField();
    kmlPanel.add(fileName,
        new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1),
            null, 0, false));
    cityList = new JList();
    kmlPanel.add(cityList,
        new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50),
            null, 0, false));
    cityListLabel = new JLabel();
    cityListLabel.setText("Select Cities to Include:");
    kmlPanel.add(cityListLabel,
        new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED,
            GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    fileNameLabel = new JLabel();
    fileNameLabel.setText("Input File Name:");
    kmlPanel.add(fileNameLabel,
        new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED,
            GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final Spacer spacer1 = new Spacer();
    kmlPanel.add(spacer1,
        new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0,
            false));
    final Spacer spacer2 = new Spacer();
    kmlPanel.add(spacer2,
        new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0,
            false));
    final Spacer spacer3 = new Spacer();
    kmlPanel.add(spacer3,
        new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_VERTICAL, 1,
            GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    final Spacer spacer4 = new Spacer();
    kmlPanel.add(spacer4,
        new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_VERTICAL, 1,
            GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    final Spacer spacer5 = new Spacer();
    kmlPanel.add(spacer5,
        new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_VERTICAL, 1,
            GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    selectCities = new JButton();
    selectCities.setText("Proceed");
    kmlPanel.add(selectCities,
        new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_CAN_SHRINK |
                GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return kmlPanel;
  }

}

