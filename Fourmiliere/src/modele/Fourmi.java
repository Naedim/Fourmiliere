package modele;

import etapes.Etape;
import etapes.Oeuf;
import vue.BilanGraphique;

/**
 * Classe de Fourmi, permet de représenter une fourmi en fonction de son étape d'évolution.
 */
public class Fourmi {
  Etape etape;

  public Etape getEtape() {
    return etape;
  }

  /**
   * Constructeur de fourmi, initialise une fourmi à la première étape de sa vie. (Oeuf)
   */
  public Fourmi(Fourmiliere f) {
    this.etape = new Oeuf(f, this);
  }

  /**
   * Méthode permettant de lancer le processus d'évolution.
   */
  public void step(BilanGraphique b) {
    this.etape = this.etape.next();
    this.etape.step(b);
  }
}
