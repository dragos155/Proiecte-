package lab7.pachet;

public class Persoane {
	private int ID;
	private String nume;
	private int varsta;
	public Persoane(int iD, String nume, int varsta) {
		super();
		ID = iD;
		this.nume = nume;
		this.varsta = varsta;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getVarsta() {
		return varsta;
	}
	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
}
