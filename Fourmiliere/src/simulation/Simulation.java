package simulation;

import infomodele.BilanGraphique;

public interface Simulation {

  /**
   * Methode qui permet d'incrementer de 1 step le temps de simulation, 1 step represente 1 jour.
   * @param bilan : BilanGraphique a  remplir
   **/
  public void step(BilanGraphique bilan);
}
