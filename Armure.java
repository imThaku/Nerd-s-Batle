
public class Armure {
	private String nom;
	private int id;
	private int bonus_vita;
	private int bonus_vitesse;
	private int bonus_esquive;
	private int bonus_attaque;
	private int bonus_attaqueSpe;
	private int bonus_def;
	private int bonus_defSpe;
	
	public Armure(String nom, int id,int vita, int vitesse, int esquive, int attaque, int attaqueSpe, int def, int defSpe){
		this.nom = nom;
		this.id = id;
		this.bonus_vita = vita;
		this.bonus_vitesse = vitesse;
		this.bonus_esquive = esquive;
		this.bonus_attaque = attaque;
		this.bonus_attaqueSpe = attaqueSpe;
		this.bonus_def = def;
		this.bonus_defSpe = defSpe;
	}
	
	//GETTEURS SETTEURS

	public String getNom() {
		return nom;
	}

	public int getId() {
		return id;
	}

	public int getBonus_vita() {
		return bonus_vita;
	}

	public int getBonus_vitesse() {
		return bonus_vitesse;
	}

	public int getBonus_esquive() {
		return bonus_esquive;
	}

	public int getBonus_attaque() {
		return bonus_attaque;
	}

	public int getBonus_attaqueSpe() {
		return bonus_attaqueSpe;
	}

	public int getBonus_def() {
		return bonus_def;
	}

	public int getBonus_defSpe() {
		return bonus_defSpe;
	}
	
	
	
}
