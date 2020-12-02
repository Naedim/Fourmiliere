package vue;

import java.awt.Color;
import java.awt.Point;

public class Parametre {

  protected int index;
  protected Point point;
  protected Color color;
  
  public Parametre(int index) {
    this.index = index;
  }
  
  public Parametre(int index, Point p) {
    this.index = index;
    this.point = p;
  }
  
  public Parametre(int index, Color c) {
    this.index = index;
    this.color = c;
  }
}
