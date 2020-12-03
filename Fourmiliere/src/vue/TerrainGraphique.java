package vue;

import graphicLayer.GRect;
import graphicLayer.GSpace;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
  protected List<Case> listCase;

  /**
   * Un TerrainGraphique a par default une hauteur et une largeur de 1000 et 800. Le controleur
   * lance la vue apr�s sa cr�ation.
   * 
   * @param posFourmiliere : position de la fourmiliere du terrain
   * @param dimFourmiliere : dimensions de la fourmiliere du terrain
   */
  public TerrainGraphique(Point posFourmiliere, Dimension dimFourmiliere) {
    elementGraphique = new GSpace("Simulation d'un terrain", new Dimension(1000, 800));
    fourmiliere = new FourmiliereGraphique(posFourmiliere, dimFourmiliere);
    listProie = new HashMap<Proie, ProieGraphique>();

    elementGraphique.setColor(Color.WHITE);

    Case cas = new Case(0, 0, this);
    listCase = new ArrayList<Case>();
    for (int x = 0; x < 1000; x += 5) {
      for (int y = 0; y < 800; y += 5) {
        cas = new Case(x, y, this);
        listCase.add(cas);
        elementGraphique.addElement(cas.getElementGraphique());
      }
    }

    elementGraphique.addElement(fourmiliere.getTerritoire().getElementGraphique());
    elementGraphique.addElement(fourmiliere.getElementGraphique());

    elementGraphique.open();
  }

  /** Défile tt les cases et récupère la case. */
  public Case getCaseByPos(int x, int y) {
    if (x >= 0 && y >= 0) {
      Case cas = null;
      for (Case c : this.listCase) {
        if (c.getElementGraphique().getX() == x && c.getElementGraphique().getY() == y) {
          cas = c;
          break;
        }
      }
      return cas;
    }
    return null;
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
   * Ajoute une proie a l'ensemble de ProieGraphique.
   * 
   * @param proie la cle de l'association Proie ProieGrapgique
   * @return L'�l�ment graphique de la ProieGraphique cree.
   */
  public GRect ajouterProie(Proie proie) {
    ProieGraphique proieGraphique = new ProieGraphique(this);
    this.listProie.put(proie, proieGraphique);
    return proieGraphique.getElementGraphique();
  }

  /**
   * Deplace une proie de l'ensemble de ProieGraphique.
   * 
   * @param proie la clef de l'association de la ProieGraphique a modifier.
   * @param p le nouveau point o� la ProieGraphique doit �tre situ�e.
   */
  public void deplacerProie(Proie proie, Point p) {
    this.listProie.get(proie).getElementGraphique().setPosition(p);
  }

  public ProieGraphique getProieGraphique(Proie proie) {
    return this.listProie.get(proie);
  }

  /**
   * méthode qui récupère la case a gauche, a droite, au dessus, et en dessous de celle actuelle.
   * 
   * @param cas : case
   * @return
   */
  public HashMap<String, Case> getCasesAdjacentes(Case cas) {
    HashMap<String, Case> lstCaseReturn = new HashMap<String, Case>();
    Case caseGauche =
        this.getCaseByPos(cas.getElementGraphique().getX() - 5, cas.getElementGraphique().getY());
    if (caseGauche != null) {
      lstCaseReturn.put("Gauche", caseGauche);
    }
    
    Case caseDroit =
        this.getCaseByPos(cas.getElementGraphique().getX() + 5, cas.getElementGraphique().getY());
    if (caseDroit != null) {
      lstCaseReturn.put("Droit", caseDroit);
    }
    
    Case caseHaut =
        this.getCaseByPos(cas.getElementGraphique().getX(), cas.getElementGraphique().getY() - 5);
    if (caseHaut != null) {
      lstCaseReturn.put("Haut", caseHaut);
    }
    
    Case caseBas =
        this.getCaseByPos(cas.getElementGraphique().getX(), cas.getElementGraphique().getY() + 5);
    if (caseBas != null) {
      lstCaseReturn.put("Bas", caseBas);
    }

    return lstCaseReturn;
  }
}
