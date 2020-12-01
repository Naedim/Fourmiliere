package etapes;

import modele.Fourmiliere;

public class EtapeActuelle {

  protected Etape etapeActuelle;

  public EtapeActuelle() {
    this.etapeActuelle = new Oeuf();
  }

  /**
   * Méthode qui permet de passer à l'étape suivante de
   * l'évolution ou de finir sa vie.
   **/
  public void step(Fourmiliere f) {
    this.etapeActuelle.step(f);
    this.etapeActuelle = this.etapeActuelle.next();
  }
}
