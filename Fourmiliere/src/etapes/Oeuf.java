package etapes;

import modele.Fourmiliere;
import simulation.Simulation;

public class Oeuf implements Simulation, Etape {

  protected final int tempsEvolution = 3;
  protected int dureeVie = 0;
  protected Fourmiliere fourmiliere;

  public Oeuf(Fourmiliere f) {
    this.fourmiliere = f;
  }

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsEvolution) {
      // Ajout d'une larve
      return new Larve(this.fourmiliere);
    }
    return this;
  }
}
