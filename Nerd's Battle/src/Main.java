import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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
			}else if(r.equals("3")){
				System.out.println("Mod sélectionné: 1vPoutch.");
				launchStuff(listCAC,listARMURE);
				launchSelec(listCAC,listARMURE);
			}
			else{
				System.out.println("Choisissez un mode valide, 1 ,2 ou 3.");
				r="";
			}
		}
	}
	
	public static void launchStuff(ArrayList lc,ArrayList la){
		Cac a = new Cac("Hacharnée",2.0,"physique",0,6,0,8,0,0,0,2000);
		lc.add(a);
		Cac b = new Cac("Kal'Hache",1.2,"physique",0,10,0,8,0,0,0,1700);
		lc.add(b);
		Cac c = new Cac("Epée Nice",1.5,"physique",0,5,2,6,0,0,0,1800);
		lc.add(c);
		Cac d = new Cac("Fist",1.1,"physique",0,2,0,1,0,0,0,1250);
		lc.add(d);
		
		Armure a1 = new Armure("Cap'illaire",2,-9,-1,6,-7,8,-6, 1000);
		Armure a2 = new Armure("CouafWaf",-6,1,-9,-9,-2,10,2 ,1000);
		Armure a3 = new Armure("Sombre Héros",10,10,-6,-6,5,-3,0,1000);
		Armure a4 = new Armure("Bott'ade",-5,-10,0,-5,7,1,4,1000);
		Armure a5 = new Armure("Sandalousie",9,-9,0,8,1,-7,5,1000);
		Armure a6 = new Armure("Centdalmatien",-1,-3,-2,-9,1,-5,9,1000);
		la.add(a1);
		la.add(a2);
		la.add(a3);
		la.add(a4);
		la.add(a5);
		la.add(a6);
	}
	
	public static void launchSelec(ArrayList lcac,ArrayList larm){
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
		launchMagasin(lcac,larm,perso);
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

	private static void launchMagasin(ArrayList lcac,ArrayList larm, Personnage perso) {
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
								launchMagasin(lcac,larm,perso);
							}else if(q==o){
								launchMagasin(lcac,larm,perso);
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
								launchMagasin(lcac,larm,perso);
							}else if(q==o){
								launchMagasin(lcac,larm,perso);
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
		launch1vPoutch(lcac,perso);
	}

}
