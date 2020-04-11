package Subiect2_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MainApp {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		List<Melodie> melodii = new ArrayList<Melodie>();
		
		String url = "jdbc:mysql://localhost:3306/test";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = (Connection)DriverManager.getConnection(url,"root","root");
		Statement sql = (Statement)con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = sql.executeQuery("select * from melodii");
		
		rs.first();
		
		do
		{
			String titlu = rs.getString("Titlu");
			String artist = rs.getString("Artist");
			String an = rs.getString("An");
			
			Melodie m = new Melodie (titlu, artist, Integer.parseInt(an));
			
			melodii.add(m);
			
		} while (rs.next());
		
		for (Melodie mel : melodii)
		{
			System.out.println(mel.toString());
		}
		
		String indice = JOptionPane.showInputDialog(null, "Introduceti indicele melodiei");
		melodii.remove(Integer.parseInt(indice));
		
		System.out.println("\nContinutul listei dupa stergere: \n");
		for (Melodie mel : melodii)
		{
			System.out.println(mel.toString());
		}
	}

}
