package etapes;

import modele.Fourmi;
import modele.Fourmiliere;

public class Cadavre extends Etape {
  protected int tempsVie = 2;
  protected int dureeVie = 0;

  public Cadavre(Fourmiliere f, Fourmi fourmi) {
    super(f, fourmi);
    this.fourmiliere.incrementNbNymphe();
  }

  @Override
  public Etape next() {
    // TODO Auto-generated method stub
    return null;
  }
  
  public void finCadavre() {
    //TODO 
  }
  
  @Override 
  public void step() {
    this.dureeVie++;
  }
}
