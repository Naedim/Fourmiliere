package etapes;

import modele.Bilan;
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
  }

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsEvolution) {
      return new Nymphe(this.fourmiliere, this.fourmi);
    }
    return this;
  }
  
  @Override
  public void bilan(Bilan b) {
    b.incrementNbLarve();
  }

}
