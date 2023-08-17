package io.github.usafa_compsci350;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Generate_KML - KML File Generation based on City and Network Info.
 *
 * @author Group 3
 */
public class GenerateKml {
    private ArrayList<CityInfo> cityInfo;
    private FileWriter writer;
    public GenerateKml(ArrayList<CityInfo> cityInfo) throws Exception{
        this.cityInfo = cityInfo;
        try {
            this.writer = new FileWriter("testColorado.kml", false);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * generateKml() - Will write the information from cityInfo into a kml format
     * testColorado.kml will be created if it doesn't exist.
     * @param filename the name of the file that will be created
     * @return The String path of the file that was created
     */
    public String generateKml(String filename) throws Exception{
        if(filename.isEmpty()){
            throw new Exception("ERROR: filename is empty");
        }
        // opens up file to testColorado.kml
        File file = new File(filename + ".kml");
        try {
            this.writer = new FileWriter(filename + ".kml", false);
            // Will check to see if file exist (will create if not)
            newFileCreation(file);
            //Start of the KML generation.
            writer.write("<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document>\n");
            //Creates the cities in the KML file
            for(int i = 0; i < cityInfo.size(); i++){
                String name = cityInfo.get(i).getCityName();
                Double longitude = cityInfo.get(i).getCityLongitude();
                Double latitude = cityInfo.get(i).getCityLatitude();
                int population = cityInfo.get(i).getCityPopulation();
                writer.write("<Placemark>\n");
                writer.write("<name>" + name + "</name>\n");
                writer.write("<description>" + name + " - Population:     " + population + "</description>\n");
                writer.write("<Point><coordinates>");
                writer.write(latitude + "," + longitude);
                writer.write("</coordinates></Point>\n");
                writer.write("</Placemark>\n");
            }
            //Will set the coordinates/altitude of the city, will set the cities connections
            for(int i = 0; i < cityInfo.size(); i++){
                int sizeConnections = cityInfo.get(i).getCityRelationList().size();
                ArrayList<String> connections = cityInfo.get(i).getCityRelationList();
                for(int j = 0; j < sizeConnections; j++) {
                    //Will break if there is no connections
                    if(connections == null || connections.isEmpty()){
                        break;
                    }
                    //Will take the connection (which is a String) and will look through cityInfo ArrayList to find
                    //the CityInfo object that is connected to current city being looked at.
                    CityInfo cityConnected = findCity(connections.get(j));
                    //Find the index of cityConnected in the ArrayList cityInfo
                    //This will make sure that city connections are not double counted.
                    int index = findIndexOfCity(cityConnected);
                    //System.out.println("currCity: " + cityInfo.get(i).getCityName() + ", i: " + i + "|| connCity: " + cityConnected.getCityName() + ", index: " + index);
                    if(index > i) {
                        //Will get current city info
                        Double curLongitude = cityInfo.get(i).getCityLongitude();
                        Double curLatitude = cityInfo.get(i).getCityLatitude();
                        //Will get the connected city's information
                        Double connectedLongitude = cityConnected.getCityLongitude();
                        Double connectedLatitude = cityConnected.getCityLatitude();
                        //Will start the formatting for connections and altitude in KML
                        writer.write("<Placemark>\n");
                        writer.write("<LineString>\n");
                        writer.write("<altitudeMode>clampToGround</altitudeMode>\n");
                        writer.write("<tessellate>1</tessellate>\n");
                        writer.write("<coordinates>\n");
                        //Will get all the connections of the current city and add them to the kml file
                        writer.write(curLatitude + "," + curLongitude + ",0\n");
                        writer.write(connectedLatitude + "," + connectedLongitude + ",0\n");
                        writer.write("</coordinates>\n");
                        writer.write("</LineString>\n");
                        writer.write("</Placemark>\n");
                    }
                }
            }
            //Write the last bits of the file and close it.
            writer.write("</Document>\n");
            writer.write("</kml>\n");
            writer.close();
            // Will write message to the console.
            App.log.writeToLog("KML File generated.");
        } catch (Exception e) {
            // Will print to console the error.
            throw new Exception(e.getMessage());
        }
        return file.getAbsolutePath();
    }

    /**
     * newFileCreation() - Will determine if there is a log.txt file that can be
     * written to. If there is not will create log.txt file. If there is, method
     * will do nothing.
     *
     * @param kmlFile The file that will be created (log.txt).
     */
    private void newFileCreation(File kmlFile) throws Exception {
        // Will check if the file exists already
        if (kmlFile.createNewFile()) {
            App.log.writeToLog("Blank KML File Created");
        }
    }

    /**
     * findCity() - will use a city name to find a cityInfo object from cityInfo arraylist.
     * @param city The name of the city for cityInfo object that will be found.
     * @return the cityInfo object with the name (String) city. OR null if error occured/name not found.
     */
    private CityInfo findCity(String city) throws Exception{
        if(cityInfo == null){
            throw new Exception("findCity error occurred. cityInfo is null.");
        }
        for(int i = 0; i < cityInfo.size(); i++){
            if(cityInfo.get(i).getCityName().equalsIgnoreCase(city)){
                return cityInfo.get(i);
            }
        }
        throw new Exception("findCity error occurred. CityInfo not found.");
    }

    /**
     * findCity() - will find the index of the given city in the cityInfo ArrayList.
     * @param city The object of the city for cityInfo object that will be found.
     * @return the index of the CityInfo object in the ArrayList cityInfo
     */
    private int findIndexOfCity(CityInfo city) throws Exception{
        if(cityInfo == null){
            throw new Exception("findIndexOfCity error occurred. cityInfo is null.");
        }
        for(int i = 0; i < cityInfo.size(); i++){
            if(city.getCityName().equalsIgnoreCase(cityInfo.get(i).getCityName())){
                return i;
            }
        }
        throw new Exception("findIndexOfCity error occurred. CityInfo not found.");
    }
}
