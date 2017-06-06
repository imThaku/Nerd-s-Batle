import java.lang.reflect.Array;
import java.util.ArrayList;

import com.sun.javafx.geom.transform.GeneralTransform3D;

public class Sort {
	private String nom;
	private double coeff_degats;
	
	public Sort(String nom, double coeff_degat){
		this.nom = nom;
		this.coeff_degats = coeff_degat;
	}
	
	public String getNomArme(){
		return this.nom;
	}
	
	public double getCoeffDegatSort(){
		return this.coeff_degats;
	}
}
