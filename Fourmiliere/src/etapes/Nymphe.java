package etapes;

import modele.Fourmi;
import modele.Fourmiliere;
import simulation.Simulation;

public class Nymphe implements Simulation, Etape {

  protected final int tempsEvolution = 5;
  protected int dureeVie = 0;
  protected Fourmiliere fourmiliere;
  protected Fourmi fourmi;

  /**.
   * 
   * @param f .
   * @param fourmi .
   */
  public Nymphe(Fourmiliere f, Fourmi fourmi) {
    this.fourmiliere = f;
    this.fourmi = fourmi;
    this.fourmiliere.incrementNbNymphe();
  }

  @Override
  public void step() {
    this.dureeVie++;
  }

  @Override
  public Etape next() {
    if (this.dureeVie == this.tempsEvolution) {
      this.fourmiliere.decrementNbNymphe();
      return new Adulte(this.fourmiliere, this.fourmi);
    }
    return this;
  }

}
