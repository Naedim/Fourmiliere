package vue;

public class Action {
  protected EnumAction action;
  protected Parametre param;

  public Action(EnumAction la) {
    this.action = la;
  }

  public Action(EnumAction la, Parametre param) {
    this.action = la;
    this.param = param;
  }

}
