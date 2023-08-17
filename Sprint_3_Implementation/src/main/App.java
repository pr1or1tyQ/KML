package io.github.usafa_compsci350;

/**
 * App - controls high level interaction and application operation.
 *
 * @author Group 3 CLASS: T1 CS-350 DOCUMENTATION:
 * javatpoint.com/java-get-current-date showed how to use LocalDateTime
 * and DateTimeFormatter to grab the current time/date at that moment
 * and print it in the format yyyy/MM/dd HH:mm:ss. Used
 * baeldung.com/java-append-to-file to learn how to use FileWriter and
 * BufferedWriter to append logMessages to the next line of the file.
 * Used w3schools.com/java/java_files_create.asp to learn how to use the
 * File method createNewFile() to create a new log.txt file in the event
 * that wasn't created.
 */
public final class App {
  // ATTRIBUTES
  public static LogFunction log = new LogFunction();
  // create log function object

  // CONSTRUCTOR

  /**
   * App constructor
   */
  private App() {
  } //to fix static class error

  // PUBLIC METHODS

  /**
   * main() - starts program and initiates log object.
   */
  public static void main(String[] args) {
    // open intro window
    IntroWindow.introWindow();

    log.writeToLog("Open intro window."); // log action
  } // end of main

} // End of App Class
