
public class Parade extends Sort{
	public Parade() {
		super("Parade", 0.0,"Bloque la prochaine attaque.");
	}
	
	public void getEffect(Personnage p1,Personnage p2,Dot d){

		System.out.println(p1.getNom()+" est gelé pour 3 tours");
	}
}

