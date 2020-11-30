package main;

import simulation.Simulation;

public class Terrain implements Simulation {
  Fourmiliere fourmiliere;

  /**
   * Constructeur de terrain, créer un terrain dans lequel est installé une fourmilière.
   */
  public Terrain() {
    this.fourmiliere = new Fourmiliere();
  }

  public Fourmiliere getFourmiliere() {
    return fourmiliere;
  }

  @Override
  public void step() {
  
  }

}
