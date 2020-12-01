package etapes;

import modele.Fourmiliere;

public class Larve implements Etape {

  protected final int tempsEvolution = 10;
  protected int dureeVie = 0;
  protected Fourmiliere fourmiliere;

  public Larve(Fourmiliere f) {
    this.fourmiliere = f;
    this.fourmiliere.incrementNbLarve();
  }

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsEvolution) {
      return new Nymphe(this.fourmiliere);
    }
    return this;
  }

}
