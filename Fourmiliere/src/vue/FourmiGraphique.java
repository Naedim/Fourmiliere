package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Point;

/**
 * Homologue graphique de la classe Fourmi du modèle.
 * 
 * @author Damien
 *
 */
public class FourmiGraphique implements ElementGraphique {


  protected final int tailleFourmi = 4; // taille defaut d'une FourmiGraphique.
  protected final Color couleurFourmi = Color.RED; //couleur defaut d'une FourmiGraphique.
  protected GRect elementGraphique; //GRect affiché sur la vue.
  protected GRect fourmiliereG; // FourmiliereGraphique dont la FourmiGraphique est issue.

  /**
   * Une FourmiGraphique nécessite de connaître sa fourmilière FourmiliereGraphique Une fourmi
   * apparait à 4 points différents de la fourmilière(haut, bas, gauche ou droite de la
   * fourmiliere).
   * 
   */
  public FourmiGraphique(GRect fourmiliereG) {
    Point positionSortie = new Point();
    //Nombre aléatoire entre 0 et 4 pour choisir aléatoirement une des 4 sorties.
    int sortie = (int) Math.floor(Math.random() * 4);
    switch (sortie) {
      case 0:
        positionSortie =
            new Point(fourmiliereG.getX() + fourmiliereG.getWidth() / 2, fourmiliereG.getY());
        break;
      case 1:
        positionSortie = new Point(fourmiliereG.getX() + fourmiliereG.getWidth() / 2,
            fourmiliereG.getY() + fourmiliereG.getHeight());
        break;
      case 2:
        positionSortie = new Point(fourmiliereG.getX() + fourmiliereG.getHeight(),
            fourmiliereG.getY() + fourmiliereG.getHeight() / 2);;
        break;
      case 3:
        positionSortie =
            new Point(fourmiliereG.getX(), fourmiliereG.getY() + fourmiliereG.getHeight() / 2);;
        break;
      default:
    }
    
    //Création et paramètrage du GRect de la fourmie 
    GRect rect = new GRect();
    rect.setWidth(this.tailleFourmi);
    rect.setHeight(this.tailleFourmi);
    rect.setPosition(positionSortie);
    rect.setColor(this.couleurFourmi);
    rect.withoutBorder();
    this.elementGraphique = rect;
  }

  @Override
  public GRect getElementGraphique() {
    return this.elementGraphique;
  }

}
