package simulation;

import modele.Terrain;

public class Simulateur {

  /**
   * Classe simulation, permet de simuler le fonctionnement d'une fourmiliere jusqu'a� ce qu'elle
   * disparaisse.
   * 
   * @param args : arg
   * @throws InterruptedException : Erreur liee au Thread.sleep
   */
  public static void main(String[] args) throws InterruptedException {
    ControlleurGraphique cg = new ControlleurGraphique();
    Terrain terrain = new Terrain();

    while (true) {
      terrain.step();
      cg.updateIhm(terrain.getBilan());
      Thread.sleep(20);
    }
  }
}
