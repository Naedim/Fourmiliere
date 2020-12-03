package modele;

import infomodele.BilanGraphique;
import java.util.ArrayList;
import java.util.List;
import simulation.Simulation;

/**
 * Classe Fourmiliere, simule le fonctionnement d'une fourmiliere. Une reine est de base integree
 * dans la fourmiliere, lorsqu'elle meurt (selon une esperance de vie aleatoire) celle ci arrete
 * depondre des oeufs et laisse la fourmiliere mourir.
 */
public class Fourmiliere implements Simulation {

  int reine = 1;
  protected final int nbPonte = 10;
  protected final int tempsVieMin = 1460;
  protected final int tempsVieMax = 3650;

  protected final int tempsVie;
  protected int dureeVie;
  protected List<Fourmi> listFourmi;
  protected List<Fourmi> listCadavres;

  /** Constructeur de fourmiliere, initialise la liste de fourmis et le temps de vie. **/
  public Fourmiliere() {
    this.listCadavres = new ArrayList<Fourmi>();
    this.listFourmi = new ArrayList<Fourmi>();
    this.tempsVie = (int) (Math.random() * (tempsVieMax - tempsVieMin) + tempsVieMin);
    this.dureeVie = 0;
  }

  public List<Fourmi> getListFourmi() {
    return listFourmi;
  }

  public int getTempsVieFourmiliere() {
    return tempsVie;
  }

  /**
   * Ajout une fourmi a� la fin d'etape cadavre dans une liste intermiediaire, permet de ne pas
   * supprimer directement sur la liste des fourmis.
   * 
   * @param fourmi : Fourmi a� supprimer
   */
  public void ajoutCadavre(Fourmi fourmi) {
    this.listCadavres.add(fourmi);
  }

  public int getNbFourmi() {
    return listFourmi.size() + reine;
  }

  /**
   * Methode permettant le fonctionnement de la fourmiliere, la ponte des oeufs, l'incrementation de
   * sa duree de vie puis ensuite elle defile la liste de cadavres pour supprimer les fourmis
   * correspondantes.
   * 
   * @param b : BilanGraphique a� remplir
   */
  public void step(BilanGraphique b) {
    this.pondre();
    this.dureeVie++;
    if (this.dureeVie == tempsVie) {
      this.reine = 0;
    }

    for (Fourmi f : listFourmi) {
      f.step(b);
    }

    for (Fourmi f : listCadavres) {
      listFourmi.remove(f);
    }
    listCadavres.clear();
  }

  /**
   * Methode permettant de creer un nombre precis d'oeufs dans la fourmiliere.
   */
  private void pondre() {
    if (this.dureeVie < this.tempsVie) {
      for (int i = 0; i < nbPonte; i++) {
        this.listFourmi.add(new Fourmi(this));
      }
    }
  }

}
