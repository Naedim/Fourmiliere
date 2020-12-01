package modele;

import java.util.ArrayList;
import java.util.List;
import simulation.Simulation;

public class Fourmiliere implements Simulation {

  protected final int tempsVie;
  protected int dureeVie;

  protected final int nbPonte = 100;
  protected final int tempsVieMin = 1460;
  protected final int tempsVieMax = 3650;

  protected List<Fourmi> listFourmi;

  Bilan bilan;

  /** Constructeur de fourmilière, initialise la liste de fourmis. **/
  public Fourmiliere() {
    this.bilan = new Bilan();
    this.listFourmi = new ArrayList<Fourmi>();
    this.tempsVie = (int) (Math.random() * (tempsVieMax - tempsVieMin) + tempsVieMin);
    this.dureeVie = 0;
  }

  public int getTempsVieFourmiliere() {
    return tempsVie;
  }

  public int getNbFourmi() {
    return listFourmi.size() + 1;
  }


  /**
   * .
   * 
   */
  public void step() {
    this.pondre();
    for (Fourmi f : listFourmi) {
      f.step();
    }
    this.dureeVie++;
  }

  private void pondre() {
    if (this.dureeVie < this.tempsVie) {
      for (int i = 0; i < nbPonte; i++) {
        this.listFourmi.add(new Fourmi(this));
      }
    }
  }

  @Override
  public void bilan() {
    for (Fourmi f : listFourmi) {
      f.bilan();
    }

  }

}
