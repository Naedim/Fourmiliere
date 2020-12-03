package etapes;

import infomodele.BilanGraphique;
import modele.Fourmi;
import modele.Fourmiliere;

/**
 * Classe Nymphe, 3eme etape de l'evolution d'une fourmi. Evolue en fourmi Adulte apres 
 * un temps d'evolution precis.
 */
public class Nymphe extends Etape {

  protected final int tempsEvolution = 5;
  protected int dureeVie = 0;

  /**
   * Constructeur de nymphe.
   * 
   * @param fourmiliere : Fourmiliere
   * @param fourmi : Fourmi
   */
  public Nymphe(Fourmiliere fourmiliere, Fourmi fourmi) {
    super(fourmiliere, fourmi);
  }

  public int getTempsEvolution() {
    return tempsEvolution;
  }
  
  @Override
  public void step(BilanGraphique b) {
    this.dureeVie++;
  }

  @Override
  public Etape next(BilanGraphique b) {
    if (this.dureeVie == this.tempsEvolution) {
      b.maturiteFourmi(this.fourmi);
      return new Adulte(this.fourmiliere, this.fourmi);
    }
    return this;
  }
}
