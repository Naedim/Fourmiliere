package modele;

import bilan.BilanGraphique;
import java.util.ArrayList;
import java.util.List;

public class Terrain {
  Fourmiliere fourmiliere;
  protected BilanGraphique bilan;
  protected List<Proie> listProies;


  /**
   * Constructeur de terrain, créer un terrain dans lequel est installé une fourmilière.
   */
  public Terrain() {
    this.fourmiliere = new Fourmiliere();
    this.bilan = new BilanGraphique();
    this.listProies = new ArrayList<Proie>();
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

    int apparitionProie = (int) Math.floor(Math.random() * 50);
    if (apparitionProie <= 1) {
      Proie p = new Proie();
      this.listProies.add(p);
      this.bilan.apparitionProie(p);
    }
    
    for (Proie p : this.listProies) {
      p.step(bilan);
    }
    this.fourmiliere.step(bilan);
  }
}
