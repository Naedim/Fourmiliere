package roles;

import modele.Fourmiliere;

/**
 * Classe utilisee pour attribuer en fonction d'une certaine probabilite 
 * un role a  une fourmi adulte.
 * 
 * @author Damien
 */
public class UsineRole {

  final int maxProbabilite = 100;

  // 60% de chances d'aªtre un ouvrier
  final int pourcentageOuvrier = 60;

  // 25% de chance d'aªtre un soldat
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

  // 15% de chance d'aªtre sexuee
  final int pourcentageSexue = 15;

  /**
   * Cree un role aleatoire en fonction des seuils de chaque role.
   * @param fourmiliere : 
   * @return Objet Role (Soldat, Sexuee, Ouvrier)
   */
  public Role creerRole(Fourmiliere fourmiliere) {

    // Nombre aleatoire entre 0 et 100
    int val = (int) (Math.random() * maxProbabilite);

    //Si le nombre est inférieur ou égal a ouvrierMax, le role est Ouvrier
    if (val <= pourcentageOuvrier) {
      return new Ouvrier();
    }

    //Sinon si le nombre est inférieur ou égal a soldatMax, le role est Soldat
    if (val <= pourcentageOuvrier + pourcentageSoldat) {
      return new Soldat();
    }

    //Sinon le role ets Sexue
    return new Sexue();
  }
}
