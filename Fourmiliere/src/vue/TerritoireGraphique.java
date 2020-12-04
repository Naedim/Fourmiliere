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
    int tailleTerritoire = (int) dimFourmiliere.getWidth();


    Point positionTerritoire =
        new Point(territoireX - tailleTerritoire * 2, territoireY - tailleTerritoire * 2);

    elementGraphique.setPosition(positionTerritoire);
    elementGraphique
        .setDimension(new Dimension((int) tailleTerritoire * 5, (int) tailleTerritoire * 5));

    this.quadrillage(territoireX, territoireY, tailleTerritoire * 5 / this.casesParLigne);
  }

  /**
   * .
   */
  public void quadrillage(int x, int y, int tailleCase) {
    for (int i = 0; i < tabCase.length; i++) {

      tabCase[i] = new Case((i % casesParLigne) * tailleCase,
          ((int) (i / casesParLigne)) * tailleCase, tailleCase);


      elementGraphique.addSubElement(tabCase[i].getElementGraphique());
    }
  }

  public GRect getElementGraphique() {
    return this.elementGraphique;
  }
}
