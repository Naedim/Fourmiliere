package etapes;

import modele.Fourmi;
import modele.Fourmiliere;

public abstract class Etape {

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
    this.etapeActuelle = new Oeuf(f, fourmi);
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
