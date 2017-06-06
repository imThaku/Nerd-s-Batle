
public class Cac {
	private String nom;
	private double valeur;
	private String type;
	private double BONUSvita;
	private double BONUSvitesse;
	private double BONUSesquive;
	private double BONUSatk;
	private double BONUSatkspe;
	private double BONUSdef;
	private double BONUSdefspe;
	private double prix;
	
	public Cac(String nom, double valeur,String type) {
		this.nom = nom;
		this.valeur = valeur;
		this.type=type;
	}
	
	

	public Cac(String nom, double valeur, String type, double bONUSvita, double bONUSvitesse, double bONUSesquive,double bONUSatk, double bONUSatkspe, double bONUSdef, double bONUSdefspe,double prix) {
		this.nom = nom;
		this.valeur = valeur;
		this.type = type;
		BONUSvita = bONUSvita;
		BONUSvitesse = bONUSvitesse;
		BONUSesquive = bONUSesquive;
		BONUSatk = bONUSatk;
		BONUSatkspe = bONUSatkspe;
		BONUSdef = bONUSdef;
		BONUSdefspe = bONUSdefspe;
		this.prix=prix;
	}

	
	
	public double getBONUSvita() {
		return BONUSvita;
	}



	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}



	public void setBONUSvita(double bONUSvita) {
		BONUSvita = bONUSvita;
	}



	public double getBONUSvitesse() {
		return BONUSvitesse;
	}



	public void setBONUSvitesse(double bONUSvitesse) {
		BONUSvitesse = bONUSvitesse;
	}



	public double getBONUSesquive() {
		return BONUSesquive;
	}



	public void setBONUSesquive(double bONUSesquive) {
		BONUSesquive = bONUSesquive;
	}



	public double getBONUSatk() {
		return BONUSatk;
	}



	public void setBONUSatk(double bONUSatk) {
		BONUSatk = bONUSatk;
	}



	public double getBONUSatkspe() {
		return BONUSatkspe;
	}



	public void setBONUSatkspe(double bONUSatkspe) {
		BONUSatkspe = bONUSatkspe;
	}



	public double getBONUSdef() {
		return BONUSdef;
	}



	public void setBONUSdef(double bONUSdef) {
		BONUSdef = bONUSdef;
	}



	public double getBONUSdefspe() {
		return BONUSdefspe;
	}



	public void setBONUSdefspe(double bONUSdefspe) {
		BONUSdefspe = bONUSdefspe;
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

	public String toString2(){
		if(this.valeur<1){
			return "Cac: "+this.nom+" (-"+valeur+" - "+type+")";
		}else if(this.valeur>=1){
			return "Cac: "+this.nom+" (+"+valeur+" - "+type+")";
		}
		return "";

	}
	
	public String toString(){
		if(this.valeur<1){
			return "Cac: "+this.nom+" (-"+valeur+" - "+type+" / "+this.BONUSvita+" / "+this.BONUSvita+" / "+this.BONUSvitesse+" / "+this.BONUSesquive+" / "+this.BONUSatk+" / "+this.BONUSatkspe+" / "+this.BONUSdef+" / "+this.BONUSdefspe+") "+this.prix+" Pièces d'or";                                          
		}else if(this.valeur>=1){
			return "Cac: "+this.nom+" (+"+valeur+" - "+type+" / "+this.BONUSvita+" / "+this.BONUSvita+" / "+this.BONUSvitesse+" / "+this.BONUSesquive+" / "+this.BONUSatk+" / "+this.BONUSatkspe+" / "+this.BONUSdef+" / "+this.BONUSdefspe+") "+this.prix+" Pièces d'or";
		}
		return "";

	}
}
