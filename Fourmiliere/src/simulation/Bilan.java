package simulation;

/**
 * Classe Bilan permettant de récuperer les données d'une fourmilière.
 */
public class Bilan {

  protected int nbFourmi;
  protected int nbOeuf;
  protected int nbLarve;
  protected int nbNymphe;
  protected int nbOuvrier;
  protected int nbSexue;
  protected int nbSoldat;
  protected int nbCadavres;

  /** Constructeur de Bilan, initialise les compteurs à 0. **/
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
  
  public int getNbFourmi() {
    return nbFourmi;
  }
  
  public void setNbFourmi(int nbFourmi) {
    this.nbFourmi = nbFourmi - this.getNbCadavre();
  }

  public int getNbCadavre() {
    return this.nbCadavres;
  }

  public void incrementNbCadavre() {
    this.nbCadavres++;
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

}
