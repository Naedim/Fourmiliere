package vue;

import java.awt.Dimension;
import java.awt.Point;


public class ControlleurGraphique {

  protected TerrainGraphique terrain;



  /**
   * Crée un terrain avec une fourmilière et un territoire.
   */
  public ControlleurGraphique() {

    Point posFourmiliere = new Point(350, 350);
    Dimension dimFourmiliere = new Dimension(100, 100);
    terrain = new TerrainGraphique(posFourmiliere, dimFourmiliere);

    // modifier avec valeurs de l'objet fourmiliere


  }

  public TerrainGraphique getTerrain() {
    return terrain;
  }


}
