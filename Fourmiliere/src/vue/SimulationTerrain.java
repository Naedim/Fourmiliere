
package vue;

import graphicLayer.GRect;
import graphicLayer.GSpace;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;


public class SimulationTerrain {

  /**
   * .
   */
  public SimulationTerrain() {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        initialisationTerrain();
      }
    });
  }

  /**
   * M�thode permettant d'initialiser le terrain, place une fourmiliere � un endroit et l'entoure
   * d'une zone "territoire" de 3 * la taille de fourmiliere.
   * 
   */
  public void initialisationTerrain() {
<<<<<<< HEAD:Fourmiliere/src/vue/SimulationTerrain.java
    Terrain objTerrain = new Terrain();

=======
>>>>>>> Graphique:Fourmiliere/src/graphique/SimulationTerrain.java
    // modifier pour une position al�atoire
    Point posFourmiliere = new Point(350, 350);
    Dimension dimFourmiliere = new Dimension(100, 100);
    GRect fourmiliere = new GRect();
    fourmiliere.setColor(Color.BLACK);
    fourmiliere.setPosition(posFourmiliere);
    // modifier avec valeurs de l'objet fourmiliere
    fourmiliere.setDimension(dimFourmiliere);

    Point positionTerritoire =
        new Point((int) posFourmiliere.getX() - (int) (dimFourmiliere.getWidth() * 2),
            (int) posFourmiliere.getY() - (int) (dimFourmiliere.getHeight() * 2));
    GRect territoire = new GRect();
    territoire.setColor(Color.WHITE);
    territoire.withBorder();
    territoire.setBorderColor(Color.BLACK);
    territoire.setPosition(positionTerritoire);
    // modifier avec valeurs de l'objet fourmiliere
    territoire.setDimension(
        new Dimension((int) dimFourmiliere.getHeight() * 5, (int) dimFourmiliere.getWidth() * 5));

    GSpace terrain = new GSpace("Simulation d'un terrain", new Dimension(1000, 800));
    terrain.setColor(Color.WHITE);
    terrain.addElement(territoire);
    terrain.addElement(fourmiliere);
    terrain.open();
  }
}
