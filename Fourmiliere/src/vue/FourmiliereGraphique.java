package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import modele.Fourmi;

public class FourmiliereGraphique implements ElementGraphique {

  protected HashMap<Fourmi, FourmiGraphique> listFourmi;
  protected TerritoireGraphique territoire;
  protected GRect elementGraphique;

  /**
   * .
   * 
   */
  public FourmiliereGraphique(Point posFourmiliere, Dimension dimFourmiliere) {

    elementGraphique = new GRect();
    elementGraphique.setDimension(dimFourmiliere);

    elementGraphique.setColor(Color.BLACK);
    elementGraphique.setPosition(posFourmiliere);

    territoire = new TerritoireGraphique(posFourmiliere, dimFourmiliere);

    this.listFourmi = new HashMap<Fourmi, FourmiGraphique>();
  }

  public TerritoireGraphique getTerritoire() {
    return territoire;
  }

  public FourmiGraphique getFourmiGraphique(Fourmi fourmi) {
    return this.listFourmi.get(fourmi);
  }

  @Override
  public GRect getElementGraphique() {
    return this.elementGraphique;
  }

  /**.
   * 
   * @param fourmi .
   * @return
   */
  public GRect ajouterFourmi(Fourmi fourmi) {
    FourmiGraphique fourmiGraphique = new FourmiGraphique();
    this.listFourmi.put(fourmi, fourmiGraphique);
    return fourmiGraphique.getElementGraphique();
  }

  public FourmiGraphique supprimerFourmiGraphique(Fourmi fourmi) {
    FourmiGraphique fourmiGraphique = this.listFourmi.remove(fourmi);
    return fourmiGraphique;
  }

  public void deplacerFourmi(Fourmi fourmi, Point p) {
    this.listFourmi.get(fourmi).getElementGraphique().setPosition(p);
  }
}
