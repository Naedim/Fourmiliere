package simulation;

import modele.Terrain;

public class Simulateur {

  /**
   * Classe simulation.
   * 
   * @param args : arg
   * @throws InterruptedException : d
   */
  public static void main(String[] args) throws InterruptedException {

    Terrain terrain = new Terrain();
    System.out.println(
        "Temps de vie de la fourmilière : " + terrain.getFourmiliere().getTempsVieFourmiliere());

    Logger logger = new Logger("log.txt");
    int nbStep = 0;

    while (true) {
      if (terrain.getFourmiliere().getTempsVieFourmiliere() > nbStep + 100) {
        terrain.step();
        nbStep++;

        logger.creeLog(terrain.getFourmiliere().faireUnBilan(), nbStep);
        Thread.sleep(10);
      } else {
        System.out.println("Fin, stop le programme");
      }
    }
  }
}
