package Subiect4_1;

import java.util.Comparator;

public class ComparaDestinatie implements Comparator<Destinatie>{

	@Override
	public int compare(Destinatie d1, Destinatie d2) {
		// TODO Auto-generated method stub
		return d1.getDestinatie().compareTo(d2.getDestinatie());
	}

}
