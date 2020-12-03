package etapes;

import infomodele.BilanGraphique;
import modele.Fourmi;
import modele.Fourmiliere;
import simulation.Simulation;

/**
 * Classe abstraite representant les etapes de l'evolution d'une fourmi.
 */
public abstract class Etape implements Simulation {

  protected Etape etape;
  protected Fourmiliere fourmiliere;
  protected Fourmi fourmi;

  /**
   * Constructeur d'etape, recupere la fourmiliere pour que chaque etape soit lie a  sa fourmiliere.
   * 
   * @param fourmiliere : Fourmiliere
   * @param fourmi : Fourmi
   */
  public Etape(Fourmiliere fourmiliere, Fourmi fourmi) {
    this.fourmiliere = fourmiliere;
    this.fourmi = fourmi;
  }

  /**
   * Methode permettant de passer a  la prochaine etape d'evolution si la duree d'evolution est
   * bonne, sinon renvoie l'etape actuelle.
   * 
   * @param b : BilanGraphique a  remplir
   * @return Etape suivante de l'evolution
   */
  public abstract Etape next(BilanGraphique b);

  @Override
  public void step(BilanGraphique b) {
    this.etape = this.etape.next(b);
    this.etape.step(b);
  }
}
