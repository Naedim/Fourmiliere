package infomodele;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import modele.Fourmi;
import modele.Proie;
import vue.Case;

/**
 * Recupere l'ensemble des modifications du modele sous formes d'une liste d'action a appliquer sur
 * la vue.
 * 
 * @author Damien
 *
 */
public class BilanGraphique {

  protected List<Action> listAction;

  public BilanGraphique() {
    this.listAction = new ArrayList<Action>();
  }

  public List<Action> getListAction() {
    return listAction;
  }

  public void maturiteFourmi(Fourmi fourmi) {
    this.listAction.add(new Action(EnumAction.AJOUTER, new Parametre(fourmi)));
  }

  public void apparitionProie(Proie proie) {
    this.listAction.add(new Action(EnumAction.AJOUTER, new Parametre(proie)));
  }

  public void deplacementFourmi(Fourmi fourmi) {
    this.listAction.add(new Action(EnumAction.DEPLACER, new Parametre(fourmi)));
  }

  public void deplacementProie(Proie proie) {
    this.listAction.add(new Action(EnumAction.DEPLACER, new Parametre(proie)));
  }

  public void mort(Fourmi fourmi) {
    this.listAction.add(new Action(EnumAction.CHANGERCOULEUR, new Parametre(fourmi, Color.BLACK)));
  }

  public void disparition(Fourmi fourmi) {
    this.listAction.add(new Action(EnumAction.SUPPRIMER, new Parametre(fourmi)));
  }


}
