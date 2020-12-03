package etapes;

import infomodele.BilanGraphique;
import modele.Fourmi;
import modele.Fourmiliere;
import roles.Role;
import roles.UsineRole;

/**
 * Classe Adulte, permettant de symboliser l'etape adulte de l'evolution. Une fourmi adulte a une
 * esperance de vie, une fourm adulte arrivee a la fin de son esperance de vie passe a l'etape
 * cadavre.
 *
 */
public class Adulte extends Etape {

  protected final int tempsVieMin = 548;
  protected final int tempsVieMax = 913;
  protected int tempsVie;
  protected int dureeVie;
  protected Role role;

  /**
   * Constructeur de la classe adulte. Initialise un temps de vie aleatoire d'une fourmi adulte
   * entre deux bornes d'esperance de vie.
   *  @param fourmiliere : fourmiliere de la fourmi
   *  @param fourmi : fourmi du role adulte
   */
  public Adulte(Fourmiliere fourmiliere, Fourmi fourmi) {
    super(fourmiliere, fourmi);
    this.tempsVie = (int) (Math.random() * (tempsVieMax - tempsVieMin) + tempsVieMin);
    this.dureeVie = 0;
    this.role = new UsineRole().creerRole(fourmiliere);
  }

  @Override
  public void step(BilanGraphique b) {
    b.deplacementFourmi(this.fourmi);
    this.dureeVie++;
  }

  public int getTempsVie() {
    return tempsVie;
  }

  public void setTempsVie(int tempsVie) {
    this.tempsVie = tempsVie;
  }

  /**
   * Si la duree de vie d'une fourmi adulte est egale a  son temps de vie, la fourmi meurt et
   * devient un cadavre.
   * 
   * @param b : BilanGraphique a  remplir
   * @return Le maªme object Adulte si duree de vie dureeVie == tempsVie, sinon renvoie un nouveau
   *         Cadavre
   */
  @Override
  public Etape next(BilanGraphique b) {
    if (this.dureeVie == this.tempsVie) {
      b.mort(this.fourmi);
      return new Cadavre(this.fourmiliere, this.fourmi);
    }
    return this;
  }

  public int getDureeVie() {
    return dureeVie;
  }

}
