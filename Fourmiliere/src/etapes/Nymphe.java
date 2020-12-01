package etapes;

import modele.Fourmiliere;
import simulation.Simulation;

public class Nymphe implements Simulation, Etape {

  protected final int tempsEvolution = 5;
  protected int dureeVie = 0;
  protected Fourmiliere fourmiliere;

  public Nymphe(Fourmiliere f) {
    this.fourmiliere = f;
    this.fourmiliere.incrementNbNymphe();
  }

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsEvolution) {
      return new Adulte(this.fourmiliere);
    }
    return this;
  }

}
