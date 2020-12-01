package modele;

import java.util.ArrayList;
import java.util.List;

public class Fourmiliere {

  protected final int tempsVie;
  protected int dureeVie;

  protected final int tempsVieMax = 1460;
  protected final int tempsVieMin = 3650;


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
    this.tempsVie = (int) (Math.random() * (tempsVieMax - tempsVieMin));
    this.dureeVie = 0;

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
    this.pondre();
    for (Fourmi f : listFourmi) {
      f.step();
    }
  }

  private void pondre() {
    if (this.dureeVie < this.tempsVie) {
      this.listFourmi.add(new Fourmi(this));
    } else {
      System.out.println("FIN DE LA FOURMILIERE");
    }
  }

  public int getNbAdultes() {
    return this.nbOuvrier + this.nbSexue + this.nbSoldat;
  }
}
