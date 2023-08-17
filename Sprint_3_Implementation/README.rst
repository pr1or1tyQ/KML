======================
Customer Instructions
======================
Quick Start:
 1. Run App.java
 2. Click “OK” button on Intro Window.
 3. Click “Open File” button on the Main Window and select
    .xlsx file.
 4. Click the next “Open File” button on the Main Window
    and select .txt file.
 5. Click the “Generate KML” button on the Main Window.
 6. Enter a name for the KML file in the City Selector window.
 7. Select the cities to include in the KML file in the City
    Selector window (All cities selected by default).
 8. Click “Proceed” to generate the KML file.
 9. Popup displays the location of the saved KML file.

In Depth Instructions:
 The main functionality is initiated from the App.java class.
 After running the main mehtod from within this class, the
 introduction window will open to the screen. Click “OK” to
 proceed or the traditional “X” in the top-right hand corner
 should you wish to end the program at any time.

 After clicking “OK” on the introduction window, that window
 will close and the Main Window that houses the file selection
 will open. The only functionality that is initially enabled is
 the open file button for reading city information. Click “Open
 File” and you will be directed to a traditional JFileChooser.
 For city information, you will only be able to select an XLSX
 file. Select the desired file and click “Open” to proceed.

 After selecting the file of city information, the next procedure
 will be file selection for reading network information. Once again,
 click “Open File” and you will be directed to a traditional
 JFileChooser. For network information, you will only be able to
 select a TXT file. Select the desired file and click “Open”
 to proceed.

 If at any point during file selection an error occurs (incorrect
 file type, etc.), the user will be alerted of the error and the
 program will close. Restart with the App.main() call.

 Once both files have been properly selected, the “Generate KML"
 button is enabled for the user. Select this button and proceed
 to the City Selector window. This window allows the user to select
 which cities should be included in the generated KML file. All
 cities will be selected by default, so deselect any cities that
 you do not want to include. Before clicking proceed, enter a file
 name to which the KML will be saved.

 Upon successful generation, the user will be alerted via the KML
 Generator window. This alert informs the user to where the KML file
 has been saved. Click “OK” to proceed.

 The program will close and the generated KML file can be opened
 with Google Earth.


========
Scenario
========

Create software to take information on a country’s cities and on the 
telecommunications links between them, and produce a Google Earth 
representation of the country’s telecommunication infrastructure.

Information Workflow
====================

The information workflow of your system consists of two inputs and two outputs.
The inputs consist of an Excel spreadsheet with the name, population, latitude,
and longitude for each city and a text file identifying the telecommunication
links from each city to the other cities to which they are connected. The
outputs include a KML (Keyhole Markup Language) file that describes the cities
and the links between them and a log file that documents the key steps
performed by your program and any problems that arose. The KML file can be fed
to Google Earth which will then show the cities and links. Figure 1 below
illustrates the flow of data. Note that the KML file can be opened in Google
Earth, and it will render your placemarks for the cities and links between them
.

Initial Requirements
=========================

Create software capable of five initial capabilities:
- A graphical user interface (GUI).
- A logging mechanism.
- The ability to read in city information, 'Read City Info'.
- The ability to read in network graph information, Read Network.
- Generate KML file for use with Google Earth, 'Generate KML'.


Graphical User Interface
========================

The GUI orchestrates the user operation and interaction. It should display and
log an introduction. It must be able to call 'Read City Info' to read the city
information into memory, call 'Read Network' to read in the network graph
information, and call 'Generate KML' to produce the KML output, which will be
rendered via Google Earth.

Log
===

The logging capability takes in a message, writes that message to a log file,
and displays the message to the console. All entries must include a date/time
stamp. All actions the software takes must be logged.

Read City Info
==============

The city data is read in from the city information worksheet and stored in
memory in an appropriate data structure. Ensure to check data for consistency,
the city names are strings and population, latitude, and longitude are numeric,
and log any errors found.

Read Network
============

Read in information on how cities are interconnected via the text file
identifying the telecommunication links. Use ‘:’ as a delimiter string to pull
out the initial city name, then use ‘,’ as a second delimiter to parse the
resulting cities as each line in the file has a source city followed by a colon
(:) and then the names of each destination city it is connected to, separated
by commas. If a city occurs in this file that was not specified in the cities
info, an error needs to be logged.

Authors
=======
- Quinn Henry
- Finn Westenfelder
- Alex Bach
- Matt Dickerman
