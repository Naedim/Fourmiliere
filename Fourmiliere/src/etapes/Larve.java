package etapes;

import modele.Fourmi;
import modele.Fourmiliere;

public class Larve implements Etape {

  protected final int tempsEvolution = 10;
  protected int dureeVie = 0;
  protected Fourmiliere fourmiliere;
  protected Fourmi fourmi;

  /**
   * .
   * 
   * @param f .
   * @param fourmi .
   */
  public Larve(Fourmiliere f, Fourmi fourmi) {
    this.fourmiliere = f;
    this.fourmi = fourmi;
    this.fourmiliere.incrementNbLarve();
  }

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsEvolution) {
      this.fourmiliere.decrementNbLarve();
      return new Nymphe(this.fourmiliere, this.fourmi);
    }
    return this;
  }

}
