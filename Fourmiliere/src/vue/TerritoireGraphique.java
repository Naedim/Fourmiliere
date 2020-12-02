package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class TerritoireGraphique extends ElementGraphique {
  protected GRect elementGraphique;

  /**
   * .
   * 
   * @param posFourmiliere .
   * @param dimFourmiliere .
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
    // modifier avec valeurs de l'objet fourmiliere
    elementGraphique.setDimension(
        new Dimension((int) dimFourmiliere.getHeight() * 5, (int) dimFourmiliere.getWidth() * 5));

  }
}
