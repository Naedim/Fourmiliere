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
   * creer aleatoirement un role pour un adulte.
   * 
   * @return un Role
   */
  public Role creerRole() {
    int val = this.randVal();
    if (val >= ouvrierMin && val <= ouvrierMax) {
      return new Ouvrier();
    }

    if (val > soldatMin && val <= soldatMax) {
      return new Soldat();
    }

    return new Sexue();

  }
}
