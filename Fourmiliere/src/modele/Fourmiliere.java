package modele;

import java.util.ArrayList;
import java.util.List;
import simulation.Simulation;

public class Fourmiliere implements Simulation {
  List<Fourmi> listFourmi;

  /** Constructeur de fourmilière, initialise la liste de fourmis. **/
  public Fourmiliere() {
    this.listFourmi = new ArrayList<Fourmi>();
  }

  @Override
  public void step() {
    for (Fourmi f : listFourmi) {
      f.step();
    }
  }

}
