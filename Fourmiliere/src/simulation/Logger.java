package simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import modele.Fourmiliere;

public class Logger {
  File file;

  /** .
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
   * .
   */
  public void creeLog(Fourmiliere f, int temps) {
    try {
      FileWriter fw = new FileWriter(file, true);
      fw.write("[" + temps + "] LOG : Population de fourmis = " + f.getNbFourmi() + "\n");
      fw.write("Nombre d'oeufs = " + f.getNbOeuf() + "\n");
      fw.write("Nombre de larves = " + f.getNbLarve() + "\n");
      fw.write("Nombre de nymphes = " + f.getNbNymphe() + "\n");
      fw.write("Nombres de fourmis Adultes : " + f.getNbAdultes() + "\n");
      fw.write("    Soldat = " + f.getNbSoldat() + "\n");
      fw.write("    Ouvrier = " + f.getNbOuvrier() + "\n");
      fw.write("    Sexué = " + f.getNbSexue() + "\n");
      fw.write("Nombre de cadavres : " + f.getNbCadavre() + "\n\n");
      fw.close();
    } catch (IOException e) {
      System.out.println("Erreur de fichier");
    }
  }
}
