package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

/**
 * Repr�sentation graphique du TerritoireGraphhique d'une FourmiliereGraphique.
 * 
 * @author Damien
 *
 */
public class TerritoireGraphique implements ElementGraphique {
  protected final int nbCases = 100;
  protected GRect elementGraphique;
  protected Case[] tabCase = new Case[nbCases];
  protected int casesParLigne = 10;
  protected int tailleTerritoire;
  protected int tailleCase;

  /**
   * La taille d'un territoire et son positionnement d�pendent de la taille de la fourmiliere du
   * territoire.
   * 
   * @param posFourmiliere position de la fourmiliere du territoire
   * @param dimFourmiliere dimensions del a fourmilieres
   */
  public TerritoireGraphique(Point posFourmiliere, Dimension dimFourmiliere) {
    elementGraphique = new GRect();
    elementGraphique.setColor(Color.WHITE);
    elementGraphique.withBorder();
    elementGraphique.setBorderColor(Color.BLACK);

    int territoireX = (int) posFourmiliere.getX();
    int territoireY = (int) posFourmiliere.getY();
    int tailleFourmiliere = (int) dimFourmiliere.getWidth();


    Point positionTerritoire =
        new Point(territoireX - tailleFourmiliere * 2, territoireY - tailleFourmiliere * 2);

    elementGraphique.setPosition(positionTerritoire);
    this.tailleTerritoire = tailleFourmiliere * 5;
    elementGraphique.setDimension(new Dimension((int) tailleTerritoire, (int) tailleTerritoire));

    this.tailleCase = tailleTerritoire / casesParLigne;

    this.quadrillage(territoireX, territoireY);
  }

  /**
   * .
   */
  public void quadrillage(int x, int y) {
    for (int i = 0; i < tabCase.length; i++) {

      tabCase[i] = new Case((i % casesParLigne) * tailleCase,
          ((int) (i / casesParLigne)) * tailleCase, tailleCase);


      elementGraphique.addSubElement(tabCase[i].getElementGraphique());
    }
  }

  public GRect getElementGraphique() {
    return this.elementGraphique;
  }

  /**
   * .
   * 
   * @param x :
   * @param y :
   * @return
   */
  public Case getCaseByCoord(int x, int y) {
    int i = 0;
    i += (y / this.tailleCase) * nbCases;
    i += (x / tailleCase);

    return this.tabCase[i];
  }

  /**
   * .
   * 
   * @param maCase :
   * @return
   */
  public Case[] getCasesAdjacentes(Case maCase) {

    Case[] casesAdjacentes = new Case[4];
    int indexMaCase = 0;
    for (Case c : this.tabCase) {
      if (c.equals(maCase)) {
        break;
      }
      indexMaCase++;
    }

    // Si case gauche
    if (indexMaCase - 1 > 0) {
      casesAdjacentes[0] = tabCase[indexMaCase - 1];
    }

    // Si case droite
    if (indexMaCase + 1 < tabCase.length) {
      casesAdjacentes[1] = tabCase[indexMaCase + 1];
    }

    // Si case haut
    if (indexMaCase - casesParLigne > 0) {
      casesAdjacentes[2] = tabCase[indexMaCase - casesParLigne];
    }

    // Si case bas
    if (indexMaCase + casesParLigne > tabCase.length) {
      casesAdjacentes[3] = tabCase[indexMaCase + casesParLigne];
    }
    
    return casesAdjacentes;
  }
}
