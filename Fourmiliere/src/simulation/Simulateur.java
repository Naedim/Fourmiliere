package simulation;

import main.Terrain;

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

    while (true) {
      logger.creeLog(terrain.getFourmiliere());
      Thread.sleep(1000);
    }
  }
}
