package etapes;

import modele.Fourmi;
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
  protected Fourmi fourmi;

  /**
   * Constructeur de la classe adulte.
   * 
   */
  public Adulte(Fourmiliere f, Fourmi fourmi) {
    this.fourmiliere = f;
    this.fourmi = fourmi;
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
      this.fourmiliere.mortFourmi(this.fourmi);
    }
    return this;
  }

}
