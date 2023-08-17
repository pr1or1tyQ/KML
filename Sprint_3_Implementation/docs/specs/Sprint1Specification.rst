===============================
GUI/Logging Base Functionality
===============================

The purpose of this software system is to combine unclassified
information about a country’s cities with classified information about
telecommunications links between the cities. This will produce a
graphical representation of the country’s telecommunication
infrastructure that can be viewed in map software such as Google Earth.
The goal of this sprint is to produce the graphical user interface
(GUI) that will facilitate user interaction with the program. This
sprint does not include the associated functionality of reading in the
files, parsing, or combining them.







Problem Description
===========================


The user needs a way to interact with the program, know the features
available, and select the feature they wish to interact with.

For this sprint, the GUI will display a screen that controls program
interaction that both informs the user and accepts input. The
functionality will support file selection/input while generating a log
of program activities behind the scenes.

The program needs a way to display an introductory graphics window where
the user can begin the program as well as a main graphics panel in
which the user can view and interact with the program functionality.

The user must be able to complete the various operations required by the
program to include generating a KML file, reading city information, and
reading network information. KML files display locational data and can
be implemented in geographic browsers.

Lastly the program needs to generate a document that records the program
actions.





Requirements
--------------------
Functional Requirements (Listed in order of priority):

- System Level

- Shall Create an intro window

- Shall open window with “Ok” button

- Shall display “Welcome to KML Generator – Click Ok to Proceed”

- Window shall be of adequate size for functionality (not full-screen)

- Shall Create main program window

- Shall Generate KML button

- After “ReadCity” and “ReadNetwork” functions have completed
  successfully, shall display “Generate KML File” button on right third
  of main window

- When clicked, shall call “Generate KML” function

- Shall Read City Button

- Shall display “Read City Info” button on left third of main window

- When clicked, shall open file browser that allows user to select file
  with City Info

- If valid file is selected, program shall call “Read City Info” function
  (function will be completed in next sprint)

- User cannot select invalid file type, error will be thrown and printed
  to console if invalid file type is accepted a

- Shall allow button to be pressed again to select a new read city file

- Read Network Button

- Shall display “Read Network” button on middle third of main window

- When clicked, shall open file browser that allows user to select file
  with Network info

- If valid file is selected, program shall call “Read Network” function
  (function will be completed in next sprint)

- User cannot select invalid file type, error will be thrown and printed
  if invalid file type is selected

- Shall allow button to be pressed again to select a new network file

- Shall create a logging function

- Shall create log function that will take descriptive message and append
  the message to the end of a log.txt file

- Shall put descriptive message to the console

- Logged message shall include a time and date stamp

- Message and time and date stamp shall be displayed to the console

- Shall create a log.txt file if one does not exist

- Shall throw an error if function cannot write to file

Non-Functional Requirements:
------------------------------



- Shall follow proper java coding standards

- Shall wrap 80 characters

- Tabs shall be equal to two spaces

- Shall include proper whitespace after operators and no whitespace at the
  end of lines

- Program(s) shall not accept file of invalid type



Use Cases
-----------------

- Actor: The DSA agent

Main Success Scenario:
-------------------------


- To start the KML generator program with intro screen

- To have a display that shows all functionality of the KML generator To
  log every action that is taken by program and user into a file and
  console

- To import the file with city information

- To import the file with network information



- Trigger: User starts the program



- Preconditions: Must have a city information and network file ready for
  importing.

- Guarantees: Actions will be logged

Extensions:
------------


- Improper file selected; User is prompted to select new file again.

- Player clicks the exit button on window; Program shall close.

- User will only be able to minimize window, close window, and select
  given buttons.

- In the event of GUI failure, program will exit with error code.

Proposed Change
===================

- The above requirements will be met by the software system utilizing the
  below techniques:

Classes:
-----------

- We will use the following classes for implementation:

- App – will be main control of the program, calls all associated
  functions and controls program flow

- ReadCity – reads city information for specified file, opens file browser
  and allows user to specify city information file

- ReadNetwork – reads network information, opens file browser and allows
  user to specify network file

- Windows - will open main GUI windows and display buttons

- AppTest - will test main control

- LogFunction – will record all actions taken in program



Data Structure:
-----------------

- No data structures are required for this sprint

Algorithms:
-------------

- No algorithms are used for this sprint

Alternatives
----------------

Drop down menu could be used instead of file browsers, but the file
browser is more user friendly. Other languages could also be
considered, but Java best supports the capabilities of the design
team.



Testing
==========


For the GUI and all of its requirements, we will create a main success
scenario with descriptions of how it should function. Then we will step
through the main success scenario writing what we view. To test if the
GUI works we will compare our expectations of the GUI with our
walkthrough and our log, if they are the same the test passed. For the
logging function, a main success scenario will be created with a
corresponding correct log.txt file. Each process in the main success
scenario will be stepped through on the program so that the actual
log.txt file can be compared to the pre-made theoretical log.txt file.
Comparing the files, if there are differences then the test case
fails.



JUnit testing cannot be used for a GUI, but individual method
functionality tests will be performed with automated JUnit testing.



Documentation
==============

Use comments in accordance with Java coding standards.

If requested by DIA users, create a document (such as README) showing
how to interact with GUI features.



Implementation
=================

Work Items
------------

The GUI and basic implementation will be developed using agile
development.


Implementation 1
-----------------

Completed by 16 September

- GUI that handles user operation and interaction.

- GUI that displays and logs an introduction.

- GUI can call ‘Read City Info,’ call ‘Read Network’, and call ‘Generate
  KML’. The functions being called do not need to be completed yet.

- The logging mechanism takes in a message, writes that message to a log
  file, and displays the message to the console to include a time
  stamp.

- Actions taken by software are appropriately logged by calling
  corresponding logging function. Assignee(s)

References
===========

None
