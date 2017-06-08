
public class DernierCoup extends Sort{
	public DernierCoup() {
		super("Dernier Coup", 0.0,"Une chance sur trois de tuer l'enemi si il a moins de 20% de PV.");
	}
	
	public void getEffect(Personnage p1,Personnage p2,Dot d){
		double rdm = Math.random();
		if(rdm>p2.getEsquive()){
			if(p2.getVita()<((p2.getVitaMAX()/100)*20)){
				int random = (int)(Math.random() * (10-0)) + 0;
				if(random<7){
					System.out.println(p2.getNom()+" est achevé par "+p1.getNom()+"!");
					p2.setVita(0);
				}else{
					System.out.println("La tentative de coup fatal a échoué.");
				}
			}else{
				System.out.println(p2.getNom()+" a encore trop de vitalité pour etre achevé.");
			}
		}else{
			System.out.println(p2.getNom()+" a esquivé.");
		}
	}
}
