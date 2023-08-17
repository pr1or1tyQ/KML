package io.github.usafa_compsci350;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class LogFunctionTest {

  public LogFunctionTest() {
    writeToLog();
  }

  @Test
  void writeToLog() {
    LogFunction log = new LogFunction();

    // Create a stream to hold the output
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    // Save the old System.out
    PrintStream old = System.out;
    // Tell Java to use new stream
    System.setOut(ps);

    log.writeToLog("Test"); //goes to baos

    // restore
    System.out.flush();
    System.setOut(old);

    assert (baos.toString().contains("Log: Test"));
  }
}