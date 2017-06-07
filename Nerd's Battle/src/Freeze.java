
public class Freeze extends Sort{
	public Freeze() {
		super("Freeze", 0.0,"Gèle l'ennemi pendant 3 tours");
	}
	
	public void getEffect(Personnage p1,Personnage p2,Dot d){

		System.out.println(p1.getNom()+" est gelé pour 3 tours");
	}
}

