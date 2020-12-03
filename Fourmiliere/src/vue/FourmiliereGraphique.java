package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import modele.Fourmi;

/**
 * FourmiliereGraphique, homologue de la classe Fourmiliere du package modele. Contient l'ensemble
 * de ses FourmiGraphique dans un HashMap permettant d'associer une Fourmi du modele avec son
 * homologue graphique FourmiGraphique. Possède une TerritoireGraphique.
 * 
 * @author Damien
 *
 */
public class FourmiliereGraphique implements ElementGraphique {

  protected HashMap<Fourmi, FourmiGraphique> listFourmi;
  protected TerritoireGraphique territoire;
  protected GRect elementGraphique;

  /**
   * Une fourmiliereGraphique est construite avec une position et des dimensions. Sa couleur est de
   * base en noire. Le constructeur de FourmiliereGraphique appelle le constructeur de
   * TerrainGraphique.
   * @param posFourmiliere : position de la fourmiliere
   * @param dimFourmiliere : dimensions de la fourmiliere
   */
  public FourmiliereGraphique(Point posFourmiliere, Dimension dimFourmiliere) {

    elementGraphique = new GRect();
    elementGraphique.setDimension(dimFourmiliere);

    elementGraphique.setColor(Color.BLACK);
    elementGraphique.setPosition(posFourmiliere);

    territoire = new TerritoireGraphique(posFourmiliere, dimFourmiliere);

    this.listFourmi = new HashMap<Fourmi, FourmiGraphique>();
  }

  public TerritoireGraphique getTerritoire() {
    return territoire;
  }

  public FourmiGraphique getFourmiGraphique(Fourmi fourmi) {
    return this.listFourmi.get(fourmi);
  }

  @Override
  public GRect getElementGraphique() {
    return this.elementGraphique;
  }

  /**
   * Cree une FourmiGraphique et ajoute une association (Fourmi ,FourmiGraphique) au HashMap en se
   * basant sur une clef de type Fourmi.
   * 
   * @param fourmi du modele.
   * @return l'élement graphique de la fourmi
   */
  public GRect ajouterFourmiGraphique(Fourmi fourmi) {
    FourmiGraphique fourmiGraphique = new FourmiGraphique(this.getElementGraphique());
    this.listFourmi.put(fourmi, fourmiGraphique);
    return fourmiGraphique.getElementGraphique();
  }

  /**
   * Supprime une Association du Hashmap en en se basant sur une clef de type Fourmi.
   * 
   * @param fourmi la clef de l'association a supprimer.
   * @return la valeur de l'association supprimée.
   */
  public FourmiGraphique supprimerFourmiGraphique(Fourmi fourmi) {
    FourmiGraphique fourmiGraphique = this.listFourmi.remove(fourmi);
    return fourmiGraphique;
  }

  /**
   * Déplace dans la vue l'elementGraphique d'une FourmiGraphique du HashMap.
   * 
   * @param fourmi clef de l'association de la la fourmiGraphique a déplacer.
   * @param p Le nouveau point de la fourmi.
   */
  public void deplacerFourmi(Fourmi fourmi, Point p) {
    this.listFourmi.get(fourmi).getElementGraphique().translate(p);
  }
}
