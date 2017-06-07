import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static CSVDecoder CSVCac;
	public static CSVDecoder CSVArm;
	public static File cac;
	public static File arm;
	static int debug=0;
	
	public static void main(String[] args) {
		ArrayList<Cac> listCAC = new ArrayList();
		ArrayList<Armure> listARMURE = new ArrayList();
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
				debug=2;
				// monstre a creer
				launchStuff(listCAC,listARMURE);
				launchSelec(listCAC,listARMURE,monstre);
				
			}else if(r.equals("3")){
				System.out.println("Mod sélectionné: 1vPoutch.");
				/*
				cac=new File("//Users//Stephou//Documents//GitHub//Nerd-s-Battle//Nerd's Battle//src//Arme-Feuille1.csv");
				arm=new File("//Users//Stephou//Documents//GitHub//Nerd-s-Battle//Nerd's Battle//resources//Equipement-Feuille1.csv");
				CSVCac = new CSVDecoder(cac);
				CSVArm = new CSVDecoder(arm);
				try {
					listCAC=CSVCac.decodeCac();
					listARMURE=CSVArm.decodeArm();
					for (int i=0;i<listCAC.size();i++){
						System.out.println(listCAC.get(i).toString2());
						System.out.println(listARMURE.get(i).toString());
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				launchStuff(listCAC,listARMURE);
				launchSelec(listCAC,listARMURE,monstre);
			}	
			else{
				System.out.println("Choisissez un mode valide, 1 ,2 ou 3.");
				r="";
			}
		}
	}
	
	public static void launchStuff(ArrayList<Cac> lc,ArrayList<Armure> la){
		File test= new File("");
		String t=test.getPath();
		cac=new File(test.getAbsolutePath()+"//src//Arme-Feuille1.csv");
		arm=new File(test.getAbsolutePath()+"//resources//Equipement-Feuille1.csv");
		CSVCac = new CSVDecoder(cac);
		CSVArm = new CSVDecoder(arm);
		try {
			lc.addAll(CSVCac.decodeCac());
			la.addAll(CSVArm.decodeArm());
		} catch (IOException e) {
			System.out.println("Erreure fichier CSV");
			e.printStackTrace();
		}
	}
	
	public static void launchSelec(ArrayList<Cac> lcac,ArrayList<Armure> larm,Personnage monstre){
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
				System.out.println("Guerrier choisi.");
				perso = new Guerrier();
			}else if(r.equals("2")){
				System.out.println("Mage choisi.");
				perso = new Mage();
			}else if(r.equals("3")){
				System.out.println("Archer choisi.");
				perso = new Archer();
			}
			else{
				System.out.println("Choisissez une classe disponible, 1 ,2 ou 3.");
				r="";
			}
		}
		launchMagasin(lcac,larm,perso,monstre);
	}
	
	public static void launch1vPoutch(ArrayList lcac,Personnage perso){
		Poutch poutch = new Poutch();
		int tour=1;
		while(!perso.isDead() && !poutch.isDead()){
			if(tour==1){
				System.out.println("Le combat commence ! Tour 1");
			}else{
				System.out.println("Le combat continu, tour "+tour);
			}
			System.out.println("Vitalité perso:"+perso.getVita()+"pv  |  Poutch:"+poutch.getVita()+"pv");
			System.out.println("Selectionnez votre action:");
			System.out.println("	1. "+perso.getCac().toString2());
			System.out.println("	2. Sort1");
			System.out.println("	3. Sort2");
			System.out.println("	4. Sortulti");
			System.out.println("	5. Objet");
			String r ="";
			double degats;
			while(r.equals("")){
				Scanner sc = new Scanner(System.in);
				r = sc.nextLine();
				if(r.equals("1")){
					System.out.println("CAC choisi.");
					if(perso.getCac().getType().equals("physique")){
						degats = perso.infligeDegatCac() - poutch.getDef();
						poutch.subitDegat(degats);
						System.out.println("Poutch - " + degats + " pv !");
					}else if(perso.getCac().getType().equals("special")){
						degats = perso.infligeDegatCacSpe() - poutch.getDefspe();
						poutch.subitDegat(degats);
						System.out.println("Poutch - " + degats + " pv !");
					}
				}else if(r.equals("2")){
					System.out.println("Sort1 choisi.");

				}else if(r.equals("3")){
					System.out.println("Sort2 choisi.");

				}else if(r.equals("4")){
					System.out.println("SortUlti choisi.");

				}else if(r.equals("5")){
					System.out.println("Objet choisi.");

				}
				else{
					System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
					r="";
				}
			}
			tour++;
		}
		if(perso.getVita()<=0){
			System.out.println("Vous avez perdu...");
		} else{
			System.out.println("Vous avez vaincu ce Poutch!");
		}
	}

	
	public static void launch1vIA(ArrayList lcac, Personnage perso,Personnage poutch){
		
		int tour=1;
		while(!perso.isDead() && !poutch.isDead()){
			if(tour==1){
				System.out.println("Le combat commence ! Tour 1");
			}else{
				System.out.println("Le combat continu, tour "+tour);
			}
			if(perso.getVitesse()>poutch.getVitesse()){
			System.out.println("Vitalité perso:"+perso.getVita()+"pv  |  Poutch:"+poutch.getVita()+"pv");
			System.out.println("Selectionnez votre action:");
			System.out.println("	1. "+perso.getCac().toString2());
			System.out.println("	2. Sort1");
			System.out.println("	3. Sort2");
			System.out.println("	4. Sortulti");
			System.out.println("	5. Objet");
			String r ="";
			double degats;
			while(r.equals("")){
				Scanner sc = new Scanner(System.in);
				r = sc.nextLine();
				if(r.equals("1")){
					System.out.println("CAC choisi.");
					if(perso.getCac().getType().equals("physique")){
						degats = perso.infligeDegatCac() - poutch.getDef();
						poutch.subitDegat(degats);
						System.out.println("Poutch - " + degats + " pv !");
					}else if(perso.getCac().getType().equals("special")){
						degats = perso.infligeDegatCacSpe() - poutch.getDefspe();
						poutch.subitDegat(degats);
						System.out.println("Poutch - " + degats + " pv !");
					}
				}else if(r.equals("2")){
					System.out.println("Sort1 choisi.");

				}else if(r.equals("3")){
					System.out.println("Sort2 choisi.");

				}else if(r.equals("4")){
					System.out.println("SortUlti choisi.");

				}else if(r.equals("5")){
					System.out.println("Objet choisi.");

				}
				else{
					System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
					r="";
				}
			} 
			degats = poutch.infligeDegatCac() - perso.getDef();
			perso.subitDegat(degats);
			System.out.println("Perso - " + degats + " pv !");
			
			}else if (poutch.getVitesse()>perso.getVitesse()){
				// Jeux de l'ia
				Double degats;
				degats = poutch.infligeDegatCac() - perso.getDef();
				perso.subitDegat(degats);
				System.out.println("Perso - " + degats + " pv !");
				
				System.out.println("Vitalité perso:"+perso.getVita()+"pv  |  Poutch:"+poutch.getVita()+"pv");
				System.out.println("Selectionnez votre action:");
				System.out.println("	1. "+perso.getCac().toString2());
				System.out.println("	2. Sort1");
				System.out.println("	3. Sort2");
				System.out.println("	4. Sortulti");
				System.out.println("	5. Objet");
				String r ="";
				while(r.equals("")){
					Scanner sc = new Scanner(System.in);
					r = sc.nextLine();
					if(r.equals("1")){
						System.out.println("CAC choisi.");
						if(perso.getCac().getType().equals("physique")){
							degats = perso.infligeDegatCac() - poutch.getDef();
							poutch.subitDegat(degats);
							System.out.println("Poutch - " + degats + " pv !");
						}else if(perso.getCac().getType().equals("special")){
							degats = perso.infligeDegatCacSpe() - poutch.getDefspe();
							poutch.subitDegat(degats);
							System.out.println("Poutch - " + degats + " pv !");
						}
					}else if(r.equals("2")){
						System.out.println("Sort1 choisi.");

					}else if(r.equals("3")){
						System.out.println("Sort2 choisi.");

					}else if(r.equals("4")){
						System.out.println("SortUlti choisi.");

					}else if(r.equals("5")){
						System.out.println("Objet choisi.");

					}
					else{
						System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
						r="";
					}
				} 
			}
			tour++;
		}
		if(perso.getVita()<=0){
			System.out.println("Vous avez perdu...");
		} else{
			System.out.println("Vous avez vaincu ce Poutch!");
		}
	}
	
	
	
	
	
	
	
	
	
	
	private static void launchMagasin(ArrayList lcac,ArrayList larm, Personnage perso,Personnage monstre) {
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
								launchMagasin(lcac,larm,perso,monstre);
							}else if(q==o){
								launchMagasin(lcac,larm,perso,monstre);
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
								launchMagasin(lcac,larm,perso,monstre);
							}else if(q==o){
								launchMagasin(lcac,larm,perso,monstre);
							}else{
								System.out.println("Choisissez une option disponible.");
								r="";
							}
						}
						r ="";
					}else if(r.equals("3")){
						System.out.println("Consommable pas dispo");
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
		if(debug==0){
			launch1vPoutch(lcac,perso);
		}else{
			
			launch1vIA(lcac,perso,monstre);
		}
	}

}
