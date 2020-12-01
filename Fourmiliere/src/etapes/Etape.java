package etapes;

import modele.Fourmi;
import modele.Fourmiliere;

public abstract class Etape {

  protected Etape etape;
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
    this.etape = this.etape.next();
    this.etape.step();
  }
}
