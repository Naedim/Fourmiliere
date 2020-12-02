package modele;

import bilan.BilanGraphique;
import etapes.Etape;
import etapes.Oeuf;

/**
 * Classe de Fourmi, permet de représenter une fourmi en fonction de son étape d'évolution.
 */
public class Fourmi {
  Etape etape;
  int index;

  public Etape getEtape() {
    return etape;
  }

  /**
   * Constructeur de fourmi, initialise une fourmi à la première étape de sa vie. (Oeuf)
   */
  public Fourmi(Fourmiliere f) {
    this.etape = new Oeuf(f, this);
    this.index = f.getListFourmi().size() - 1;
  }

  
  public int getIndex() {
    return index;
  }

  /**
   * Méthode permettant de lancer le processus d'évolution.
   */
  public void step(BilanGraphique b) {
    this.etape = this.etape.next(b);
    this.etape.step(b);
  }
}
