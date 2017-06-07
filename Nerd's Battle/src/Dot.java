import java.util.ArrayList;

public class Dot {
	private Personnage p1;
	private Personnage p2;
	private ArrayList<DotElement> dotP1;
	private ArrayList<DotElement> dotP2;
	
	public Dot(Personnage p1, Personnage p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.dotP1 = new ArrayList<DotElement>();
		this.dotP2 = new ArrayList<DotElement>();
	}
	
	public void addDot(Personnage p, double valeur, int nbTour){
		DotElement a = new DotElement(valeur,nbTour);
		if(p1.getNom().equals(p.getNom())){
			this.dotP1.add(a);
		}else{
			this.dotP2.add(a);
		}
	}
	
	public void endRound(){
		double dgtP1=0;
		for(int i=0;i<dotP1.size();i++){
			if(dotP1.get(i).getNbTour()>=0){
				dgtP1=dgtP1+dotP1.get(i).getValeur();
				dotP1.get(i).setNbTour(dotP1.get(i).getNbTour()-1);
			}
		}
		if(dgtP1>0){
			this.p1.subitDegat(dgtP1);
			System.out.println(p1.getNom()+" a subit "+dgtP1+" dégat sur la durée !");
		}
		double dgtP2=0;
		for(int i=0;i<dotP2.size();i++){
			if(dotP2.get(i).getNbTour()>=0){
				dgtP2=dgtP2+dotP2.get(i).getValeur();
				dotP2.get(i).setNbTour(dotP2.get(i).getNbTour()-1);
			}
		}
		if(dgtP2>0){
			this.p2.subitDegat(dgtP2);
			System.out.println(p2.getNom()+" a subit "+dgtP2+" dégat sur la durée !");
		}
	}
	
}
