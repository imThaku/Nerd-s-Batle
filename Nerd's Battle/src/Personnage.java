import java.util.ArrayList;

public class Personnage {
	private double vita;
	private double vitaMAX;
	private double vitesse;
	private double esquive;
	private double atk;
	private double atkspe;
	private double def;
	private double defspe;
	private double gold =5000;
	private String nom;
	private boolean canBeHeal = true;
	private ArrayList <Sort> listSorts =new ArrayList();
	private Cac cac = new Cac("Coup de poing",1.0,"physique",0,0,0,0,0,0,0,0);
	private Armure armure = new Armure("Armure du debutant", 0, 0, 0, 0, 0, 0, 0,0);
	private Objet objet = new Objet("Vent",0.0,0.0,0.0,0.0,0.0,0.0,0.0, 0);
	private boolean stun =false;
	private ArrayList<Effect> listEffectPositif=new ArrayList();
	private ArrayList<Effect> listEffectNegatif=new ArrayList();
	
	public Personnage(double vita, double vitesse, double esquive, double atk, double atkspe, double def,double defspe) {
		this.vita = vita;
		this.vitesse = vitesse;
		this.esquive = esquive;
		this.atk = atk;
		this.atkspe = atkspe;
		this.def = def;
		this.defspe = defspe;
		this.vitaMAX=this.vita;
	}
	
	
	public double getVitaMAX() {
		return vitaMAX;
	}


	public void setVitaMAX(double vitaMAX) {
		this.vitaMAX = vitaMAX;
	}


	public boolean isCanBeHeal() {
		return canBeHeal;
	}


