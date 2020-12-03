package modele;

import bilan.BilanGraphique;
import etapes.Etape;
import etapes.Oeuf;
import simulation.Simulation;

/**
 * Classe de Fourmi, permet de représenter une fourmi en fonction de son étape d'évolution.
 */
public class Fourmi implements Simulation {
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
  @Override
  public void step(BilanGraphique b) {
    this.etape = this.etape.next(b);
    this.etape.step(b);
  }
}
