====================
KML File Generation
====================
The purpose of this software system is to combine unclassified
information about a country’s cities with classified information about
telecommunications links between the cities. This will produce a
graphical representation of the country’s telecommunication
infrastructure that can be viewed in map software such as Google Earth.
The goal of this sprint is to add functionality to generate a KML file
continaing a visual representation of the City information and
Network information. Further, the GUI and logging functionality will
be updated to accommodate the KML file generation. This is the final
project Sprint.


Problem Description
===========================
The user will provide a text file containing network connections and an
excel file containing cities with latitudes and longitudes. After
parsing this information, the program needs to generate a KML to allow
users to view a visual representation of the city and network data.
For this sprint, the "GenerateKml" class will be fully implemented to
generate a KML file from previously parsed data. The user will be able
to select which cities they want in the generated KML file. Proper error
and logging handling will be used for all added functionalities.
The GUI will be updated to simplify the KML generator workflow. The
program will prevent the used from skipping steps or inputting invalid
files. Lastly, we will update documentation for using the program in
the “ReadMe” file.


Requirements
--------------------
Functional Requirements (Listed in order of priority):

- Shall prevent user from clicking “Generate KML” button until after city
  and network files have been successfully parsed.

- Shall create a checkbox JOption Pane that displays all available cities
  when “Generate KML” is clicked. User can select which cities to
  include in the Network map KML file. Default case includes all
  cities.

- Shall generate KML file after user confirms city selection

- Shall display popup with the location of the KML file after
  successful generation.

- Shall use correct error handling to display all errors associated with
  KML generation.

- Shall update logging information for each action involved in KML
  file generation.


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
  button will be clickable

- User will press the KML button and pop up will display each city with
  a check box next to it. The user can uncheck the cities they do
  not wish to add/see in the network map.

- KML file is generated and saved to user's filesystem.

- Trigger: User starts the program, inputs data, and generates KML

- Preconditions: Must have a city information and network file ready
  for importing.

- Guarantees: Actions will be logged and file data will be correctly
  converted to a KML file.


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

- In the event of GUI failure, program shall exit with error code.

- If KML file generation fails, program shall exit with error code.


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

- CityInfo – will store information on entered cities to include their
  network interconnections

- GenerateKml - use information stored in CityInfo to generate a KML
  file based on cities selected by user.


Data Structure:
-----------------

- We will use the ArrayList data structure in this sprint to store city
  information to include their connections to other cities.

- We will use a KML file (modified XML standard) to store city
  information. File will be viewable in mapping software such as
  Google Earth.


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

As this sprint focuses on KML file generation, testing
will be conducted by comparing the generated KMLs to predefined
KMLs. Asserting that the generated KMLs are equal to our
predefined KMLs, we can confirm that file generation is working
correctly. Any variations will indiacte prblems in file generation.
Individual method functionality tests will be performed with
automated JUnit testing.


Documentation
==============

Use comments in accordance with Java coding standards.
Create a document (such as README) showing
how to interact with GUI features and select files.


Implementation
=================

Work Items
------------

The KML generation functionality will be developed using agile
development.

Implementation 3
-----------------
Completed by 23 November

- Creation and implementation of selectCities method

- Update GUI functionality to select cities to include in KML

- Update logging function functionality for added functionality

- Implementation of GenerateKml methods to take city data stored
  in CityInfo ArrayLists and convert them to a KML file format

- Updated test harness for all added functionality

References
===========
None
