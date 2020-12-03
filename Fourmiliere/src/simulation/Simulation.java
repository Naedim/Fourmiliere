package simulation;

import bilangraphique.BilanGraphique;

public interface Simulation {

  /**
   * Méthode qui permet d'incrémenter de 1 step le temps de simulation, 1 step représente 1 jour.
   * @param bilan : BilanGraphique à remplir
   **/
  public void step(BilanGraphique bilan);
}
