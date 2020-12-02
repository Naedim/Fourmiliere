package vue;

import graphicLayer.GElement;
import graphicLayer.GRect;

public abstract class ElementGraphique {
  public static final GRect elementGraphique = new GRect();

  public static GElement getElementGraphique() {
    return elementGraphique;
  }


}
