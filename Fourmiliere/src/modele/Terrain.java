package modele;

import simulation.Bilan;

/**
 * Classe représentant le terrain dans lequel se développe une fourmilière.
 */
public class Terrain {
  Fourmiliere fourmiliere;
  protected Bilan bilan;

  /**
   * Constructeur de terrain, créer un terrain dans lequel est installé une fourmilière.
   */
  public Terrain() {
    this.fourmiliere = new Fourmiliere();
    this.bilan = new Bilan();
  }

  public Fourmiliere getFourmiliere() {
    return fourmiliere;
  }

  /** 
   * Méthode qui avance de 1 step le fonctionnement d'une fourmiliere.
   */
  public void step() {
    this.fourmiliere.step();
  }

  /**
   * Méthode qui permet de lancer le processus de bilan.
   */
  public void bilan() {
    this.bilan = new Bilan();
    this.fourmiliere.bilan(this.bilan);
  }
  
  public Bilan getBilan() {
    return this.bilan;
  }
}
