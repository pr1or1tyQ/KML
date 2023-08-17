============================================
File Parsing and File Writing Functionality
============================================
The purpose of this software system is to combine unclassified
information about a country’s cities with classified information about
telecommunications links between the cities. This will produce a
graphical representation of the country’s telecommunication
infrastructure that can be viewed in map software such as Google Earth.
The goal of this sprint is to add functionality to parse Excel and text
files containing City information and Network information respectively.
Further, the GUI and logging functionality will be updated to
accommodate for the updated file parsing functions. This Sprint does
not include the functionality of generating the KML file.


Problem Description
===========================
The user will provide a text file containing network connections and an
excel file containing cities with latitudes and longitudes. The program
needs to be able to understand the information contained in the files
to create City objects with proper Network associations.
For this sprint, “ReadCityInfo” and “ReadNetworkInfo” classes will be
fully implemented to parse user input files and store data. Proper
error and logging handling will be used for all added functionalities.
The GUI will be updated to simplify KML generator workflow. The program
will prevent the used from skipping steps or inputting invalid files.
Lastly, we will create documentation for using the program such as
a “ReadMe” file.


Requirements
--------------------
Functional Requirements (Listed in order of priority):

- Shall have a City class with attributes: latitude, longitude, and an
  arrayList of connected cities

- Shall implement “Read City Info” and “Read Network Info” to open file
  selected by user using the file browser (previously implemented).

- Shall Open and Parse each line of an excel (.xlsx) file: each line
  contains the city name, longitude, and latitude which will be used to
  create a city class and define attributes.

- Shall read in a Network text (.txt) file and parse city relation
  information, and then update the related City attributes with
  relationships.

- Shall use correct error handling to display all errors associated with
  parsing files.

- Shall store network associations in an arrayList  such that each City
  object has a connectedCities attribute containing all connected
  cities.

- Shall update logging information for each action to include reading
  Network/City file, storing information in associated attributes

- Shall update GUI once City Info and Network Files have been parsed and
  information stored in associated attributes. Parsed file name will be
  stored under the associated “Read City Info” and “Read Network Info”
  buttons.

- Shall prevent user from clicking "Read Network Info" button until
  after City information has been correctly parsed.

- Shall prevent user from clicking “Generate KML” button until after city
  and network files have been successfully parsed.

- Shall create a checkbox JOption Pane that displays all available cities
  when “Generate KML” is clicked. User can select which cities to
  include in the Network map KML file. Default case includes all
  cities.


Non-Functional Requirements:
------------------------------
- Shall follow proper java coding standards

- Shall wrap 80 characters

- Tabs shall be equal to two spaces

- Shall include proper whitespace after operators and no whitespace at
  the end of lines

- Program(s) shall not proceed until files are correctly parsed


Use Cases
-----------------
- Actor: The DSA agent

Main Success Scenario:
-------------------------
- To start the KML generator program with intro screen

- To have a display that shows all functionality of the KML generator
  (read city info, read network info, and generate KML buttons)

- log every action that is taken by program and user into a file and
  console

- Click read city info button to import the file with city
  information

- Store all information from file selected for read city into City
  object and update object attributes;

- Click read city info button to import the file with city
  information (must be done after city info parsed)

- Store all information from file selected in network info into Network
  object and update object attributes.

- After City and Network file parsed successfully, the generate KML file
  button will change colors

- User will press the KML button and pop up will display each city with
  a check box next to it. The user can uncheck the cities they do
  not wish to add/see in the network map.

- Trigger: User starts the program

- Preconditions: Must have a city information and network file ready
  for importing.

- Guarantees: Actions will be logged and file data will be properly
  stored in City Class.


Extensions:
------------

- Improper file selected; User is prompted to select new file again.

- Errors with file parsing will be displayed in log and passed to the
  user. User will be prompted to select new file for parsing.

- Player clicks the exit button on window; Program shall close.

- User will only be able to minimize window, close window, and select
  given buttons.

- User exits out of select cities pop-up screen, will select all cities
  by default to be included in the network map

- In the event of GUI failure, program will exit with error code.


Proposed Change
===================
- The above requirements will be met by the software system utilizing
  the below techniques:

Classes:
-----------

- We will use the following classes for implementation:

- App – will be main control of the program, calls all associated
  functions and controls program flow

- ReadCity – parses city information for specified file, opens file
  browser and allows user to specify city information file

- ReadNetwork – parses network information, opens file browser and
  allows user to specify network file

- Windows - will open main GUI windows and display buttons

- AppTest - will test main control

- LogFunction – will record all actions taken in program

- Cities – will store information on entered cities to include their
  network interconnections


Data Structure:
-----------------

- We will use the ArrayList data structure in this sprint to store city
  information to include their connections to other cities.


Algorithms:
-------------

- We will rely on standard Java File I/O algorithms to complete this
  sprint.

- Apache POI algorithm will be used for parsing excel binary formatted
  files.


Alternatives
----------------

Drop down menu could be used instead of file browsers, but the file
browser is more user friendly. Other languages could also be
considered, but Java best supports the capabilities of the design
Team.

Have user manually enter city and network information (not very user
friendly or efficient).


Testing
==========

As this sprint focuses on File I/O and specifically parsing, testing
will be conducted by comparing the generated ArrayLists  to predefined
ArrayLists. Asserting that the generated ArrayLists are equal to our
predefined ArrayLists, we can confirm that our File I/O and parsing
works as desired.
JUnit testing cannot be used for a GUI, but individual method
functionality tests will be performed with automated JUnit testing.


Documentation
==============

Use comments in accordance with Java coding standards.
Create a document (such as README) showing
how to interact with GUI features and select files.


Implementation
=================

Work Items
------------

The file parsing functionality will be developed using agile
development.

Implementation 2
-----------------
Completed by 19 October

- Creation and implementation of parseExcel and parseTxt functions

- Update GUI functionality to store selection of files

- Update logging function functionality to reflect selection of files

- Creation and implementation of City Class (to include ArrayList) to
  store city and network information

References
===========
None
