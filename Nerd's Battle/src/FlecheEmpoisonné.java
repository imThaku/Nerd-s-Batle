
public class FlecheEmpoisonné extends Sort{
	public FlecheEmpoisonné() {
		super("Fleche Empoisonné", 0.6,"Empoisonne pendant trois tour et empèche la cible de se soigner ");
	}
	
	public void getEffect(Personnage p1,Personnage p2,Dot d){
		Effect nonSoignable = new Effect("nonHeal", 0, 3, false);
		p2.getListEffectNegatif().add(nonSoignable);
		p2.setCantBeHeal(false);
		d.addDot(p2, p1.getAtkspe()*0.6, 3);
		System.out.println(p2.getNom()+" est empoisonné et ne peux plus se soigner.");
	}
}