package adultes;

import main.Etape;

public class Adulte implements Etape {

  protected final int tempsVieMin = 548;
  protected final int tempsVieMax = 913;
  protected int dureeVie = 0;

  public Adulte() {}

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if ("fin de vie") {
      return null;
    }
    return this;
  }

}
