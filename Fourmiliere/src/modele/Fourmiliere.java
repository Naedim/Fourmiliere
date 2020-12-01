package modele;

import java.util.ArrayList;
import java.util.List;
import simulation.Bilan;
import simulation.Simulation;

/**
 * Classe Fourmiliere, simule le fonctionnement d'une fourmiliere. Une reine est de base intégrée
 * dans la fourmilière, lorsqu'elle meurt (selon une espérance de vie aléatoire) celle ci arrete
 * depondre des oeufs et laisse la fourmiliere mourir.
 */
public class Fourmiliere implements Simulation {

  int reine = 1;

  protected final int tempsVie;
  protected int dureeVie;

  protected final int nbPonte = 100;
  protected final int tempsVieMin = 1460;
  protected final int tempsVieMax = 3650;

  protected List<Fourmi> listFourmi;


  /** Constructeur de fourmiliere, initialise la liste de fourmis et le temps de vie. **/
  public Fourmiliere() {
    this.listFourmi = new ArrayList<Fourmi>();
    this.tempsVie = (int) (Math.random() * (tempsVieMax - tempsVieMin) + tempsVieMin);
    this.dureeVie = 0;
  }

  public int getTempsVieFourmiliere() {
    return tempsVie;
  }

  public int getNbFourmi() {
    return listFourmi.size() + reine;
  }

  /**
   * Méthode permettant le fonctionnement de la fourmiliere, la ponte des oeufs puis
   * l'incrémentation de sa durée de vie.
   */
  public void step() {
    this.pondre();
    this.dureeVie++;
    if (this.dureeVie == tempsVie) {
      this.reine = 0;
    }

    for (Fourmi f : listFourmi) {
      f.step();
    }
  }

  /**
   * Méthode permettant de créer un nombre précis d'oeufs dans la fourmiliere.
   */
  private void pondre() {
    if (this.dureeVie < this.tempsVie) {
      for (int i = 0; i < nbPonte; i++) {
        this.listFourmi.add(new Fourmi(this));
      }
    }
  }

  @Override
  public void bilan(Bilan b) {
    for (Fourmi f : listFourmi) {
      f.bilan(b);
    }
    b.setNbFourmi(getNbFourmi());

  }

}
