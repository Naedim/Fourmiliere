package roles;

import modele.Fourmiliere;

/**
 * Classe utilisée pour attribuer en fonction d'une certaine probabilité 
 * un role à une fourmi adulte.
 * 
 * @author Damien
 */
public class UsineRole {

  final int maxProbabilite = 100;

  // 60% de chances d'être un ouvrier
  final int pourcentageOuvrier = 60;

  // 25% de chance d'être un soldat
  final int pourcentageSoldat = 25;
  
  // 15% de chance d'être sexuee
  final int pourcentageSexue = 15;

  
  public int getPourcentageOuvrier() {
    return pourcentageOuvrier;
  }

  public int getPourcentageSoldat() {
    return pourcentageSoldat;
  }

  public int getPourcentageSexue() {
    return pourcentageSexue;
  }


  /**
   * Crée un role aléatoire en fonction des seuils de chaque rôle.
   * 
   * @param fourmiliere : Fourmiliere
   * @return Objet Role (Soldat, Sexuee, Ouvrier)
   */
  public Role creerRole(Fourmiliere fourmiliere) {

    // Nombre aléatoire entre 0 et 100
    int val = (int) (Math.random() * maxProbabilite);

    //Si le nombre est inférieur ou égal à ouvrierMax, le role est Ouvrier
    if (val <= pourcentageOuvrier) {
      return new Ouvrier();
    }

    //Sinon si le nombre est inférieur ou égal à soldatMax, le role est Soldat
    if (val <= pourcentageOuvrier + pourcentageSoldat) {
      return new Soldat();
    }

    //Sinon le role est Sexue
    return new Sexue();
  }
}
