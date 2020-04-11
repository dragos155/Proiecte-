package Subiect3_1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{

	private Connection con;
	private Statement sql;
	private ResultSet rs;
	private JTextField myTxt;
	private DefaultListModel myModel;
	private JList myList;
	private JButton myBtn;

	public MyFrame() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		super ("Statiuni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setLayout(new BorderLayout());
		
		myTxt = new JTextField();
		myModel = new DefaultListModel();
		myList = new JList(myModel);
		myBtn = new JButton ("Sterge statiune");
		
		getContentPane().add(myTxt,BorderLayout.NORTH);
		getContentPane().add(myList,BorderLayout.CENTER);
		getContentPane().add(myBtn,BorderLayout.SOUTH);
		
		myBtn.addActionListener(this);
		myTxt.addActionListener(this);
		
		setVisible(true);
		
		connect();
	}
	
	public void connect() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		String url = "jdbc:mysql://localhost:3306/test";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = (Connection)DriverManager.getConnection(url,"root","root");
		sql = (Statement)con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = sql.executeQuery("select * from destinatii");
		
		rs.first();
		
		do 
		{
			String tara = rs.getString("Tara");
			String statiune = rs.getString("Statiunea");
			String nr_obiective = rs.getString("Nr_Obiective");
			
			myModel.addElement(tara + ", " + statiune + ", " + nr_obiective + "\n");
			
		} while (rs.next());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//daca se apasa pe buton
		if (e.getSource() == myBtn)
		{
			int selectedIndex = myList.getSelectedIndex();
			if (selectedIndex != -1)
			{
				String element = (String) myModel.getElementAt(selectedIndex);
				String parts[] = element.split(", ");

				try {
					rs.first();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					do 
					{
						try {
							if (rs.getString("Statiunea").equalsIgnoreCase(parts[1]))
							{
								rs.deleteRow();
								myModel.remove(selectedIndex);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} while (rs.next());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		//daca se introduce in caseta de text
		if (e.getSource() == myTxt)
		{
			String element = myTxt.getText();
			String parts[] = element.split(", ");
			
			try {
				rs.moveToInsertRow();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				rs.updateString("Tara", parts[0]);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				rs.updateString("Statiunea", parts[1]);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				rs.updateInt("Nr_Obiective", Integer.parseInt(parts[2]));
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				rs.insertRow();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String tara="";
			try {
				tara = rs.getString("Tara");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String statiune="";
			try {
				statiune = rs.getString("Statiunea");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String nr_obiective="";
			try {
				nr_obiective = rs.getString("Nr_Obiective");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			myModel.addElement(tara + ", " + statiune + ", " + nr_obiective + "\n");
		}
	}
}
