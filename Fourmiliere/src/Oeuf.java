public class Oeuf implements Simulation, Etape {

  protected final int tempsEvolution = 3;
  protected int dureeVie = 0;

  public Oeuf() {
  }

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsEvolution) {
      return new Larve();
    }
    return this;
  }

}
