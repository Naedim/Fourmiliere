package etapes;

import modele.Fourmi;
import modele.Fourmiliere;
import roles.Ouvrier;
import roles.Role;
import roles.Soldat;
import roles.UsineRole;

public class Adulte extends Etape implements Role {

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
    
    if (dureeVie == tempsVie) {
      
      if (this.role instanceof Ouvrier) {
        this.fourmiliere.decrementNbOuvrier();
      } else if (this.role instanceof Soldat) {
        this.fourmiliere.decrementNbSoldat();
      } else {
        this.fourmiliere.decrementNbSexue();
      }
    }
  }

  @Override
  public Etape next() {
    return this;
  }

}
