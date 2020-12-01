package etapes;

import modele.Fourmiliere;

public class Larve implements Etape {

  protected final int tempsEvolution = 10;
  protected int dureeVie = 0;

  public Larve() {
  }

  @Override
  public void step(Fourmiliere f) {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsEvolution) {
      return new Nymphe();
    }
    return this;
  }

}
