import java.util.ArrayList;

public class GobTout extends Personnage {
	private ArrayList Sort;
	private Cac cac = new Cac("Lance langue",10.0,"physique");

	public GobTout() {
		super(200, 10, 0.0, 10, 0, 10, 10,"GobTout");
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
