package vue;

import graphicLayer.GRect;
import graphicLayer.GSpace;
import java.awt.Color;
import java.awt.Point;

/**
 * Homologue graphique de la classe Proie du modele Pouvant se déplacer librement dans le terrain.
 * Une proie appartient au TerrainGraphique. Elle connait son TerrainGraphique. 
 * Celle-ci a une taille et une couleur par défault.
 * * @author Damien
 *
 */
public class ProieGraphique implements ElementGraphique {
  protected final int tailleProie = 10;
  protected final Color couleurProie = Color.GREEN;
  protected GRect elementGraphique;
  protected TerrainGraphique terrainGraphique;


  /**
   * Une proie apparait aléatoirement sur son Terrain.
   * @param terrainGraphique : Le terrain dans laquelle la proie est
   */
  public ProieGraphique(TerrainGraphique terrainGraphique) {
    this.terrainGraphique = terrainGraphique;

    GRect rect = new GRect();
    rect.setWidth(this.tailleProie);
    rect.setHeight(this.tailleProie);
    GSpace space = this.terrainGraphique.getElementGraphique();
    int posX = (int) Math.floor(Math.random() * space.getWidth());
    int posY = (int) Math.floor(Math.random() * space.getHeight());

    rect.setPosition(new Point(posX, posY));
    rect.setColor(this.couleurProie);
    rect.withoutBorder();
    this.elementGraphique = rect;
  }

  @Override
  public GRect getElementGraphique() {
    return this.elementGraphique;
  }
}
