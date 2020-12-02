package vue;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class BilanGraphique {

  protected List<Action> listAction;

  public BilanGraphique() {
    this.listAction = new ArrayList<Action>();
  }

  public List<Action> getListAction() {
    return listAction;
  }

  public void maturite() {
    this.listAction.add(new Action(EnumAction.AJOUTER));
  }

  public void deplacement(int indexFourmi, Point p) {
    this.listAction.add(new Action(EnumAction.DEPLACER, new Parametre(indexFourmi, p)));
  }

  public void mort(int indexFourmi) {
    this.listAction
        .add(new Action(EnumAction.CHANGERCOULEUR, new Parametre(indexFourmi, Color.BLACK)));
  }


}
