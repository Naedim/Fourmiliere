package etapes;

import modele.Fourmi;
import modele.Fourmiliere;
import simulation.Bilan;

/**
 * Classe cadavre, dernière étape de la vie d'une fourmi.
 */
public class Cadavre extends Etape {
  protected int tempsVie = 2;
  protected int dureeVie = 0;

  /**
   * Constructeur de cadavre.
   * 
   * @param f : Fourmiliere
   * @param fourmi : Fourmi
   */
  public Cadavre(Fourmiliere f, Fourmi fourmi) {
    super(f, fourmi);
  }

  @Override
  public Etape next() {
    return this;
  }
  
  @Override 
  public void step() {
    this.dureeVie++;
  }
  
  @Override
  public void bilan(Bilan b) {
    b.incrementNbCadavre();
  }
}
