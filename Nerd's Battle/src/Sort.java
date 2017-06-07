import java.lang.reflect.Array;
import java.util.ArrayList;

import com.sun.javafx.geom.transform.GeneralTransform3D;

public class Sort {
	private String nom;
	private double coeff_degats;
	private double coeff_soins;
	private String type; 
	
	
	
	public Sort(String nom, double coeff_degats, double coeff_soins, String type) {
		super();
		this.nom = nom;
		this.coeff_degats = coeff_degats;
		this.coeff_soins = coeff_soins;
		this.type = type;
	}

	public String getNomArme(){
		return this.nom;
	}
	
	public double getCoeffDegatSort(){
		return this.coeff_degats;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getCoeff_degats() {
		return coeff_degats;
	}

	public void setCoeff_degats(double coeff_degats) {
		this.coeff_degats = coeff_degats;
	}

	public double getCoeff_soins() {
		return coeff_soins;
	}

	public void setCoeff_soins(double coeff_soins) {
		this.coeff_soins = coeff_soins;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}