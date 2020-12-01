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
  public void creeLog(Fourmiliere f) {

    try {
      FileWriter fw = new FileWriter(file, true);
      fw.write("[temps] LOG : Population de fourmis = " + f + "\n");
      fw.write("Nombres d'oeufs = \n");
      fw.write("Nombres de larves = \n");
      fw.write("Nombres de nymphes = \n");
      fw.write("Nombres de fourmis Adultes : \n");
      fw.write("    Soldat = \n");
      fw.write("    Ouvrier = \n");
      fw.write("    Sexué = \n\n");

      fw.close();
    } catch (IOException e) {
      System.out.println("Erreur de fichier");
    }
  }
}
