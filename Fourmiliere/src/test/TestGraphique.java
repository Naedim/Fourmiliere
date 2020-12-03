package test;


import static org.junit.Assert.assertTrue;

import java.awt.Point;
import modele.Fourmi;
import modele.Proie;
import org.junit.jupiter.api.Test;
import simulation.ControlleurGraphique;
import vue.FourmiGraphique;
import vue.FourmiliereGraphique;
import vue.ProieGraphique;
import vue.TerrainGraphique;

class TestGraphique {

  /**
   * Test de quelques méthodes de TerrainGraphique / ProieGraphique / FourmiGraphique.
   */
  @Test
  void testElementGraphique() {
    ControlleurGraphique cg = new ControlleurGraphique();

    TerrainGraphique terrainG = cg.getTerrain();
    assertTrue(terrainG.getListProie().size() == 0);
    assertTrue(terrainG.getElementGraphique().getWidth() == 1000);
    assertTrue(terrainG.getElementGraphique().getHeight() == 800);


    Proie proie = new Proie();
    terrainG.ajouterProie(proie);
    assertTrue(terrainG.getListProie().size() == 1);

    ProieGraphique proieRecup = terrainG.getListProie().get(proie);
    int posX = proieRecup.getElementGraphique().getX();
    int posY = proieRecup.getElementGraphique().getY();

    terrainG.deplacerProie(proie, new Point(posX + 5, posY + 3));
    proieRecup = terrainG.getListProie().get(proie);
    assertTrue(posX != proieRecup.getElementGraphique().getX());
    assertTrue(posY != proieRecup.getElementGraphique().getY());


    FourmiliereGraphique fourmiliereG = terrainG.getFourmiliere();
    assertTrue(fourmiliereG.getListFourmi().size() == 0);
    assertTrue(fourmiliereG.getElementGraphique().getWidth() == 100);
    assertTrue(fourmiliereG.getElementGraphique().getHeight() == 100);

    Fourmi fourmi = new Fourmi(null);
    fourmiliereG.ajouterFourmiGraphique(fourmi);
    assertTrue(fourmiliereG.getListFourmi().size() == 1);
    terrainG.deplacerProie(proie, new Point(25, 50));
    assertTrue(terrainG.getListProie().size() == 1);

    FourmiGraphique fourmiRecup = fourmiliereG.getListFourmi().get(fourmi);
    posX = fourmiRecup.getElementGraphique().getX();
    posY = fourmiRecup.getElementGraphique().getY();

    fourmiliereG.deplacerFourmi(fourmi, new Point(posX + 5, posY + 3));
    fourmiRecup = fourmiliereG.getListFourmi().get(fourmi);
    assertTrue(posX != fourmiRecup.getElementGraphique().getX());
    assertTrue(posY != fourmiRecup.getElementGraphique().getY());
  }

}
