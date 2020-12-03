package etapes;

import infomodele.BilanGraphique;
import modele.Fourmi;
import modele.Fourmiliere;

/**
 * Classe cadavre, derniere etape de la vie d'une fourmi avant d'aªtre definitivement retirer de la
 * fourmiliere.
 */
public class Cadavre extends Etape {
  protected int tempsVie = 10;
  protected int dureeVie = 0;

  /**
   * Constructeur de cadavre.
   * 
   * @param fourmiliere : Foumiliere
   * @param fourmi : Fourmi
   */
  public Cadavre(Fourmiliere fourmiliere, Fourmi fourmi) {
    super(fourmiliere, fourmi);
  }

  @Override
  public Etape next(BilanGraphique b) {
    if (dureeVie == tempsVie) {
      fourmiliere.ajoutCadavre(fourmi);
      b.disparition(this.fourmi);
    }
    return this;
  }

  @Override
  public void step(BilanGraphique b) {
    this.dureeVie++;
  }
}
