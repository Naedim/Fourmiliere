package roles;

public class UsineRole {
  
  final int maxProbabilite = 100;

  final int ouvrierMin = 0;
  final int ouvrierMax = 60;

  final int soldatMin = 60;
  final int soldatMax = 85;

  final int sexueMin = 85;
  final int sexueMax = 100;

  private int randVal() {
    return (int) (Math.random() * maxProbabilite);
  }

  /**
   * creer aléatoirement un role pour un adulte.
   * 
   * @return un Role
   */
  public Role creerAdulte() {
    int val = this.randVal();
    if (val >= ouvrierMin && val <= ouvrierMax) {
      return new Ouvrier();
    }
    
    if (val > soldatMin && val <= soldatMax) {
      return new Ouvrier();
    }
    
    if (val > sexueMin && val <= sexueMax) {
      return new Ouvrier();
    }
    return null;

  }
}
