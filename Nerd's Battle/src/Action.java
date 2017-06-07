import java.util.ArrayList;
import java.util.Scanner;

public class Action {
	
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
	
	private static void launchMagasin1(ArrayList lcac,ArrayList larm, Personnage perso){
		
		System.out.println("Bienvnue dans l'échoppe !");
		System.out.println("Vous disposer de "+perso.getGold()+" pièces d'or, voulez vous acheter des équipement ?");
		System.out.println("	1. Oui");
		System.out.println("	2. Non");
		boolean test1 = false;
		boolean test2 = false;
		Scanner sc = new Scanner(System.in);
		int str = sc.nextInt();
		
		
			switch(str){
				case 1 :
					System.out.println("Que voulez-vous acheter?");
					System.out.println("	1. Cac");
					System.out.println("	2. Armure");
					System.out.println("	3. Consomable");
					System.out.println("	4. Partir");
					
					Scanner sc2 = new Scanner(System.in);
					int str2 = sc2.nextInt();
					
					switch(str2){
						case 1 :
							System.out.println("Quel cac vous interesse?");
							int o;
							for(o=0;o<lcac.size();o++){
								System.out.println("	"+o+". "+lcac.get(o).toString());
							}
							System.out.println("	"+o+".Rien finalement");
							
							Scanner sc3 = new Scanner(System.in);
							int str3 = sc3.nextInt();
							
							
							if(str3>=0 && str3<lcac.size()){
								perso.setCac((Cac) lcac.get(str3));
								perso.setGold(perso.getGold()-perso.getCac().getPrix());
								System.out.println("Vous avez choisi "+perso.getCac().getNom());
								launchMagasin(lcac,larm,perso);
							}else if(str3==o){
								launchMagasin(lcac,larm,perso);
							}else{
							   	System.out.println("Choisissez une option disponible.");
							}
							break;
						case 2 :
							System.out.println("Quelle armure vous interesse?");
							int i;
							for(i=0;i<larm.size();i++){
								System.out.println("	"+i+". "+larm.get(i).toString());
							}
							System.out.println("	"+i+".Rien finalement");
							
							Scanner sc4 = new Scanner(System.in);
							int str4 = sc4.nextInt();
							
							if(str4>=0 && str4<larm.size()){
								perso.setArmure((Armure)larm.get(str4));
								perso.setGold(perso.getGold()-perso.getArmure().getPrix());
								System.out.println("Vous avez choisi "+perso.getArmure().getNom());
								launchMagasin(lcac,larm,perso);
							}else if(str4==i){
								launchMagasin(lcac,larm,perso);
							}else{
								System.out.println("Choisissez une option disponible.");
							}
							break;
						case 3 : 
							System.out.println("Consommable pas dispo");
							break;
						case 4 :
							System.out.println("Au revoir alors.");
							break;
						default :
							System.out.println("Choisissez une option disponible, 1 ,2 ,3 ou 4.");
							break;
					}
					break;
					
				case 2 :
					System.out.println("Adieu alors !");
					break;
				default : 
					System.out.println("Choisissez une option disponible, 1 ,2 ,3 ou 4.");
					break;
	
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
		
	}
	
	public static void main(String[]args){
		
		ArrayList<Cac> listCAC1 = new ArrayList();
		ArrayList<Armure> listARMURE1 = new ArrayList();
		ArrayList<Cac> listCAC2 = new ArrayList();
		ArrayList<Armure> listARMURE2 = new ArrayList();
		
		launchStuff(listCAC1,listARMURE1);
		launchStuff(listCAC2,listARMURE2);
		
		boolean test1 = false;
		boolean test2 = false;
		boolean test3 = false;
		
		Personnage joueur1 = new Personnage(0, 0, 0, 0, 0, 0, 0);
		Personnage joueur2 = new Personnage(0, 0, 0, 0, 0, 0, 0);
		
		
		while(test2 != true){
					
			System.out.println("Joueur 1 : Choisissez votre classe");
			System.out.println("1 - Archer");
			System.out.println("2 - Guerrier");
			System.out.println("3 - Mage");
			Scanner sc = new Scanner(System.in);
			int str = sc.nextInt();
			
			switch(str){
			case 1 :
				System.out.println("Vous avez choisi l'archer !");
				joueur1 = new Archer();
				test2 = true;
				break;
			case 2 : 
				System.out.println("Vous avez choisi le guerrier !");
				joueur1 = new Guerrier();
				test2 = true;
				break;
			case 3 :
				System.out.println("Vous avez choisi le mage !");
				joueur1 = new Mage();
				test2 = true;
				break;
			default : 
				System.out.println("Mauvaise action, veuillez recommencez\n");
				break;
			}
			
		
		}
		
		launchMagasin1(listCAC1,listARMURE1,joueur1);
		
		while(test3 != true){
			
			System.out.println("Joueur 2 : Choisissez votre classe");
			System.out.println("1 - Archer");
			System.out.println("2 - Guerrier");
			System.out.println("3 - Mage");
			Scanner sc = new Scanner(System.in);
			int str = sc.nextInt();
			
			switch(str){
			case 1 :
				System.out.println("Vous avez choisi l'archer !");
				joueur2 = new Archer();
				test3 = true;
				break;
			case 2 : 
				System.out.println("Vous avez choisi le guerrier !");
				joueur2 = new Guerrier();
				test3 = true;
				break;
			case 3 :
				System.out.println("Vous avez choisi le mage !");
				joueur2 = new Mage();
				test3 = true;
				break;
			default : 
				System.out.println("Mauvaise action, veuillez recommencez\n");
				break;
			}	
			
		}
		
		launchMagasin1(listCAC2,listARMURE2,joueur2);
		

		int manche = 1;
		
		while(!(joueur1.isDead()) && !(joueur2.isDead())){
			
			System.out.println("\nMANCHE "+ manche+" \n");
			manche = manche + 1;
			
			int choix = 0;
			
			if(joueur1.getVitesse()>joueur2.getVitesse()){
				choix = 1;
			}
			else if(joueur2.getVitesse()>joueur1.getVitesse()){
				choix = 2;
			}
			if(joueur1.getVitesse() == joueur2.getVitesse()){
				int rdm = (int) (1 + Math.random() * (2 - 1 + 1));
				if(rdm == 1){
					choix = 1;
				}
				if(rdm == 2){
					choix = 2;
				}
			}
			
			

			
			if(choix == 1){
				
				
				
				if(!(joueur1.isDead()) && !(joueur2.isDead())){
					System.out.println("Tour joueur 1");
					System.out.println("Choisissez une action");
					System.out.println("1 - Attaque corps a corps");
					System.out.println("2 - Sors 1");
					System.out.println("3 - Sors 2");
					System.out.println("4 - Sors Ultime");
					System.out.println("5 - Utiliser un objet");
					
					
					Scanner sc = new Scanner(System.in);
					int str = sc.nextInt();
					
				
					
					switch(str){
						case 1 : 
							joueur2.setVita( (joueur2.getVita()) - (joueur1.getAtk() - joueur2.getDef()));
							System.out.println("Le joueur 1 choisi l'attaque physique et inflige "+ (joueur1.getAtk() - joueur2.getDef())+" dommages au joueur 2");
							System.out.println("Le joueur 2 a "+joueur2.getVita()+" points de vitalité ");
							
							break;
						case 2 :
							// méthode attaque magique
							test1 = true;
							break;
						case 3 :
							// méthode attaque spéciale
							
							break;
						case 4 :
							// méthode utiliser un objet
							
							break;
						default : 
							System.out.println("Mauvaise action, veuillez recommencez\n");
							break;
					}
				}
			
				//
				
				if(!(joueur1.isDead()) && !(joueur2.isDead())){
					System.out.println("Tour joueur 2");
					System.out.println("Choisissez une action");
					System.out.println("1 - Attaque corps a corps");
					System.out.println("2 - Sors 1");
					System.out.println("3 - Sors 2");
					System.out.println("4 - Sors Ultime");
					System.out.println("5 - Utiliser un objet");
					
					
					Scanner sc2 = new Scanner(System.in);
					int str2 = sc2.nextInt();
					
					
					
				
					
					switch(str2){
						case 1 : 
							joueur1.setVita( (joueur1.getVita()) - (joueur2.getAtk() - joueur1.getDef()));
							System.out.println("Le joueur 2 choisi l'attaque physique et inflige "+ (joueur2.getAtk() - joueur1.getDef())+" dommages au joueur 1");
							System.out.println("Le joueur 1 a "+joueur1.getVita()+" points de vitalité ");
							
							break;
						case 2 :
							// méthode attaque magique
							test1 = true;
							break;
						case 3 :
							// méthode attaque spéciale
							
							break;
						case 4 :
							// méthode utiliser un objet
							
							break;
						default : 
							System.out.println("Mauvaise action, veuillez recommencez\n");
							break;
					}
				}
			}
			
			if(choix == 2){
				
				if(!(joueur1.isDead()) && !(joueur2.isDead())){				
					System.out.println("Tour joueur 2");
					System.out.println("Choisissez une action");
					System.out.println("1 - Attaque corps a corps");
					System.out.println("2 - Sors 1");
					System.out.println("3 - Sors 2");
					System.out.println("4 - Sors Ultime");
					System.out.println("5 - Utiliser un objet");
					
					
					Scanner sc = new Scanner(System.in);
					int str = sc.nextInt();
					
				
					
					switch(str){
						case 1 : 
							joueur1.setVita( (joueur1.getVita()) - (joueur2.getAtk() - joueur1.getDef()));
							System.out.println("Le joueur 2 choisi l'attaque physique et inflige "+ (joueur2.getAtk() - joueur1.getDef())+" dommages au joueur 1");
							System.out.println("Le joueur 1 a "+joueur1.getVita()+" points de vitalité ");
							
							break;
						case 2 :
							// méthode attaque magique
							test1 = true;
							break;
						case 3 :
							// méthode attaque spéciale
							
							break;
						case 4 :
							// méthode utiliser un objet
							
							break;
						default : 
							System.out.println("Mauvaise action, veuillez recommencez\n");
							break;
					}
				}
				
			
				//
				if(!(joueur1.isDead()) && !(joueur2.isDead())){
					System.out.println("Tour joueur 1");
					System.out.println("Choisissez une action");
					System.out.println("1 - Attaque corps a corps");
					System.out.println("2 - Sors 1");
					System.out.println("3 - Sors 2");
					System.out.println("4 - Sors Ultime");
					System.out.println("5 - Utiliser un objet");
					
					
					Scanner sc2 = new Scanner(System.in);
					int str2 = sc2.nextInt();
					
					
					
				
					
					switch(str2){
						case 1 : 
							joueur2.setVita( (joueur2.getVita()) - (joueur1.getAtk() - joueur2.getDef()));
							System.out.println("Le joueur 1 choisi l'attaque physique et inflige "+ (joueur1.getAtk() - joueur2.getDef())+" dommages au joueur 2");
							System.out.println("Le joueur 2 a "+joueur2.getVita()+" points de vitalité ");
							
							break;
						case 2 :
							// méthode attaque magique
							test1 = true;
							break;
						case 3 :
							// méthode attaque spéciale
							
							break;
						case 4 :
							// méthode utiliser un objet
							
							break;
						default : 
							System.out.println("Mauvaise action, veuillez recommencez\n");
							break;
					}
				}
			}
			
			
		}
		
		System.out.println("Match terminé ! ");
		
	}

}
