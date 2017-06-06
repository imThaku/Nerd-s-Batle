

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
	
	public File getFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Selection fichier");
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files", "*.csv");
		fileChooser.getExtensionFilters().add(extFilter);
		file = fileChooser.showOpenDialog(null);
		return file;
	}
	
	
	public ArrayList<Cac> decodeCac() throws IOException{
		String elems[];
		String line;
		FileInputStream fis;
		
		ArrayList<Cac> CSV = new ArrayList<Cac>();
		if(!file.canRead()) return null;
		fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		while((line = br.readLine()) != null){
			int cpt=0;
			elems = line.split(",");
			if(elems.length == 9){
			Cac cac1 = new Cac (elems[0],Integer.parseInt(elems[5]),"Mele");
			CSV.add(cpt, cac1);
			cpt++;
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
