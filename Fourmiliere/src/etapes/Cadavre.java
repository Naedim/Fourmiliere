package etapes;

import bilangraphique.BilanGraphique;
import modele.Fourmi;
import modele.Fourmiliere;

/**
 * Classe cadavre, dernière étape de la vie d'une fourmi avant d'être définitivement 
 * retirer de la fourmilière.
 */
public class Cadavre extends Etape {
  protected int tempsVie = 10;
  protected int dureeVie = 0;

  /**
   * Constructeur de cadavre.
   * 
   * @param f : Foumilière
   * @param fourmi : Fourmi
   */
  public Cadavre(Fourmiliere f, Fourmi fourmi) {
    super(f, fourmi);
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
