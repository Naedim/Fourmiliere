package modele;

import java.util.ArrayList;
import java.util.List;

public class Fourmiliere {
  protected List<Fourmi> listFourmi;
  protected int nbOeuf;
  protected int nbLarve;
  protected int nbNymphe;
  protected int nbOuvrier;
  protected int nbSexue;
  protected int nbSoldat;
  
  /** Constructeur de fourmilière, initialise la liste de fourmis. **/
  public Fourmiliere() {
    this.listFourmi = new ArrayList<Fourmi>();
    nbOeuf = 0;
    nbLarve = 0;
    nbNymphe = 0;
    nbOuvrier = 0;
    nbSexue = 0;
    nbSoldat = 0;
  }

  public int getNbFourmi() {
    return listFourmi.size();
  }

  public int getNbOeuf() {
    return nbOeuf;
  }

  public void incrementNbOeuf() {
    this.nbOeuf++;
  }

  public int getNbLarve() {
    return nbLarve;
  }

  public void incrementNbLarve() {
    this.nbLarve++;
  }

  public int getNbNymphe() {
    return nbNymphe;
  }

  public void incrementNbNymphe() {
    this.nbNymphe++;
  }

  public int getNbOuvrier() {
    return nbOuvrier;
  }

  public void incrementNbOuvrier() {
    this.nbOuvrier++;
  }

  public int getNbSexue() {
    return nbSexue;
  }

  public void incrementNbSexue() {
    this.nbSexue++;
  }

  public int getNbSoldat() {
    return nbSoldat;
  }

  public void incrementNbSoldat() {
    this.nbSoldat++;
  }
  
  
  /**
   * .
   * 
   */
  public void step() {
    for (Fourmi f : listFourmi) {
      f.step();
    }
  }

  public int getNbAdultes() {
    return this.nbOuvrier + this.nbSexue + this.nbSoldat;
  }
}
