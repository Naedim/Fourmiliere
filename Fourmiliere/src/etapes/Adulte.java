package etapes;

import main.Etape;
import roles.Role;
import roles.UsineRole;

public class Adulte implements Etape, Role {

  protected final int tempsVieMin = 548;
  protected final int tempsVieMax = 913;
  protected int tempsVie;
  protected int dureeVie;
  protected Role role;

  /**Constructeur de la classe adulte.
   *  
   */
  public Adulte() {
    this.tempsVie = (int) (Math.random() * (tempsVieMax - tempsVieMin));
    this.dureeVie = 0;
    this.role = new UsineRole().creerRole();
  }

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (dureeVie == tempsVie) {
      return null;
    }
    return this;
  }

}
