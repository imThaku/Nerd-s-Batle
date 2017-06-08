import java.util.ArrayList;

public class UsineMonstre{
	private Monstre monstreSimple;
    
    public UsineMonstre()
    {
        this.monstreSimple =null;
    }
	
	public Monstre createBlop(){
		Monstre blop = new Monstre(20, 0.1, 0.1, 10, 10, 5, 5);
		blop.setNom("Blop");
		blop.setGold(500);
		Sort sort1 = new Sort("bloups!", 0.5, "Inflige de faible degats a l'ennemi");
		Sort sort2 = new Sort("BLOPBLOPBLOP", 1, "Inflige de gros degats a l'ennemi");
		blop.addSort(sort1);
		blop.addSort(sort2);
		return blop;
	}
	
	public Monstre createFombassiette(){
		Monstre fombassiette = new Monstre(200, 0.1, 0.1, 100, 50, 60, 60);
		fombassiette.setNom("Fombassiette");
		fombassiette.setGold(700);
		Sort sort1 = new Sort("VousEtesAVEUGLE", 1, "Aveugle l'ennemi");
		Sort sort2 = new Sort("FOMBASSEAU132", 1.5, "Hack votre cerveau !");
		fombassiette.addSort(sort1);
		fombassiette.addSort(sort2);
		return fombassiette;
	}
	
	public Monstre creatGobalElite(){
		Monstre gobalElite = new Monstre(125, 0.5, 0.3, 45, 20, 20, 20);
		gobalElite.setNom("GobalElite");
		gobalElite.setGold(650);
		Sort sort1 = new Sort("CykaBlyat", 0.5, "i will report you !");
		Sort sort2 = new Sort("Zeus!", 1.5, "OS l'ennemi");
		gobalElite.addSort(sort1);
		gobalElite.addSort(sort2);
		return gobalElite;
	}
	
	public Monstre createGobTout(){
		Monstre gobTout = new Monstre(110, 0.2, 0.2, 60, 60, 20, 20);
		gobTout.setNom("GobTout");
		gobTout.setGold(600);
		Sort sort1 = new Sort("Avale", 0.5, "Avale l'ennemi");
		Sort sort2 = new Sort("AvaleTout!", 1.5, "Avale vraiment tout OMG");
		gobTout.addSort(sort1);
		gobTout.addSort(sort2);
		return gobTout;
	}
	
	public Monstre createGobelinDisquetteur(){
		Monstre gobelinDisquetteur = new Monstre(80, 0.5, 0.3, 20, 60, 20, 60);
		gobelinDisquetteur.setNom("GobelinDisquetteur");
		gobelinDisquetteur.setGold(550);
		Sort sort1 = new Sort("EjecteLaDisquette", 0.5, "Ejecte une disque, attention !");
		Sort sort2 = new Sort("InsereLaDisquette", 1, "Insere une disque, ça va faire mal !");
		gobelinDisquetteur.addSort(sort1);
		gobelinDisquetteur.addSort(sort2);
		return gobelinDisquetteur;
	}
	
	public Monstre createPunchlinoGob(){
		Monstre punchLineGob = new Monstre(50, 0.5, 0.3, 20, 20, 20, 20);
		punchLineGob.setNom("PunchLinoGob");
		punchLineGob.setGold(500);
		Sort sort1 = new Sort("ZbeubZbeub", 0.2, "ZbeubZbeuuuuuuuuuuuuuuub!");
		Sort sort2 = new Sort("AdieuNaim", 1, "ah non enfaite, merci papa!");
		punchLineGob.addSort(sort1);
		punchLineGob.addSort(sort2);
		return punchLineGob;
		
	}
}
