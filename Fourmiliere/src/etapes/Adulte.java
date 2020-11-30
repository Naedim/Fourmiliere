package etapes;

import main.Etape;
import roles.Role;

public class Adulte implements Etape, Role {

  protected final int tempsEvolution = 548;
  protected int dureeVie = 0;

  public Adulte() {}

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    return new Adulte();
  }

}
