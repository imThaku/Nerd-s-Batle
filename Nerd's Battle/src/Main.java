import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException {
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
			}
			else{
				System.out.println("Choisissez un mode valide, 1 ou 2.");
				r="";
			}
		}
	}

}
