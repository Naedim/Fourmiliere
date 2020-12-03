package bilan;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import modele.Fourmi;

public class BilanGraphique {

  protected List<Action> listAction;

  public BilanGraphique() {
    this.listAction = new ArrayList<Action>();
  }

  public List<Action> getListAction() {
    return listAction;
  }

  public void maturite(Fourmi fourmi) {
    this.listAction.add(new Action(EnumAction.AJOUTER, new Parametre(fourmi)));
  }

  public void deplacement(Fourmi fourmi) {
    this.listAction.add(new Action(EnumAction.DEPLACER, new Parametre(fourmi)));
  }

  public void mort(Fourmi fourmi) {
    this.listAction
        .add(new Action(EnumAction.CHANGERCOULEUR, new Parametre(fourmi, Color.BLACK)));
  }

  public void disparition(Fourmi fourmi) {
    this.listAction.add(new Action(EnumAction.SUPPRIMER, new Parametre(fourmi)));
  }


}
