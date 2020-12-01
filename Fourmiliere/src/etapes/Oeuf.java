package etapes;

import modele.Fourmi;
import modele.Fourmiliere;
import simulation.Bilan;

/**
 * Classe Oeuf, 1ère étape de l'évolution d'une fourmi. Evolue en larve après 
 * un temps d'évolution précis.
 */
public class Oeuf extends Etape {

  protected final int tempsEvolution = 3;
  protected int dureeVie = 0;

  /**
   * Constructeur d'oeuf.
   * 
   * @param f : Fourmiliere
   * @param fourmi : Fourmi
   */
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

  @Override
  public void bilan(Bilan b) {
    b.incrementNbOeuf();
  }
}
