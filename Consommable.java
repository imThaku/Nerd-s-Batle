
public class Consommable {
	private String nom;
	private double valeur;
	private String type;
	private double bonusVita;
	private double bonusEsquive;
	private double bonusVitesse;
	private double bonusAtak;
	private double bonusAtakSpe;
	private double bonusDef;
	private double bonusDefSpe;
	private double prix;
	
	public Consommable(String nom, double valeur,String type) {
		this.nom = nom;
		this.valeur = valeur;
		this.type=type;
	}
	
	

	public Consommable(String nom, double valeur, String type, double bonusVita, double bonusEsquive, double bonusVitesse,double bonusAtak, double bonusAtakSpe, double bonusDef, double bonusDefSpe,double prix) {
		this.nom = nom;
		this.valeur = valeur;
		this.type = type;
		this.bonusVita = bonusVita;
		this.bonusEsquive = bonusEsquive;
		this.bonusEsquive = bonusVitesse;
		this.bonusAtak = bonusAtak;
		this.bonusAtakSpe = bonusAtakSpe;
		this.bonusDef = bonusDef;
		this.bonusDefSpe = bonusDefSpe;
		this.prix=prix;
	}

	
	
	public double getBonusVita() {
		return bonusVita;
	}


	public void setBonusVita(double bonusVita) {
		this.bonusVita = bonusVita;
	}
	
	
	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}



	public double getBonusEsquive() {
		return bonusEsquive;
	}



	public void setBonusEsquive(double bonusEsquive) {
		this.bonusEsquive = bonusEsquive;
	}



	public double getBonusVitesse() {
		return bonusVitesse;
	}



	public void setBonusVitesse(double bonusVitesse) {
		this.bonusVitesse = bonusVitesse;
	}



	public double getBonusAtak() {
		return bonusAtak;
	}



	public void setBonusAtak(double bonusAtak) {
		this.bonusAtak = bonusAtak;
	}



	public double getBonusAtakSpe() {
		return bonusAtakSpe;
	}



	public void setBonusAtakSpe(double bonusAtakSpe) {
		this.bonusAtakSpe = bonusAtakSpe;
	}



	public double getBonusDef() {
		return bonusDef;
	}



	public void setBonusDef(double bonusDef) {
		this.bonusDef = bonusDef;
	}



	public double getBonusDefSpe() {
		return bonusDefSpe;
	}



	public void setBonusDefSpe(double bonusDefSpe) {
		this.bonusDefSpe = bonusDefSpe;
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
			return "Consommable: "+this.nom+" (-"+valeur+" - "+type+")";
		}else if(this.valeur>=1){
			return "Consommable: "+this.nom+" (+"+valeur+" - "+type+")";
		}
		return "";

	}
	
	public String toString(){
		if(this.valeur<1){
			return "Consommable: "+this.nom+" (-"+valeur+" - "+type+" / "+this.bonusVita+" / "+this.bonusVita+" / "+this.bonusEsquive+" / "+this.bonusVitesse+" / "+this.bonusAtak+" / "+this.bonusAtakSpe+" / "+this.bonusDef+" / "+this.bonusDefSpe+") "+this.prix+" Pièces d'or";                                          
		}else if(this.valeur>=1){
			return "Consommable: "+this.nom+" (+"+valeur+" - "+type+" / "+this.bonusVita+" / "+this.bonusVita+" / "+this.bonusEsquive+" / "+this.bonusVitesse+" / "+this.bonusAtak+" / "+this.bonusAtakSpe+" / "+this.bonusDef+" / "+this.bonusDefSpe+") "+this.prix+" Pièces d'or";
		}
		return "";

	}
}
