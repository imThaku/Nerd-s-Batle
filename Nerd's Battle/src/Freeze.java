
public class Freeze extends Sort{
	public Freeze() {
		super("Freeze", 0.0,"Gèle l'ennemi pendant 3 tours");
	}
	
	public void getEffect(Personnage p1,Personnage p2,Dot d){
		if(this.getCooldown()==0){
			Effect gele = new Effect("stun", 0, 3, false);
			p2.getListEffectNegatif().add(gele);
		//	System.out.println(p2.getListEffectNegatif());
			System.out.println(p2.getNom()+" est gelé pour 3 tours");	
			this.setCooldown(5);
		}
		else{
			System.out.println("Le cooldown est de "+this.getCooldown());
		}
	}
}
