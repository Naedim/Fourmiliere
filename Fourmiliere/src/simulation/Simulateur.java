package simulation;

import main.Terrain;

public class Simulateur {

  /**
   * Classe simulation.
   * 
   * @param args : arg
   */
  public static void main(String[] args) {

    Terrain terrain = new Terrain();
    Logger logger = new Logger("log.txt");

    while (true) {
      logger.creeLog(terrain.getFourmiliere());
      // sleep(10);
    }
  }
}
