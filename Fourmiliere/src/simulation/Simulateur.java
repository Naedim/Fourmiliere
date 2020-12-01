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
    Logger logger = new Logger("log.txt");
    int nbStep = 0;

    while (true) {
      terrain.step();
      nbStep++;
      logger.creeLog(terrain.getFourmiliere(), nbStep);
      Thread.sleep(10);
    }
  }
}
