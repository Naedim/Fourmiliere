package etapes;

import modele.Fourmi;
import modele.Fourmiliere;
import roles.Role;
import roles.UsineRole;
import simulation.Bilan;

/**
 * Classe Adulte, permettant de symboliser l'Ã©tape adulte de l'Ã©volution.
 * Une fourmi adulte à une espérance de vie, une fourm adulte arrivée
 *  à la fin de son espérance de vie passe à l'étape cadavre.
 *
 */
public class Adulte extends Etape {

  protected final int tempsVieMin = 548;
  protected final int tempsVieMax = 913;
  protected int tempsVie;
  protected int dureeVie;
  protected Role role;

  /**
   * Constructeur de la classe adulte. Initialise un temps de vie aléatoired'une fourmi adulte entre
   * deux bornes d'espérance de vie.
   */
  public Adulte(Fourmiliere f, Fourmi fourmi) {
    super(f, fourmi);
    this.tempsVie = (int) (Math.random() * (tempsVieMax - tempsVieMin) + tempsVieMin);
    this.dureeVie = 0;
    this.role = new UsineRole().creerRole(f);
  }

  @Override
  public void step() {
    this.dureeVie++;
  }

  /**
   * Si la durée de vie d'une fourmi adulte est égale à son temps de vie, la fourmi meurt et devient
   * un cadavre.
   * 
   * @return le même object Adulte si durée de vie dureeVie == tempsVie, sinon renvoie un nouveau
   *         Cadavre
   */
  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsVie) {
      return new Cadavre(this.fourmiliere, this.fourmi);
    }
    return this;
  }

  @Override
  public void bilan(Bilan b) {
    this.role.bilan(b);
  }

}
