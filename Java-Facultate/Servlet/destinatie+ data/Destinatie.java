package Subiect4_1;

import java.util.Calendar;

public class Destinatie {


	private String destinatie;
	private Calendar data_vizitarii;
	
	public Destinatie(String destinatie, Calendar data_vizitarii) {
		this.destinatie = destinatie;
		this.data_vizitarii = data_vizitarii;
	}
	public String getDestinatie() {
		return destinatie;
	}
	public void setDestinatie(String destinatie) {
		this.destinatie = destinatie;
	}
	public Calendar getData_vizitarii() {
		return data_vizitarii;
	}
	public void setData_vizitarii(Calendar data_vizitarii) {
		this.data_vizitarii = data_vizitarii;
	}
	
	public String afisareData()
	{
		if (data_vizitarii.get(Calendar.MONTH) == 0)
		{
			return data_vizitarii.get(Calendar.DAY_OF_MONTH) + "/" + 12 + "/" + (data_vizitarii.get(Calendar.YEAR)-1);
		}
		return data_vizitarii.get(Calendar.DAY_OF_MONTH) + "/" + data_vizitarii.get(Calendar.MONTH) + "/" + data_vizitarii.get(Calendar.YEAR);
	}
	
	public String toString()
	{
		return destinatie + " " + afisareData();
	}
}
