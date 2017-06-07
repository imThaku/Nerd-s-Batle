
public class MultiShot extends Sort{
	public MultiShot() {
		super("MultiShot", 1.0,"Augmente les dégats du sort si utilisé plusieurs fois");
	}
	
	public void getEffect(Personnage p1,Personnage p2,Dot d){
		p2.subitDegat((p1.getAtk()*this.getValeurSort())-p2.getDef());
		System.out.println(p2.getNom()+" subit "+p1.getAtk()*this.getValeurSort()+" dégats, et la puissance du sort est augmenté.");
		this.setCoeff_degats(this.getValeurSort()+0.25);
	}
}