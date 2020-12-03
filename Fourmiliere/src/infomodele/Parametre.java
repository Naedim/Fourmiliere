package infomodele;

import java.awt.Color;
import java.awt.Point;
import modele.Fourmi;
import modele.Proie;
import vue.Case;

/**
 * Contient les parametres a utiliser pour une action donn�e.
 * @author Damien
 *
 */
public class Parametre {

  protected Fourmi fourmi;
  protected Proie proie;
  protected Point point;
  protected Color color;

  public Parametre(Fourmi fourmi) {
    this.fourmi = fourmi;
  }

  public Parametre(Fourmi fourmi, Point p) {
    this.fourmi = fourmi;
    this.point = p;
  }

  public Parametre(Proie proie) {
    this.proie = proie;
  }

  public Parametre(Proie proie, Point p) {
    this.proie = proie;
    this.point = p;
  }


  public Parametre(Fourmi fourmi, Color c) {
    this.fourmi = fourmi;
    this.color = c;
  }

  public Fourmi getFourmi() {
    return fourmi;
  }

  public Proie getProie() {
    return proie;
  }

  public Point getPoint() {
    return point;
  }

  public Color getColor() {
    return color;
  }


}
