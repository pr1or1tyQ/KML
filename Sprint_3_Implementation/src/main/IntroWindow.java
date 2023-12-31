package io.github.usafa_compsci350;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * IntroWindow - creates introduction window GUI.
 *
 * @author Group 3
 */
public class IntroWindow {
  private JPanel mainPanel;
  private JLabel label1;
  private JLabel label2;
  private JPanel panel2;
  private JPanel panel1;
  private JPanel panel3;
  private JButton okButton;
  public static JFrame frame;

  /**
   * IntroWindow() - generates introduction window
   */
  public IntroWindow() {
    okButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        MainWindow mainWndw = new MainWindow();
        mainWndw.openWindow();
      }
    });
  }


  /**
   * introWindow - will set the JFrame and create the window.
   */
  public static void introWindow() {
    frame = new JFrame("Intro Window");
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setContentPane(new IntroWindow().mainPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  {
    // GUI initializer generated by IntelliJ IDEA GUI Designer
    // >>> IMPORTANT!! <<<
    // DO NOT EDIT OR ADD ANY CODE HERE!
    setupUI();
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer.
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void setupUI() {
    mainPanel = new JPanel();
    mainPanel.setLayout(
        new GridLayoutManager(7, 1, new Insets(0,
            0, 0, 0), -1, -1));
    mainPanel.setMinimumSize(new Dimension(220, 180));
    mainPanel.setPreferredSize(new Dimension(220, 180));
    mainPanel.setRequestFocusEnabled(true);
    panel1 = new JPanel();
    panel1.setLayout(
        new GridLayoutManager(1, 3, new Insets(0,
            0, 0, 0), -1, -1));
    mainPanel.add(panel1,
        new GridConstraints(1, 0, 1,
            1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK
                | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK
                | GridConstraints.SIZEPOLICY_CAN_GROW, null,
            null, null, 0,
            false));
    label1 = new JLabel();
    label1.setText("Welcome to the KML Generator!");
    panel1.add(label1,
        new GridConstraints(0, 1, 1,
            1, GridConstraints.ANCHOR_WEST,
            GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED,
            GridConstraints.SIZEPOLICY_FIXED, null,
            null, null, 0, false));
    final Spacer spacer1 = new Spacer();
    panel1.add(spacer1,
        new GridConstraints(0, 0, 1,
            1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW, 1,
            null, null, null, 0,
            false));
    final Spacer spacer2 = new Spacer();
    panel1.add(spacer2,
        new GridConstraints(0, 2, 1,
            1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW, 1,
            null, null, null, 0,
            false));
    panel3 = new JPanel();
    panel3.setLayout(
        new GridLayoutManager(1, 3,
            new Insets(0, 0, 0, 0), -1, -1));
    mainPanel.add(panel3,
        new GridConstraints(5, 0, 1,
            1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK
                | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK
                | GridConstraints.SIZEPOLICY_CAN_GROW, null,
            null, null, 0,
            false));
    okButton = new JButton();
    okButton.setText("OK");
    panel3.add(okButton,
        new GridConstraints(0, 1, 1,
            1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_CAN_SHRINK
                | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null,
            null, null, 0, false));
    final Spacer spacer3 = new Spacer();
    panel3.add(spacer3,
        new GridConstraints(0, 2, 1,
            1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW, 1,
            null, null, null, 0,
            false));
    final Spacer spacer4 = new Spacer();
    panel3.add(spacer4,
        new GridConstraints(0, 0, 1,
            1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW, 1,
            null, null, null, 0,
            false));
    panel2 = new JPanel();
    panel2.setLayout(
        new GridLayoutManager(1, 3,
            new Insets(0, 0, 0, 0), -1, -1));
    mainPanel.add(panel2,
        new GridConstraints(3, 0, 1,
            1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK
                | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK
                | GridConstraints.SIZEPOLICY_CAN_GROW, null,
            null, null, 0,
            false));
    label2 = new JLabel();
    label2.setText("Click OK to proceed.");
    panel2.add(label2,
        new GridConstraints(0, 1, 1,
            1, GridConstraints.ANCHOR_WEST,
            GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED,
            GridConstraints.SIZEPOLICY_FIXED, null,
            null, null, 0, false));
    final Spacer spacer5 = new Spacer();
    panel2.add(spacer5,
        new GridConstraints(0, 0, 1,
            1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW, 1,
            null, null, null, 0,
            false));
    final Spacer spacer6 = new Spacer();
    panel2.add(spacer6,
        new GridConstraints(0, 2, 1,
            1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW, 1,
            null, null, null, 0,
            false));
    final Spacer spacer7 = new Spacer();
    mainPanel.add(spacer7,
        new GridConstraints(6, 0, 1,
            1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_VERTICAL, 1,
            GridConstraints.SIZEPOLICY_WANT_GROW, null,
            null, null, 0, false));
    final Spacer spacer8 = new Spacer();
    mainPanel.add(spacer8,
        new GridConstraints(0, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_VERTICAL, 1,
            GridConstraints.SIZEPOLICY_WANT_GROW, null,
            null, null, 0, false));
    final Spacer spacer9 = new Spacer();
    mainPanel.add(spacer9,
        new GridConstraints(2, 0, 1,
            1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_VERTICAL, 1,
            GridConstraints.SIZEPOLICY_WANT_GROW, null,
            null, null, 0, false));
    final Spacer spacer10 = new Spacer();
    mainPanel.add(spacer10,
        new GridConstraints(4, 0, 1,
            1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_VERTICAL, 1,
            GridConstraints.SIZEPOLICY_WANT_GROW, null,
            null, null, 0, false));
  }

  /**
   * @noinspection ALL.
   */
  public JComponent getRootComponent() {
    return mainPanel;
  }

  {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
    $$$setupUI$$$();
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    mainPanel = new JPanel();
    mainPanel.setLayout(
        new GridLayoutManager(7, 1, new Insets(0, 0, 0, 0), -1, -1));
    mainPanel.setMinimumSize(new Dimension(220, 180));
    mainPanel.setPreferredSize(new Dimension(220, 180));
    mainPanel.setRequestFocusEnabled(true);
    panel1 = new JPanel();
    panel1.setLayout(
        new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
    mainPanel.add(panel1,
        new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK |
            GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK |
                GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0,
            false));
    label1 = new JLabel();
    label1.setText("Welcome to the KML Generator!");
    panel1.add(label1,
        new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST,
            GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED,
            GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final Spacer spacer1 = new Spacer();
    panel1.add(spacer1,
        new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0,
            false));
    final Spacer spacer2 = new Spacer();
    panel1.add(spacer2,
        new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0,
            false));
    panel3 = new JPanel();
    panel3.setLayout(
        new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
    mainPanel.add(panel3,
        new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK |
            GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK |
                GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0,
            false));
    okButton = new JButton();
    okButton.setText("OK");
    panel3.add(okButton,
        new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_CAN_SHRINK |
                GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final Spacer spacer3 = new Spacer();
    panel3.add(spacer3,
        new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0,
            false));
    final Spacer spacer4 = new Spacer();
    panel3.add(spacer4,
        new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0,
            false));
    panel2 = new JPanel();
    panel2.setLayout(
        new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
    mainPanel.add(panel2,
        new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK |
            GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK |
                GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0,
            false));
    label2 = new JLabel();
    label2.setText("Click OK to proceed.");
    panel2.add(label2,
        new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST,
            GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED,
            GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final Spacer spacer5 = new Spacer();
    panel2.add(spacer5,
        new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0,
            false));
    final Spacer spacer6 = new Spacer();
    panel2.add(spacer6,
        new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0,
            false));
    final Spacer spacer7 = new Spacer();
    mainPanel.add(spacer7,
        new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_VERTICAL, 1,
            GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    final Spacer spacer8 = new Spacer();
    mainPanel.add(spacer8,
        new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_VERTICAL, 1,
            GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    final Spacer spacer9 = new Spacer();
    mainPanel.add(spacer9,
        new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_VERTICAL, 1,
            GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    final Spacer spacer10 = new Spacer();
    mainPanel.add(spacer10,
        new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_VERTICAL, 1,
            GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return mainPanel;
  }

}
