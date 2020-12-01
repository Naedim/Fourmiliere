package modele;

import etapes.Etape;
import etapes.Oeuf;

public class Fourmi {
  Etape etape;

  /**
   * Constructeur de fourmi, initialise une fourmi à la première étape de sa vie. (Oeuf)
   */
  public Fourmi(Fourmiliere f) {
    this.etape = new Oeuf(f, this);
  }

  public void step() {
    this.etape = this.etape.next();
    this.etape.step();
  }
 
  
  public void bilan() {
    this.etape.bilan();
  }
}
