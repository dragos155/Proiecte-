package lab7.pachet;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainApp {

	public static List<Persoane> listaPersoane = new ArrayList<Persoane>();
	private static int pozitieLista;
	private static int pozitieMaxima;
	
	public static int getPozitieMaxima() {
		return pozitieMaxima;
	}
	public static void setPozitieMaxima(int pozitieMaxima) {
		MainApp.pozitieMaxima = pozitieMaxima;
	}
	public static int getPozitieLista() {
		return pozitieLista;
	}
	public static void setPozitieLista(int pozitieLista) {
		MainApp.pozitieLista = pozitieLista;
	}
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/test";
		Connection con = DriverManager.getConnection (url, "root", "root");
		
		Statement sql;
		sql = (Statement) con.createStatement();
		
		ResultSet rs;
		rs = sql.executeQuery("select * from persoane");
		
		while(rs.next())
		{
			Persoane pers = new Persoane(rs.getInt(1), rs.getString(2), rs.getInt(3));
			listaPersoane.add(pers);
		}
		
		MainFrame f = new MainFrame("Tabel MySQL");
		persCurenta(f,0);
		con.close();
		sql.close();
		rs.close();
	}
	public static void persCurenta(MainFrame f, int pozitieLista)
	{
		setPozitieLista(pozitieLista);
		setPozitieMaxima(listaPersoane.size());
		f.getPosText().setText((pozitieLista + 1) + "/" + listaPersoane.size());
		f.getTextId().setText(String.valueOf(listaPersoane.get(pozitieLista).getID()));
		f.getTextVarsta().setText(String.valueOf(listaPersoane.get(pozitieLista).getVarsta()));
		f.getTextNume().setText(listaPersoane.get(pozitieLista).getNume());
	}
	
	public static void updateDB(boolean update, int lastID) throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/test";
		Connection con = DriverManager.getConnection (url, "root", "root");
		
		Statement sql;
		sql = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs;
		rs = sql.executeQuery("select * from persoane");
		
		if(update == true)
		{
			while(rs.next())
			{
				if(rs.getInt(1) == lastID)
				{
					int idNou = listaPersoane.get(pozitieLista).getID();
					int varstaNoua = listaPersoane.get(pozitieLista).getVarsta();
					String numeNou = listaPersoane.get(pozitieLista).getNume();
					rs.updateInt(1, idNou);
					rs.updateInt(3, varstaNoua);
					rs.updateString(2, numeNou);
					rs.updateRow();
					break;
				}
			}
		}
		con.close();
		sql.close();
		rs.close();
	}
	
	public static void insertItem() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/test";
		Connection con = DriverManager.getConnection (url, "root", "root");
		
		Statement sql;
		sql = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs;
		rs = sql.executeQuery("select * from persoane");
		
		rs.moveToInsertRow();
		int idNou = listaPersoane.get(pozitieMaxima).getID();
		int varstaNoua = listaPersoane.get(pozitieMaxima).getVarsta();
		String numeNou = listaPersoane.get(pozitieMaxima).getNume();
		rs.updateInt(1, idNou);
		rs.updateInt(3, varstaNoua);
		rs.updateString(2, numeNou);
		rs.insertRow();
	}
	
	public static void removeItem() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/test";
		Connection con = DriverManager.getConnection (url, "root", "root");
		
		Statement sql;
		sql = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs;
		rs = sql.executeQuery("select * from persoane");
		
		while(rs.next())
		{
			if(rs.getInt(1) == listaPersoane.get(pozitieLista).getID())
			{
				listaPersoane.remove(getPozitieLista());
				if(pozitieLista!=0)
				{
					setPozitieLista(pozitieLista - 1);
					setPozitieMaxima(pozitieMaxima - 1);
				}
				else
				{
					setPozitieLista(pozitieLista);
					setPozitieMaxima(pozitieMaxima - 1);
				}
				rs.deleteRow();
				break;
			}
		}
		con.close();
		sql.close();
		rs.close();
	}
	
	public static void sortListItems()
	{
		Collections.sort(listaPersoane, new SortID());
	}
}

