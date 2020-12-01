package modele;

import etapes.EtapeActuelle;

public class Fourmi {
  EtapeActuelle etapeActuelle;

  /**
   * Constructeur de fourmi, initialise une fourmi à la première étape de sa vie. (Oeuf)
   */
  public Fourmi() {
    this.etapeActuelle = new EtapeActuelle();
  }

  public void step(Fourmiliere f) {
    this.etapeActuelle.step(f);
  }
}
