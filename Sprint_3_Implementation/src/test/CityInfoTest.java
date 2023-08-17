package io.github.usafa_compsci350;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityInfoTest {

  public CityInfoTest() {
    testToString();
  }

  @Test
  void testToString() {
    CityInfo testCityInfo = new CityInfo("Test City",
        10, 123.45, 123.45);

    String testString = testCityInfo.toString();
    String correctString =
        "City Name: Test City\n\tCity Population: 10\n\tCity Longitude:"
                + " 123.45\n\tCity Latitude: 123.45\n\trelationship list: NONE";

    assertEquals(testString, correctString);
  }
}