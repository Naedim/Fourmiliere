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

  @Override
  public void step() {
  
  }

}
