package Subiect2_1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteFrame extends JFrame implements ActionListener {

	private JTextField txt;
	private JButton btnDelete;
	private Vector restaurante;
	private ResultSet rs;
	private MyFrame frm;

	public DeleteFrame(Vector restaurante, ResultSet rs)
	{
		super ("Stergere");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		setLayout(new FlowLayout());

		JLabel lbl = new JLabel("Dati denumirea: ");
		txt = new JTextField(10);
		btnDelete = new JButton("Stergere");

		getContentPane().add(lbl);
		getContentPane().add(txt);
		getContentPane().add(btnDelete);

		setVisible(true);

		btnDelete.addActionListener(this);

		this.restaurante = restaurante;
		this.rs = rs;
	}

	public Vector getRestaurante() {
		return restaurante;
	}

	public ResultSet getRs() {
		return rs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton source = (JButton) e.getSource();

		if (source == btnDelete)
		{
			for (int i=0; i<restaurante.size(); i++)
			{
				if (restaurante.elementAt(i) instanceof Restaurant)
				{
					Restaurant rst = (Restaurant) restaurante.elementAt(i);
					if (rst.getDenumire().equalsIgnoreCase(txt.getText()))
					{
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
									if (rs.getString("Denumire").equalsIgnoreCase(txt.getText()))
									{
										rs.deleteRow();
										restaurante.removeElementAt(i);
										this.dispose();
										try {
											MyFrame frm = new MyFrame();
										} catch (InstantiationException | IllegalAccessException
												| ClassNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}while (rs.next());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		}
	}
}
