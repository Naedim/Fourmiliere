package roles;

import modele.Fourmiliere;

/**Fourmi sexuee.
 * 
 * @author Damien
 *
 */
public class Sexue implements Role {

  public Sexue() {
    
  }

  @Override
  public void decremente(Fourmiliere f) {
    f.decrementNbSexue();
  }
}
