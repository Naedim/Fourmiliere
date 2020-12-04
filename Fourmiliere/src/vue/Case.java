package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Point;


public class Case implements ElementGraphique {

  protected GRect elementGraphique;
  protected int nbPheromones;

  int step = 0;

  /**
   * Constructeur d'une case.
   * 
   * @param x : coordonée x
   * @param y : coordonée y
   */
  public Case(int x, int y, int taille) {
    nbPheromones = 0;
    GRect rect = new GRect();
    rect.setWidth(taille);
    rect.setHeight(taille);
    rect.setPosition(new Point(x, y));
    rect.withBorder();
    rect.setColor(Color.WHITE);

    this.elementGraphique = rect;
  }

  /**
   * .
   */
  public void addPheromones() {
    nbPheromones++;
    System.out.println("Ajout de phéromones case : " + this.getElementGraphique().getX() + " , "
        + this.getElementGraphique().getY());
  }

  public int getNbPheromone() {
    return nbPheromones;
  }

  @Override
  public GRect getElementGraphique() {
    return elementGraphique;
  }

  /**
   * .
   * 
   */
  public void updatePheromone() {
    step++;
    if (step == 5) {
      this.nbPheromones -= 3;
    }
  }

}
