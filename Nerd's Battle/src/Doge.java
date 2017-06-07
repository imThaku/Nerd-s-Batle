
public class Doge extends Sort{
	public Doge() {
		super("Doge", 0.0,"Augmente de 20% l'esquive");
	}
	
	public void getEffect(Personnage p1,Personnage p2,Dot d){
		Effect equive = new Effect("esq", 0.2, 5, false);
		p1.getListEffectPositif().add(equive);
		System.out.println(p1.getNom()+" augmente son esquive de 20%.");
	}
}