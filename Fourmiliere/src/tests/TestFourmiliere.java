package tests;

import static org.junit.Assert.assertTrue;

import modele.Fourmiliere;
import modele.Terrain;
import org.junit.jupiter.api.Test;
import simulation.Bilan;
import simulation.Logger;


class TestFourmiliere {
  private Terrain terrain = new Terrain();
  private Logger logger = new Logger("log.txt");
  private int nbStep = 0;

  private Fourmiliere fourmiliere = terrain.getFourmiliere();
  private int nbPonte = terrain.getFourmiliere().getNbPonte();
  private int nbFourmiCrees = 1;

  private boolean boucle = true;

  public void testStep() {
    terrain.step();
    nbStep++;
    terrain.bilan();
    Bilan b = terrain.getBilan();
    logger.creeLog(terrain.getBilan(), nbStep);
    int nbEnfants = b.getNbOeuf() + b.getNbLarve() + b.getNbNymphe();
    assertTrue(b.getNbFourmi() == b.getNbAdultes() + nbEnfants);
    assertTrue(b.getNbFourmi() + b.getNbCadavre() == nbFourmiCrees);
    if (b.getNbFourmi() == 0) {
      boucle = false;
    }
  }

  @Test
  void test() {
    fourmiliere.setTempsVie(100);
    int mortReine = fourmiliere.getTempsVieFourmiliere();

    assertTrue(fourmiliere.getNbFourmi() == 1);

    System.out.println("Temps de vie de la fourmilière : " + mortReine);


    for (int i = 0; i < mortReine; i++) {
      nbFourmiCrees += nbPonte;
      testStep();
    }

    while (boucle) {
      testStep();
    }

    terrain.bilan();
    assertTrue(terrain.getBilan().getNbCadavre() == nbFourmiCrees);

  }

}
