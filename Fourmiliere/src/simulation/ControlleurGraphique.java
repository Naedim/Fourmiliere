package simulation;

import bilangraphique.Action;
import bilangraphique.BilanGraphique;
import bilangraphique.Parametre;
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

/**
 * Classe ControlleurGraphique, actualise la vue pour qu'elle corresponde au modèle en fonction d'un
 * BilanGraphique.
 */
public class ControlleurGraphique {

  protected TerrainGraphique terrainGraphique;

  public static class GestionnaireDeplacement {
    private GestionnaireDeplacement(Fourmi fourmi) {}

    private GestionnaireDeplacement(Proie proie) {}
  }

  /**
   * Crée un terrainGraphique avec une représentation graphique de fourmilière et d'un
   * territoire.
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
   * Méthode permettant d'effectuer les actions d'un bilan sur l'élement graphique.
   * @param bilan : Le bilan d'action de mon terrain
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
  }

  /**
   * Méthode permettant d'ajouter un objet fourmi dans la fourmilière graphique.
   * @param fourmi : L'objet fourmi à ajouter dans l'affichage
   */
  private void ajouterFourmi(Fourmi fourmi) {
    FourmiliereGraphique fourmiliereG = this.getFourmiliereGraphique();
    GRect fourmiRect = fourmiliereG.ajouterFourmiGraphique(fourmi);
    this.ajouterElementGraphique(fourmiRect);
  }

  /**
   * Méthode permettant d'ajouter un objet proie dans le terrain graphique.
   * 
   * @param proie : L'objet proie à ajouter dans l'affichage
   */
  private void ajouterProie(Proie proie) {
    TerrainGraphique terrainG = this.terrainGraphique;
    GRect proieGraphique = terrainG.ajouterProie(proie);
    this.ajouterElementGraphique(proieGraphique);
  }

  /**
   * Méthode supprimant la fourmi et sa réference graphique.
   * 
   * @param fourmi : L'objet fourmi qui réference l'objet graphique à supprimer
   */
  private void supprimerFourmi(Fourmi fourmi) {
    FourmiGraphique fourmiGraphique =
        this.getFourmiliereGraphique().supprimerFourmiGraphique(fourmi);
    this.supprimerElementGraphique(fourmiGraphique.getElementGraphique());
  }

  private void changerCouleurFourmi(GRect fourmiGraphique, Color couleur) {
    fourmiGraphique.setColor(couleur);
  }

  /**
   * Méthode permettant de simuler une décision aléatoire de déplacement.
   * @param rect : GRect avant déplacement
   * @return Un nouveau point de position
   */
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
   * Modifie la position d'une fourmi tout en respectant les limites imposer par le territoire.
   * @param fourmiGraphique : La fourmi graphique à déplacer
   */
  private void deplacerFourmi(GRect fourmiRect) {
    GRect territoire = this.getFourmiliereGraphique().getTerritoire().getElementGraphique();
    Point posTerritoire = territoire.getPosition();
    Dimension dimTerritoire = territoire.getDimension().getSize();
    Point pos = this.deplacementAleatoire(fourmiRect);

    int terrX = posTerritoire.x;
    int terrY = posTerritoire.y;

    if (terrX < pos.x && pos.x + fourmiRect.getWidth() < (terrX + dimTerritoire.width)) {
      if (terrY < pos.y && pos.y + fourmiRect.getHeight() < (terrY + dimTerritoire.height)) {
        fourmiRect.setPosition(new Point(pos.x, pos.y));
      }
    }
  }

  /**
   * Modifie la position d'une proie tout ne respectant les limites imposer par le terrain.
   * @param proieRect : La proie graphique à deplacer
   */
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

  /**
   * Ajoute l'élément dans l'affichage du terrainGraphique.
   * @param element : L'élément graphique
   */
  private void ajouterElementGraphique(GRect element) {
    this.terrainGraphique.getElementGraphique().addElement(element);
  }

  /**
   * Supprime l'élément de l'affichage du terrainGraphique.
   * @param insecteRect : L'élément graphique
   */
  private void supprimerElementGraphique(GRect insecteRect) {
    this.terrainGraphique.getElementGraphique().removeElement(insecteRect);
  }


}
