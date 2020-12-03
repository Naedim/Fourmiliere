package vue;

import graphicLayer.GRect;

/**
 * Interface assurant la présence d'une méthode getElementGraphique dans chaque élement graphique.
 * Un élément graphique a un attribut elementGraphique étant l'objet GRect lui correspondant dans la
 * vue.
 * 
 * @author Damien
 *
 */
public interface ElementGraphique {

  public GRect getElementGraphique();


}
