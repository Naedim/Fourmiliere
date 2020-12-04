package vue;

import graphicLayer2.GRect;

/**
 * Interface assurant la pr�sence d'une m�thode getElementGraphique dans chaque �lement graphique.
 * Un �l�ment graphique a un attribut elementGraphique �tant l'objet GRect lui correspondant dans la
 * vue.
 * 
 * @author Damien
 *
 */
public interface ElementGraphique {

  public GRect getElementGraphique();


}
