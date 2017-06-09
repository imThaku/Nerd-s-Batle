import java.util.ArrayList;

public class Archer extends Personnage{
	public Archer() {
		super(180, 100, 0.2, 50, 30, 15, 15,"");
		Sort g1 = new FlecheEmpoisonné();
		Sort g2 = new MultiShot();
		Sort g3 = new Doge();
		this.getListSorts().add(g1);
		this.getListSorts().add(g2);
		this.getListSorts().add(g3);
	}

}
