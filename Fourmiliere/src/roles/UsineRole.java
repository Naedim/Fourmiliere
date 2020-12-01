package roles;

import modele.Fourmiliere;

/**Classe utilisée pour attribuer aléatoirement un role à une fourmi adulte.
 * 
 * @author Damien
 *
 */
public class UsineRole {

  final int maxProbabilite = 100;
  
  //60% de chances d'être un ouvrier
  final int ouvrierMax = 60;

  // 25% de chance d'être un soldat
  final int soldatMax = 85;

  // 15% de chance d'être sexuee
  final int sexueMax = 100;
  
  /**
   * Crée un role aléatoire en fonction des seuils de chaque rôle. 
   * @return
   */
  public Role creerRole(Fourmiliere fourmiliere) {
    
    //Nombre aléatoire entre 0 et 100
    int val = (int) (Math.random() * maxProbabilite);
    
    if (val <= ouvrierMax) {
      fourmiliere.incrementNbOuvrier();
      return new Ouvrier();
    }

    if (val <= soldatMax) {
      fourmiliere.incrementNbSoldat();
      return new Soldat();
    }

    fourmiliere.incrementNbSexue();
    return new Sexue();

  }
}
