package etapes;

import modele.Fourmi;
import modele.Fourmiliere;

public class Larve extends Etape {

  protected final int tempsEvolution = 10;
  protected int dureeVie = 0;

  /**
   * .
   * 
   * @param f .
   * @param fourmi .
   */
  public Larve(Fourmiliere f, Fourmi fourmi) {
    super(f, fourmi);
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
