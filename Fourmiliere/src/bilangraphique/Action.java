package bilangraphique;

public class Action {
  protected EnumAction action;
  protected Parametre param;

  public Action(EnumAction la, Parametre param) {
    this.action = la;
    this.param = param;
  }

  public EnumAction getAction() {
    return action;
  }

  public Parametre getParam() {
    return param;
  }
}
