package modele;

public class Bilan {

  protected int nbFourmi;
  protected int nbOeuf;
  protected int nbLarve;
  protected int nbNymphe;
  protected int nbOuvrier;
  protected int nbSexue;
  protected int nbSoldat;
  protected int nbCadavres;

  /** . **/
  public Bilan() {
    nbFourmi = 0;
    nbOeuf = 0;
    nbLarve = 0;
    nbNymphe = 0;
    nbOuvrier = 0;
    nbSexue = 0;
    nbSoldat = 0;
    nbCadavres = 0;
  }

  public int getNbAdultes() {
    return this.nbOuvrier + this.nbSexue + this.nbSoldat;
  }
  
  public int getNbCadavre() {
    return nbCadavres;
  }
  
  public int getNbFourmi() {
    return nbFourmi;
  }
  
  public int getNbOeuf() {
    return nbOeuf;
  }

  public void incrementNbOeuf() {
    this.nbOeuf++;
  }

  public void decrementNbOeuf() {
    this.nbOeuf--;
  }

  public int getNbLarve() {
    return nbLarve;
  }

  public void incrementNbLarve() {
    this.nbLarve++;
  }

  public void decrementNbLarve() {
    this.nbLarve--;
  }

  public int getNbNymphe() {
    return nbNymphe;
  }

  public void incrementNbNymphe() {
    this.nbNymphe++;
  }

  public void decrementNbNymphe() {
    this.nbNymphe--;
  }

  public int getNbOuvrier() {
    return nbOuvrier;
  }

  public void incrementNbOuvrier() {
    this.nbOuvrier++;
  }

  public void decrementNbOuvrier() {
    this.nbOuvrier--;
  }

  public int getNbSexue() {
    return nbSexue;
  }

  public void incrementNbSexue() {
    this.nbSexue++;
  }

  public void decrementNbSexue() {
    this.nbSexue--;
  }

  public int getNbSoldat() {
    return nbSoldat;
  }

  public void incrementNbSoldat() {
    this.nbSoldat++;
  }

  public void decrementNbSoldat() {
    this.nbSoldat--;
  }

}
