public class Effect {
	private String nom;
	private int nbTours;
	private double valeur;
	private boolean active;
	
	public Effect(String nom, double valeur, int nbTours, boolean active){
		this.nom = nom;
		this.valeur = valeur;
		this.nbTours = nbTours;
		this.active = active;
		
	}
	
	public boolean getEffectActif(){
		return this.active;
	}
	
	public void setEffectActif(boolean a){
		this.active = a;
	}
	
	
	public String getEffectName(){
		return this.nom;
	}
	public double getEffectValeur(){
		return this.valeur;
	}
	
	public int getTempsRestant(){
		return this.nbTours;
	}
	
	public void setTempsRestant(int temps){
		this.nbTours = temps;
	}
	public String toString(){
		return this.getEffectName()+" "+this.getEffectValeur();
	}
}