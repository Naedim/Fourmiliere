package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import modele.Fourmiliere;
import org.junit.jupiter.api.Test;
import roles.Ouvrier;
import roles.Role;
import roles.Soldat;
import roles.UsineRole;



class TestUsineRole {

  private int nbOuvrier = 0;
  private int nbSoldat = 0;
  private int nbSexue = 0;

  public void getNbRoles(List<Role> listRole) {
    for (Role r : listRole) {
      if (r instanceof Ouvrier) {
        nbOuvrier++;
      } else if (r instanceof Soldat) {
        nbSoldat++;
      } else {
        nbSexue++;
      }
    }
  }

  @Test
  void test() {

    Fourmiliere f = new Fourmiliere();
    UsineRole ur = new UsineRole();

    List<Role> listRole = new ArrayList<Role>();

    int nbRoles = 1000000;

    for (int i = 0; i < nbRoles; i++) {
      listRole.add(ur.creerRole(f));
      assertTrue(listRole.size() == i + 1);
    }
    getNbRoles(listRole);

    float por = (float) (this.nbOuvrier) / nbRoles * 100;
    float psolr = (float) (this.nbSoldat) / nbRoles * 100;
    float psexr = (float) (this.nbSexue) / nbRoles * 100;

    float pourcentO = (float) ur.getPourcentageOuvrier();
    float pourcentSol = (float) ur.getPourcentageSoldat();
    float pourcentSex = (float) ur.getPourcentageSexue();

    assertTrue(pourcentO - 2.5 <= por && por <= pourcentO + 2.5);
    assertTrue(pourcentSol - 2.5 <= psolr && psolr <= pourcentSol + 2.5);
    assertTrue(pourcentSex - 2.5 <= psexr && psexr <= pourcentSex + 2.5);


  }


}
