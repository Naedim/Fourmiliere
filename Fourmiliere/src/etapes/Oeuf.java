package etapes;

import modele.Fourmiliere;
import simulation.Simulation;

public class Oeuf implements Simulation, Etape {

  protected final int tempsEvolution = 3;
  protected int dureeVie = 0;
  protected Fourmiliere fourmiliere;

  public Oeuf() {
    
  }

  @Override
  public void step(Fourmiliere f) {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsEvolution) {
      return new Larve();
    }
    return this;
  }

}
