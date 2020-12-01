package roles;

import simulation.Bilan;

/** Fourmi ouvriere.
 * 
 * @author Damien
 *
 */
public class Ouvrier implements Role {

  public Ouvrier() {

  }

  @Override
  public void bilan(Bilan b) {
    b.incrementNbOuvrier();
  }

}
