
public class Vampiro extends Sort{

	public Vampiro() {
		super("Vampiro", 1.0,"Vol de vie de 33%, de type physique.");
	}
	
	public void getEffect(Personnage p1,Personnage p2,Dot d){
		p2.subitDegat(p1.getAtk()-p2.getDef());
		System.out.println(p2.getNom()+" subit "+(p1.getAtk()-p2.getDef())+" dégats !");
		p1.setVita(p1.getVita()+((p1.getAtk()-p2.getDef())/3));
		System.out.println(p1.getNom()+" se regénère de "+((p1.getAtk()-p2.getDef())/3)+" PV !");
	}
	
}
