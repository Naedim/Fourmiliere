package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Point;


public class Case implements ElementGraphique {

  protected GRect elementGraphique;
  protected int nbPheromones;


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
  public void addPheromones(Point p) {
    nbPheromones++;
    System.out.println("Ajout de phéromones case : " + this.getElementGraphique().getX() + " , "
        + this.getElementGraphique().getY());

    // Utiliser pour marquer un emplacement de phéromones
    // GRect rect = new GRect();
    // rect.setWidth(this.tailleCase);
    // rect.setHeight(this.tailleCase);
    // rect.setPosition(p);
    // rect.withBorder();
    // rect.setColor(Color.WHITE);
    // terrainG.getElementGraphique().addElement(this.getElementGraphique());
    // this.getElementGraphique().setColor(Color.BLUE);
  }

  public int nbDePheromones() {
    return nbPheromones;
  }

  @Override
  public GRect getElementGraphique() {
    return elementGraphique;
  }

}
