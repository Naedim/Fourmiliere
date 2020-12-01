package etapes;

import modele.Bilan;
import modele.Fourmi;
import modele.Fourmiliere;

public class Cadavre extends Etape {
  protected int tempsVie = 2;
  protected int dureeVie = 0;

  public Cadavre(Fourmiliere f, Fourmi fourmi) {
    super(f, fourmi);
  }

  @Override
  public Etape next() {
    return this;
  }
  
  public void finCadavre() {
    //TODO 
  }
  
  @Override 
  public void step() {
    this.dureeVie++;
  }
  
  @Override
  public void bilan(Bilan b) {
    b.incrementNbCadavre();
  }
}
