package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;


public class ControlleurGraphique {

  protected TerrainGraphique terrain;



  /**
   * Crée un terrain avec une fourmilière et un territoire.
   */
  public ControlleurGraphique() {

    Point posFourmiliere = new Point(350, 350);
    Dimension dimFourmiliere = new Dimension(100, 100);
    terrain = new TerrainGraphique(posFourmiliere, dimFourmiliere);
  }

  public TerrainGraphique getTerrain() {
    return terrain;
  }

  /**
   * .
   * 
   * @param bilan .
   */
  public void updateIhm(BilanGraphique bilan) {
    for (Action action : bilan.getListAction()) {
      switch (action.action) {
        case AJOUTER:
          this.ajouterFourmi();
          break;
        case SUPPRIMER:
          this.supprimerFourmi(action.getParam());
          break;
        case DEPLACER:
          this.deplacerFourmi(action.getParam());
          break;
        case CHANGERCOULEUR:
          this.changerCouleurFourmi(action.getParam());
          break;
        default:

      }
    }
    this.terrain.getElementGraphique().repaint();
    this.getFourmiliere().resetNbSuppression();
  }

  private void ajouterFourmi() {
    FourmiliereGraphique fourmiliere  = this.getFourmiliere();
    int indexFourmi = fourmiliere.ajouterFourmi();
    this.ajouterElementGraphique(fourmiliere.getFourmi(indexFourmi));
  }

  private void supprimerFourmi(Parametre param) {
    int indexFourmi = param.getIndex();
    this.getFourmiliere().supprimerFourmi(indexFourmi);
    this.supprimerElementGraphique(indexFourmi);
    
  }


  private void changerCouleurFourmi(Parametre param) {
    int indexFourmi = param.getIndex();
    Color c = param.getColor();

    GRect fourmi = this.getTerrain().getFourmiliere().getFourmi(indexFourmi);
    

    fourmi.setColor(c);

  }

  private void deplacerFourmi(Parametre param) {
    int indexFourmi = param.getIndex();
    Point p = param.getPoint();
    GRect fourmi = this.getFourmiliere().getFourmi(indexFourmi);
    fourmi.setPosition(p);

  }


  private FourmiliereGraphique getFourmiliere() {
    return this.getTerrain().getFourmiliere();
  }
  
  private void ajouterElementGraphique(GRect element) {
    this.terrain.getElementGraphique().addElement(element);
  }
  
  private void supprimerElementGraphique(int indexFourmi) {
    this.terrain.getElementGraphique().remove(indexFourmi);
  }



}
