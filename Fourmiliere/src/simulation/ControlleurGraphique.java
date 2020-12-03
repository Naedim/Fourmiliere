package simulation;

import bilan.Action;
import bilan.BilanGraphique;
import bilan.Parametre;
import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import modele.Fourmi;
import vue.FourmiGraphique;
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
    Fourmi fourmi;
    GRect fourmiRect;
    for (Action action : bilan.getListAction()) {
      switch (action.getAction()) {
        case AJOUTER:
          this.ajouterFourmi(action.getParam().getFourmi());
          break;
        case SUPPRIMER:
          fourmi = action.getParam().getFourmi();
          this.supprimerFourmi(fourmi);
          break;
        case DEPLACER:
          fourmi = action.getParam().getFourmi();
          fourmiRect =
              this.getFourmiliereGraphique().getFourmiGraphique(fourmi).getElementGraphique();
          this.deplacerFourmi(fourmiRect);
          break;
        case CHANGERCOULEUR:
          Parametre p = action.getParam();
          fourmi = p.getFourmi();
          Color couleur = p.getColor();

          fourmiRect =
              this.getFourmiliereGraphique().getFourmiGraphique(fourmi).getElementGraphique();
          this.changerCouleurFourmi(fourmiRect, couleur);
          break;
        default:

      }
    }
    this.terrain.getElementGraphique().repaint();
  }

  private void ajouterFourmi(Fourmi fourmi) {
    FourmiliereGraphique fourmiliere = this.getFourmiliereGraphique();
    GRect fourmiRect = fourmiliere.ajouterFourmi(fourmi);
    this.ajouterElementGraphique(fourmiRect);
  }

  private void supprimerFourmi(Fourmi fourmi) {
    FourmiGraphique fourmiGraphique =
        this.getFourmiliereGraphique().supprimerFourmiGraphique(fourmi);
    this.supprimerElementGraphique(fourmiGraphique.getElementGraphique());
  }


  private void changerCouleurFourmi(GRect fourmiGraphique, Color couleur) {
    fourmiGraphique.setColor(couleur);
  }

  /**
   * Modifie la position d'un GRect d'une fourmiGraphique e manière aléatoire.
   * 
   * @param fourmiGraphique Le rectangle graphique à déplacer.
   */
  private void deplacerFourmi(GRect fourmiGraphique) {
    Point posFourmi = fourmiGraphique.getPosition();
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

    GRect territoire = this.getFourmiliereGraphique().getTerritoire().getElementGraphique();
    Point positionTerrain = territoire.getPosition();
    Dimension dimensionTerrain = territoire.getDimension().getSize();

    int terrX = positionTerrain.x;
    int terrY = positionTerrain.y;

    if (terrX < fourmiX && fourmiX < (terrX + dimensionTerrain.width)) {
      if (terrY < fourmiY && fourmiY < (terrY + dimensionTerrain.height)) {
        fourmiGraphique.setPosition(new Point(fourmiX, fourmiY));
      }
    }

  }

  private FourmiliereGraphique getFourmiliereGraphique() {
    return this.getTerrain().getFourmiliere();
  }

  private void ajouterElementGraphique(GRect element) {
    this.terrain.getElementGraphique().addElement(element);
  }

  private void supprimerElementGraphique(GRect fourmiRect) {
    this.terrain.getElementGraphique().removeElement(fourmiRect);
  }

}
