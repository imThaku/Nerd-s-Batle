
public class Cac {
	private String nom;
	private double valeur;
	private String type;
	
	public Cac(String nom, double valeur,String type) {
		super();
		this.nom = nom;
		this.valeur = valeur;
		this.type=type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString(){
		if(this.valeur<1){
			return "Cac: "+this.nom+" (-"+valeur+" - "+type+")";
		}else if(this.valeur>=1){
			return "Cac: "+this.nom+" (+"+valeur+" - "+type+")";
		}
		return "";

	}
}
