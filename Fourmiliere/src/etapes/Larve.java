package etapes;

import modele.Fourmi;
import modele.Fourmiliere;
import simulation.Bilan;

/**
 * Classe Larve, 2ème étape de l'évolution d'une fourmi. Evolue en Nymphe après un temps
 * d'évolution précis.
 */
public class Larve extends Etape {

  protected final int tempsEvolution = 10;
  protected int dureeVie = 0;

  /**
   * Constructeur de larve.
   * 
   * @param f : Fourmiliere
   * @param fourmi : Fourmi
   */
  public Larve(Fourmiliere f, Fourmi fourmi) {
    super(f, fourmi);
  }
  
  public int getTempsEvolution() {
    return tempsEvolution;
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
}
