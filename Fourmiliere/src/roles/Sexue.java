package roles;

import modele.Bilan;

/**Fourmi sexuee.
 * 
 * @author Damien
 *
 */
public class Sexue implements Role {

  public Sexue() {
    
  }

  @Override
  public void bilan(Bilan b) {
    b.incrementNbSexue();
    
    
  }
}
