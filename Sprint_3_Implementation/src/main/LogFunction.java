package io.github.usafa_compsci350;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Log_Function - A Log_Function class that enables a descriptive message
 * (date/time/message) to be written to a log.txt file and to the console. Will
 * create log.txt file if it doesn't exist already.
 *
 * @author Group 3
 */
public class LogFunction {
  private final DateTimeFormatter timeFormat;
  private FileWriter writer;

  public LogFunction() {
    // Creates the format so its date time
    this.timeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    try {
      this.writer = new FileWriter("log.txt", true);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * writeToLog() - Will take in a message and will write it to the console and
   * log.txt file in proper format. (Date/Time/Message). Also, will create
   * log.txt if it doesn't exist.
   *
   * @param message The message to be written to the log
   */
  public void writeToLog(String message) {
    // timeStamp records the current time/date
    LocalDateTime timeStamp = LocalDateTime.now();
    // Creates correct formatted message to write to log
    String logMessage = timeFormat.format(timeStamp) + ", Log: " + message;
    // opens up file to log.txt
    File file = new File("log.txt");
    try {
      this.writer = new FileWriter("log.txt", true);
      // Will check to see if file exist (will create if not)
      newFileCreation(file);
      // Will write message to the "log.txt" file
      writeToFile(logMessage);
      writer.close();
      // Will write message to the console.
      System.out.println(logMessage);
    } catch (Exception e) {
      // Will print to console the error.
      System.out.println(e.getMessage());
    }
  }

  /**
   * newFileCreation() - Will determine if there is a log.txt file that can be
   * written to. If there is not will create log.txt file. If there is, method
   * will do nothing.
   *
   * @param logFile The file that will be created (log.txt).
   */
  private void newFileCreation(File logFile) throws Exception {
    // Will check if the file exists already
    if (logFile.createNewFile()) {
      // If the file is created then it will be written to the log
      LocalDateTime timeStamp = LocalDateTime.now();
      // Will create a formatted message and write to
      // log when file created.
      String logMessage = timeFormat.format(timeStamp) + ", Log: "
          + "File log.txt created";
      System.out.println(logMessage);
      writeToFile(logMessage);
    }
  }

  /**
   * writeToFile() - Will write message to the file "log.txt" will write in
   * correct format Date/Time/Message.
   *
   * @param message The message that will be written to log.txt file.
   */
  private void writeToFile(String message) throws Exception {
    // FileWriter/BufferedWriter will write to the file
    //FileWriter writer = new FileWriter("log.txt", true);
    writer.write(message);
    writer.write('\n');
    //writer.close();
  }
}
