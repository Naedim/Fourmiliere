package etapes;

import modele.Fourmi;
import modele.Fourmiliere;
import roles.Role;
import roles.UsineRole;
import simulation.Bilan;

/**
 * Classe Adulte, permettant de symboliser l'étape adulte de l'évolution.
 * Une fourmi adulte � une esp�rance de vie, une fourm adulte arriv�e
 *  � la fin de son esp�rance de vie passe � l'�tape cadavre.
 *
 */
public class Adulte extends Etape {

  protected final int tempsVieMin = 548;
  protected final int tempsVieMax = 913;
  protected int tempsVie;
  protected int dureeVie;
  protected Role role;

  /**
   * Constructeur de la classe adulte. Initialise un temps de vie al�atoired'une fourmi adulte entre
   * deux bornes d'esp�rance de vie.
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
   * Si la dur�e de vie d'une fourmi adulte est �gale � son temps de vie, la fourmi meurt et devient
   * un cadavre.
   * 
   * @return le m�me object Adulte si dur�e de vie dureeVie == tempsVie, sinon renvoie un nouveau
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
