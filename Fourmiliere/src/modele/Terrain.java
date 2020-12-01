package modele;

public class Terrain {
  Fourmiliere fourmiliere;

  /**
   * Constructeur de terrain, créer un terrain dans lequel est installé une fourmilière.
   */
  public Terrain() {
    this.fourmiliere = new Fourmiliere();
  }

  public Fourmiliere getFourmiliere() {
    return fourmiliere;
  }

  public void step() {
    this.fourmiliere.step();
  }
}
