package Subiect2_1;

public class Restaurant {

	private String denumire;
	private String specific;
	private String zona;
	public Restaurant(String denumire, String specific, String zona) {
		this.denumire = denumire;
		this.specific = specific;
		this.zona = zona;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getSpecific() {
		return specific;
	}
	public void setSpecific(String specific) {
		this.specific = specific;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	
	public String toString()
	{
		return denumire + ", " + specific + ", " + zona + "\n";
	}
}
