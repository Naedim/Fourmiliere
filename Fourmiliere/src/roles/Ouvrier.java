package roles;

import modele.Fourmiliere;

/**Fourmi ouvriere.
 * 
 * @author Damien
 *
 */
public class Ouvrier implements Role {

  public Ouvrier() {

  }

  @Override
  public void decremente(Fourmiliere f) {
    f.decrementNbOuvrier();
    
  }

}
