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
	static int debug=0;
	static Personnage Perso = new Personnage();
	static int persoS=0;
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
				debug=2;
				// monstre a creer
				
				System.out.println("Bienvenue dans le mode campagne");
				System.out.println("Le GitTeub était une contrée paisible depuis des millénaires.Romain \n"
						+ "des doigts le chasseur équipé de son arc était parti chasser de la femelle avec\n"
						+ " ses amis Murator le guerrier armé de sa grosse épée et de Harry Pot-de-Fleur le\n"
						+ " magicien.Une fois arrivé dans la taverne Murator se lâcha sur la piste de danse \n"
						+ "et impressionna les demoiselles. Rouxi, une magnifique gobelin vînt à lui et ils\n"
						+ " partagèrent un verre ensemble.Soudainement, des gobelins du village débarquèrent\n"
						+ " à la recherche de la bande des 3. Ils leurs reprochaient d’avoir séduit Rouxi la\n"
						+ " fille de leur chef Fombassiette 123 qui était promise au prince du royaume du\n"
						+ " Mortdort.Les gobelins se mirent à saccager la taverne et se ruèrent sur Murator et ses amis…");
				System.out.println("");
				int cpt=1;
				while(cpt!=2){
				Personnage monstre1=new Personnage();
				int rdm = (int) (1 + Math.random() * (4 - 1 + 1));
				
				System.out.println("\n COMBAT "+cpt);
				
				switch(rdm){
					case 1 :
						monstre1 = new GobelinDisquetteur();
						System.out.println("\n Attention un Gobelin Disquetteur apparaît !!");
						
						break;
					case 2 : 
						monstre1 = new GobTout();
						System.out.println("\n Attention un Gob'Tout apparaît !!");
						break;
					case 3 : 
						monstre1 = new GobalElite();
						System.out.println("\n Attention un Gobal Elite apparaît !!");
						break;
					case 4 : 
						monstre1 = new PunchlinoGob();
						System.out.println("\n Attention un Punchlino Gob apparaît !!");
						break;
				}
				cpt++;
				launchStuff(listCAC,listARMURE, listObjet);
				launchSelec(listCAC,listARMURE,listObjet,monstre1);
				}
				System.out.println("Malgré leurs efforts les 3 compères furent capturés et jetés dans les geôles de Fombassiette 123\n"
									+"Bien décidé à ne pas laisser l’amour de sa vie lui échapper, Murator implora ses amis de l’aider à sortir de cette cage\n"
									+ " et de s’attaquer au chef des gobelins en personne afin de récupérer sa dulcinée.\n"
									+ "Les 3 zéros appelèrent le gardien afin de simuler une envie d’aller aux toilettes pour l'assommer et récupérer ses clés pour s’échapper.");
				System.out.println("");
				int rdm = (int) (1 + Math.random() * (4 - 1 + 1));
				Personnage monstre1=new Personnage();
				switch(rdm){
				case 1 :
					monstre1 = new GobelinDisquetteur();
					System.out.println("\n Attention un Gobelin Disquetteur apparaît !!");
					
					break;
				case 2 : 
					monstre1 = new GobTout();
					System.out.println("\n Attention un Gob'Tout apparaît !!");
					break;
				case 3 : 
					monstre1 = new GobalElite();
					System.out.println("\n Attention un Gobal Elite apparaît !!");
					break;
				case 4 : 
					monstre1 = new PunchlinoGob();
					System.out.println("\n Attention un Punchlino Gob apparaît !!");
					break;
				}
				launchStuff(listCAC,listARMURE, listObjet);
				launchSelec(listCAC,listARMURE,listObjet,monstre1);
				System.out.println("");
				System.out.println("Ils arrivèrent dans un couloir et une armée de Gobelin se trouvait face à eux.");
				int cpt1=1;
				while(cpt1!=3){
				int rdm1 = (int) (1 + Math.random() * (4 - 1 + 1));
				
				System.out.println("\n COMBAT "+cpt1);
				
				switch(rdm1){
					case 1 :
						monstre1 = new GobelinDisquetteur();
						System.out.println("\n Attention un Gobelin Disquetteur apparaît !!");
						
						break;
					case 2 : 
						monstre1 = new GobTout();
						System.out.println("\n Attention un Gob'Tout apparaît !!");
						break;
					case 3 : 
						monstre1 = new GobalElite();
						System.out.println("\n Attention un Gobal Elite apparaît !!");
						break;
					case 4 : 
						monstre1 = new PunchlinoGob();
						System.out.println("\n Attention un Punchlino Gob apparaît !!");
						break;
				}
				cpt1++;
				launchStuff(listCAC,listARMURE, listObjet);
				launchSelec(listCAC,listARMURE,listObjet,monstre1);
				}
				Personnage Boss=new Fombassiette();
				System.out.println("\n Attention Fombassiette vous attaque");
				launchStuff(listCAC,listARMURE, listObjet);
				launchSelec(listCAC,listARMURE,listObjet,Boss);
				if(Perso.getVita()>0){
					System.out.println("Murator et ses amis ont réussi à vaincre leur ennemis.\n"
							+ "Murator alla chercher Rouxi dans sa chambre mais en arrivant c’était trop tard…\n"
							+ "Elle était au lit avec le gobelin maçon Caralho !");
				}else{
					System.out.println("Fombassiette 123 ne lâcha rien et tua les 3 zéros…. \n"
							+ "Murator en train d’agoniser lâcha dans un dernier soupir : Hé merde je resterai puceau….");
				}
				
				
			}else if(r.equals("3")){
				Personnage monstre1=new Personnage();
				System.out.println("Mod sélectionné: 1vPoutch.");
				launchStuff(listCAC,listARMURE,listObjet);
				launchSelec(listCAC,listARMURE,listObjet,monstre1);
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
	
	public static void launchSelec(ArrayList lcac,ArrayList larm,ArrayList<Objet> listObjet, Personnage monstre1){
		
		if (persoS==0){
		System.out.println("Quelle classe voulez-vous jouer ?");
		System.out.println("	1. Guerrier");
		System.out.println("	2. Mage");
		System.out.println("	3. Archer");
		String r ="";
		while(r.equals("")){
			Scanner sc = new Scanner(System.in);
			r = sc.nextLine();
			if(r.equals("1")){
				Perso = new Guerrier();
				Sort g1 = new Vampiro();
				Sort g2 = new DernierCoup();
				Sort g3 = new Parade();
				Perso.addSort(g1);
				Perso.addSort(g2);
				Perso.addSort(g3);
				Perso.setNom("Aventurier");
				System.out.println("Guerrier choisi.");
			}else if(r.equals("2")){
				System.out.println("Mage choisi.");
				Perso = new Mage();
				Perso.setNom("Aventurier");
			}else if(r.equals("3")){
				System.out.println("Archer choisi.");
				Perso = new Archer();
				Perso.setNom("Aventurier");
			}
			else{
				System.out.println("Choisissez une classe disponible, 1 ,2 ou 3.");
				r="";
			}
		}
		persoS=1;
		launchMagasin(lcac,larm,listObjet,Perso,monstre1);
		}else{
			launchMagasin(lcac,larm,listObjet,Perso,monstre1);
		}
		
	}
	
	public static void launch1vPoutch(ArrayList lcac,Personnage perso){
		Poutch poutch = new Poutch();
		Dot dot= new Dot(Perso,poutch);
		int tour=1;
		while(!Perso.isDead() && !poutch.isDead()){
			Perso.appliqueEffetPositif();
			Perso.appliqueEffetNegatif();
			poutch.appliqueEffetPositif();
			poutch.appliqueEffetNegatif();
			if(Perso.isDead()){
				System.out.println("Vous etes mort !(malus)");
				break;
			}
			if(tour==1){
				System.out.println("Le combat commence ! Tour 1");
			}else{
				System.out.println("Le combat continu, tour "+tour);
			}
			System.out.println("Vitalité Perso:"+Perso.getVita()+"pv  |  Poutch:"+poutch.getVita()+"pv");
			System.out.println("Selectionnez votre action:");
			System.out.println("	1. "+Perso.getCac().toString2());
			System.out.println("	2. "+Perso.getListSorts().get(0).getNom()+": "+Perso.getListSorts().get(0).getDescription());
			System.out.println("	3. "+Perso.getListSorts().get(1).getNom()+": "+Perso.getListSorts().get(1).getDescription());
			System.out.println("	4. "+Perso.getListSorts().get(2).getNom()+": "+Perso.getListSorts().get(2).getDescription());
			System.out.println("	5. "+Perso.getObjet().getNom());
			String r ="";
			double degats;
			while(r.equals("")){
				Scanner sc = new Scanner(System.in);
				r = sc.nextLine();
				if(r.equals("1")){
					System.out.println("CAC choisi.");
					if(Perso.getCac().getType().equals("physique")){
						degats = Perso.infligeDegatCac() - poutch.getDef();
						if(degats>0){
							poutch.subitDegat(degats);
							System.out.println("Poutch -" + degats + " pv !");
						}else{
							System.out.println("Poutch  ne subit aucun degats");
						}
					}else if(Perso.getCac().getType().equals("special")){
						degats = Perso.infligeDegatCacSpe() - poutch.getDefspe();
						if(degats>0){
							poutch.subitDegat(degats);
							System.out.println("Poutch -" + degats + " pv !");
						}else{
							System.out.println("Poutch  ne subit aucun degats");
						}
					}
				}else if(r.equals("2")){
					Perso.getListSorts().get(0).getEffect(Perso, poutch, dot);
					
				}else if(r.equals("3")){
					Perso.getListSorts().get(1).getEffect(Perso, poutch, dot);

				}else if(r.equals("4")){
					Perso.getListSorts().get(2).getEffect(Perso, poutch, dot);

				}else if(r.equals("5")){
						Perso.useObjet();
						Objet objet = new Objet("Vent",0.0,0.0,0.0,0.0,0.0,0.0,0.0, 0);
						Perso.setObjet(objet);
				}
				else{
					System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
					r="";
				}
			}
			tour++;
			dot.endRound();
		}
		if(Perso.getVita()<=0){
			System.out.println("Vous avez perdu...");
		} else{
			System.out.println("Vous avez vaincu ce Poutch!");
		}
	}
	
	
public static void launch1vIA(ArrayList lcac, Personnage perso,Personnage poutch){
		
		int tour=1;
		Dot dot= new Dot(Perso,poutch);
		while(!Perso.isDead() && !poutch.isDead()){
			if(tour==1){
				System.out.println("Le combat commence ! Tour 1");
			}else{
				System.out.println("Le combat continu, tour "+tour);
			}
			if(Perso.getVitesse()>poutch.getVitesse()){
			System.out.println("Vitalité Perso:"+Perso.getVita()+"pv  |  Poutch:"+poutch.getVita()+"pv");
			System.out.println("Selectionnez votre action:");
			System.out.println("	1. "+Perso.getCac().toString2());
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
					if(Perso.getCac().getType().equals("physique")){
						degats = Perso.infligeDegatCac() - poutch.getDef();
						if(degats>0){
							poutch.subitDegat(degats);
							System.out.println("Poutch -" + degats + " pv !");
						}else{
							System.out.println("Poutch  ne subit aucun degats");
						}
					}else if(Perso.getCac().getType().equals("special")){
						degats = Perso.infligeDegatCacSpe() - poutch.getDefspe();
						if(degats>0){
							poutch.subitDegat(degats);
							System.out.println("Poutch -" + degats + " pv !");
						}else{
							System.out.println("Poutch  ne subit aucun degats");
						}
					}
				}else if(r.equals("2")){
					Perso.getListSorts().get(0).getEffect(Perso, poutch, dot);
					
				}else if(r.equals("3")){
					Perso.getListSorts().get(1).getEffect(Perso, poutch, dot);

				}else if(r.equals("4")){
					Perso.getListSorts().get(2).getEffect(Perso, poutch, dot);

				}else if(r.equals("5")){
						Perso.useObjet();
						Objet objet = new Objet("Vent",0.0,0.0,0.0,0.0,0.0,0.0,0.0, 0);
						Perso.setObjet(objet);
				}
				else{
					System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
					r="";
				}
			} 
			if(poutch.getCac().getType().equals("physique")){
				degats = poutch.infligeDegatCac() - Perso.getDef();
				if(degats>0){
					Perso.subitDegat(degats);
					System.out.println("Perso -" + degats + " pv !");
				}else{
					System.out.println("Perso  ne subit aucun degats");
				}
			}else if(poutch.getCac().getType().equals("special")){
				degats = poutch.infligeDegatCacSpe() - Perso.getDefspe();
				if(degats>0){
					Perso.subitDegat(degats);
					System.out.println("Perso -" + degats + " pv !");
				}else{
					System.out.println("Perso  ne subit aucun degats");
				}
			}
			
			}else if (poutch.getVitesse()>Perso.getVitesse()){
				// Jeux de l'ia
				Double degats;
				if(poutch.getCac().getType().equals("physique")){
					degats = poutch.infligeDegatCac() - Perso.getDef();
					if(degats>0){
						Perso.subitDegat(degats);
						System.out.println("Perso -" + degats + " pv !");
					}else{
						System.out.println("Perso  ne subit aucun degats");
					}
				}else if(poutch.getCac().getType().equals("special")){
					degats = poutch.infligeDegatCacSpe() - Perso.getDefspe();
					if(degats>0){
						Perso.subitDegat(degats);
						System.out.println("Perso -" + degats + " pv !");
					}else{
						System.out.println("Perso  ne subit aucun degats");
					}
				}
				
				System.out.println("Vitalité Perso:"+Perso.getVita()+"pv  |  Poutch:"+poutch.getVita()+"pv");
				System.out.println("Selectionnez votre action:");
				System.out.println("	1. "+Perso.getCac().toString2());
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
						if(Perso.getCac().getType().equals("physique")){
							degats = Perso.infligeDegatCac() - poutch.getDef();
							if(degats>0){
								poutch.subitDegat(degats);
								System.out.println("Poutch -" + degats + " pv !");
							}else{
								System.out.println("Poutch  ne subit aucun degats");
							}
						}else if(Perso.getCac().getType().equals("special")){
							degats = Perso.infligeDegatCacSpe() - poutch.getDefspe();
							if(degats>0){
								poutch.subitDegat(degats);
								System.out.println("Poutch -" + degats + " pv !");
							}else{
								System.out.println("Poutch  ne subit aucun degats");
							}
						}
					}else if(r.equals("2")){
						Perso.getListSorts().get(0).getEffect(Perso, poutch, dot);
						
					}else if(r.equals("3")){
						Perso.getListSorts().get(1).getEffect(Perso, poutch, dot);

					}else if(r.equals("4")){
						Perso.getListSorts().get(2).getEffect(Perso, poutch, dot);

					}else if(r.equals("5")){
							Perso.useObjet();
							Objet objet = new Objet("Vent",0.0,0.0,0.0,0.0,0.0,0.0,0.0, 0);
							Perso.setObjet(objet);
					}
					else{
						System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
						r="";
					}
				} 
			}
			tour++;
		}
		if(Perso.getVita()<=0){
			System.out.println("Vous avez perdu...");
		} else{
			System.out.println("Vous avez vaincu ce Poutch!");
		}
	}
	
	
	
	
	
	

	private static void launchMagasin(ArrayList lcac,ArrayList larm,ArrayList<Objet> listObjet ,Personnage perso,Personnage monstre) {
		System.out.println("Bienvnue dans l'échoppe !");
		System.out.println("Vous disposer de "+Perso.getGold()+" pièces d'or, voulez vous acheter des équipement ?");
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
								Perso.setCac((Cac) lcac.get(q));
								Perso.setGold(Perso.getGold()-Perso.getCac().getPrix());
								System.out.println("Vous avez choisi "+Perso.getCac().getNom());
								launchMagasin(lcac,larm,listObjet,Perso,monstre);
							}else if(q==o){
								launchMagasin(lcac,larm,listObjet,Perso,monstre);
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
								Perso.setArmure((Armure)larm.get(q));
								Perso.setGold(Perso.getGold()-Perso.getArmure().getPrix());
								System.out.println("Vous avez choisi "+Perso.getArmure().getNom());
								launchMagasin(lcac,larm,listObjet,Perso,monstre);
							}else if(q==o){
								launchMagasin(lcac,larm,listObjet,Perso,monstre);
							}else{
								System.out.println("Choisissez une option disponible.");
								r="";
							}
						}
						r ="";
					}else if(r.equals("3")){
						System.out.println("Quel consommable vous interesse?");
						int o;
						for(o=0;o<listObjet.size();o++){
							System.out.println("	"+o+". "+listObjet.get(o).toString());
						}
						System.out.println("	"+o+".Rien finalement");
						r ="";
						while(r.equals("")){
							Scanner sc2 = new Scanner(System.in);
							r = sc2.nextLine();
							int q = Integer.parseInt(r);
							if(q>=0 && q<listObjet.size()){
								Perso.setObjet((Objet) listObjet.get(q));
								Perso.setGold(Perso.getGold()-Perso.getObjet().getPrix());
								System.out.println("Vous avez choisi "+Perso.getObjet().getNom());
								launchMagasin(lcac,larm,listObjet,Perso,monstre);
							}else if(q==o){
								launchMagasin(lcac,larm,listObjet,Perso,monstre);
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
		if(debug==0){
			launch1vPoutch(lcac,Perso);
		}else{
			
			launch1vIA(lcac,Perso,monstre);
		}
	}

}
