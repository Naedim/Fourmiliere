package roles;

import simulation.Bilan;

/** 
 * Fourmi sexuee, soit mâle soit femelle (possible nouvelle reine).
 * @author Damien
 */
public class Sexue implements Role {

  public Sexue() {
    
  }

  @Override
  public void bilan(Bilan b) {
    b.incrementNbSexue();
  }
}
