package etapes;

import modele.Fourmi;
import modele.Fourmiliere;
import simulation.Simulation;

/**
 * Classe abstraite représentant les étapes de l'évolution d'une fourmi.
 */
public abstract class Etape implements Simulation {

  protected Etape etape;
  protected Fourmiliere fourmiliere;
  protected Fourmi fourmi;

  /**
   * Constructeur d'étape, récupère la fourmilière pour que chaque étape soit lié à sa fourmilière.
   * 
   * @param f : Fourmiliere
   * @param fourmi : Fourmi
   */
  public Etape(Fourmiliere f, Fourmi fourmi) {
    this.fourmiliere = f;
    this.fourmi = fourmi;
  }

  /**
   * Méthode permettant de passer à la prochaine étape d'évolution si la durée d'évolution 
   * est bonne, sinon renvoie l'étape actuelle.
   * 
   * @return Etape suivante de l'évolution
   */
  public abstract Etape next();

  @Override
  public void step() {
    this.etape = this.etape.next();
    this.etape.step();
  }
}
