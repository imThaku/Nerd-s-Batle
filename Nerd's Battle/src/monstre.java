
import java.util.ArrayList;

public class monstre extends Personnage{
	public monstre(double vita, double vitesse, double esquive, double atk, double atkspe, double def, double defspe) {
		super(vita, vitesse, esquive, atk, atkspe, def, defspe);
		// TODO Auto-generated constructor stub
	}

	private ArrayList Sort;
	private Cac cac = new Cac("Trempette",0.0,"physique");

	

	public ArrayList getSort() {
		return Sort;
	}

	public void setSort(ArrayList sort) {
		Sort = sort;
	}

	public Cac getCac() {
		return cac;
	}

	public void setCac(Cac cac) {
		this.cac = cac;
	}
}