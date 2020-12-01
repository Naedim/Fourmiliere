package modele;

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

  public void step() {
    this.fourmiliere.step();
  }

  public void bilan() {
    this.bilan = new Bilan();
    this.fourmiliere.bilan(this.bilan);
  }
  
  public Bilan getBilan() {
    return this.bilan;
  }
}
