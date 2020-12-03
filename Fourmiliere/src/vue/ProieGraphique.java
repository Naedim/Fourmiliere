package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Point;

public class ProieGraphique implements ElementGraphique {
  protected final int tailleProie = 10;
  protected final Color couleurProie = Color.GREEN;

  protected GRect elementGraphique;

  /**
   * .
   * 
   */
  public ProieGraphique() {
    GRect rect = new GRect();
    rect.setWidth(this.tailleProie);
    rect.setHeight(this.tailleProie);

    int posX = (int) Math.floor(Math.random() * 1000);
    int posY = (int) Math.floor(Math.random() * 8000);

    rect.setPosition(new Point(posX, posY));
    rect.setColor(this.couleurProie);
    rect.withoutBorder();
    this.elementGraphique = rect;
  }

  @Override
  public GRect getElementGraphique() {
    return this.elementGraphique;
  }
}
