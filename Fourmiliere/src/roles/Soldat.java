package roles;

import simulation.Bilan;

/**
 * Fourmi soldat.
 * @author Damien
 *
 */
public class Soldat implements Role {
  
  public Soldat() {
    
  }

  @Override
  public void bilan(Bilan b) {
    b.incrementNbSoldat();
    
  }
}
