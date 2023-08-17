package io.github.usafa_compsci350;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateKmlTest {

    public GenerateKmlTest(){
        //compare code generate KML to given KML file using same data
        //ensure proper KML generation functionality
        fileCreationTest();
    }

    @Test
    void fileCreationTest(){
        try{

            Path testPath = Paths.get(System.getProperty("user.dir")); //get path for test case files
            Path sourcePath = Paths.get(System.getProperty("user.dir"));


            File testFile = new File("./testKMLFile.kml"); //code generate KML file
            File sourceFile = new File("./sourceKMLFile.kml"); //source provided KML file

            Scanner testFileScanner = new Scanner(testFile);
            Scanner sourceFileScanner = new Scanner(sourceFile);

            while(testFileScanner.hasNextLine()){ //compare each line
                String currTestLine = testFileScanner.nextLine();
                String currSourceLine = sourceFileScanner.nextLine();

                assertEquals(currTestLine, currSourceLine); //fails if not the same
            }

        }
        catch (Exception e){
            assert(false); //test failed
        }
    }


}
