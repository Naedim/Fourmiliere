package vue;

import graphicLayer.GRect;
import graphicLayer.GSpace;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import modele.Proie;

/**
 * Un TerrainGraphique contient une fourmiliere et un ensemble d'instances de Proie dans un HashMap.
 * 
 * @author Damien
 *
 */
public class TerrainGraphique {

  protected GSpace elementGraphique;
  protected FourmiliereGraphique fourmiliere;
  protected HashMap<Proie, ProieGraphique> listProie;

  /**
   * Un TerrainGraphique a par default une hauteur et une largeur de 1000 et 800. Le controleur
   * lance la vue après sa création.
   * 
   */
  public TerrainGraphique(Point posFourmiliere, Dimension dimFourmiliere) {

    elementGraphique = new GSpace("Simulation d'un terrain", new Dimension(1000, 800));
    fourmiliere = new FourmiliereGraphique(posFourmiliere, dimFourmiliere);
    listProie = new HashMap<Proie, ProieGraphique>();

    elementGraphique.setColor(Color.WHITE);
    elementGraphique.addElement(fourmiliere.getTerritoire().getElementGraphique());
    elementGraphique.addElement(fourmiliere.getElementGraphique());
    elementGraphique.open();
  }

  public FourmiliereGraphique getFourmiliere() {
    return fourmiliere;
  }

  public GSpace getElementGraphique() {
    return elementGraphique;
  }


  public HashMap<Proie, ProieGraphique> getListProie() {
    return listProie;
  }


  /**
   * Ajoute une proie à l'ensemble de ProieGraphique.
   * 
   * @param proie la cle de l'association Proie ProieGrapgique
   * @return L'élément graphique de la ProieGraphique cree.
   */
  public GRect ajouterProie(Proie proie) {
    ProieGraphique proieGraphique = new ProieGraphique(this);
    this.listProie.put(proie, proieGraphique);
    return proieGraphique.getElementGraphique();
  }

  /**
   * Deplace une proie de l'ensemble de ProieGraphique.
   * 
   * @param proie la clef de l'association de la ProieGraphique à modifier.
   * @param p le nouveau point où la ProieGraphique doit être située.
   */
  public void deplacerProie(Proie proie, Point p) {
    this.listProie.get(proie).getElementGraphique().setPosition(p);
  }

  public ProieGraphique getProieGraphique(Proie proie) {
    return this.listProie.get(proie);
  }
}
