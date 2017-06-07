
public class Heal extends Sort{
	public Heal() {
		super("Heal", 0.0,"Plus le lanceur a d'attaque et moins il a de défense, plus il se soigne.");
	}
	
	public void getEffect(Personnage p1,Personnage p2,Dot d){
		double soin = (p1.getVitaMAX())/((p1.getDef()+p1.getDefspe())/10);
		p1.setVita(p1.getVita()+soin);
		System.out.println(p1.getNom()+" se regénère de "+soin+" PV !");
	}
}
