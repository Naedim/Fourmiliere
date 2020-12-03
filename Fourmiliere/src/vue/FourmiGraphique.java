package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Point;

/**
 * Homologue graphique de la classe Fourmi du mod�le.
 * 
 * @author Damien
 *
 */
public class FourmiGraphique implements ElementGraphique {

  protected final int tailleFourmi = 5; // taille defaut d'une FourmiGraphique.
  protected final Color couleurFourmi = Color.RED; // couleur defaut d'une FourmiGraphique.
  protected GRect elementGraphique; // GRect affich� sur la vue.
  protected GRect fourmiliereG; // FourmiliereGraphique dont la FourmiGraphique est issue.

  /**
   * Une FourmiGraphique n�cessite de conna�tre sa fourmili�re FourmiliereGraphique Une fourmi
   * apparait a 4 points diff�rents de la fourmili�re(haut, bas, gauche ou droite de la
   * fourmiliere).
   * 
   * @param fourmiliereGraphique : la fourmiliereGraphique de ma FourmiGraphique.
   */
  public FourmiGraphique(GRect fourmiliereGraphique) {
    Point positionSortie = new Point();
    // Nombre al�atoire entre 0 et 4 pour choisir al�atoirement une des 4 sorties.
    int sortie = (int) Math.floor(Math.random() * 4);
    switch (sortie) {
      case 0:
        positionSortie =
            new Point(fourmiliereGraphique.getX() + fourmiliereGraphique.getWidth() / 2,
                fourmiliereGraphique.getY());
        break;
      case 1:
        positionSortie =
            new Point(fourmiliereGraphique.getX() + fourmiliereGraphique.getWidth() / 2,
                fourmiliereGraphique.getY() + fourmiliereGraphique.getHeight());
        break;
      case 2:
        positionSortie = new Point(fourmiliereGraphique.getX() + fourmiliereGraphique.getHeight(),
            fourmiliereGraphique.getY() + fourmiliereGraphique.getHeight() / 2);
        break;
      case 3:
        positionSortie = new Point(fourmiliereGraphique.getX(),
            fourmiliereGraphique.getY() + fourmiliereGraphique.getHeight() / 2);
        break;
      default:
    }

    // Cr�ation et param�trage du GRect de la fourmie
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
