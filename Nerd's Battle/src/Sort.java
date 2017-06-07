import java.lang.reflect.Array;
import java.util.ArrayList;

import com.sun.javafx.geom.transform.GeneralTransform3D;

public class Sort {
	private String nom;
	private double coeff_degats;
	private String description;
	
	public Sort(String nom, double coeff_degat, String description){
		this.nom = nom;
		this.coeff_degats = coeff_degat;
		this.description = description;
	}
	
	public double getValeurSort(){
		return this.coeff_degats;
	}
	
	public String getNom() {
		return nom;
	}
	public String getDescription(){
		return this.description;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public void setCoeff_degats(double coeff_degats) {
		this.coeff_degats = coeff_degats;
	}

	public void getEffect(Personnage p1, Personnage p2, Dot dot){
		
	}
}