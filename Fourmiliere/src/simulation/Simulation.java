package simulation;

public interface Simulation {

  /**
   * Méthode qui permet d'incrémenter de 1 step le temps de simulation, 1 step représente 1 jour.
   **/
  public void step();
  
  /**
   * Méthode permettant de lancer une opération de bilan collectant des données.
   * @param b : Objet Bilan
   */
  public void bilan(Bilan b);
}
