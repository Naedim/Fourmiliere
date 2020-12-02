package simulation;

import vue.ControlleurGraphique;

public class Simulateur {

  /**
   * Classe simulation, permet de simuler le fonctionnement d'une fourmiliÃ¨re jusqu'Ã  ce qu'elle
   * disparaisse.
   * 
   * @param args : arg
   * @throws InterruptedException : Erreur liÃ© au Thread.sleep
   */
  public static void main(String[] args) throws InterruptedException {
<<<<<<< HEAD

    ControlleurGraphique cg = new ControlleurGraphique();

=======
    Terrain terrain = new Terrain();
    
    while (true) { 
      terrain.step();   
      Thread.sleep(10); 
    } 
>>>>>>> Graphique
  }
}
