package infomodele;

/**
 * Decrit une action a que le controlleurGraphique doit efefctuer pour actualiser la vue par rapport
 * au modele.
 * 
 * @author Damien
 *
 */
public class Action {
  protected EnumAction intituleAction;
  protected Parametre param;

  public Action(EnumAction intituleAction, Parametre param) {
    this.intituleAction = intituleAction;
    this.param = param;
  }

  public EnumAction getAction() {
    return intituleAction;
  }

  public Parametre getParam() {
    return param;
  }
}
