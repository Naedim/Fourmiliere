package etapes;

import modele.Fourmi;
import modele.Fourmiliere;

public class Oeuf extends Etape {

  protected final int tempsEvolution = 3;
  protected int dureeVie = 0;

  public Oeuf(Fourmiliere f, Fourmi fourmi) {
    super(f, fourmi);
  }

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsEvolution) {
      // Ajout d'une larve
      return new Larve(this.fourmiliere, this.fourmi);
    }
    return this;
  }
}
