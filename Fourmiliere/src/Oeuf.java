public class Oeuf implements Simulation, Etape {

  protected final int tempsEvolution = 3;
  protected int dureeVie;

  public Oeuf() {
    this.dureeVie = 0;
  }

  @Override
  public void step() {
    this.dureeVie++;
    this = this.next();
  }

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsEvolution) {
      return (Etape) new Larve();
    }
    return this;
  }

}
