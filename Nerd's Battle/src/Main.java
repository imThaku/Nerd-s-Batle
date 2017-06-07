import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static CSVDecoder CSVCac;
	public static CSVDecoder CSVArm;
	public static CSVDecoder CSVObj;
	public static File cac;
	public static File arm;
	public static File obj;
	public static void main(String[] args) {
		ArrayList<Cac> listCAC = new ArrayList();
		ArrayList<Armure> listARMURE = new ArrayList();
		ArrayList<Objet> listObjet = new ArrayList();
		System.out.println("Bienvenu dans Nerd's Battle!");
		System.out.println("Quel mode voulez lancer ?");
		System.out.println("	1. 1v1 compétitif");
		System.out.println("	2. 1vIA Campagne");
		System.out.println("	3. 1vPoutch");
		String r ="";
		while(r.equals("")){
			Scanner sc = new Scanner(System.in);
			r = sc.nextLine();
			if(r.equals("1")){
				System.out.println("Mod sélectionné: 1v1 compétitif.");
				//launch1v1();
			}else if(r.equals("2")){
				System.out.println("Mode en dev");
			}else if(r.equals("3")){
				System.out.println("Mod sélectionné: 1vPoutch.");
				launchStuff(listCAC,listARMURE,listObjet);
				launchSelec(listCAC,listARMURE,listObjet);
			}
			else{
				System.out.println("Choisissez un mode valide, 1 ,2 ou 3.");
				r="";
			}
		}
	}
	
	public static void launchStuff(ArrayList<Cac> lc,ArrayList<Armure> la,ArrayList<Objet> lo){
		File test= new File("");
		String t=test.getPath();
		cac=new File(test.getAbsolutePath()+"//rsc//Arme-Feuille1.csv");
		arm=new File(test.getAbsolutePath()+"//rsc//Equipement-Feuille1.csv");
		obj=new File(test.getAbsolutePath()+"//rsc//Consommable-Feuille1.csv");
		CSVCac = new CSVDecoder(cac);
		CSVArm = new CSVDecoder(arm);
		CSVObj = new CSVDecoder(obj);
		try {
			lc.addAll(CSVCac.decodeCac());
			la.addAll(CSVArm.decodeArm());
			lo.addAll(CSVObj.decodeObj());
		} catch (IOException e) {
			System.out.println("Erreure fichier CSV");
			e.printStackTrace();
		}		
		
	}
	
	public static void launchSelec(ArrayList lcac,ArrayList larm,ArrayList lobj){
		Personnage perso = null;
		System.out.println("Quelle classe voulez-vous jouer ?");
		System.out.println("	1. Guerrier");
		System.out.println("	2. Mage");
		System.out.println("	3. Archer");
		String r ="";
		while(r.equals("")){
			Scanner sc = new Scanner(System.in);
			r = sc.nextLine();
			if(r.equals("1")){
				perso = new Guerrier();
				Sort g1 = new Vampiro();
				Sort g2 = new DernierCoup();
				Sort g3 = new Parade();
				perso.addSort(g1);
				perso.addSort(g2);
				perso.addSort(g3);
				perso.setNom("Aventurier");
				System.out.println("Guerrier choisi.");
			}else if(r.equals("2")){
				System.out.println("Mage choisi.");
				perso = new Mage();
				perso.setNom("Aventurier");
			}else if(r.equals("3")){
				System.out.println("Archer choisi.");
				perso = new Archer();
				perso.setNom("Aventurier");
			}
			else{
				System.out.println("Choisissez une classe disponible, 1 ,2 ou 3.");
				r="";
			}
		}
		launchMagasin(lcac,larm,lobj,perso);
	}
	
	public static void launch1vPoutch(ArrayList lcac,Personnage perso){
		Poutch poutch = new Poutch();
		Dot dot= new Dot(perso,poutch);
		int tour=1;
		while(!perso.isDead() && !poutch.isDead()){
			perso.appliqueEffetPositif();
			perso.appliqueEffetNegatif();
			poutch.appliqueEffetPositif();
			poutch.appliqueEffetNegatif();
			if(perso.isDead()){
				System.out.println("Vous etes mort !(malus)");
				break;
			}
			if(tour==1){
				System.out.println("Le combat commence ! Tour 1");
			}else{
				System.out.println("Le combat continu, tour "+tour);
			}
			System.out.println("Vitalité perso:"+perso.getVita()+"pv  |  Poutch:"+poutch.getVita()+"pv");
			System.out.println("Selectionnez votre action:");
			System.out.println("	1. "+perso.getCac().toString2());
			System.out.println("	2. "+perso.getListSorts().get(0).getNom()+": "+perso.getListSorts().get(0).getDescription());
			System.out.println("	3. "+perso.getListSorts().get(1).getNom()+": "+perso.getListSorts().get(1).getDescription());
			System.out.println("	4. "+perso.getListSorts().get(2).getNom()+": "+perso.getListSorts().get(2).getDescription());
			System.out.println("	5. "+perso.getObjet().getNom());
			String r ="";
			double degats;
			while(r.equals("")){
				Scanner sc = new Scanner(System.in);
				r = sc.nextLine();
				if(r.equals("1")){
					System.out.println("CAC choisi.");
					if(perso.getCac().getType().equals("physique")){
						degats = perso.infligeDegatCac() - poutch.getDef();
						if(degats>0){
							poutch.subitDegat(degats);
							System.out.println("Poutch -" + degats + " pv !");
						}else{
							System.out.println("Poutch  ne subit aucun degats");
						}
					}else if(perso.getCac().getType().equals("special")){
						degats = perso.infligeDegatCacSpe() - poutch.getDefspe();
						if(degats>0){
							poutch.subitDegat(degats);
							System.out.println("Poutch -" + degats + " pv !");
						}else{
							System.out.println("Poutch  ne subit aucun degats");
						}
					}
				}else if(r.equals("2")){
					perso.getListSorts().get(0).getEffect(perso, poutch, dot);
					
				}else if(r.equals("3")){
					perso.getListSorts().get(1).getEffect(perso, poutch, dot);

				}else if(r.equals("4")){
					perso.getListSorts().get(2).getEffect(perso, poutch, dot);

				}else if(r.equals("5")){
						perso.useObjet();
						Objet objet = new Objet("Vent",0.0,0.0,0.0,0.0,0.0,0.0,0.0, 0);
						perso.setObjet(objet);
				}
				else{
					System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
					r="";
				}
			}
			tour++;
			dot.endRound();
		}
		if(perso.getVita()<=0){
			System.out.println("Vous avez perdu...");
		} else{
			System.out.println("Vous avez vaincu ce Poutch!");
		}
	}

	private static void launchMagasin(ArrayList lcac,ArrayList larm,ArrayList lobj ,Personnage perso) {
		System.out.println("Bienvnue dans l'échoppe !");
		System.out.println("Vous disposer de "+perso.getGold()+" pièces d'or, voulez vous acheter des équipement ?");
		System.out.println("	1. Oui");
		System.out.println("	2. Non");
		String r ="";
		while(r.equals("")){
			Scanner sc = new Scanner(System.in);
			r = sc.nextLine();
			if(r.equals("1")){
				System.out.println("Que voulez-vous acheter?");
				System.out.println("	1. Cac");
				System.out.println("	2. Armure");
				System.out.println("	3. Consomable");
				System.out.println("	4. Partir");
				r ="";
				while(r.equals("")){
					Scanner sc1 = new Scanner(System.in);
					r = sc1.nextLine();
					if(r.equals("1")){
						System.out.println("Quel cac vous interesse?");
						int o;
						for(o=0;o<lcac.size();o++){
							System.out.println("	"+o+". "+lcac.get(o).toString());
						}
						System.out.println("	"+o+".Rien finalement");
						r ="";
						while(r.equals("")){
							Scanner sc2 = new Scanner(System.in);
							r = sc2.nextLine();
							int q = Integer.parseInt(r);
							if(q>=0 && q<lcac.size()){
								perso.setCac((Cac) lcac.get(q));
								perso.setGold(perso.getGold()-perso.getCac().getPrix());
								System.out.println("Vous avez choisi "+perso.getCac().getNom());
								launchMagasin(lcac,larm,lobj,perso);
							}else if(q==o){
								launchMagasin(lcac,larm,lobj,perso);
							}else{
								System.out.println("Choisissez une option disponible.");
								r="";
							}
						}
						r ="";
					}else if(r.equals("2")){
						System.out.println("Quelle armure vous interesse?");
						int o;
						for(o=0;o<larm.size();o++){
							System.out.println("	"+o+". "+larm.get(o).toString());
						}
						System.out.println("	"+o+".Rien finalement");
						r ="";
						while(r.equals("")){
							Scanner sc2 = new Scanner(System.in);
							r = sc2.nextLine();
							int q = Integer.parseInt(r);
							if(q>=0 && q<larm.size()){
								perso.setArmure((Armure)larm.get(q));
								perso.setGold(perso.getGold()-perso.getArmure().getPrix());
								System.out.println("Vous avez choisi "+perso.getArmure().getNom());
								launchMagasin(lcac,larm,lobj,perso);
							}else if(q==o){
								launchMagasin(lcac,larm,lobj,perso);
							}else{
								System.out.println("Choisissez une option disponible.");
								r="";
							}
						}
						r ="";
					}else if(r.equals("3")){
						System.out.println("Quel consommable vous interesse?");
						int o;
						for(o=0;o<lobj.size();o++){
							System.out.println("	"+o+". "+lobj.get(o).toString());
						}
						System.out.println("	"+o+".Rien finalement");
						r ="";
						while(r.equals("")){
							Scanner sc2 = new Scanner(System.in);
							r = sc2.nextLine();
							int q = Integer.parseInt(r);
							if(q>=0 && q<lobj.size()){
								perso.setObjet((Objet) lobj.get(q));
								perso.setGold(perso.getGold()-perso.getObjet().getPrix());
								System.out.println("Vous avez choisi "+perso.getObjet().getNom());
								launchMagasin(lcac,larm,lobj,perso);
							}else if(q==o){
								launchMagasin(lcac,larm,lobj,perso);
							}else{
								System.out.println("Choisissez une option disponible.");
								r="";
							}
						}
						r ="";
					}else if(r.equals("4")){
						System.out.println("Au revoir alors.");
					}
					else{
						System.out.println("Choisissez une option disponible, 1 ,2 ,3 ou 4.");
						r="";
					}
				}
			}else if(r.equals("2")){
				System.out.println("Adieu alors !");
			}
			else{
				System.out.println("Choisissez une option disponible, 1 ou 2.");
				r="";
			}
		}
		System.out.println("Vous sortez de l'échoppe.");
		launch1vPoutch(lcac,perso);
	}

}
