package enfants;

import main.Etape;

public class Adulte implements Etape {
  
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
