
import java.util.ArrayList;

public class monstre extends Personnage{
	private ArrayList Sort;
	private Cac cac = new Cac("Trempette",0.0,"physique");

	public monstre() {
		super(100, 5, 10, 24, 10, 6, 0);
	}

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