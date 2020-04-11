
package Subiect2_2;

public class Melodie {

	private String titlu;
	private String artist;
	private int an;
	
	public Melodie(String titlu, String artist, int an) {
		this.titlu = titlu;
		this.artist = artist;
		this.an = an;
	}
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getAn() {
		return an;
	}
	public void setAn(int an) {
		this.an = an;
	}
	
	public String toString()
	{
		return titlu + ", " + artist + ", " + an;
	}
}
