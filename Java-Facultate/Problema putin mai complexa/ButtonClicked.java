package lab7.pachet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonClicked implements ActionListener {
	MainFrame frameTabel;
	private static JButton lastButtonPressed;
	private static int lastID;
	public ButtonClicked(MainFrame frameTabel) {
		super();
		this.frameTabel = frameTabel;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == frameTabel.getEditButton())
		{
			lastID = Integer.parseInt(frameTabel.getTextId().getText());
			lastButtonPressed = frameTabel.getEditButton();
			frameTabel.changeFrameState(true);
		}
		if(e.getSource() == frameTabel.getSaveButton() && lastButtonPressed == frameTabel.getEditButton())
		{
			int idNou, varstaNoua;
			String numeNou;
			boolean ok = true;
			
			idNou = Integer.parseInt(frameTabel.getTextId().getText());
			varstaNoua = Integer.parseInt(frameTabel.getTextVarsta().getText());
			numeNou = frameTabel.getTextNume().getText();	
			
			for (Persoane item : MainApp.listaPersoane) 
			{
				if(idNou == item.getID())
				{
					if(lastID == item.getID())
					{
						ok = true;
					}
					else
					{
					JOptionPane.showMessageDialog(null, "Exista deja o persoana cu ID-ul introdus");
					ok = false;
					}
				}

			}
			if(ok == true)
			{
				Persoane item = MainApp.listaPersoane.get(MainApp.getPozitieLista());
				item.setID(idNou);
				item.setNume(numeNou);
				item.setVarsta(varstaNoua);
				try {
					MainApp.updateDB(true, lastID);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				frameTabel.changeFrameState(false);
			}
		}
		if(e.getSource() == frameTabel.getAddButton())
		{
			frameTabel.getTextId().setText(null);
			frameTabel.getTextNume().setText(null);
			frameTabel.getTextVarsta().setText(null);
			lastButtonPressed = frameTabel.getAddButton();
			frameTabel.changeFrameState(true);
		}
		if(e.getSource() == frameTabel.getSaveButton() && lastButtonPressed == frameTabel.getAddButton())
		{
			int idNou, varstaNoua;
			String numeNou;
			boolean ok = true;
			
			idNou = Integer.parseInt(frameTabel.getTextId().getText());
			varstaNoua = Integer.parseInt(frameTabel.getTextVarsta().getText());
			numeNou = frameTabel.getTextNume().getText();	
			
			for (Persoane item : MainApp.listaPersoane) 
			{
				if(idNou == item.getID())
				{
					JOptionPane.showMessageDialog(null, "Exista deja o persoana cu ID-ul introdus");
					ok = false;
				}
			}
			if(ok == true)
			{
				Persoane item = new Persoane(idNou, numeNou, varstaNoua);
				MainApp.listaPersoane.add(item);
				try {
					MainApp.insertItem();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				frameTabel.changeFrameState(false);
			}
			MainApp.persCurenta(frameTabel, MainApp.getPozitieMaxima());
		}
		if(e.getSource() == frameTabel.getUndoButton())
		{
			frameTabel.changeFrameState(false);
		}
		if(e.getSource() == frameTabel.getFirstButton())
		{
			MainApp.persCurenta(frameTabel, 0);
		}
		if(e.getSource() == frameTabel.getPreviousButton())
		{
			if(MainApp.getPozitieLista() > 0)
			{
				MainApp.persCurenta(frameTabel, MainApp.getPozitieLista() - 1);
			}
		}
		if(e.getSource() == frameTabel.getNextButton())
		{
			if(MainApp.getPozitieLista() < MainApp.getPozitieMaxima() - 1)
			{
				MainApp.persCurenta(frameTabel, MainApp.getPozitieLista() + 1);
			}
		}
		if(e.getSource() == frameTabel.getLastButton())
		{
			if(MainApp.getPozitieLista() < MainApp.getPozitieMaxima() - 1)
			{
				MainApp.persCurenta(frameTabel, MainApp.getPozitieMaxima() - 1);
			}
		}
		
		if(e.getSource() == frameTabel.getDeleteButton())
		{
			int optiune = JOptionPane.showConfirmDialog(null, "Sunteti sigur ca doriti sa stergeti persoana curenta?","Confirmare stergere",JOptionPane.YES_NO_OPTION);
			if(optiune == 0)//yes
			{
				try {
					MainApp.removeItem();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				MainApp.persCurenta(frameTabel, MainApp.getPozitieLista());
			}
			
		}
		if(e.getSource() == frameTabel.getSearchButton())
		{
			boolean ok = false;
			String numeCautat = "";
			do
			{
				numeCautat = JOptionPane.showInputDialog(null,"Numele","Cautare nume",JOptionPane.OK_CANCEL_OPTION);
				
			}while("".equals(numeCautat));
			
			if(numeCautat != null)
			{
				for(Persoane item : MainApp.listaPersoane)
				{
					if(item.getNume().matches("(?i)"+numeCautat) == true)
					{
						MainApp.persCurenta(frameTabel, MainApp.listaPersoane.indexOf(item));
						ok = true;
					}
				}
				if(ok == false)
				{
					JOptionPane.showMessageDialog(null, "Persoana nu a fost gasita");
				}
			}
		}
		if(e.getSource() == frameTabel.getSortItemsButton())
		{
			MainApp.sortListItems();
			MainApp.persCurenta(frameTabel, 0);
		}
	}
}
