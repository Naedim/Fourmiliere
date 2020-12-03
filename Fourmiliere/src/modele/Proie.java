package modele;

import infomodele.BilanGraphique;
import simulation.Simulation;

/**
 * Classe Proie, represente le modele proie et ses actions.
 */
public class Proie implements Simulation {

  @Override
  public void step(BilanGraphique bilan) {
    for (int i = 0; i < 5; i++) {
      bilan.deplacementProie(this);
    }

  }

}
