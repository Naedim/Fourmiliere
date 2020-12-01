package etapes;

import modele.Fourmi;
import modele.Fourmiliere;
import roles.Role;
import roles.UsineRole;

public class Adulte extends Etape {

  protected final int tempsVieMin = 548;
  protected final int tempsVieMax = 913;
  protected int tempsVie;
  protected int dureeVie;
  protected Role role;

  /**
   * Constructeur de la classe adulte.
   * 
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

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsVie) {
      return new Adulte(this.fourmiliere, this.fourmi);
    }
    return this;
  }
  
  @Override 
  public void bilan() {
    this.role.bilan();
  }

}
