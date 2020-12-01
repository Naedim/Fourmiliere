package simulation;

import modele.Bilan;

public interface Simulation {

  /** Méthode incrémentant de 1 step la simulation, Un step équivaut à un jour. */
  public void step();
  
  public void bilan(Bilan b);
}
