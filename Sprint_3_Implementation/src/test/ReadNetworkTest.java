package io.github.usafa_compsci350;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class ReadNetworkTest {

  public ReadNetworkTest() {
    fileBrowse();
    assignConnections();
  }

  @Test
  void fileBrowse() {
    //Will create a blank object
    Object object = null;
    try {
      //Will get a file
      ReadNetwork networkReader = new ReadNetwork();
      networkReader.fileBrowse();
      //Will set the file to a path
      object = networkReader.getPath();
    } catch (Exception e) {
      //Error occurred assert an error.
      assert (false);
    }
    //Make sure that something is in the object.
    assert (object != null);
    //object must be the path, which is an instance of String.
    assert (object instanceof String);
  }

  @Test
  void assignConnections() {
    String path = "testFiles/colorado_network.txt";
    ArrayList<CityInfo> cities = new ArrayList<CityInfo>();
    try {
      ReadCity cityReader = new
          ReadCity("testFiles/colorado_cities.xlsx");
      cities = cityReader.readFileInfo();
      //ASSIGNS CONNECTIONS INSIDE OF CONSTRUCTOR!!!
      //This is where assignConnections() is called.
      new ReadNetwork(cities, path);
    } catch (Exception e) {
      //Error occurred
      assert (false);
    }
    String string1 = "Colorado Springs,Vail,";
    String string2 = "Denver,Vail,Pueblo,";
    String string3 = "Colorado Springs,";
    String string4 = "Denver,Colorado Springs,Aspen,";
    String string5 = "Vail,";
    assert (string1.equals(cities.get(0).printRelationshipList()));
    assert (string2.equals(cities.get(1).printRelationshipList()));
    assert (string3.equals(cities.get(2).printRelationshipList()));
    assert (string4.equals(cities.get(3).printRelationshipList()));
    assert (string5.equals(cities.get(4).printRelationshipList()));
  }
}