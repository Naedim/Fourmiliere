package modele;

import java.util.ArrayList;
import java.util.List;

public class Fourmiliere {
  List<Fourmi> listFourmi;
  int nbOeuf;
  int nbLarve;
  int nbNymphe;
  int nbOuvrier;
  int nbSexue;
  int nbSoldat;

  /** Constructeur de fourmilière, initialise la liste de fourmis. **/
  public Fourmiliere() {
    this.listFourmi = new ArrayList<Fourmi>();
  }

  /** .
   * 
   */
  public void step() {
    for (Fourmi f : listFourmi) {
      f.step(this);
    }
  }
}
