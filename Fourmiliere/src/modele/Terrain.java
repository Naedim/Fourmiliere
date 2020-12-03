package modele;

import infomodele.BilanGraphique;
import java.util.ArrayList;
import java.util.List;

public class Terrain {
  Fourmiliere fourmiliere;
  protected BilanGraphique bilan;
  protected List<Proie> listProies;

  /**
   * Constructeur de terrain, creer un terrain contenant une fourmiliere, une liste de proie ainsi
   * qu'un BilanGraphique.
   */
  public Terrain() {
    this.fourmiliere = new Fourmiliere();
    this.bilan = new BilanGraphique();
    this.listProies = new ArrayList<Proie>();
  }

  /**
   * Recupere le BilanGraphique dans un objet, puis le reinitialise.
   * 
   * @return Un BilanGraphique avec une liste d'action
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
   * Methode qui avance de 1 step le fonctionnement d'un terrain, fait apparaitre des proies selon
   * une certaine probabilite et incremente le fonctionnement d'une fourmiliere. <br>
   * Chaque step permet de remplir le BilanGraphique de terrain.
   */
  public void step() {

    int apparitionProie = (int) Math.floor(Math.random() * 500);
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
