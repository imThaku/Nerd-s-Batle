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
	static int cpt=1;
	static ArrayList<Cac> listCAC = new ArrayList();
	static ArrayList<Armure> listARMURE = new ArrayList();
	static ArrayList<Objet> listObjet = new ArrayList();

	public static void main(String[] args) {
		launchStuff(listCAC, listARMURE, listObjet);
		System.out.println("Bienvenu dans Nerd's Battle!");
		System.out.println("Quel mode voulez lancer ?");
		System.out.println("	1. 1v1 Compétitif");
		System.out.println("	2. 1vIA Campagne");
		System.out.println("	3. 1vPoutch");
		String r = "";
		while (r.equals("")) {
			Scanner sc = new Scanner(System.in);
			r = sc.nextLine();
			if (r.equals("1")) {
				System.out.println("Mod sélectionné: 1v1 Compétitif.");
				System.out.println("-------------------Création du premier personnage-------------------");
				Personnage perso1 = null;
				System.out.println("Quel est ton nom aventurier ?");
				Scanner scNom1 = new Scanner(System.in);
				String nom1 = scNom1.nextLine();
				System.out.println("Bienvenue "+nom1+"!");
				perso1 = launchSelecRet(listCAC, listARMURE, listObjet,1,perso1);
				String r1 = "";
				while (r1.equals("")) {
					System.out.println("Voulez vous aller à l'echoppe ?");
					System.out.println("	1.Oui");
					System.out.println("	2.Non");
					Scanner sc1 = new Scanner(System.in);
					r1 = sc1.nextLine();
					if (r1.equals("1")) {
						perso1 = launchMagasinRet(listCAC, listARMURE, listObjet, perso1);
						r1="";
					}else if(r1.equals("2")){
						System.out.println("Bonne chance alors !");
					}else if(r1.equals("3")){
						r1="";
						System.out.println("Vita    "+perso1.getVita()+" \nVitesse "+perso1.getVitesse()+" \nEsquive "+perso1.getEsquive()+" \nAtk     "+perso1.getAtk()+" \nAtkSpe  "+perso1.getAtkspe()+" \nDef     "+perso1.getDef()+" \nDefSpe  "+perso1.getDefspe());
					}else{
						System.out.println("Donnez une reponse valide, 1 ou 2");
						r1="";
					}
				}
				perso1.setNom(nom1);
				System.out.println("-------------------Création du deuxieme personnage-------------------");
				Personnage perso2 = null;
				System.out.println("Quel est ton nom aventurier ?");
				Scanner scNom2 = new Scanner(System.in);
				String nom2 = scNom2.nextLine();
				System.out.println("Bienvenue "+nom2+"!");
				perso2 = launchSelecRet(listCAC, listARMURE, listObjet,1,perso2);
				String r2 = "";
				while (r2.equals("")) {
					System.out.println("Voulez vous aller à l'echoppe ?");
					System.out.println("	1.Oui");
					System.out.println("	2.Non");
					Scanner sc1 = new Scanner(System.in);
					r2 = sc1.nextLine();
					if (r2.equals("1")) {
						perso2 = launchMagasinRet(listCAC, listARMURE, listObjet, perso2);
						r2="";
					}else if(r2.equals("2")){
						System.out.println("Bonne chance alors !");
					}else if(r2.equals("3")){
						r2="";
						System.out.println("Vita    "+perso2.getVita()+" \nVitesse "+perso2.getVitesse()+" \nEsquive "+perso2.getEsquive()+" \nAtk     "+perso2.getAtk()+" \nAtkSpe  "+perso2.getAtkspe()+" \nDef     "+perso2.getDef()+" \nDefSpe  "+perso2.getDefspe());
					}else{
						System.out.println("Donnez une reponse valide, 1 ou 2");
						r2="";
					}
				}
				perso2.setNom(nom2);
				launch1v1(perso1,perso2);
			} else if (r.equals("2")) {
				Personnage perso = null;
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
				launchSelec(listCAC, listARMURE, listObjet,2,perso);
			} else if (r.equals("3")) {
				System.out.println("Mod sélectionné: 1vPoutch.");
				Personnage perso = null;
				launchSelec(listCAC, listARMURE, listObjet,3,perso);
			} else {
				System.out.println("Choisissez un mode valide, 1 ,2 ou 3.");
				r = "";
			}
		}
	}

	public static void launchStuff(ArrayList<Cac> lc, ArrayList<Armure> la, ArrayList<Objet> lo) {
		File test = new File("");
		String t = test.getPath();
		cac = new File(test.getAbsolutePath() + "//rsc//Arme-Feuille1.csv");
		arm = new File(test.getAbsolutePath() + "//rsc//Equipement-Feuille1.csv");
		obj = new File(test.getAbsolutePath() + "//rsc//Consommable-Feuille1.csv");
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
		return;
	}

	public static void launchSelec(ArrayList lcac, ArrayList larm, ArrayList lobj,int choix,Personnage perso) {
		System.out.println("Quelle classe voulez-vous jouer ?");
		System.out.println("	1. Guerrier");
		System.out.println("	2. Mage");
		System.out.println("	3. Archer");
		String r = "";
		while (r.equals("")) {
			Scanner sc = new Scanner(System.in);
			r = sc.nextLine();
			if (r.equals("1")) {
				perso = new Guerrier();
				Sort g1 = new Vampiro();
				Sort g2 = new DernierCoup();
				Sort g3 = new Parade();
				perso.addSort(g1);
				perso.addSort(g2);
				perso.addSort(g3);
				perso.setNom("Aventurier");
				System.out.println("Guerrier choisi.");
			} else if (r.equals("2")) {
				System.out.println("Mage choisi.");
				perso = new Mage();
				perso.setNom("Aventurier");
			} else if (r.equals("3")) {
				System.out.println("Archer choisi.");
				perso = new Archer();
				perso.setNom("Aventurier");
			} else {
				System.out.println("Choisissez une classe disponible, 1 ,2 ou 3.");
				r = "";
			}
		}
		if(choix==3){
			launchMagasin(lcac, larm, lobj, perso,choix,-1);
		}else if(choix==2){
			perso.setGold(500);
			launch1vIApart1(perso,1);
		}
		return;
	}
	
	public static Personnage launchSelecRet(ArrayList lcac, ArrayList larm, ArrayList lobj,int choix,Personnage perso) {
		System.out.println("Quelle classe voulez-vous jouer ?");
		System.out.println("	1. Guerrier");
		System.out.println("	2. Mage");
		System.out.println("	3. Archer");
		String r = "";
		while (r.equals("")) {
			Scanner sc = new Scanner(System.in);
			r = sc.nextLine();
			if (r.equals("1")) {
				perso = new Guerrier();
				Sort g1 = new Vampiro();
				Sort g2 = new DernierCoup();
				Sort g3 = new Parade();
				perso.addSort(g1);
				perso.addSort(g2);
				perso.addSort(g3);
				perso.setNom("Aventurier");
				System.out.println("Guerrier choisi.");
			} else if (r.equals("2")) {
				System.out.println("Mage choisi.");
				perso = new Mage();
				perso.setNom("Aventurier");
			} else if (r.equals("3")) {
				System.out.println("Archer choisi.");
				perso = new Archer();
				perso.setNom("Aventurier");
			} else {
				System.out.println("Choisissez une classe disponible, 1 ,2 ou 3.");
				r = "";
			}
		}
		if(choix==3){
			launchMagasin(lcac, larm, lobj, perso,choix,-1);
		}
		return perso;
	}

	public static void launch1vPoutch(ArrayList lcac, Personnage perso) {
		Poutch poutch = new Poutch();
		Dot dot = new Dot(perso, poutch);
		int tour = 1;
		while (!perso.isDead() && !poutch.isDead()) {
			perso.appliqueEffetPositif();
			perso.appliqueEffetNegatif();
			poutch.appliqueEffetPositif();
			poutch.appliqueEffetNegatif();
			if (perso.isDead()) {
				System.out.println("Vous etes mort !(malus)");
				break;
			}
			System.out.println("Heros POS: " + perso.getListEffectPositif());
			System.out.println("Heros NEG: " + perso.getListEffectNegatif());
			System.out.println("Poutch POS: " + poutch.getListEffectPositif());
			System.out.println("Poutch NEG: " + poutch.getListEffectNegatif());
			if (!perso.isStun()) {
				if (tour == 1) {
					System.out.println("-------------Le combat commence ! Tour 1-------------");
				} else {
					System.out.println("-------------Le combat continu, tour " + tour + "!-------------");
				}
				System.out.println("Vitalité perso:" + perso.getVita() + "pv  |  Poutch:" + poutch.getVita() + "pv");
				System.out.println("Selectionnez votre action:");
				System.out.println("	1. " + perso.getCac().toString2());
				System.out.println("	2. " + perso.getListSorts().get(0).getNom() + ": "
						+ perso.getListSorts().get(0).getDescription());
				System.out.println("	3. " + perso.getListSorts().get(1).getNom() + ": "
						+ perso.getListSorts().get(1).getDescription());
				System.out.println("	4. " + perso.getListSorts().get(2).getNom() + ": "
						+ perso.getListSorts().get(2).getDescription());
				System.out.println("	5. " + perso.getObjet().getNom());
				String r = "";
				double degats;
				while (r.equals("")) {
					Scanner sc = new Scanner(System.in);
					r = sc.nextLine();
					if (r.equals("1")) {
						System.out.println("CAC choisi.");
						if (perso.getCac().getType().equals("physique")) {
							degats = perso.infligeDegatCac() - poutch.getDef();
							if (degats > 0) {
								poutch.subitDegat(degats);
								System.out.println("Poutch -" + degats + " pv !");
							} else {
								System.out.println("Poutch  ne subit aucun degats");
							}
						} else if (perso.getCac().getType().equals("special")) {
							degats = perso.infligeDegatCacSpe() - poutch.getDefspe();
							if (degats > 0) {
								poutch.subitDegat(degats);
								System.out.println("Poutch -" + degats + " pv !");
							} else {
								System.out.println("Poutch  ne subit aucun degats");
							}
						}
					} else if (r.equals("2")) {
						perso.getListSorts().get(0).getEffect(perso, poutch, dot);

					} else if (r.equals("3")) {
						perso.getListSorts().get(1).getEffect(perso, poutch, dot);

					} else if (r.equals("4")) {
						perso.getListSorts().get(2).getEffect(perso, poutch, dot);

					} else if (r.equals("5")) {
						perso.useObjet();
						Objet objet = new Objet("Vent", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0);
						perso.setObjet(objet);
						
					} else if (r.equals("6")) {
						System.out.println(" "+perso.getVita()+" \n "+perso.getVitesse()+" \n "+perso.getEsquive()+" \n "+perso.getAtk()+" \n "+perso.getAtkspe()+" \n "+perso.getDef()+" \n "+perso.getDefspe());
					} else {
						System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
						r = "";
					}
				}
			}
			tour++;
			dot.endRound();
		}
		if (perso.getVita() <= 0) {
			System.out.println("Vous avez perdu...");
		} else {
			System.out.println("Vous avez vaincu ce Poutch!");
		}
		return;
	}

	private static void launchMagasin(ArrayList lcac, ArrayList larm, ArrayList lobj, Personnage perso,int choix,int part) {
		System.out.println("Bienvnue dans l'échoppe !");
		System.out
				.println("Vous disposer de " + perso.getGold() + " pièces d'or, voulez vous acheter des équipement ?");
		System.out.println("	1. Oui");
		System.out.println("	2. Non");
		String r = "";
		while (r.equals("")) {
			Scanner sc = new Scanner(System.in);
			r = sc.nextLine();
			if (r.equals("1")) {
				System.out.println("Que voulez-vous acheter?");
				System.out.println("	1. Cac");
				System.out.println("	2. Armure");
				System.out.println("	3. Consomable");
				System.out.println("	4. Partir");
				r = "";
				while (r.equals("")) {
					Scanner sc1 = new Scanner(System.in);
					r = sc1.nextLine();
					if (r.equals("1")) {
						System.out.println("Quel cac vous interesse?");
						int o;
						for (o = 0; o < lcac.size(); o++) {
							System.out.println("	" + o + ". " + lcac.get(o).toString());
						}
						System.out.println("	" + o + ".Rien finalement");
						r = "";
						while (r.equals("")) {
							Scanner sc2 = new Scanner(System.in);
							r = sc2.nextLine();
							int q = Integer.parseInt(r);
							if (q >= 0 && q < lcac.size()) {
								perso.setCac((Cac) lcac.get(q));
								perso.setGold(perso.getGold() - perso.getCac().getPrix());
								System.out.println("Vous avez choisi " + perso.getCac().getNom());
								launchMagasin(lcac, larm, lobj, perso,choix,-1);
							} else if (q == o) {
								launchMagasin(lcac, larm, lobj, perso,choix,-1);
							} else {
								System.out.println("Choisissez une option disponible.");
								r = "";
							}
						}
						r = "";
					} else if (r.equals("2")) {
						System.out.println("Quelle armure vous interesse?");
						int o;
						for (o = 0; o < larm.size(); o++) {
							System.out.println("	" + o + ". " + larm.get(o).toString());
						}
						System.out.println("	" + o + ".Rien finalement");
						r = "";
						while (r.equals("")) {
							Scanner sc2 = new Scanner(System.in);
							r = sc2.nextLine();
							int q = Integer.parseInt(r);
							if (q >= 0 && q < larm.size()) {
								perso.setArmure((Armure) larm.get(q));
								perso.setGold(perso.getGold() - perso.getArmure().getPrix());
								System.out.println("Vous avez choisi " + perso.getArmure().getNom());
								launchMagasin(lcac, larm, lobj, perso,choix,-1);
							} else if (q == o) {
								launchMagasin(lcac, larm, lobj, perso,choix,-1);
							} else {
								System.out.println("Choisissez une option disponible.");
								r = "";
							}
						}
						r = "";
					} else if (r.equals("3")) {
						System.out.println("Quel consommable vous interesse?");
						int o;
						for (o = 0; o < lobj.size(); o++) {
							System.out.println("	" + o + ". " + lobj.get(o).toString());
						}
						System.out.println("	" + o + ".Rien finalement");
						r = "";
						while (r.equals("")) {
							Scanner sc2 = new Scanner(System.in);
							r = sc2.nextLine();
							int q = Integer.parseInt(r);
							if (q >= 0 && q < lobj.size()) {
								perso.setObjet((Objet) lobj.get(q));
								perso.setGold(perso.getGold() - perso.getObjet().getPrix());
								System.out.println("Vous avez choisi " + perso.getObjet().getNom());
								launchMagasin(lcac, larm, lobj, perso,choix,-1);
							} else if (q == o) {
								launchMagasin(lcac, larm, lobj, perso,choix,-1);
							} else {
								System.out.println("Choisissez une option disponible.");
								r = "";
							}
						}
						r = "";
					} else if (r.equals("4")) {
						System.out.println("Au revoir alors.");
					} else {
						System.out.println("Choisissez une option disponible, 1 ,2 ,3 ou 4.");
						r = "";
					}
				}
			} else if (r.equals("2")) {
				System.out.println("Adieu alors !");
			} else {
				System.out.println("Choisissez une option disponible, 1 ou 2.");
				r = "";
			}
		}
		System.out.println("Vous sortez de l'échoppe.");
		if(choix==3){
			launch1vPoutch(lcac, perso);
		}else if(choix==2){
			launch1vIApart1(perso,part);
		}
		return;
	}

	private static Personnage launchMagasinRet(ArrayList lcac, ArrayList larm, ArrayList lobj, Personnage perso) {
		System.out.println("Bienvnue dans l'échoppe !");
		System.out.println("Vous disposer de " + perso.getGold() + " pièces d'or, voulez vous acheter des équipement ?");
		System.out.println("	1. Oui");
		System.out.println("	2. Non");
		String r = "";
		while (r.equals("")) {
			Scanner sc = new Scanner(System.in);
			r = sc.nextLine();
			if (r.equals("1")) {
				System.out.println("Que voulez-vous acheter?");
				System.out.println("	1. Cac");
				System.out.println("	2. Armure");
				System.out.println("	3. Consomable");
				System.out.println("	4. Partir");
				r = "";
				while (r.equals("")) {
					Scanner sc1 = new Scanner(System.in);
					r = sc1.nextLine();
					if (r.equals("1")) {
						System.out.println("Quel cac vous interesse?");
						int o;
						for (o = 0; o < lcac.size(); o++) {
							System.out.println("	" + o + ". " + lcac.get(o).toString());
						}
						System.out.println("	" + o + ".Rien finalement");
						r = "";
						while (r.equals("")) {
							Scanner sc2 = new Scanner(System.in);
							r = sc2.nextLine();
							int q = Integer.parseInt(r);
							if (q >= 0 && q < lcac.size()) {
								if(perso.getGold()>=((Cac) lcac.get(q)).getPrix()){
									perso.setCac((Cac) lcac.get(q));
									perso.setGold(perso.getGold() - perso.getCac().getPrix());
									System.out.println("Vous avez choisi " + perso.getCac().getNom());
								}else{
									System.out.println("Vous n'avez plus assez d'argent.");
								}
								return perso;
							
							} else if (q == o) {
								return perso;
							
							} else {
								System.out.println("Choisissez une option disponible.");
								r = "";
							}
						}
						r = "";
					} else if (r.equals("2")) {
						System.out.println("Quelle armure vous interesse?");
						int o;
						for (o = 0; o < larm.size(); o++) {
							System.out.println("	" + o + ". " + larm.get(o).toString());
						}
						System.out.println("	" + o + ".Rien finalement");
						r = "";
						while (r.equals("")) {
							Scanner sc2 = new Scanner(System.in);
							r = sc2.nextLine();
							int q = Integer.parseInt(r);
							if (q >= 0 && q < larm.size()) {
								if(perso.getGold()>=((Armure) larm.get(q)).getPrix()){
									perso.setArmure((Armure) larm.get(q));
									perso.setGold(perso.getGold() - perso.getArmure().getPrix());
									System.out.println("Vous avez choisi " + perso.getArmure().getNom());
								}else{
									System.out.println("Vous n'avez plus assez d'argent.");
								}
								return perso;
								
							} else if (q == o) {
								return perso;
							
							} else {
								System.out.println("Choisissez une option disponible.");
								r = "";
							}
						}
						r = "";
					} else if (r.equals("3")) {
						System.out.println("Quel consommable vous interesse?");
						int o;
						for (o = 0; o < lobj.size(); o++) {
							System.out.println("	" + o + ". " + lobj.get(o).toString());
						}
						System.out.println("	" + o + ".Rien finalement");
						r = "";
						while (r.equals("")) {
							Scanner sc2 = new Scanner(System.in);
							r = sc2.nextLine();
							int q = Integer.parseInt(r);
							if (q >= 0 && q < lobj.size()) {
								if(perso.getGold()>=((Objet) lobj.get(q)).getPrix()){
									perso.setObjet((Objet) lobj.get(q));
									perso.setGold(perso.getGold() - perso.getObjet().getPrix());
									System.out.println("Vous avez choisi " + perso.getObjet().getNom());
								}else{
									System.out.println("Vous n'avez plus assez d'argent.");
								}
								return perso;

							} else if (q == o) {
								return perso;

							} else {
								System.out.println("Choisissez une option disponible.");
								r = "";
							}
						}
						r = "";
					} else if (r.equals("4")) {
						System.out.println("Au revoir alors.");
					} else {
						System.out.println("Choisissez une option disponible, 1 ,2 ,3 ou 4.");
						r = "";
					}
				}
			} else if (r.equals("2")) {
				System.out.println("Adieu alors !");
				break;
			} else {
				System.out.println("Choisissez une option disponible, 1 ou 2.");
				r = "";
			}
		}
		return perso;
	}
	

	
	public static void launch1v1(Personnage perso1, Personnage perso2){
		Dot dot = new Dot(perso1, perso2);
		int tour = 1;
		while (!perso1.isDead() && !perso2.isDead()) {
			perso1.getListSorts().get(2).downCD();
			perso2.getListSorts().get(2).downCD();
			if(perso1.getVitesse()>perso2.getVitesse()){
				System.out.println("");
				System.out.println("");
				System.out.println("");
				perso1.appliqueEffetPositif();
				perso1.appliqueEffetNegatif();
				System.out.println("");
				perso2.appliqueEffetPositif();
				perso2.appliqueEffetNegatif();
				System.out.println("");
				if (tour == 1) {
					System.out.println("-------------Le combat commence ! Tour 1-------------");
				} else {
					System.out.println("-------------Le combat continu, tour " + tour + "!-------------");
				}
				if (!perso1.isStun()&&!perso1.isDead()) {
					System.out.println(perso1.getNom()+":" + perso1.getVita() + "pv  | "+perso2.getNom()+ ":" + perso2.getVita() + "pv");
					System.out.println(perso1.getNom()+" à toi de jouer !");
					System.out.println("Selectionnez votre action:");
					System.out.println("	1. " + perso1.getCac().toString2());
					System.out.println("	2. " + perso1.getListSorts().get(0).getNom() + ": "
							+ perso1.getListSorts().get(0).getDescription());
					System.out.println("	3. " + perso1.getListSorts().get(1).getNom() + ": "
							+ perso1.getListSorts().get(1).getDescription());
					System.out.println("	4. " + perso1.getListSorts().get(2).getNom() + ": "
							+ perso1.getListSorts().get(2).getDescription());
					System.out.println("	5. " + perso1.getObjet().getNom());
					String r = "";
					double degats;
					double rdm = Math.random();
					while (r.equals("")) {
						Scanner sc = new Scanner(System.in);
						r = sc.nextLine();
						if (r.equals("1")) {
							System.out.println("CAC choisi.");
							if(rdm>perso2.getEsquive()){
								if (perso1.getCac().getType().equals("physique")) {
									degats = perso1.infligeDegatCac() - perso2.getDef();
									if (degats > 0) {
										perso2.subitDegat(degats);
										System.out.println(perso2.getNom()+"  -" + degats + " pv !");
									} else {
										System.out.println(perso2.getNom()+"   ne subit aucun degats");
									}
								} else if (perso1.getCac().getType().equals("special")) {
									degats = perso1.infligeDegatCacSpe() - perso2.getDefspe();
									if (degats > 0) {
										perso2.subitDegat(degats);
										System.out.println(perso2.getNom()+"  -" + degats + " pv !");
									} else {
										System.out.println(perso2.getNom()+"  ne subit aucun degats");
									}
								}
							}else{
								System.out.println(perso2.getNom()+" a esquivé.");
							}
						} else if (r.equals("2")) {
							perso1.getListSorts().get(0).getEffect(perso1, perso2, dot);

						} else if (r.equals("3")) {
							perso1.getListSorts().get(1).getEffect(perso1, perso2, dot);

						} else if (r.equals("4")) {
							perso1.getListSorts().get(2).getEffect(perso1, perso2, dot);

						} else if (r.equals("5")) {
							perso1.useObjet();
							Objet objet = new Objet("Vent", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0);
							perso1.setObjet(objet);
							
						} else {
							System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
							r = "";
						}
					}
				}else if(perso1.isStun()){
					System.out.println(perso1.getNom()+" est stun! Il ne peut pas jouer.");
				}else if(perso1.isDead()){
					System.out.println(perso1.getNom()+" est mort!");
				}
				if (!perso2.isStun()&&!perso2.isDead()) {
					System.out.println(perso1.getNom()+":" + perso1.getVita() + "pv  | "+perso2.getNom()+ ":" + perso2.getVita() + "pv");
					System.out.println(perso2.getNom()+" à toi de jouer !");
					System.out.println("Selectionnez votre action:");
					System.out.println("	1. " + perso2.getCac().toString2());
					System.out.println("	2. " + perso2.getListSorts().get(0).getNom() + ": "
							+ perso2.getListSorts().get(0).getDescription());
					System.out.println("	3. " + perso2.getListSorts().get(1).getNom() + ": "
							+ perso2.getListSorts().get(1).getDescription());
					System.out.println("	4. " + perso2.getListSorts().get(2).getNom() + ": "
							+ perso2.getListSorts().get(2).getDescription());
					System.out.println("	5. " + perso2.getObjet().getNom());
					String r = "";
					double degats;
					double rdm = Math.random();
					while (r.equals("")) {
						Scanner sc = new Scanner(System.in);
						r = sc.nextLine();
						if (r.equals("1")) {
							System.out.println("CAC choisi.");
							if(rdm>perso1.getEsquive()){
								if (perso2.getCac().getType().equals("physique")) {
									degats = perso2.infligeDegatCac() - perso1.getDef();
									if (degats > 0) {
										perso1.subitDegat(degats);
										System.out.println(perso1.getNom()+"  -" + degats + " pv !");
									} else {
										System.out.println(perso1.getNom()+"   ne subit aucun degats");
									}
								} else if (perso2.getCac().getType().equals("special")) {
									degats = perso2.infligeDegatCacSpe() - perso1.getDefspe();
									if (degats > 0) {
										perso1.subitDegat(degats);
										System.out.println(perso1.getNom()+"  -" + degats + " pv !");
									} else {
										System.out.println(perso1.getNom()+"  ne subit aucun degats");
									}
								}
							}else{
								System.out.println(perso1.getNom()+" a esquivé.");
							}
						} else if (r.equals("2")) {
							perso2.getListSorts().get(0).getEffect(perso2, perso1, dot);

						} else if (r.equals("3")) {
							perso2.getListSorts().get(1).getEffect(perso2, perso1, dot);

						} else if (r.equals("4")) {
							perso2.getListSorts().get(2).getEffect(perso2, perso1, dot);

						} else if (r.equals("5")) {
							perso2.useObjet();
							Objet objet = new Objet("Vent", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0);
							perso2.setObjet(objet);
							
						} else {
							System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
							r = "";
						}
					}
				}else if(perso2.isStun()){
					System.out.println(perso2.getNom()+" est stun! Il ne peut pas jouer.");
				}else if(perso2.isDead()){
					System.out.println(perso2.getNom()+" est mort!");
				}
				tour++;
				dot.endRound();
			}else{
				System.out.println("");
				System.out.println("");
				System.out.println("");
				perso1.appliqueEffetPositif();
				perso1.appliqueEffetNegatif();
				System.out.println("");
				perso2.appliqueEffetPositif();
				perso2.appliqueEffetNegatif();
				System.out.println("");
				if (tour == 1) {
					System.out.println("-------------Le combat commence ! Tour 1-------------");
				} else {
					System.out.println("-------------Le combat continu, tour " + tour + "!-------------");
				}
				if (!perso2.isStun()&&!perso2.isDead()) {
					System.out.println(perso1.getNom()+":" + perso1.getVita() + "pv  | "+perso2.getNom()+ ":" + perso2.getVita() + "pv");
					System.out.println(perso2.getNom()+" à toi de jouer !");
					System.out.println("Selectionnez votre action:");
					System.out.println("	1. " + perso2.getCac().toString2());
					System.out.println("	2. " + perso2.getListSorts().get(0).getNom() + ": "
							+ perso2.getListSorts().get(0).getDescription());
					System.out.println("	3. " + perso2.getListSorts().get(1).getNom() + ": "
							+ perso2.getListSorts().get(1).getDescription());
					System.out.println("	4. " + perso2.getListSorts().get(2).getNom() + ": "
							+ perso2.getListSorts().get(2).getDescription());
					System.out.println("	5. " + perso2.getObjet().getNom());
					String r = "";
					double degats;
					double rdm = Math.random();
					while (r.equals("")) {
						Scanner sc = new Scanner(System.in);
						r = sc.nextLine();
						if (r.equals("1")) {
							System.out.println("CAC choisi.");
							if(rdm>perso1.getEsquive()){
								if (perso2.getCac().getType().equals("physique")) {
									degats = perso2.infligeDegatCac() - perso1.getDef();
									if (degats > 0) {
										perso1.subitDegat(degats);
										System.out.println(perso1.getNom()+"  -" + degats + " pv !");
									} else {
										System.out.println(perso1.getNom()+"   ne subit aucun degats");
									}
								} else if (perso2.getCac().getType().equals("special")) {
									degats = perso2.infligeDegatCacSpe() - perso1.getDefspe();
									if (degats > 0) {
										perso1.subitDegat(degats);
										System.out.println(perso1.getNom()+"  -" + degats + " pv !");
									} else {
										System.out.println(perso1.getNom()+"  ne subit aucun degats");
									}
								}
							}else{
								System.out.println(perso1.getNom()+" a esquivé.");
							}
						} else if (r.equals("2")) {
							perso2.getListSorts().get(0).getEffect(perso2, perso1, dot);

						} else if (r.equals("3")) {
							perso2.getListSorts().get(1).getEffect(perso2, perso1, dot);

						} else if (r.equals("4")) {
							perso2.getListSorts().get(2).getEffect(perso2, perso1, dot);

						} else if (r.equals("5")) {
							perso2.useObjet();
							Objet objet = new Objet("Vent", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0);
							perso2.setObjet(objet);
							
						} else {
							System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
							r = "";
						}
					}
				}else if(perso2.isStun()){
					System.out.println(perso2.getNom()+" est stun! Il ne peut pas jouer.");
				}else if(perso2.isDead()){
					System.out.println(perso2.getNom()+" est mort!");
				}
				if (!perso1.isStun()&&!perso1.isDead()) {
					System.out.println(perso1.getNom()+":" + perso1.getVita() + "pv  | "+perso2.getNom()+ ":" + perso2.getVita() + "pv");
					System.out.println(perso1.getNom()+" à toi de jouer !");
					System.out.println("Selectionnez votre action:");
					System.out.println("	1. " + perso1.getCac().toString2());
					System.out.println("	2. " + perso1.getListSorts().get(0).getNom() + ": "
							+ perso1.getListSorts().get(0).getDescription());
					System.out.println("	3. " + perso1.getListSorts().get(1).getNom() + ": "
							+ perso1.getListSorts().get(1).getDescription());
					System.out.println("	4. " + perso1.getListSorts().get(2).getNom() + ": "
							+ perso1.getListSorts().get(2).getDescription());
					System.out.println("	5. " + perso1.getObjet().getNom());
					String r = "";
					double degats;
					double rdm = Math.random();
					while (r.equals("")) {
						Scanner sc = new Scanner(System.in);
						r = sc.nextLine();
						if (r.equals("1")) {
							if(rdm>perso2.getEsquive()){
								System.out.println("CAC choisi.");
								if (perso1.getCac().getType().equals("physique")) {
									degats = perso1.infligeDegatCac() - perso2.getDef();
									if (degats > 0) {
										perso2.subitDegat(degats);
										System.out.println(perso2.getNom()+"  -" + degats + " pv !");
									} else {
										System.out.println(perso2.getNom()+"   ne subit aucun degats");
									}
								} else if (perso1.getCac().getType().equals("special")) {
									degats = perso1.infligeDegatCacSpe() - perso2.getDefspe();
									if (degats > 0) {
										perso2.subitDegat(degats);
										System.out.println(perso2.getNom()+"  -" + degats + " pv !");
									} else {
										System.out.println(perso2.getNom()+"  ne subit aucun degats");
									}
								}
							}else{
								System.out.println(perso2.getNom()+" a esquivé.");
							}
						} else if (r.equals("2")) {
							perso1.getListSorts().get(0).getEffect(perso1, perso2, dot);

						} else if (r.equals("3")) {
							perso1.getListSorts().get(1).getEffect(perso1, perso2, dot);

						} else if (r.equals("4")) {
							perso1.getListSorts().get(2).getEffect(perso1, perso2, dot);

						} else if (r.equals("5")) {
							perso1.useObjet();
							Objet objet = new Objet("Vent", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0);
							perso1.setObjet(objet);
							
						} else {
							System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
							r = "";
						}
					}
				}else if(perso1.isStun()){
					System.out.println(perso1.getNom()+" est stun! Il ne peut pas jouer.");
				}else if(perso1.isDead()){
					System.out.println(perso1.getNom()+" est mort!");
				}
				tour++;
				dot.endRound();
			}
			
			
		}
		if(perso1.getVita()>perso2.getVita()){
			System.out.println(perso1.getNom()+" a gagné!");
		}else{
			System.out.println(perso2.getNom()+" a gagné!");
		}
	}
	
	public static void launch1vIA(Personnage perso1, Personnage perso2,int part){
		Dot dot = new Dot(perso1, perso2);
		int tour = 1;
		while (!perso1.isDead() && !perso2.isDead()) {
			if(perso1.getVitesse()>perso2.getVitesse()){
				System.out.println("");
				System.out.println("");
				System.out.println("");
				perso1.appliqueEffetPositif();
				perso1.appliqueEffetNegatif();
				System.out.println("");
				perso2.appliqueEffetPositif();
				perso2.appliqueEffetNegatif();
				System.out.println("");
				if (tour == 1) {
					System.out.println("-------------Le combat commence ! Tour 1-------------");
				} else {
					System.out.println("-------------Le combat continu, tour " + tour + "!-------------");
				}
				if (!perso1.isStun()&&!perso1.isDead()) {
					System.out.println(perso1.getNom()+":" + perso1.getVita() + "pv  | "+perso2.getNom()+ ":" + perso2.getVita() + "pv");
					System.out.println(perso1.getNom()+" à toi de jouer !");
					System.out.println("Selectionnez votre action:");
					System.out.println("	1. " + perso1.getCac().toString2());
					System.out.println("	2. " + perso1.getListSorts().get(0).getNom() + ": "
							+ perso1.getListSorts().get(0).getDescription());
					System.out.println("	3. " + perso1.getListSorts().get(1).getNom() + ": "
							+ perso1.getListSorts().get(1).getDescription());
					System.out.println("	4. " + perso1.getListSorts().get(2).getNom() + ": "
							+ perso1.getListSorts().get(2).getDescription());
					System.out.println("	5. " + perso1.getObjet().getNom());
					String r = "";
					double degats;
					double rdm = Math.random();
					while (r.equals("")) {
						Scanner sc = new Scanner(System.in);
						r = sc.nextLine();
						if (r.equals("1")) {
							System.out.println("CAC choisi.");
							if(rdm>perso2.getEsquive()){
								if (perso1.getCac().getType().equals("physique")) {
									degats = perso1.infligeDegatCac() - perso2.getDef();
									if (degats > 0) {
										perso2.subitDegat(degats);
										System.out.println(perso2.getNom()+"  -" + degats + " pv !");
									} else {
										System.out.println(perso2.getNom()+"   ne subit aucun degats");
									}
								} else if (perso1.getCac().getType().equals("special")) {
									degats = perso1.infligeDegatCacSpe() - perso2.getDefspe();
									if (degats > 0) {
										perso2.subitDegat(degats);
										System.out.println(perso2.getNom()+"  -" + degats + " pv !");
									} else {
										System.out.println(perso2.getNom()+"  ne subit aucun degats");
									}
								}
							}else{
								System.out.println(perso2.getNom()+" a esquivé.");
							}
						} else if (r.equals("2")) {
							perso1.getListSorts().get(0).getEffect(perso1, perso2, dot);

						} else if (r.equals("3")) {
							perso1.getListSorts().get(1).getEffect(perso1, perso2, dot);

						} else if (r.equals("4")) {
							perso1.getListSorts().get(2).getEffect(perso1, perso2, dot);

						} else if (r.equals("5")) {
							perso1.useObjet();
							Objet objet = new Objet("Vent", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0);
							perso1.setObjet(objet);
							
						} else {
							System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
							r = "";
						}
					}
				}else if(perso1.isStun()){
					System.out.println(perso1.getNom()+" est stun! Il ne peut pas jouer.");
				}else if(perso1.isDead()){
					System.out.println(perso1.getNom()+" est mort!");
				}
				if (!perso2.isStun()&&!perso2.isDead()) {
					double degats;
					double rdm = Math.random();
					int r = (int)(Math.random() *10);
						if (r>5) {
							if(rdm>perso1.getEsquive()){
								perso1.subitDegat((perso2.getAtk()*perso2.getListSorts().get(0).getValeurSort())-perso1.getDef());
								System.out.println(perso2.getNom()+" utilise le sort "+perso2.getListSorts().get(0).getNom());
								System.out.println(perso2.getListSorts().get(0).getDescription());
								System.out.println(perso2.getNom()+" inflige "+((perso2.getAtk()*perso2.getListSorts().get(0).getValeurSort())-perso1.getDef())+" dégats.");
							}else{
								System.out.println(perso1.getNom()+" a esquivé.");
							}
						} else{
							perso1.subitDegat((perso2.getAtk()*perso2.getListSorts().get(0).getValeurSort())-perso1.getDef());
							System.out.println(perso2.getNom()+" utilise le sort "+perso2.getListSorts().get(1).getNom());
							System.out.println(perso2.getListSorts().get(1).getDescription());
							System.out.println(perso2.getNom()+" inflige "+((perso2.getAtk()*perso2.getListSorts().get(1).getValeurSort())-perso1.getDef())+" dégats.");
						}
				}else if(perso2.isStun()){
					System.out.println(perso2.getNom()+" est stun! Il ne peut pas jouer.");
				}else if(perso2.isDead()){
					System.out.println(perso2.getNom()+" est mort!");
				}
				tour++;
				dot.endRound();
			}else{
				System.out.println("");
				System.out.println("");
				System.out.println("");
				perso1.appliqueEffetPositif();
				perso1.appliqueEffetNegatif();
				System.out.println("");
				perso2.appliqueEffetPositif();
				perso2.appliqueEffetNegatif();
				System.out.println("");
				if (tour == 1) {
					System.out.println("-------------Le combat commence ! Tour 1-------------");
				} else {
					System.out.println("-------------Le combat continu, tour " + tour + "!-------------");
				}
				if (!perso2.isStun()&&!perso2.isDead()) {
					double degats;
					double rdm = Math.random();
					int r = (int)(Math.random() * (2-0)) + 0;
							if (r==1) {
								if(rdm>perso1.getEsquive()){
									perso1.subitDegat((perso2.getAtk()*perso2.getListSorts().get(0).getValeurSort())-perso1.getDef());
									System.out.println(perso2.getNom()+" utilise le sort "+perso2.getListSorts().get(0).getNom());
									System.out.println(perso2.getListSorts().get(0).getDescription());
									System.out.println(perso2.getNom()+" inflige "+((perso2.getAtk()*perso2.getListSorts().get(0).getValeurSort())-perso1.getDef())+" dégats.");
								}else{
									System.out.println(perso1.getNom()+" a esquivé.");
								}
							} else {
								perso1.subitDegat((perso2.getAtk()*perso2.getListSorts().get(0).getValeurSort())-perso1.getDef());
								System.out.println(perso2.getNom()+" utilise le sort "+perso2.getListSorts().get(1).getNom());
								System.out.println(perso2.getListSorts().get(1).getDescription());
								System.out.println(perso2.getNom()+" inflige "+((perso2.getAtk()*perso2.getListSorts().get(1).getValeurSort())-perso1.getDef())+" dégats.");
							}
				}else if(perso2.isStun()){
					System.out.println(perso2.getNom()+" est stun! Il ne peut pas jouer.");
				}else if(perso2.isDead()){
					System.out.println(perso2.getNom()+" est mort!");
				}
				if (!perso1.isStun()&&!perso1.isDead()) {
					System.out.println(perso1.getNom()+":" + perso1.getVita() + "pv  | "+perso2.getNom()+ ":" + perso2.getVita() + "pv");
					System.out.println(perso1.getNom()+" à toi de jouer !");
					System.out.println("Selectionnez votre action:");
					System.out.println("	1. " + perso1.getCac().toString2());
					System.out.println("	2. " + perso1.getListSorts().get(0).getNom() + ": "
							+ perso1.getListSorts().get(0).getDescription());
					System.out.println("	3. " + perso1.getListSorts().get(1).getNom() + ": "
							+ perso1.getListSorts().get(1).getDescription());
					System.out.println("	4. " + perso1.getListSorts().get(2).getNom() + ": "
							+ perso1.getListSorts().get(2).getDescription());
					System.out.println("	5. " + perso1.getObjet().getNom());
					String r = "";
					double degats;
					double rdm = Math.random();
					while (r.equals("")) {
						Scanner sc = new Scanner(System.in);
						r = sc.nextLine();
						if (r.equals("1")) {
							if(rdm>perso2.getEsquive()){
								System.out.println("CAC choisi.");
								if (perso1.getCac().getType().equals("physique")) {
									degats = perso1.infligeDegatCac() - perso2.getDef();
									if (degats > 0) {
										perso2.subitDegat(degats);
										System.out.println(perso2.getNom()+"  -" + degats + " pv !");
									} else {
										System.out.println(perso2.getNom()+"   ne subit aucun degats");
									}
								} else if (perso1.getCac().getType().equals("special")) {
									degats = perso1.infligeDegatCacSpe() - perso2.getDefspe();
									if (degats > 0) {
										perso2.subitDegat(degats);
										System.out.println(perso2.getNom()+"  -" + degats + " pv !");
									} else {
										System.out.println(perso2.getNom()+"  ne subit aucun degats");
									}
								}
							}else{
								System.out.println(perso2.getNom()+" a esquivé.");
							}
						} else if (r.equals("2")) {
							perso1.getListSorts().get(0).getEffect(perso1, perso2, dot);

						} else if (r.equals("3")) {
							perso1.getListSorts().get(1).getEffect(perso1, perso2, dot);

						} else if (r.equals("4")) {
							perso1.getListSorts().get(2).getEffect(perso1, perso2, dot);

						} else if (r.equals("5")) {
							perso1.useObjet();
							Objet objet = new Objet("Vent", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0);
							perso1.setObjet(objet);
							
						} else {
							System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
							r = "";
						}
					}
				}else if(perso1.isStun()){
					System.out.println(perso1.getNom()+" est stun! Il ne peut pas jouer.");
				}else if(perso1.isDead()){
					System.out.println(perso1.getNom()+" est mort!");
				}
				tour++;
				dot.endRound();
			}
			
			
		}
		if(perso1.getVita()>perso2.getVita()){
			System.out.println(perso1.getNom()+" a gagné!");
			perso1.setGold(perso2.getGold()+perso1.getGold());
			System.out.println(perso1.getNom()+" a gagné "+perso2.getGold()+" pièces d'or.");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			if(part==1){
				launch1vIApart1(perso1,part);
			}
			if(part==2){
				launch1vIApart3(perso1,3);
			}
			if(part==4){
				launch1vIApart4(perso1,4);
			}
			if(part==5){
				System.out.println("Murator et ses amis ont réussi à vaincre leur ennemis.\n"
						+ "Murator alla chercher Rouxi dans sa chambre mais en arrivant c’était trop tard…\n"
						+ "Elle était au lit avec le gobelin maçon Caralho !");
			}
		}else{
			System.out.println(perso2.getNom()+" a gagné!");
			
			if(part==5){
				System.out.println("Fombassiette 123 ne lâcha rien et tua les 3 zéros…. \n"
						+ "Murator en train d’agoniser lâcha dans un dernier soupir : Hé merde je resterai puceau….");
			}else{
				System.out.println("Vous etes mort...");
			}
		}
		
	}



	private static void launch1vIApart1(Personnage perso,int part) {
		Personnage monstre1 = null;
		int rdm = (int) (1 + Math.random() * (2));
		UsineMonstre u = new UsineMonstre();
		
		String r1 = "";
		while (r1.equals("")) {
			System.out.println("Voulez vous aller à l'echoppe ?");
			System.out.println("	1.Oui");
			System.out.println("	2.Non");
			Scanner sc1 = new Scanner(System.in);
			r1 = sc1.nextLine();
			if (r1.equals("1")) {
				perso = launchMagasinRet(listCAC, listARMURE, listObjet, perso);
				r1="";
			}else if(r1.equals("2")){
				System.out.println("Bonne chance alors !");
			}else if(r1.equals("3")){
				r1="";
				System.out.println("Vita    "+perso.getVita()+" \nVitesse "+perso.getVitesse()+" \nEsquive "+perso.getEsquive()+" \nAtk     "+perso.getAtk()+" \nAtkSpe  "+perso.getAtkspe()+" \nDef     "+perso.getDef()+" \nDefSpe  "+perso.getDefspe());
			}else{
				System.out.println("Donnez une reponse valide, 1 ou 2");
				r1="";
			}
		}
		
		if(cpt<3){
			System.out.println("\n COMBAT "+cpt);
			switch(rdm){
				case 1 :
					monstre1 = u.createBlop();
					System.out.println("\n Attention un BlobGob apparaît !!");
					
					break;
				case 2 : 
					monstre1 = u.creatGobalElite();
					System.out.println("\n Attention un Gobal Elite apparaît !!");
					break;
				case 3 : 
					monstre1 = u.createGobelinDisquetteur();
					System.out.println("\n Attention un Gobelin Disquetteur apparaît !!");
					break;
				case 4 : 
					monstre1 = u.createGobTout();
					System.out.println("\n Attention un Gob'Tout apparaît !!");
					break;
			}
			cpt++;
			
			launch1vIA(perso,monstre1,part);
		}else{
			System.out.println("Malgré leurs efforts les 3 compères furent capturés et jetés dans les geôles de Fombassiette 123\n"
					+"Bien décidé à ne pas laisser l’amour de sa vie lui échapper, Murator implora ses amis de l’aider à sortir de cette cage\n"
					+ " et de s’attaquer au chef des gobelins en personne afin de récupérer sa dulcinée.\n"
					+ "Les 3 zéros appelèrent le gardien afin de simuler une envie d’aller aux toilettes pour l'assommer et récupérer ses clés pour s’échapper.");
			System.out.println("");
			launch1vIApart2(perso,2);
		}
		
	}
	
	private static void launch1vIApart2(Personnage perso,int part) {
		Personnage monstre1 = null;
		int rdm = (int) (1 + Math.random() * (2));
		UsineMonstre u = new UsineMonstre();
		String r1 = "";
		while (r1.equals("")) {
			System.out.println("Voulez vous aller à l'echoppe ?");
			System.out.println("	1.Oui");
			System.out.println("	2.Non");
			Scanner sc1 = new Scanner(System.in);
			r1 = sc1.nextLine();
			if (r1.equals("1")) {
				perso = launchMagasinRet(listCAC, listARMURE, listObjet, perso);
				r1="";
			}else if(r1.equals("2")){
				System.out.println("Bonne chance alors !");
			}else if(r1.equals("3")){
				r1="";
				System.out.println("Vita    "+perso.getVita()+" \nVitesse "+perso.getVitesse()+" \nEsquive "+perso.getEsquive()+" \nAtk     "+perso.getAtk()+" \nAtkSpe  "+perso.getAtkspe()+" \nDef     "+perso.getDef()+" \nDefSpe  "+perso.getDefspe());
			}else{
				System.out.println("Donnez une reponse valide, 1 ou 2");
				r1="";
			}
		}
		System.out.println("\n COMBAT "+cpt);
		switch(rdm){
		case 1 :
			monstre1 = u.createBlop();
			System.out.println("\n Attention un BlobGob apparaît !!");
			
			break;
		case 2 : 
			monstre1 = u.creatGobalElite();
			System.out.println("\n Attention un Gobal Elite apparaît !!");
			break;
		case 3 : 
			monstre1 = u.createGobelinDisquetteur();
			System.out.println("\n Attention un Gobelin Disquetteur apparaît !!");
			break;
		case 4 : 
			monstre1 = u.createGobTout();
			System.out.println("\n Attention un Gob'Tout apparaît !!");
			break;
		}
		cpt++;
		
		launch1vIA(perso,monstre1,2);
		
	}
	
	private static void launch1vIApart3(Personnage perso,int part) {
		if(cpt==4){
			String r1 = "";
			System.out.println("");
			System.out.println("Ils arrivèrent dans un couloir et une armée de Gobelin se trouvait face à eux.");
		}
		Personnage monstre1 = null;
		int rdm = (int) (1 + Math.random() * (2));
		UsineMonstre u = new UsineMonstre();
		String r1 = "";
		while (r1.equals("")) {
			System.out.println("Voulez vous aller à l'echoppe ?");
			System.out.println("	1.Oui");
			System.out.println("	2.Non");
			Scanner sc1 = new Scanner(System.in);
			r1 = sc1.nextLine();
			if (r1.equals("1")) {
				perso = launchMagasinRet(listCAC, listARMURE, listObjet, perso);
				r1="";
			}else if(r1.equals("2")){
				System.out.println("Bonne chance alors !");
			}else if(r1.equals("3")){
				r1="";
				System.out.println("Vita    "+perso.getVita()+" \nVitesse "+perso.getVitesse()+" \nEsquive "+perso.getEsquive()+" \nAtk     "+perso.getAtk()+" \nAtkSpe  "+perso.getAtkspe()+" \nDef     "+perso.getDef()+" \nDefSpe  "+perso.getDefspe());
			}else{
				System.out.println("Donnez une reponse valide, 1 ou 2");
				r1="";
			}
		}
		
		
		if(cpt<8){
			System.out.println("\n COMBAT "+cpt);
			switch(rdm){
				case 1 :
					monstre1 = u.createBlop();
					System.out.println("\n Attention un BlobGob apparaît !!");
					
					break;
				case 2 : 
					monstre1 = u.creatGobalElite();
					System.out.println("\n Attention un Gobal Elite apparaît !!");
					break;
				case 3 : 
					monstre1 = u.createGobelinDisquetteur();
					System.out.println("\n Attention un Gobelin Disquetteur apparaît !!");
					break;
				case 4 : 
					monstre1 = u.createGobTout();
					System.out.println("\n Attention un Gob'Tout apparaît !!");
					break;
			}
			cpt++;
			
		
			launch1vIA(perso,monstre1,2);
		}else{
			launch1vIApart4(perso,5);
		}
		
	}
	
	private static void launch1vIApart4(Personnage perso, int part) {
		String r1 = "";
		while (r1.equals("")) {
			System.out.println("Voulez vous aller à l'echoppe ?");
			System.out.println("	1.Oui");
			System.out.println("	2.Non");
			Scanner sc1 = new Scanner(System.in);
			r1 = sc1.nextLine();
			if (r1.equals("1")) {
				perso = launchMagasinRet(listCAC, listARMURE, listObjet, perso);
				r1="";
			}else if(r1.equals("2")){
				System.out.println("Bonne chance alors !");
			}else if(r1.equals("3")){
				r1="";
				System.out.println("Vita    "+perso.getVita()+" \nVitesse "+perso.getVitesse()+" \nEsquive "+perso.getEsquive()+" \nAtk     "+perso.getAtk()+" \nAtkSpe  "+perso.getAtkspe()+" \nDef     "+perso.getDef()+" \nDefSpe  "+perso.getDefspe());
			}else{
				System.out.println("Donnez une reponse valide, 1 ou 2");
				r1="";
			}
		}
		System.out.println("\n Attention Fombassiette vous attaque");
		UsineMonstre u = new UsineMonstre();
		Personnage monstre1 = u.createFombassiette();
		System.out.println("\n----------------------------COMBAT FINAL----------------------------");
		launch1vIA(perso,monstre1,5);
	}

}
