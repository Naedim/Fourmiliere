package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Point;

/**Homologue graphique de la classe Fourmi du modèle.
 * 
 * @author Damien
 *
 */
public class FourmiGraphique implements ElementGraphique {

  
  protected final int tailleFourmi = 4; //taille par défaut de la représentation graphique d'une fourmi 
  protected final Color couleurFourmi = Color.RED;
  protected GRect elementGraphique;
  protected GRect fourmiliereG;

  /**
   * .
   * 
   */
  public FourmiGraphique(GRect fourmiliereG) {
    Point positionSortie = new Point();
    int sortie = (int) Math.floor(Math.random() * 4);

    Point sortieHaut =
        new Point(fourmiliereG.getX() + fourmiliereG.getWidth() / 2, fourmiliereG.getY());

    Point sortieBas = new Point(fourmiliereG.getX() + fourmiliereG.getWidth() / 2,
        fourmiliereG.getY() + fourmiliereG.getHeight());

    Point sortieDroite = new Point(fourmiliereG.getX() + fourmiliereG.getHeight(),
        fourmiliereG.getY() + fourmiliereG.getHeight() / 2);

    Point sortieGauche =
        new Point(fourmiliereG.getX(), fourmiliereG.getY() + fourmiliereG.getHeight() / 2);

    switch (sortie) {
      case 0:
        positionSortie = sortieHaut;
        break;
      case 1:
        positionSortie = sortieBas;
        break;
      case 2:
        positionSortie = sortieDroite;
        break;
      case 3:
        positionSortie = sortieGauche;
        break;
      default:
    }

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
