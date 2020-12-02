package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Point;

public class FourmiGraphique implements ElementGraphique {

  protected final int tailleFourmi = 1;
  protected final Color couleurFourmi = Color.RED;
  protected final Point position = new Point(600, 400);

  protected GRect elementGraphique;

  /**.
   * 
   */
  public FourmiGraphique() {
    GRect rect = new GRect();
    rect.setPosition(this.position);
    rect.setColor(this.couleurFourmi);
    this.elementGraphique = rect;
  }

  @Override
  public GRect getElementGraphique() {
    return this.elementGraphique;
  }

}
