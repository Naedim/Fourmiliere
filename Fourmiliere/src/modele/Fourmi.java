package modele;

import bilangraphique.BilanGraphique;
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

  @Override
  public void step(BilanGraphique b) {
    this.etape = this.etape.next(b);
    this.etape.step(b);
  }
}
