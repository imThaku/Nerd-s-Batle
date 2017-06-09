import java.util.ArrayList;

public class GobelinDisquetteur extends Personnage{
	private ArrayList Sort;
	private Cac cac = new Cac("SuperDisquette",30.0,"physique");

	public GobelinDisquetteur() {
		super(100, 80, 0.1, 20, 30, 15, 15,"GobelinDisquetteur");
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
