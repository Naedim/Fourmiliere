package simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe Logger, permet de créer un suivi de valeurs d'une fourmiliere dans un fichier txt.
 */
public class Logger {
  File file;

  /**
   * Constructeur de logger.
   * 
   * @param chemin : Chemin du fichier log
   */
  public Logger(String chemin) {
    file = new File(chemin);
    PrintWriter writer;
    try {
      writer = new PrintWriter(file);
      writer.print("");
      writer.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * Méthode renseignant un fichier texte à partir d'un Objet Bilan.
   * 
   * @param bilan : Bilan
   * @param temps : Nombre de step depuis le lancement
   */
  public void creeLog(Bilan bilan, int temps) {
    try {
      FileWriter fw = new FileWriter(file, true);
      fw.write("[" + temps + "] LOG : Population de fourmis = " + bilan.getNbFourmi() + "\n");
      fw.write("Nombre d'oeufs = " + bilan.getNbOeuf() + "\n");
      fw.write("Nombre de larves = " + bilan.getNbLarve() + "\n");
      fw.write("Nombre de nymphes = " + bilan.getNbNymphe() + "\n");
      fw.write("Nombres de fourmis Adultes : " + bilan.getNbAdultes() + "\n");
      fw.write("    Soldat = " + bilan.getNbSoldat() + "\n");
      fw.write("    Ouvrier = " + bilan.getNbOuvrier() + "\n");
      fw.write("    Sexué = " + bilan.getNbSexue() + "\n");
      fw.write("Nombre de cadavres : " + bilan.getNbCadavre() + "\n\n");
      fw.close();
    } catch (IOException e) {
      System.out.println("Erreur de fichier");
    }
  }
}
