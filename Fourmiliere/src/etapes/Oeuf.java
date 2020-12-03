package etapes;

import infomodele.BilanGraphique;
import modele.Fourmi;
import modele.Fourmiliere;

/**
 * Classe Oeuf, 1ere etape de l'evolution d'une fourmi. Evolue en larve apres 
 * un temps d'evolution precis.
 */
public class Oeuf extends Etape {

  protected final int tempsEvolution = 3;
  protected int dureeVie = 0;

  /**
   * Constructeur d'oeuf.
   * 
   * @param fourmiliere : Fourmiliere
   * @param fourmi : Fourmi
   */
  public Oeuf(Fourmiliere fourmiliere, Fourmi fourmi) {
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

      return new Larve(this.fourmiliere, this.fourmi);
    }
    return this;
  }
}
