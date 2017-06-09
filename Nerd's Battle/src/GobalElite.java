import java.util.ArrayList;

public class GobalElite extends Personnage {
	private ArrayList Sort;
	private Cac cac = new Cac("Awp",30.0,"physique");

	public GobalElite() {
		super(150, 90, 0.3, 30, 0, 30, 15,"GobalElite");
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
