package bilangraphique;

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
