package etapes;

import simulation.Simulation;

/**
 * Interface désignant les classes "étapes" de l'évolution d'une fourmi.
 */
public interface Etape extends Simulation {

  /**
   * Permet de passer à l'étape suivante si la durée de vie est bonne.
   * 
   * @return Un objet Etape contenant la nouvelle étape si la condition de durée est ok, sinon
   *         renvoie l'étape actuelle
   */
  public Etape next();
}
