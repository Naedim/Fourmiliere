package etapes;

import modele.Bilan;
import modele.Fourmi;
import modele.Fourmiliere;
import simulation.Simulation;

public abstract class Etape implements Simulation {

  protected Etape etape;
  protected Fourmiliere fourmiliere;
  protected Fourmi fourmi;

  /**
   * .
   * 
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
  @Override
  public void step() {
    this.etape = this.etape.next();
    this.etape.step();
  }

  @Override
  public void bilan(Bilan b) {
    
  }
}
