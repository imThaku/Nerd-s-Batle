import java.util.ArrayList;

public class Mage extends Personnage{

	public Mage() {
		super(180, 90, 0.2, 30, 50, 10, 40,"");
		Sort g1 = new Heal();
		Sort g2 = new NuageLetal();
		Sort g3 = new Freeze();
		this.getListSorts().add(g1);
		this.getListSorts().add(g2);
		this.getListSorts().add(g3);
	}
	
}
