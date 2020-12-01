package etapes;

import modele.Fourmiliere;
import roles.Role;
import roles.UsineRole;

public class Adulte implements Etape, Role {

  protected final int tempsVieMin = 548;
  protected final int tempsVieMax = 913;
  protected int tempsVie;
  protected int dureeVie;
  protected Role role;
  protected Fourmiliere fourmiliere;

  /** Constructeur de la classe adulte.
   *  
   */
  public Adulte(Fourmiliere f) {
    this.fourmiliere = f;
    this.tempsVie = (int) (Math.random() * (tempsVieMax - tempsVieMin));
    this.dureeVie = 0;
    this.role = new UsineRole().creerRole(f);
  }

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (dureeVie == tempsVie) {
      this.fourmiliere.
    }
    return this;
  }

}
