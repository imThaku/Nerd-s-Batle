import java.util.ArrayList;

public class PunchlinoGob extends Personnage {
	
	private ArrayList Sort;
	private Cac cac = new Cac("Hook",50.0,"physique");

	public PunchlinoGob() {
		super(50, 150, 0.5, 30, 0, 0, 0);
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
