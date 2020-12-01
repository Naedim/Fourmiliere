package modele;

import etapes.EtapeActuelle;
import simulation.Simulation;

public class Fourmi implements Simulation {
  EtapeActuelle etapeActuelle;

  /**
   * Constructeur de fourmi, initialise une fourmi à la première étape de sa vie. (Oeuf)
   */
  public Fourmi() {
    this.etapeActuelle = new EtapeActuelle();
  }

  @Override
  public void step() {
    this.etapeActuelle.step();
  }
}
