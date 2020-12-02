package simulation;

import modele.Terrain;

public class Simulateur {

  /**
   * Classe simulation, permet de simuler le fonctionnement d'une fourmiliÃ¨re jusqu'Ã  
   * ce qu'elle disparaisse.
   * 
   * @param args : arg
   * @throws InterruptedException : Erreur liÃ© au Thread.sleep
   */
  public static void main(String[] args) throws InterruptedException {

    Terrain terrain = new Terrain();
    System.out.println(
        "Temps de vie de la fourmiliÃ¨re : " + terrain.getFourmiliere().getTempsVieFourmiliere());

    Logger logger = new Logger("log.txt");
    int nbStep = 0;
    while (true) {
      terrain.step();
      nbStep++;
      terrain.bilan();
      Bilan bilan = terrain.getBilan();
      logger.creeLog(terrain.getBilan(), nbStep);

      if (bilan.getNbFourmi() == 0) {
        break;
      }
      Thread.sleep(10);
    }
  }
}
