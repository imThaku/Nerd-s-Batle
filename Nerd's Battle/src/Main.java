
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {


	public static void main(String[] args) throws IOException {
		ArrayList<Cac> listCAC = new ArrayList();

		System.out.println("Bienvenu dans Nerd's Battle!");
		System.out.println("Quel mode voulez lancer ?");
		System.out.println("	1. 1v1 compétitif");
		System.out.println("	2. 1vIA Campagne");
		System.out.println("	3. 1vPoutch");
		String r ="";
		ArrayList<Cac> CSV = new ArrayList<Cac>();
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

				File file = Explorer.getFile();
				CSVDecoder csv = new CSVDecoder(file);
				CSV=csv.decodeCac();
				for(int i=0;i<CSV.size();i++){
					System.out.println(CSV.get(i).toString());
				}

				launchStuff(listCAC);
				launch1vPoutch(listCAC);

			}
			else{
				System.out.println("Choisissez un mode valide, 1 ,2 ou 3.");
				r="";
			}
		}
	}
	
	public static void launchStuff(ArrayList lc){
		Cac a = new Cac("Epée du noob",1.1,"physique");
		Cac b = new Cac("Arcflingué",0.9,"physique");
		lc.add(a);
		lc.add(b);
	}
	
	public static void test(){
		
		
		
	}
	
	public static void launch1vPoutch(ArrayList lcac){
		for(int i=0;i<lcac.size();i++){
			System.out.println(lcac.get(i).toString());
		}
		Personnage perso = null;
		Poutch poutch = new Poutch();
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
		int tour=1;
		while(!perso.isDead() && !poutch.isDead()){
			if(tour==1){
				System.out.println("Le combat commence ! Tour 1");
			}else{
				System.out.println("Le combat continu, tour "+tour);
			}
			System.out.println("Vitalité perso:"+perso.getVita()+"pv  |  Poutch:"+poutch.getVita()+"pv");
			System.out.println("Selectionnez votre action:");
			System.out.println("	1. "+perso.getCac().toString());
			System.out.println("	2. Sort1");
			System.out.println("	3. Sort2");
			System.out.println("	4. Sortulti");
			System.out.println("	5. Objet");
			r ="";
			while(r.equals("")){
				Scanner sc = new Scanner(System.in);
				r = sc.nextLine();
				if(r.equals("1")){
					System.out.println("CAC choisi.");
					if(perso.getCac().getType().equals("physique")){
						poutch.setVita(poutch.getVita()-(perso.getAtk()*perso.getCac().getValeur()-poutch.getDef()));
						System.out.println("Poutch subit "+(perso.getAtk()*perso.getCac().getValeur()-poutch.getDef())+" dégats !");
					}else if(perso.getCac().getType().equals("special")){
						poutch.setVita(poutch.getVita()-(perso.getAtkspe()*perso.getCac().getValeur()-poutch.getDefspe()));
						System.out.println("Poutch subit "+(perso.getAtkspe()*perso.getCac().getValeur()-poutch.getDefspe())+" dégats !");
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

}
