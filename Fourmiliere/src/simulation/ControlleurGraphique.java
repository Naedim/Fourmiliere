package simulation;

import bilan.Action;
import bilan.BilanGraphique;
import bilan.Parametre;
import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import vue.FourmiliereGraphique;
import vue.TerrainGraphique;


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
    int indexFourmi;
    GRect fourmi;
    for (Action action : bilan.getListAction()) {
      switch (action.getAction()) {
        case AJOUTER:
          this.ajouterFourmi();
          break;
        case SUPPRIMER:
          indexFourmi = action.getParam().getIndex();
          this.supprimerFourmi(indexFourmi);
          break;
        case DEPLACER:
          indexFourmi = action.getParam().getIndex();
          fourmi = this.getFourmiliere().getFourmi(indexFourmi);
          this.deplacerFourmi(fourmi);
          break;
        case CHANGERCOULEUR:
          Parametre p = action.getParam();
          indexFourmi = p.getIndex();
          Color couleur = p.getColor();

          fourmi = this.getFourmiliere().getFourmi(indexFourmi);
          this.changerCouleurFourmi(fourmi, couleur);
          break;
        default:

      }
    }
    this.terrain.getElementGraphique().repaint();
  }

  private void ajouterFourmi() {
    FourmiliereGraphique fourmiliere = this.getFourmiliere();
    int indexFourmi = fourmiliere.ajouterFourmi();
    this.ajouterElementGraphique(fourmiliere.getFourmi(indexFourmi));
  }

  private void supprimerFourmi(int indexFourmi) {
    this.getFourmiliere().supprimerFourmi(indexFourmi);
    this.supprimerElementGraphique(indexFourmi);
  }


  private void changerCouleurFourmi(GRect fourmi, Color couleur) {
    fourmi.setColor(couleur);
  }

  /**
   * Modifie la position d'un GRect d'une fourmi e manière aléatoire.
   * 
   * @param fourmi Le rectangle graphique à déplacer.
   */
  private void deplacerFourmi(GRect fourmi) {
    Point posFourmi = fourmi.getPosition();
    int deplacement = (int) Math.floor(Math.random() * 4);

    int fourmiX = posFourmi.x;
    int fourmiY = posFourmi.y;

    switch (EnumDeplacementFourmi.values()[deplacement]) {
      case HAUT:
        fourmiY--;
        break;
      case BAS:
        fourmiY++;
        break;
      case GAUCHE:
        fourmiX--;
        break;
      case DROITE:
        fourmiX++;
        break;
      default:
        System.out.println("ON NE PASSE PAS DEDANS");
    }

    GRect territoire = this.getFourmiliere().getTerritoire().getElementGraphique();
    Point positionTerrain = territoire.getPosition();
    Dimension dimensionTerrain = territoire.getDimension().getSize();

    int terrX = positionTerrain.x;
    int terrY = positionTerrain.y;

    if (terrX < fourmiX && fourmiX < (terrX + dimensionTerrain.width)) {
      if (terrY < fourmiY && fourmiY < (terrY + dimensionTerrain.height)) {
        fourmi.setPosition(new Point(fourmiX, fourmiY));
      }
    }

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
