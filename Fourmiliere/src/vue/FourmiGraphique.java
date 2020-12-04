package vue;

import java.awt.Color;
import java.awt.Point;
import graphicLayer2.GRect;

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
  protected FourmiliereGraphique fourmiliereG; // FourmiliereGraphique dont la FourmiGraphique est
  // issue.
  protected Case maCase;

  /**
   * Une FourmiGraphique n�cessite de conna�tre sa fourmili�re FourmiliereGraphique Une fourmi
   * apparait a 4 points diff�rents de la fourmili�re(haut, bas, gauche ou droite de la
   * fourmiliere).
   * 
   * @param fourmiliereGraphique : la fourmiliereGraphique de ma FourmiGraphique.
   */
  public FourmiGraphique(FourmiliereGraphique fourmiliereGraphique) {
    Point positionSortie = new Point();
    GRect elemFourmiliere = fourmiliereGraphique.getElementGraphique();
    this.fourmiliereG = fourmiliereGraphique;
    // Nombre al�atoire entre 0 et 4 pour choisir al�atoirement une des 4 sorties.
    int sortie = (int) Math.floor(Math.random() * 4);
    switch (sortie) {
      case 0:
        positionSortie = new Point(elemFourmiliere.getX() + elemFourmiliere.getWidth() / 2,
            elemFourmiliere.getY());
        break;
      case 1:
        positionSortie = new Point(elemFourmiliere.getX() + elemFourmiliere.getWidth() / 2,
            elemFourmiliere.getY() + elemFourmiliere.getHeight());
        break;
      case 2:
        positionSortie = new Point(elemFourmiliere.getX() + elemFourmiliere.getHeight(),
            elemFourmiliere.getY() + elemFourmiliere.getHeight() / 2);
        break;
      case 3:
        positionSortie = new Point(elemFourmiliere.getX(),
            elemFourmiliere.getY() + elemFourmiliere.getHeight() / 2);
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

    this.maCase =
        this.fourmiliereG.getTerritoire().getCaseByCoord(rect.getX(), rect.getY());
  }

  @Override
  public GRect getElementGraphique() {
    return this.elementGraphique;
  }

}
