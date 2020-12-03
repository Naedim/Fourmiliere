package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Point;

public class FourmiGraphique implements ElementGraphique {

  protected final int tailleFourmi = 4;
  protected final Color couleurFourmi = Color.RED;
  protected final Point positionSortie = new Point(450, 400);

  protected GRect elementGraphique;

  /**
   * .
   * 
   */
  public FourmiGraphique() {
    // int x = (int) (Math.random() * (600 - 300) + 300);
    // int y = (int) (Math.random() * (600 - 300) + 300);
    GRect rect = new GRect();
    rect.setWidth(this.tailleFourmi);
    rect.setHeight(this.tailleFourmi);
    rect.setPosition(positionSortie);
    rect.setColor(this.couleurFourmi);
    rect.withoutBorder();
    this.elementGraphique = rect;
  }

  @Override
  public GRect getElementGraphique() {
    return this.elementGraphique;
  }

}
