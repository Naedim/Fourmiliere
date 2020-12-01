package etapes;

import modele.Fourmi;
import modele.Fourmiliere;

public class EtapeActuelle {

  protected Etape etapeActuelle;

  public EtapeActuelle(Fourmiliere f, Fourmi fourmi) {
    this.etapeActuelle = new Oeuf(f, fourmi);
  }

  /**
   * Méthode qui permet de passer à l'étape suivante de
   * l'évolution ou de finir sa vie.
   **/
  public void step() {
    this.etapeActuelle.step();
    this.etapeActuelle = this.etapeActuelle.next();
  }
}
