package vue;

import graphicLayer.GSpace;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class TerrainGraphique {

  protected GSpace elementGraphique;
  protected FourmiliereGraphique fourmiliere;

  /**
   * .
   * 
   */
  public TerrainGraphique(Point posFourmiliere, Dimension dimFourmiliere) {
    elementGraphique = new GSpace("Simulation d'un terrain", new Dimension(1000, 800));
    fourmiliere = new FourmiliereGraphique(posFourmiliere, dimFourmiliere);

    elementGraphique.setColor(Color.WHITE);
    elementGraphique.addElement(ElementGraphique.getElementGraphique());
    fourmiliere.getTerritoire();
    elementGraphique.addElement(ElementGraphique.getElementGraphique());
    elementGraphique.open();
  }


  public FourmiliereGraphique getFourmiliere() {
    return fourmiliere;
  }

  public GSpace getElementGraphique() {
    return elementGraphique;
  }
}
