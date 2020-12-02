package modele;

import vue.BilanGraphique;

public class Terrain {
  Fourmiliere fourmiliere;
  protected BilanGraphique bilan;


  /**
   * Constructeur de terrain, créer un terrain dans lequel est installé une fourmilière.
   */
  public Terrain() {
    this.fourmiliere = new Fourmiliere();
    this.bilan = new BilanGraphique();
  }

  /**
   * .
   * 
   * @return .
   */
  public BilanGraphique getBilan() {
    BilanGraphique b = this.bilan;
    this.bilan = new BilanGraphique();
    return b;
  }

  public Fourmiliere getFourmiliere() {
    return fourmiliere;
  }

  /**
   * Méthode qui avance de 1 step le fonctionnement d'une fourmiliere.
   */
  public void step() {
    this.fourmiliere.step(bilan);
  }
}
