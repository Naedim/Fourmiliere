package simulation;

import graphicLayer.GRect;
import graphicLayer.GSpace;
import infomodele.Action;
import infomodele.BilanGraphique;
import infomodele.Parametre;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import modele.Fourmi;
import modele.Proie;
import vue.Case;
import vue.FourmiGraphique;
import vue.FourmiliereGraphique;
import vue.TerrainGraphique;

/**
 * Classe ControlleurGraphique, actualise la vue pour qu'elle corresponde au modele en fonction d'un
 * BilanGraphique.
 */
public class ControlleurGraphique {

  protected TerrainGraphique terrainGraphique;
  protected Case caseActuelle;

  public Case getCaseActuelle() {
    return caseActuelle;
  }

  public static class GestionnaireDeplacement {
    private GestionnaireDeplacement(Fourmi fourmi) {}

    private GestionnaireDeplacement(Proie proie) {}
  }

  /**
   * Cree un terrainGraphique avec une representation graphique de fourmiliere et d'un territoire.
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
   * Methode permettant d'effectuer les actions d'un bilan sur l'element graphique.
   * 
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
    this.terrainGraphique.getElementGraphique().repaint();
  }

  /**
   * Methode permettant d'ajouter un objet fourmi dans la fourmiliere graphique.
   * 
   * @param fourmi : L'objet fourmi a� ajouter dans l'affichage
   */
  private void ajouterFourmi(Fourmi fourmi) {
    FourmiliereGraphique fourmiliereG = this.getFourmiliereGraphique();
    GRect fourmiRect = fourmiliereG.ajouterFourmiGraphique(fourmi);
    this.ajouterElementGraphique(fourmiRect);
  }

  /**
   * Methode permettant d'ajouter un objet proie dans le terrain graphique.
   * 
   * @param proie : L'objet proie a� ajouter dans l'affichage
   */
  private void ajouterProie(Proie proie) {
    System.out.println("Ajout d'une proie");
    TerrainGraphique terrainG = this.terrainGraphique;
    GRect proieGraphique = terrainG.ajouterProie(proie);
    this.ajouterElementGraphique(proieGraphique);
  }

  /**
   * Methode supprimant la fourmi et sa reference graphique.
   * 
   * @param fourmi : L'objet fourmi qui reference l'objet graphique a� supprimer
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
   * Methode permettant de simuler une decision aleatoire de deplacement.
   * 
   * @param rect : GRect avant deplacement
   * @return Un nouveau point de position
   */
  private Point deplacementAleatoire(GRect rect) {
    Point pos = rect.getPosition();
    int deplacement = (int) Math.floor(Math.random() * 4);

    int posX = pos.x;
    int posY = pos.y;
    int valeurDeplacement = 5;

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
   * 
   * @param fourmiGraphique : La fourmi graphique a� deplacer
   */
  private void deplacerFourmi(GRect fourmiRect) {
    GRect territoire = this.getFourmiliereGraphique().getTerritoire().getElementGraphique();
    Point posTerritoire = territoire.getPosition();
    Dimension dimTerritoire = territoire.getDimension().getSize();

    // Définir une case actuelle avant le déplacement
    // this.caseActuelle = new Case(fourmiRect.getX(), fourmiRect.getY(), this.getTerrain());
    // this.caseActuelle.addPheromones(new Point(fourmiRect.getX(), fourmiRect.getY()));

    // Récupérer la liste des casesAdjacentes pour pouvoir vérifier qui a des phéromones
    // HashMap<String, Case> caseAdjacentes = terrainGraphique.getCasesAdjacentes(caseActuelle);

    // Si aucune case choisit alors déplacement aléatoire 25%
    // if (caseAdjacentes.size() > 0) {
    // int probabiliteGauche = 25;
    // int probabiliteDroite = 25;
    // int probabiliteHaut = 25;
    // int probabiliteBas = 25;
    //
    // // gérer les cas de probabilités
    // if (caseAdjacentes.get("Gauche").nbDePheromones() > 0) {
    // probabiliteGauche = 40;
    // }
    Point pos;
    // Case caseGauche = caseAdjacentes.get("Gauche");
    // Case caseDroite = caseAdjacentes.get("Gauche");
    // Case caseHaut = caseAdjacentes.get("Gauche");
    // Case caseBas = caseAdjacentes.get("Gauche");

    // if (caseGauche.nbDePheromones() > 0) {
    // pos = new Point(caseGauche.getElementGraphique().getX(),
    // caseGauche.getElementGraphique().getY());
    // } else {
    pos = this.deplacementAleatoire(fourmiRect);
    // }

    int terrX = posTerritoire.x;
    int terrY = posTerritoire.y;

    if (terrX < pos.x && pos.x + fourmiRect.getWidth() < (terrX + dimTerritoire.width)) {
      if (terrY < pos.y && pos.y + fourmiRect.getHeight() < (terrY + dimTerritoire.height)) {
        fourmiRect.setPosition(new Point(pos.x, pos.y));
      }
    }
  }

  // }

  /**
   * Modifie la position d'une proie tout ne respectant les limites imposer par le terrain.
   * 
   * @param proieRect : La proie graphique a� deplacer
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
   * Ajoute l'element dans l'affichage du terrainGraphique.
   * 
   * @param element : L'element graphique
   */
  private void ajouterElementGraphique(GRect element) {
    this.terrainGraphique.getElementGraphique().addElement(element);
  }

  /**
   * Supprime l'element de l'affichage du terrainGraphique.
   * 
   * @param insecteRect : L'element graphique
   */
  private void supprimerElementGraphique(GRect insecteRect) {
    this.terrainGraphique.getElementGraphique().removeElement(insecteRect);
  }


}
