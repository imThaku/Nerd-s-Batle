import java.util.Scanner;

public class Action {
	
	public static void main(String[]args){
		
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
		

		
		
		while(!(joueur1.isDead()) && !(joueur2.isDead())){
			
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
				
			
				//
				
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
			
			if(choix == 2){
				
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
				
			
				//
				
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
		
		System.out.println("Match terminé ! ");
		
	}

}
