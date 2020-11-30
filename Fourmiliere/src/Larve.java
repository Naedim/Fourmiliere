
public class Larve implements Etape {

  protected final int tempsEvolution = 10;
  protected int dureeVie = 0;

  public Larve() {
  }

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsEvolution) {
      return new Nymphe();
    }
    return this;
  }

}
