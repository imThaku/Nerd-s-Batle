
public class NuageLetal extends Sort{
	public NuageLetal() {
		super("Nuage Letal", 0.7,"Inflige des dégat sur la durée pendant 3 tours");
	}
	
	public void getEffect(Personnage p1,Personnage p2,Dot d){
		d.addDot(p2, p1.getAtkspe()*0.7, 3);
		System.out.println(p2.getNom()+" est suivi par un orage magique.");
	}
}
