package etapes;

import modele.Fourmi;
import modele.Fourmiliere;
import vue.BilanGraphique;

/**
 * Classe cadavre, derni�re �tape de la vie d'une fourmi.
 */
public class Cadavre extends Etape {
  protected int tempsVie = 2;
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
      b.disparition(fourmi.getIndex());
    }
    return this;
  }

  @Override
  public void step(BilanGraphique b) {
    this.dureeVie++;
  }
}
