package io.github.usafa_compsci350;

import java.util.ArrayList;

/**
 * CityInfo - Creates structure to store information for each city.
 * @author Group 3.
 */
public class CityInfo {

  //City Attributes
  private String cityName;
  private int cityPopulation;
  private double cityLongitude;
  private double cityLatitude;

  //Network Attributes
  private ArrayList<String> relationshipList;

  //constructors

  /**
   * CityInfo() - zero argument constructor.
   */
  public CityInfo() {
    //initialize city attributes
    this.cityName = null;
    this.cityPopulation = 0;
    this.cityLatitude = 0.0;
    this.cityLongitude = 0.0;

    //initialize network attributes
    relationshipList = new ArrayList<String>();
  }

  /**
   * CityInfo() - full constructor.
   */
  public CityInfo(String cityName, int cityPopulation, double cityLatitude,
                  double cityLongitude) {
    this.cityName = cityName;
    this.cityPopulation = cityPopulation;
    this.cityLatitude = cityLatitude;
    this.cityLongitude = cityLongitude;
    this.relationshipList = new ArrayList<String>();
  }

  //Methods

  // getter/setter methods

  /**
   * getCityName will get the curr cities name.
   * @return the city name
   */
  public String getCityName() {
    return this.cityName;
  }

  /**
   * setCityName - will set curr city name
   * @param cityName - the name that the city name will be set to
   */
  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  /**
   * getCityPopulation - will get the curr city population
   * @return will return the curr city population
   */
  public int getCityPopulation() {
    return this.cityPopulation;
  }

  /**
   * setCityPopulation - will set the curr city population
   * @param cityPopulation the int value the population will be set to
   */
  public void setCityPopulation(int cityPopulation) {
    this.cityPopulation = cityPopulation;
  }

  /**
   * getCityLongitude - will return the city longitude
   * @return the city longitude (double)
   */
  public double getCityLongitude() {
    return this.cityLongitude;
  }

  /**
   * setCityLongitude - will set the curr city longitude
   * @param cityLongitude - the double value that the longitude will be set to
   */
  public void setCityLongitude(double cityLongitude) {
    this.cityLongitude = cityLongitude;
  }
  
  public double getCityLatitude() {
    return this.cityLatitude;
  }

  public void setCityLatitude(double cityLatitude) {
    this.cityLatitude = cityLatitude;
  }

  public ArrayList<String> getCityRelationList() {
    return this.relationshipList;
  }

  public void removeItemCityRelationList(int i) {
    this.relationshipList.remove(i);
  }

  public void setCityRelation(String cityNameRelation) {
    this.relationshipList.add(cityNameRelation);
  }

  /**
   * toString() - overwrite toString() to print cityInformation.
   * @return String
   */
  @Override
  public String toString() {
    String cityInformation =
        "City Name: " + this.getCityName() + "\n\tCity Population: "
            + this.getCityPopulation() + "\n\tCity Longitude: "
            + this.getCityLongitude() + "\n\tCity Latitude: "
            + this.getCityLatitude();
    if (relationshipList.isEmpty()) {
      cityInformation = cityInformation + "\n\trelationship list: NONE";
    } else {
      cityInformation = cityInformation + "\n\trelationship list: ";
      for (int i = 0; i < relationshipList.size(); i++) {
        if (i == relationshipList.size() - 1) {
          cityInformation = cityInformation + relationshipList.get(i);
        } else {
          cityInformation = cityInformation + relationshipList.get(i) + ", ";
        }
      }
    }
    return cityInformation;
  }

  /**
   * printRelationshipList() - prints the network of this city.
   * @return String
   */
  public String printRelationshipList() {
    String list = "";
    for (int i = 0; i < relationshipList.size(); i++) {
      if (i == relationshipList.size() - 1) {
        list = list + relationshipList.get(i);
      }
      list = relationshipList.get(i) + ", ";
    }
    return list;
  }

}
