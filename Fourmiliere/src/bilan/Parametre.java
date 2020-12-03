package bilan;

import java.awt.Color;
import java.awt.Point;
import modele.Fourmi;

public class Parametre {

  protected Fourmi fourmi;
  protected Point point;
  protected Color color;
  
  public Parametre(Fourmi fourmi) {
    this.fourmi = fourmi;
  }
  
  public Parametre(Fourmi fourmi, Point p) {
    this.fourmi = fourmi;
    this.point = p;
  }
  
  public Parametre(Fourmi fourmi, Color c) {
    this.fourmi = fourmi;
    this.color = c;
  }

  public Fourmi getFourmi() {
    return fourmi;
  }

  public Point getPoint() {
    return point;
  }

  public Color getColor() {
    return color;
  }
  
  
}
