package modele;

import bilangraphique.BilanGraphique;
import simulation.Simulation;

public class Proie implements Simulation {

  @Override
  public void step(BilanGraphique bilan) {
    for (int i = 0; i < 5; i++) {
      bilan.deplacementProie(this);
    }

  }

}
