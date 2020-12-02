package vue; 
 
import graphicLayer.GRect; 
import java.awt.Color; 
import java.awt.Dimension; 
import java.awt.Point; 
import java.util.ArrayList; 
import java.util.List; 
 
public class FourmiliereGraphique implements ElementGraphique { 
 
  protected List<GRect> listFourmi; 
  protected TerritoireGraphique territoire; 
  protected GRect elementGraphique; 
 
  /** 
   * . 
   *  
   */ 
  public FourmiliereGraphique(Point posFourmiliere, Dimension dimFourmiliere) { 
 
    elementGraphique = new GRect(); 
    elementGraphique.setDimension(dimFourmiliere); 
 
    elementGraphique.setColor(Color.BLACK); 
    elementGraphique.setPosition(posFourmiliere); 
 
    territoire = new TerritoireGraphique(posFourmiliere, dimFourmiliere); 
 
    this.listFourmi = new ArrayList<GRect>(); 
  } 
 
  public TerritoireGraphique getTerritoire() { 
    return territoire; 
  } 
   
  public GRect getFourmi(int i) { 
    return this.listFourmi.get(i); 
  }

  @Override
  public GRect getElementGraphique() {
    return this.elementGraphique;
  } 
 
} 
