//package tests;
//
//import static org.junit.Assert.assertTrue;
//
//import etapes.Adulte;
//import etapes.Etape;
//import etapes.Larve;
//import etapes.Nymphe;
//import etapes.Oeuf;
//import modele.Fourmi;
//import modele.Fourmiliere;
//import org.junit.jupiter.api.Test;
//
//class TestEvolution {
//  /**
//   * Test vérifiant que l'oeuf devient une larve après x jour d'évolution.
//   */
//  @Test
//  void test() {
//    Fourmiliere fourmiliere = new Fourmiliere();
//    Fourmi fourmi  = new Fourmi(fourmiliere);
//    Etape etape = new Oeuf(fourmiliere, fourmi);
//    
//    
//    for (int i = 0; i <= ((Oeuf) etape).getTempsEvolution(); i++) {
//      assertTrue(fourmi.getEtape() instanceof Oeuf);
//      fourmi.step();
//    }
//    assertTrue(fourmi.getEtape() instanceof Larve);
//
//    
//    etape = new Larve(fourmiliere, fourmi);
//    for (int i = 0; i < ((Larve) etape).getTempsEvolution(); i++) {
//      assertTrue(fourmi.getEtape() instanceof Larve);
//      fourmi.step();
//    }
//    assertTrue(fourmi.getEtape() instanceof Nymphe);
//    
//    etape = new Nymphe(fourmiliere, fourmi);
//    for (int i = 0; i < ((Nymphe) etape).getTempsEvolution(); i++) {
//      assertTrue(fourmi.getEtape() instanceof Nymphe);
//      fourmi.step();
//    }
//    assertTrue(fourmi.getEtape() instanceof Adulte);
//  }
//}
