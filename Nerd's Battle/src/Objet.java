
public class Objet {
	private String nom;
	private double BONUSvita;
	private double BONUSvitesse;
	private double BONUSesquive;
	private double BONUSatk;
	private double BONUSatkspe;
	private double BONUSdef;
	private double BONUSdefspe;
	private double prix;
	private int nbTour;

	public Objet(String nom,double bONUSvita, double bONUSvitesse, double bONUSesquive,double bONUSatk, double bONUSatkspe, double bONUSdef, double bONUSdefspe,double prix) {
		this.nom = nom;
		BONUSvita = bONUSvita;
		BONUSvitesse = bONUSvitesse;
		BONUSesquive = bONUSesquive;
		BONUSatk = bONUSatk;
		BONUSatkspe = bONUSatkspe;
		BONUSdef = bONUSdef;
		BONUSdefspe = bONUSdefspe;
		this.prix=prix;
	}

	
	
	public Objet(String nom2, double bONUSvita2, double bONUSvitesse2, double bONUSesquive2, double bONUSatk2,
			double bONUSatkspe2, double bONUSdef2, double bONUSdefspe2, int prix2,int nbTour) {
		this.nom = nom2;
		BONUSvita = bONUSvita2;
		BONUSvitesse = bONUSvitesse2;
		BONUSesquive = bONUSesquive2;
		BONUSatk = bONUSatk2;
		BONUSatkspe = bONUSatkspe2;
		BONUSdef = bONUSdef2;
		BONUSdefspe = bONUSdefspe2;
		this.prix=prix2;
		this.nbTour=nbTour;
	}



	public int getNbTour() {
		return nbTour;
	}



	public void setNbTour(int nbTour) {
		this.nbTour = nbTour;
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

	public String toString2(){
			return "Objet: "+this.nom;

	}
	
	public String toString(){
			return "Objet: "+this.nom+" ( /vita "+this.BONUSvita+" /vit "+this.BONUSvitesse+" /esq "+this.BONUSesquive+" /atk "+this.BONUSatk+" /atkspe "+this.BONUSatkspe+" /def "+this.BONUSdef+" /defspe "+this.BONUSdefspe+") actif "+this.nbTour+"tours. |"+this.prix+" Pièces d'or";

	}
}


