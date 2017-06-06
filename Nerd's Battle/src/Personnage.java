import java.util.ArrayList;

public class Personnage {
	private double vita;
	private double vitesse;
	private double esquive;
	private double atk;
	private double atkspe;
	private double def;
	private double defspe;
	private ArrayList Sort;
	private Cac cac = new Cac("Coup de poing",1.0,"physique");
	
	public Personnage(double vita, double vitesse, double esquive, double atk, double atkspe, double def,double defspe) {
		this.vita = vita;
		this.vitesse = vitesse;
		this.esquive = esquive;
		this.atk = atk;
		this.atkspe = atkspe;
		this.def = def;
		this.defspe = defspe;
	}
	public double getVita() {
		return vita;
	}
	public void setVita(double vita) {
		this.vita = vita;
	}
	public double getVitesse() {
		return vitesse;
	}
	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
	}
	public double getEsquive() {
		return esquive;
	}
	public void setEsquive(double esquive) {
		this.esquive = esquive;
	}
	public double getAtk() {
		return atk;
	}
	public void setAtk(double atk) {
		this.atk = atk;
	}
	public double getAtkspe() {
		return atkspe;
	}
	public void setAtkspe(double atkspe) {
		this.atkspe = atkspe;
	}
	public double getDef() {
		return def;
	}
	public void setDef(double def) {
		this.def = def;
	}
	public double getDefspe() {
		return defspe;
	}
	public void setDefspe(double defspe) {
		this.defspe = defspe;
	}
	public ArrayList getSort() {
		return Sort;
	}

	public void setSort(ArrayList sort) {
		Sort = sort;
	}

	public Cac getCac() {
		return cac;
	}

	public void setCac(Cac cac) {
		this.cac = cac;
	}
	public boolean isDead(){
		boolean rtn =false;
		if(this.vita<=0.0){
			rtn=true;
		}
		return rtn;
	}
	
	
}
