// Extrauppgiften

package framebuttons;

public class MyButton extends JButton {

  private Color c1;
  private Color c2;
  private String s1;
  private String s2;
  private boolean on = true;

  public MyButton(Color c1, Color c2, String s1, String s2) {
    this.c1 = c1;
    this.c2 = c2;
    this.s1 = s1;
    this.s2 = s2;

    setBounds(0,0,100,100);
    setBackground(c1);
    setText(s1);
    setVisible(true);
  }

  public void toggleState() {
    if (on) {
      setBackground(c2);
      setText(s2);
      on = false;
    } else {
      setBackground(c1);
      setText(s1);
      on = true;
    }
  }

}
