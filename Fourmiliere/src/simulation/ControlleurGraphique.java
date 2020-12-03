package simulation;

import bilan.Action;
import bilan.BilanGraphique;
import bilan.Parametre;
import graphicLayer.GRect;
import graphicLayer.GSpace;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import modele.Fourmi;
import modele.Proie;
import vue.FourmiGraphique;
import vue.FourmiliereGraphique;
import vue.TerrainGraphique;


public class ControlleurGraphique {

  protected TerrainGraphique terrainGraphique;


  public static class GestionnaireDeplacement {

    private GestionnaireDeplacement(Fourmi fourmi) {

    }

    private GestionnaireDeplacement(Proie proie) {

    }
  }


  /**
   * Crée un terrainGraphique avec une fourmilière et un territoire.
   */
  public ControlleurGraphique() {

    Point posFourmiliere = new Point(350, 350);
    Dimension dimFourmiliere = new Dimension(100, 100);
    terrainGraphique = new TerrainGraphique(posFourmiliere, dimFourmiliere);
  }

  public TerrainGraphique getTerrain() {
    return terrainGraphique;
  }

  /**
   * .
   * 
   * @param bilan .
   */
  public void updateIhm(BilanGraphique bilan) {
    Fourmi fourmi;
    Proie proie;
    GRect insecteRect;
    Parametre param;
    for (Action action : bilan.getListAction()) {
      switch (action.getAction()) {
        case AJOUTER:
          param = action.getParam();
          if (param.getFourmi() != null) {
            this.ajouterFourmi(action.getParam().getFourmi());
          } else {
            this.ajouterProie(action.getParam().getProie());
          }

          break;
        case SUPPRIMER:
          fourmi = (Fourmi) action.getParam().getFourmi();
          this.supprimerFourmi(fourmi);
          break;
        case DEPLACER:
          param = action.getParam();
          fourmi = param.getFourmi();
          if (fourmi != null) {
            insecteRect =
                this.getFourmiliereGraphique().getFourmiGraphique(fourmi).getElementGraphique();
            this.deplacerFourmi(insecteRect);
            break;
          } else {
            proie = param.getProie();
            insecteRect = this.terrainGraphique.getProieGraphique(proie).getElementGraphique();
            this.deplacerProie(insecteRect);
          }
          break;

        case CHANGERCOULEUR:
          Parametre p = action.getParam();
          fourmi = p.getFourmi();
          Color couleur = p.getColor();

          insecteRect =
              this.getFourmiliereGraphique().getFourmiGraphique(fourmi).getElementGraphique();
          this.changerCouleurFourmi(insecteRect, couleur);
          break;
        default:

      }
    }
    this.terrainGraphique.getElementGraphique().repaint();
  }

  private void ajouterFourmi(Fourmi fourmi) {
    FourmiliereGraphique fourmiliere = this.getFourmiliereGraphique();
    GRect insecteRect = fourmiliere.ajouterFourmi(fourmi);
    this.ajouterElementGraphique(insecteRect);
  }

  private void ajouterProie(Proie proie) {
    GRect proieGraphique = this.terrainGraphique.ajouterProie(proie);
    this.ajouterElementGraphique(proieGraphique);
  }

  private void supprimerFourmi(Fourmi fourmi) {
    FourmiGraphique fourmiGraphique =
        this.getFourmiliereGraphique().supprimerFourmiGraphique(fourmi);
    this.supprimerElementGraphique(fourmiGraphique.getElementGraphique());
  }


  private void changerCouleurFourmi(GRect fourmiGraphique, Color couleur) {
    fourmiGraphique.setColor(couleur);
  }

  private Point deplacementAleatoire(GRect rect) {

    Point pos = rect.getPosition();
    int deplacement = (int) Math.floor(Math.random() * 4);

    int posX = pos.x;
    int posY = pos.y;
    int valeurDeplacement = (int) Math.floor(Math.random() * 5);

    switch (EnumDeplacementFourmi.values()[deplacement]) {
      case HAUT:
        posY -= valeurDeplacement;
        break;
      case BAS:
        posY += valeurDeplacement;
        break;
      case GAUCHE:
        posX -= valeurDeplacement;
        break;
      case DROITE:
        posX += valeurDeplacement;
        break;
      default:
        System.out.println("ON NE PASSE PAS DEDANS");
    }
    return new Point(posX, posY);
  }

  /**
   * Modifie la position d'un GRect d'une fourmiGraphique e manière aléatoire.
   * 
   * @param fourmiGraphique Le rectangle graphique à déplacer.
   */
  private void deplacerFourmi(GRect fourmiRect) {

    GRect territoire = this.getFourmiliereGraphique().getTerritoire().getElementGraphique();
    Point positionTerrain = territoire.getPosition();
    Dimension dimensionTerrain = territoire.getDimension().getSize();

    Point pos = this.deplacementAleatoire(fourmiRect);
    int terrX = positionTerrain.x;
    int terrY = positionTerrain.y;

    if (terrX < pos.x && pos.x + fourmiRect.getWidth() < (terrX + dimensionTerrain.width)) {
      if (terrY < pos.y && pos.y + fourmiRect.getHeight() < (terrY + dimensionTerrain.height)) {
        fourmiRect.setPosition(new Point(pos.x, pos.y));
      }
    }

  }

  private void deplacerProie(GRect proieRect) {
    GSpace terrain = this.getTerrain().getElementGraphique();
    int maxX = terrain.getWidth();
    int maxY = terrain.getHeight();

    Point pos = this.deplacementAleatoire(proieRect);

    if (0 < pos.x && pos.x + proieRect.getWidth() < maxX) {
      if (0 < pos.y && pos.y + proieRect.getHeight() < maxY) {
        proieRect.setPosition(new Point(pos.x, pos.y));
      }
    }

  }

  private FourmiliereGraphique getFourmiliereGraphique() {
    return this.getTerrain().getFourmiliere();
  }

  private void ajouterElementGraphique(GRect element) {
    this.terrainGraphique.getElementGraphique().addElement(element);
  }

  private void supprimerElementGraphique(GRect insecteRect) {
    this.terrainGraphique.getElementGraphique().removeElement(insecteRect);
  }


}
