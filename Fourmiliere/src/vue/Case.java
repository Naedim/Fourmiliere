package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Point;


public class Case implements ElementGraphique {

  protected GRect elementGraphique;
  protected final int tailleCase = 5;
  protected int nbPheromones;
  protected TerrainGraphique terrainG;


  /**
   * Constructeur d'une case.
   * 
   * @param x : coordonée x
   * @param y : coordonée y
   */
  public Case(int x, int y, TerrainGraphique terrainG) {
    this.terrainG = terrainG;
    nbPheromones = 0;
    GRect rect = new GRect();
    rect.setWidth(this.tailleCase);
    rect.setHeight(this.tailleCase);
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
    GRect rect = new GRect();
    rect.setWidth(this.tailleCase);
    rect.setHeight(this.tailleCase);
    rect.setPosition(p);
    rect.withBorder();
    rect.setColor(Color.BLUE);
    terrainG.getElementGraphique().addElement(rect);
  }

  public int nbDePheromones() {
    return nbPheromones;
  }

  @Override
  public GRect getElementGraphique() {
    return elementGraphique;
  }

}
