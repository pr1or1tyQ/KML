package io.github.usafa_compsci350;

import org.junit.jupiter.api.Test;

class MainWindowTest {

  public MainWindowTest() {
    mainWindow();
  }

  @Test
  void mainWindow() {
    MainWindow testMainWindow = new MainWindow();
    assert (testMainWindow.frame.isActive());
  }

}