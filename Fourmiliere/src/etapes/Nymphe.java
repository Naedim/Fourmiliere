package etapes;

import modele.Fourmi;
import modele.Fourmiliere;
import vue.BilanGraphique;

/**
 * Classe Nymphe, 3ème étape de l'évolution d'une fourmi. Evolue en fourmi Adulte après 
 * un temps d'évolution précis.
 */
public class Nymphe extends Etape {

  protected final int tempsEvolution = 5;
  protected int dureeVie = 0;

  /**
   * Constructeur de nymphe.
   * 
   * @param f : Fourmiliere
   * @param fourmi : Fourmi
   */
  public Nymphe(Fourmiliere f, Fourmi fourmi) {
    super(f, fourmi);
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
      b.maturite();
      return new Adulte(this.fourmiliere, this.fourmi);
    }
    return this;
  }
}
