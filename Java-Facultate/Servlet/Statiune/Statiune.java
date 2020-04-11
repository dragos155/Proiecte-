package problema4_2;

public class Statiune {
	private String nume_statiune;
	private String nume_tara;
	private int numar_partii;
	public Statiune(String nume_statiune, String nume_tara, int numar_partii) {
		super();
		this.nume_statiune = nume_statiune;
		this.nume_tara = nume_tara;
		this.numar_partii = numar_partii;
	}
	public String getNume_statiune() {
		return nume_statiune;
	}
	public void setNume_statiune(String nume_statiune) {
		this.nume_statiune = nume_statiune;
	}
	public String getNume_tara() {
		return nume_tara;
	}
	public void setNume_tara(String nume_tara) {
		this.nume_tara = nume_tara;
	}
	public int getNumar_partii() {
		return numar_partii;
	}
	public void setNumar_partii(int numar_partii) {
		this.numar_partii = numar_partii;
	}
	@Override
	public String toString()
	{
		return nume_statiune + " " + nume_tara + " " + numar_partii;
	}
}
