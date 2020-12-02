package roles;

import modele.Fourmiliere;

/**
 * Classe utilisÃ©e pour attribuer en fonction d'une certaine probabilitÃ© 
 * un role Ã  une fourmi adulte.
 * 
 * @author Damien
 */
public class UsineRole {

  final int maxProbabilite = 100;

  // 60% de chances d'Ãªtre un ouvrier
  final int pourcentageOuvrier = 60;

  // 25% de chance d'Ãªtre un soldat
  final int pourcentageSoldat = 25;

  public int getPourcentageOuvrier() {
    return pourcentageOuvrier;
  }

  public int getPourcentageSoldat() {
    return pourcentageSoldat;
  }

  public int getPourcentageSexue() {
    return pourcentageSexue;
  }

  // 15% de chance d'Ãªtre sexuee
  final int pourcentageSexue = 15;

  /**
   * CrÃ©e un role alÃ©atoire en fonction des seuils de chaque rÃ´le.
   * 
   * @return Objet Role (Soldat, Sexuee, Ouvrier)
   */
  public Role creerRole(Fourmiliere fourmiliere) {

    // Nombre alÃ©atoire entre 0 et 100
    int val = (int) (Math.random() * maxProbabilite);

    //Si le nombre est inférieur ou égal à ouvrierMax, le role est Ouvrier
    if (val <= pourcentageOuvrier) {
      return new Ouvrier();
    }

    //Sinon si le nombre est inférieur ou égal à soldatMax, le role est Soldat
    if (val <= pourcentageOuvrier + pourcentageSoldat) {
      return new Soldat();
    }

    //Sinon le role ets Sexue
    return new Sexue();
  }
}
