
public class Nymphe implements Simulation, Etape {

  protected final int tempsEvolution = 5;
  protected int dureeVie = 0;

  public Nymphe() {}

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsEvolution) {
      // TO DO
    }
    return this;
  }

}
