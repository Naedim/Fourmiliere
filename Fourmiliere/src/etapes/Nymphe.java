package etapes;

import modele.Fourmi;
import modele.Fourmiliere;
import simulation.Simulation;

public class Nymphe extends Etape implements Simulation {

  protected final int tempsEvolution = 5;
  protected int dureeVie = 0;

  /**.
   * 
   * @param f .
   * @param fourmi .
   */
  public Nymphe(Fourmiliere f, Fourmi fourmi) {
    super(f, fourmi);
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
