package main;

import etapes.Oeuf;

public class EtapeActuelle implements Simulation {

  protected Etape etapeActuelle;

  public EtapeActuelle() {
    this.etapeActuelle = new Oeuf();
  }

  /**
   * Méthode qui permet de passer à l'étape suivante de
   * l'évolution ou de finir sa vie.
   **/
  public void step() {
    this.etapeActuelle.step();
    this.etapeActuelle = this.etapeActuelle.next();
    if (this.etapeActuelle.equals(null)) {
      this.mourir();
    }
  }

  void mourir() {

  }

}
