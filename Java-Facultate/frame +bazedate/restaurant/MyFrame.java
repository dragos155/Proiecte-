package Subiect2_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{

	private Connection con;
	private Statement sql;
	private ResultSet rs;
	private DefaultListModel myModel;
	private JList myList;
	private JButton myBtn;
	private Vector restaurante;

	public MyFrame() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		super ("Restaurante");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);

		setLayout(new BorderLayout());

		myModel = new DefaultListModel();
		myList = new JList(myModel);
		myList.setPreferredSize(new Dimension(300,230));

		myBtn = new JButton("Sterge restaurant");

		getContentPane().add(myList, BorderLayout.NORTH);
		getContentPane().add(myBtn, BorderLayout.SOUTH);

		myBtn.addActionListener(this);

		setVisible(true);

		restaurante = new Vector();
		connect();
	}


	public void connect() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		myModel.clear();
		try {
			String url = "jdbc:mysql://localhost:3306/test";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(url,"root","root");
			sql = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = sql.executeQuery("select * from restaurante");

			rs.first();

			do
			{
				String denumire = rs.getString("Denumire");
				String specific = rs.getString("Specific");
				String zona = rs.getString("Zona");

				Restaurant r = new Restaurant(denumire,specific,zona);

				restaurante.addElement(r);

			}while (rs.next());

			for (int i=0; i<restaurante.size(); i++)
			{
				if (restaurante.elementAt(i) instanceof Restaurant)
				{
					Restaurant rst = (Restaurant) restaurante.elementAt(i);
					myModel.addElement(rst.toString());
				}
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(MyFrame.this, e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton source = (JButton) e.getSource();

		if (source == myBtn)
		{
			DeleteFrame deleteFrm = new DeleteFrame (restaurante,rs);
			restaurante = deleteFrm.getRestaurante();
			rs = deleteFrm.getRs();
		}
	}

}
