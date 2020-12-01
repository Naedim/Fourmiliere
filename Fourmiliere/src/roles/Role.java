package roles;

import simulation.Bilan;

public interface Role {

  /**
   * Méthode incrémentant le compteur d'un rôle spécifique dans un bilan.
   *
   * @param b : Bilan
   */
  public void bilan(Bilan b);
}
