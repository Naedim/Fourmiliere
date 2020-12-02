package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class FourmiliereGraphique implements ElementGraphique {

  protected List<FourmiGraphique> listFourmi;
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

    this.listFourmi = new ArrayList<FourmiGraphique>();
  }

  public TerritoireGraphique getTerritoire() {
    return territoire;
  }

  public GRect getFourmi(int i) {
    return this.listFourmi.get(i).getElementGraphique();
  }

  @Override
  public GRect getElementGraphique() {
    return this.elementGraphique;
  }

  public int ajouterFourmi() {
    this.listFourmi.add(new FourmiGraphique());
    return this.listFourmi.size() - 1;
  }

  public void supprimerFourmi(int index) {
    this.listFourmi.remove(index);
  }

  public void deplacerFourmi(int index, Point p) {
    this.listFourmi.get(index).getElementGraphique().setPosition(p);
  }
}
