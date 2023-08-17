package io.github.usafa_compsci350;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ReadCityTest {

  public ReadCityTest() {
    fileBrowse();
    readFileInfo();
  }

  @Test
  void fileBrowse() {
    //Will create a blank object
    Object object = null;
    try {
      //Will get a file
      ReadCity cityReader = new ReadCity();
      //Will set the object to a path
      object = cityReader.getPath();
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
  void readFileInfo() {
    ArrayList<CityInfo> cities = new ArrayList<CityInfo>();
    CityInfo testCity = null;
    try {
      ReadCity cityReader = new
          ReadCity("testFiles/colorado_cities.xlsx");
      cities = cityReader.readFileInfo();
      testCity = cities.get(0);
    } catch (Exception e) {
      //Error occurred
      assert (false);
    }
    String testString = testCity.toString();
    String correctString = "City Name: Denver\n"
        + "\tCity Population: 3157520\n"
        + "\tCity Longitude: 39.73912222222222\n"
        + "\tCity Latitude: -104.98465\n"
        + "\trelationship list: NONE";
    assertEquals(testString, correctString);

  }
}