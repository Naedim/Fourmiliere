package simulation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import modele.Fourmiliere;

public class Logger {
  File file;

  public Logger(String chemin) {
    file = new File(chemin);
  }

  /**
   * .
   */
  public void creeLog(Fourmiliere f, int temps) {
    try {
      FileWriter fw = new FileWriter(file, true);
      fw.write("[" + temps + "] LOG : Population de fourmis = " + f.getNbFourmi() + "\n");
      fw.write("Nombres d'oeufs = " + f.getNbOeuf() + "\n");
      fw.write("Nombres de larves = " + f.getNbLarve() + "\n");
      fw.write("Nombres de nymphes = " + f.getNbNymphe() + "\n");
      fw.write("Nombres de fourmis Adultes : " + f.getNbAdultes() + "\n");
      fw.write("    Soldat = " + f.getNbSoldat() + "\n");
      fw.write("    Ouvrier = " + f.getNbOuvrier() + "\n");
      fw.write("    Sexué = " + f.getNbSexue() + "\n\n");
      fw.close();
    } catch (IOException e) {
      System.out.println("Erreur de fichier");
    }
  }
}
