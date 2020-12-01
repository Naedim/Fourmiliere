package modele;

import etapes.EtapeActuelle;

public class Fourmi {
  EtapeActuelle etapeActuelle;

  /**
   * Constructeur de fourmi, initialise une fourmi à la première étape de sa vie. (Oeuf)
   */
  public Fourmi(Fourmiliere f) {
    this.etapeActuelle = new EtapeActuelle(f, this);
  }

  public void step() {
    this.etapeActuelle.step();
  }
}
