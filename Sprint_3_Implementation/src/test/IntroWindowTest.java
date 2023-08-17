package io.github.usafa_compsci350;

import org.junit.jupiter.api.Test;

class IntroWindowTest {

  IntroWindowTest() {
    closeWindowTest();
  }

  @Test
  void openWindowTest() {
    IntroWindow testIntroWindow = new IntroWindow();
    assert (testIntroWindow.frame.isActive());
  }

  @Test
  void closeWindowTest() {
    IntroWindow testIntroWindow = new IntroWindow();
    assert (!testIntroWindow.frame.isActive());
  }

}