	public void setCanBeHeal(boolean canBeHeal) {
		this.canBeHeal = canBeHeal;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public ArrayList<Sort> getListSorts() {
		return listSorts;
	}
	
	public void addSort(Sort s){
		this.listSorts.add(s);
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
		if(this.vita>this.vitaMAX){
			this.vita=this.vitaMAX;
		}
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
		return listSorts.get(numSort).getValeurSort();
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
		return this.atkspe * listSorts.get(numSort).getValeurSort();
	}


	public double getGold() {
		return gold;
	}
	public void setGold(double gold) {
		this.gold = gold;
	}
	
	public void setObjet(Objet o){
		this.objet=o;
	}
	
	public void useObjet(){
		if(this.objet.getBONUSvita()>0){
			Effect vita = new Effect("vita",this.objet.getBONUSvita() , this.objet.getNbTour(), false);
			listEffectPositif.add(vita);
		}else if(this.objet.getBONUSvita()<0){
			Effect vita = new Effect("vita",this.objet.getBONUSvita() , this.objet.getNbTour(), false);
			listEffectNegatif.add(vita);
		}
		if(this.objet.getBONUSatk()>0){
			Effect atk = new Effect("atk",this.objet.getBONUSatk() , this.objet.getNbTour(), false);
			listEffectPositif.add(atk);
		}else if(this.objet.getBONUSatk()<0){
			Effect atk = new Effect("atk",this.objet.getBONUSatk() , this.objet.getNbTour(), false);
			listEffectNegatif.add(atk);
		}
		if(this.objet.getBONUSatkspe()>0){
			Effect atkSpe = new Effect("atkSpe",this.objet.getBONUSatkspe() , this.objet.getNbTour(), false);
			listEffectPositif.add(atkSpe);
		}else if(this.objet.getBONUSatkspe()<0){
			Effect atkSpe = new Effect("atkSpe",this.objet.getBONUSatkspe() , this.objet.getNbTour(), false);
			listEffectNegatif.add(atkSpe);
		}
		if(this.objet.getBONUSdef()>0){
			Effect def = new Effect("def",this.objet.getBONUSdef() , this.objet.getNbTour(), false);
			listEffectPositif.add(def);
		}else if(this.objet.getBONUSdef()<0){
			Effect def = new Effect("def",this.objet.getBONUSdef() , this.objet.getNbTour(), false);
			listEffectNegatif.add(def);
		}
		if(this.objet.getBONUSdefspe()>0){
			Effect defSpe = new Effect("defSpe",this.objet.getBONUSdefspe() , this.objet.getNbTour(), false);
			listEffectPositif.add(defSpe);
		}else if(this.objet.getBONUSdefspe()<0){
			Effect defSpe = new Effect("defSpe",this.objet.getBONUSdefspe() , this.objet.getNbTour(), false);
			listEffectNegatif.add(defSpe);
		}
		if(this.objet.getBONUSesquive()>0){
			Effect esq = new Effect("esq",this.objet.getBONUSesquive() , this.objet.getNbTour(), false);
			listEffectPositif.add(esq);
		}else if(this.objet.getBONUSesquive()<0){
			Effect esq = new Effect("esq",this.objet.getBONUSesquive() , this.objet.getNbTour(), false);
			listEffectNegatif.add(esq);
		}
		if(this.objet.getBONUSvitesse()>0){
			Effect vit = new Effect("vit",this.objet.getBONUSvitesse() , this.objet.getNbTour(), false);
			listEffectPositif.add(vit);
		}else if(this.objet.getBONUSvitesse()<0){
			Effect vit = new Effect("vit",this.objet.getBONUSvitesse() , this.objet.getNbTour(), false);
			listEffectNegatif.add(vit);
		}
		
		this.objet=null;
	}
	
	public void setCac(Cac cac) {
		this.vita=this.vita-this.cac.getBONUSvita();
		this.vitesse=this.vitesse-this.cac.getBONUSvitesse();
		this.esquive=this.esquive-this.cac.getBONUSesquive();
		this.atk=this.atk-this.cac.getBONUSatk();
		this.atkspe=this.atkspe-this.cac.getBONUSatkspe();
		this.def=this.def-this.cac.getBONUSdef();
		this.defspe=this.defspe-this.cac.getBONUSdefspe();
		
		this.cac = cac;
		this.vita=this.vita+cac.getBONUSvita();
		this.vitesse=this.vitesse+cac.getBONUSvitesse();
		this.esquive=this.esquive+cac.getBONUSesquive();
		this.atk=this.atk+cac.getBONUSatk();
		this.atkspe=this.atkspe+cac.getBONUSatkspe();
		this.def=this.def+cac.getBONUSdef();
		this.defspe=this.defspe+cac.getBONUSdefspe();
		this.vitaMAX=this.vita;
	}
	
	public void setArmure(Armure armure) {
		this.vita=this.vita-this.armure.getBonus_vita();
		this.vitesse=this.vitesse-this.armure.getBonus_vitesse();
		this.esquive=this.esquive-this.armure.getBonus_esquive();
		this.atk=this.atk-this.armure.getBonus_attaque();
		this.atkspe=this.atkspe-this.armure.getBonus_attaqueSpe();
		this.def=this.def-this.armure.getBonus_def();
		this.defspe=this.defspe-this.armure.getBonus_defSpe();
		
		this.armure = armure;
		this.vita=this.vita+armure.getBonus_vita();
		this.vitesse=this.vitesse+armure.getBonus_vitesse();
		this.esquive=this.esquive+armure.getBonus_esquive();
		this.atk=this.atk+armure.getBonus_attaque();
		this.atkspe=this.atkspe+armure.getBonus_attaqueSpe();
		this.def=this.def+armure.getBonus_def();
		this.defspe=this.defspe+armure.getBonus_defSpe();
		this.vitaMAX=this.vita;
	}
	public boolean isDead(){
		boolean rtn =false;
		if(this.vita<=0.0){
			rtn=true;
		}
		return rtn;
	}
	
	public boolean isStun() {
		return stun;
	}


	public void setStun(boolean stun) {
		this.stun = stun;
	}


	public ArrayList<Effect> getListEffectPositif() {
		return listEffectPositif;
	}


	public void setListEffectPositif(ArrayList<Effect> listEffectPositif) {
		this.listEffectPositif = listEffectPositif;
	}


	public ArrayList<Effect> getListEffectNegatif() {
		return listEffectNegatif;
	}


	public void setListEffectNegatif(ArrayList<Effect> listEffectNegatif) {
		this.listEffectNegatif = listEffectNegatif;
	}


	public void appliqueEffetPositif() {
		Effect e;
		if(this.getListEffectPositif().isEmpty()){
			return;
		}
	/*	for (Effect e : listEffectPositif) {*/
		for(int i = 0; i < listEffectPositif.size(); ++i){
			e = listEffectPositif.get(i);
			switch (e.getEffectName()) {
			case "vita":
				this.vita += e.getEffectValeur();
				System.out.println(this.nom + " +" + e.getEffectValeur() + "pv!");
				break;

			case "atk":
				if (e.getTempsRestant() > 0) {
					if (!e.getEffectActif()) {
						this.atk += e.getEffectValeur();
					}
					System.out.println(this.nom +" ATK +" + e.getEffectValeur() + " temps restant: " + e.getTempsRestant());
				}
				else {
					this.atk -= e.getEffectValeur();
				}
				break;
				
			case "atkSpe":
				if (e.getTempsRestant() > 0) {
					if (!e.getEffectActif()) {
						this.atkspe -= e.getEffectValeur();
					}
					System.out.println(this.nom +" ATKSpé +" + e.getEffectValeur() + " temps restant: " + e.getTempsRestant());
				}
				else {
					this.atkspe -= e.getEffectValeur();
				}
				break;
				
			case "def":
				if (e.getTempsRestant() > 0) {
					if (!e.getEffectActif()) {
						this.def += e.getEffectValeur();
					}
					System.out.println(this.nom +" DEF +" + e.getEffectValeur() + " temps restant: " + e.getTempsRestant());
				}
				else {
					this.def -= e.getEffectValeur();
				}
				break;
				
			case "defSpe":
				if (e.getTempsRestant() > 0) {
					if (!e.getEffectActif()) {
						this.defspe += e.getEffectValeur();
					}
					System.out.println(this.nom +" DEFSpé +" + e.getEffectValeur() + " temps restant: " + e.getTempsRestant());
				}
				else {
					this.defspe -= e.getEffectValeur();
				}
				break;
				
			case "vit":
				if (e.getTempsRestant() > 0) {
					if (!e.getEffectActif()) {
						this.vitesse += e.getEffectValeur();
					}
					System.out.println(this.nom +" VIT +" + e.getEffectValeur() + " temps restant: " + e.getTempsRestant());
				}
				else {
					this.vitesse -= e.getEffectValeur();
				}
				break;
				
			case "esq":
				if (e.getTempsRestant() > 0) {
					if (!e.getEffectActif()) {
						this.esquive += e.getEffectValeur();
					}
					System.out.println(this.nom +" Esquive +" + e.getEffectValeur()+", esquive actuel " + this.getEsquive() + " temps restant: " + e.getTempsRestant());
				}
				else {
					this.esquive -= e.getEffectValeur();
				}
				break;
				
			case "stun":
				if (e.getTempsRestant() > 0) {
					if (!e.getEffectActif()) {
						this.stun = true;
						System.out.println(this.nom +"est stunmmm !");
					}
					System.out.println(this.nom +"est stun temps restant: " + e.getTempsRestant());
				}
				else {
					this.stun = false;
				}
				break;
				
			default:
				break;
			}
		//	System.out.println("ok!!!!!!!!!!!!!!!!!!!!!!");
			if (e.getTempsRestant() == 0)
				listEffectPositif.remove(e);
			else {
		//		System.out.println(e.getTempsRestant());
				e.setTempsRestant(e.getTempsRestant() - 1);
		//		System.out.println(e.getTempsRestant());
			}
		}
	}
	
	
	public void appliqueEffetNegatif() {
		Effect e;
		if(this.getListEffectNegatif().isEmpty()){
			return;
		}
		/*for (Effect e : listEffectNegatif) {*/
		for(int i=0; i < listEffectNegatif.size(); ++i){
			e = listEffectNegatif.get(i);
			switch (e.getEffectName()) {
			case "vita":
				this.vita -= e.getEffectValeur();
				System.out.println(this.nom + " +" + e.getEffectValeur() + "pv!");
				break;

			case "atk":
				if (e.getTempsRestant() > 0) {
					if (!e.getEffectActif()) {
						this.atk -= e.getEffectValeur();
					}
					System.out.println(this.nom +" ATK -" + e.getEffectValeur() + " temps restant: " + e.getTempsRestant());
				}
				else {
					this.atk += e.getEffectValeur();
				}
				break;
				
			case "atkSpe":
				if (e.getTempsRestant() > 0) {
					if (!e.getEffectActif()) {
						this.atkspe -= e.getEffectValeur();
					}
					System.out.println(this.nom +" ATKSpé -" + e.getEffectValeur() + " temps restant: " + e.getTempsRestant());
				}
				else {
					this.atkspe += e.getEffectValeur();
				}
				break;
				
			case "def":
				if (e.getTempsRestant() > 0) {
					if (!e.getEffectActif()) {
						this.def -= e.getEffectValeur();
					}
					System.out.println(this.nom +" DEF -" + e.getEffectValeur() + " temps restant: " + e.getTempsRestant());
				}
				else {
					this.def += e.getEffectValeur();
				}
				break;
				
			case "defSpe":
				if (e.getTempsRestant() > 0) {
					if (!e.getEffectActif()) {
						this.defspe -= e.getEffectValeur();
					}
					System.out.println(this.nom +" DEFSpé -" + e.getEffectValeur() + " temps restant: " + e.getTempsRestant());
				}
				else {
					this.defspe += e.getEffectValeur();
				}
				break;
				
			case "vit":
				if (e.getTempsRestant() > 0) {
					if (!e.getEffectActif()) {
						this.vitesse -= e.getEffectValeur();
					}
					System.out.println(this.nom +" VIT -" + e.getEffectValeur() + " temps restant: " + e.getTempsRestant());
				}
				else {
					this.vitesse += e.getEffectValeur();
				}
				break;
				
			case "esq":
				if (e.getTempsRestant() > 0) {
					if (!e.getEffectActif()) {
						this.esquive -= e.getEffectValeur();
					}
					System.out.println(this.nom +" Esquive -" + e.getEffectValeur()+", esquive actuel " + this.getEsquive() + " temps restant: " + e.getTempsRestant());
				}
				else {
					this.esquive += e.getEffectValeur();
				}
				break;
				
				
			default:
				
				break;
			}
		//	System.out.println("ok!!!!!!!!!!!!!!!!!!!!!!");
			if (e.getTempsRestant() == 0)
				listEffectPositif.remove(e);
			else {
			//	System.out.println(e.getTempsRestant());
				e.setTempsRestant(e.getTempsRestant() - 1);
			//	System.out.println(e.getTempsRestant());
			}
		}
	}
	
}
