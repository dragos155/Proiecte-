package lab7.pachet;

import java.util.Comparator;


public class SortID implements Comparator<Persoane> {

	@Override
	public int compare(Persoane p1, Persoane p2) 
	{
		if(p1.getID() > p2.getID())
		{
			return 1;
		}
		else if(p1.getID() < p2.getID())
		{
			return -1;
		}
		else
			return 0;
	}

}
