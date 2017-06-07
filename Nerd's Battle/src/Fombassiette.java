import java.util.ArrayList;

public class Fombassiette extends Personnage{
	
	private ArrayList Sort;
	private Cac cac = new Cac("Dent en or",50.0,"physique");

	public Fombassiette() {
		super(500, 10, 0.2, 50, 0, 20, 20);
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
