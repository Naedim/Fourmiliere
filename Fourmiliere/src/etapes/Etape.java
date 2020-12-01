package etapes;

import modele.Fourmi;
import modele.Fourmiliere;
import simulation.Simulation;

public abstract class Etape implements Simulation {

  protected Etape etapeActuelle;
  protected Fourmiliere fourmiliere;
  protected Fourmi fourmi;

  /**
   *  .
   * @param f : d
   * @param fourmi : f
   */
  public Etape(Fourmiliere f, Fourmi fourmi) {
    this.fourmiliere = f;
    this.fourmi = fourmi;
  }

  public abstract Etape next();

  /**
   * Méthode qui permet de passer à l'étape suivante de l'évolution ou de finir sa vie.
   **/
  public void step() {
    this.etapeActuelle.step();
    this.etapeActuelle = this.etapeActuelle.next();
  }
}
