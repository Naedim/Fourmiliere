package simulation;

import modele.Terrain;

public class Simulateur {

  /**
   * Classe simulation, permet de simuler le fonctionnement d'une fourmilière jusqu'à ce qu'elle
   * disparaisse.
   * 
   * @param args : arg
   * @throws InterruptedException : Erreur liée au Thread.sleep
   */
  public static void main(String[] args) throws InterruptedException {

    ControlleurGraphique cg = new ControlleurGraphique();
    Terrain terrain = new Terrain();

    while (true) {
      terrain.step();
      cg.updateIhm(terrain.getBilan());
      Thread.sleep(1);
    }
  }
}
