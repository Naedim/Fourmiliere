package simulation;

import modele.Fourmiliere;

public interface Simulation {

  /** Méthode incrémentant de 1 step la simulation, Un step équivaut à un jour. */
  public void step(Fourmiliere f);
}
