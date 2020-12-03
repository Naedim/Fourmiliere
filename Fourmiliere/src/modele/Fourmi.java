package modele;

import etapes.Etape;
import etapes.Oeuf;
import infomodele.BilanGraphique;
import simulation.Simulation;

/**
 * Classe de Fourmi, permet de representer une fourmi en fonction de son etape d'evolution.
 */
public class Fourmi implements Simulation {
  Etape etape;

  public Etape getEtape() {
    return etape;
  }

  /**
   * Constructeur de fourmi, initialise une fourmi a  la premiere etape de sa vie. (Oeuf)
   */
  public Fourmi(Fourmiliere fourmiliere) {
    this.etape = new Oeuf(fourmiliere, this);
  }

  @Override
  public void step(BilanGraphique b) {
    this.etape = this.etape.next(b);
    this.etape.step(b);
  }
}
