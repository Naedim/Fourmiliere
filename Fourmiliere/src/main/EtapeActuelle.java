package main;

import etapes.Oeuf;

public class EtapeActuelle implements Simulation {

  protected Etape etapeActuelle;

  public EtapeActuelle() {
    this.etapeActuelle = new Oeuf();
  }

  public void step() {
    this.etapeActuelle.step();
    this.etapeActuelle = this.etapeActuelle.next();
  }

  void mourrir() {

  }

}
