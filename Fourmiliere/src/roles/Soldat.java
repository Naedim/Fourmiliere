package roles;

import modele.Fourmiliere;

/**Fourmi soldat.
 * 
 * @author Damien
 *
 */
public class Soldat implements Role {
  
  public Soldat() {
    
  }
  
  @Override
  public void decremente(Fourmiliere f) {
    f.decrementNbSoldat();
    
  }
}
