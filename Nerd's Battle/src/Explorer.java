import java.io.File;
import javafx.stage.FileChooser;

public class Explorer {

	/**
	 * Permet a l'utilisateur de selectionner un fichier
	 * @return Le fichier selectionne par l'utilisateur
	 */
	public static File getFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Selection fichier");
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files", "*.csv");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(null);
		return file;
	}
}