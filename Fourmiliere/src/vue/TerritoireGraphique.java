package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

/**
 * Représentation graphique du TerritoireGraphhique d'une FourmiliereGraphique.
 * 
 * @author Damien
 *
 */
public class TerritoireGraphique implements ElementGraphique {
  protected GRect elementGraphique;

  /**
   * La taille d'un territoire et son positionnement dépendent de la taille de la fourmiliere du
   * territoire.
   * 
   * @param posFourmiliere position de la fourmiliere du territoire
   * @param dimFourmiliere dimensions del a fourmilieres
   */
  public TerritoireGraphique(Point posFourmiliere, Dimension dimFourmiliere) {
    elementGraphique = new GRect();
    elementGraphique.setColor(Color.WHITE);
    elementGraphique.withBorder();
    elementGraphique.setBorderColor(Color.BLACK);

    Point positionTerritoire =
        new Point((int) posFourmiliere.getX() - (int) (dimFourmiliere.getWidth() * 2),
            (int) posFourmiliere.getY() - (int) (dimFourmiliere.getHeight() * 2));

    elementGraphique.setPosition(positionTerritoire);
    elementGraphique.setDimension(
        new Dimension((int) dimFourmiliere.getHeight() * 5, (int) dimFourmiliere.getWidth() * 5));

  }

  public GRect getElementGraphique() {
    return this.elementGraphique;
  }
}
