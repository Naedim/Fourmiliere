package etapes;

import bilangraphique.BilanGraphique;
import modele.Fourmi;
import modele.Fourmiliere;

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

      return new Larve(this.fourmiliere, this.fourmi);
    }
    return this;
  }
}
