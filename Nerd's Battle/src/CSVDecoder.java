
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

public class CSVDecoder {
	private File file;
	private String file_name;
	int choix;
	ObservableList<String> items = FXCollections.observableArrayList ();
	
	public CSVDecoder(File file){
		this.file = file;
		this.setFile_name(file.getName());
	}
	
	public CSVDecoder() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return une Map associant une valeur a une date. null si le fichier ne peut etre lu.
	 */
	
	
	
	public ArrayList<Cac> decodeCac() throws IOException{
		String elems[];
		String line;
		FileInputStream fis;
		ArrayList<Cac> CSV = new ArrayList<Cac>();
		if(!file.canRead()) return null;
		fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		int cpt=0;
		while((line = br.readLine()) != null){
			elems = line.split(";");
			if(elems.length == 11){
				if (cpt>=1){
					
				
			Cac cac1 = new Cac (elems[0],Double.parseDouble(elems[8]),elems[10], Double.parseDouble(elems[1]),Double.parseDouble(elems[2]), Double.parseDouble(elems[3]),Double.parseDouble(elems[4]),Double.parseDouble(elems[5]),Double.parseDouble(elems[6]),Double.parseDouble(elems[7]), Double.parseDouble(elems[9]));
			CSV.add(cac1);
			}
			cpt++;
			//System.out.println(cac1.toString2());
			}
		}
		br.close();
		return CSV;
	}
	
	public ArrayList<Armure> decodeArm() throws IOException{
		String elems[];
		String line;
		FileInputStream fis;
		
		ArrayList<Armure> CSV = new ArrayList<>();
		if(!file.canRead()) return null;
		fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		int cpt=0;
		while((line = br.readLine()) != null){
			elems = line.split(";");
			if(elems.length == 9){
				if (cpt>=1){
					
				
			Armure arm = new Armure (elems[0],Integer.parseInt(elems[1]),Integer.parseInt(elems[2]),Double.parseDouble(elems[3]),Integer.parseInt(elems[4]),Integer.parseInt(elems[5]),Integer.parseInt(elems[6]),Integer.parseInt(elems[7]),Integer.parseInt(elems[8]));
			CSV.add(arm);	
			//System.out.println(arm.toString());
			}
			cpt++;
			//System.out.println(cac1.toString2());
			}
		}
		br.close();
		return CSV;
	}
	
	public ArrayList<Objet> decodeObj() throws IOException{
		String elems[];
		String line;
		FileInputStream fis;
		ArrayList<Objet> CSV = new ArrayList<>();
		if(!file.canRead()) return null;
		fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		int cpt=0;
		while((line = br.readLine()) != null){
			elems = line.split(";");
			/*for(int i=0;i<elems.length;i++){
				if(i<elems.length){
					System.out.print(elems[i] + " / ");
				}else{
					System.out.println(elems[i]);
				}
			}*/
			if(elems.length == 10){
				if (cpt>=1){
					
				
			Objet obj = new Objet (elems[0],Integer.parseInt(elems[1]),Integer.parseInt(elems[2]),Double.parseDouble(elems[3]),Integer.parseInt(elems[4]),Integer.parseInt(elems[5]),Integer.parseInt(elems[6]),Integer.parseInt(elems[7]),Integer.parseInt(elems[8]),Integer.parseInt(elems[9]));
			CSV.add(obj);	
			//System.out.println(arm.toString());
			}
			cpt++;
			//System.out.println(cac1.toString2());
			}
		}
		br.close();
		return CSV;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	
	
}