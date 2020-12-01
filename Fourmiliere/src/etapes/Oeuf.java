package etapes;

import modele.Fourmi;
import modele.Fourmiliere;
import simulation.Simulation;

public class Oeuf implements Simulation, Etape {

  protected final int tempsEvolution = 3;
  protected int dureeVie = 0;
  protected Fourmiliere fourmiliere;
  protected Fourmi fourmi;
  
  
  public Oeuf(Fourmiliere f, Fourmi fourmi) {
    this.fourmiliere = f;
    this.fourmi = fourmi;
  }

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsEvolution) {
      // Ajout d'une larve
      this.fourmiliere.decrementNbOeuf();
      return new Larve(this.fourmiliere, this.fourmi);
    }
    return this;
  }
}
