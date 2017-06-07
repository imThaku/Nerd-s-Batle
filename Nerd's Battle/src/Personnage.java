import java.util.ArrayList;

public class Personnage {
	private double vita;
	private double vitesse;
	private double esquive;
	private double atk;
	private double atkspe;
	private double def;
	private double defspe;
	private double gold =5000;
	private ArrayList <Sort> listSorts;
	private Cac cac = new Cac("Coup de poing",1.0,"physique",0,0,0,0,0,0,0,0);
	private Armure armure = new Armure("Armure du debutant", 0, 0, 0, 0, 0, 0, 0,0);
	
	public Personnage(double vita, double vitesse, double esquive, double atk, double atkspe, double def,double defspe) {
		this.vita = vita;
		this.vitesse = vitesse;
		this.esquive = esquive;
		this.atk = atk;
		this.atkspe = atkspe;
		this.def = def;
		this.defspe = defspe;
	}
	
	
	public Personnage() {
		// TODO Auto-generated constructor stub
	}


	public ArrayList<Sort> getListSorts() {
		return listSorts;
	}


	public void setListSorts(ArrayList<Sort> listSorts) {
		this.listSorts = listSorts;
	}


	public Armure getArmure() {
		return armure;
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
	public double getSort(int numSort) {
		return listSorts.get(numSort).getCoeffDegatSort();
	}


	public Cac getCac() {
		return cac;
	}
	
	public void subitDegat(double degats){
		this.vita -= degats;
	}
	
	public double infligeDegatCac(){
		return this.atk * this.cac.getValeur();
	}
	
	public double infligeDegatCacSpe(){
		return this.atkspe * this.cac.getValeur();
	}
	
	public double infligeDegatSpell(int numSort){
		return this.atkspe * listSorts.get(numSort).getCoeffDegatSort();
	}


	public double getGold() {
		return gold;
	}
	public void setGold(double gold) {
		this.gold = gold;
	}
	public void setCac(Cac cac) {
		this.cac = cac;
		this.vita=this.vita+cac.getBONUSvita();
		this.vitesse=this.vitesse+cac.getBONUSvitesse();
		this.esquive=this.esquive+cac.getBONUSesquive();
		this.atk=this.atk+cac.getBONUSatk();
		this.atkspe=this.atkspe+cac.getBONUSatkspe();
		this.def=this.def+cac.getBONUSdef();
		this.defspe=this.defspe+cac.getBONUSdefspe();
	}
	
	public void setArmure(Armure armure) {
		this.armure = armure;
		this.vita=this.vita+armure.getBonus_vita();
		this.vitesse=this.vitesse+armure.getBonus_vitesse();
		this.esquive=this.esquive+armure.getBonus_esquive();
		this.atk=this.atk+armure.getBonus_attaque();
		this.atkspe=this.atkspe+armure.getBonus_attaqueSpe();
		this.def=this.def+armure.getBonus_def();
		this.defspe=this.defspe+armure.getBonus_defSpe();
	}
	public boolean isDead(){
		boolean rtn =false;
		if(this.vita<=0.0){
			rtn=true;
		}
		return rtn;
	}
	
	
}
