package lab7.pachet;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class MainFrame extends JFrame{

	private JToolBar tb = new JToolBar();
	private JButton firstButton = new JButton();
	private JButton previousButton = new JButton();
	private JTextField posText = new JTextField();
	private JButton nextButton = new JButton();
	private JButton lastButton = new JButton();
	private JButton addButton = new JButton();
	private JButton editButton = new JButton();
	private JButton deleteButton = new JButton();
	private JButton searchButton = new JButton();
	private JButton saveButton = new JButton();
	private JButton undoButton = new JButton();
	
	private JLabel lblId = new JLabel("ID");
	private JLabel lblNume = new JLabel("Nume");
	private JLabel lblVarsta = new JLabel("Varsta");

	private JTextField textId = new JTextField();
	private JTextField textNume = new JTextField();
	private JTextField textVarsta = new JTextField();
	
	public JTextField getTextId() {
		return textId;
	}
	public void setTextId(JTextField textId) {
		this.textId = textId;
	}
	public JTextField getTextNume() {
		return textNume;
	}
	public void setTextNume(JTextField textNume) {
		this.textNume = textNume;
	}
	public JTextField getTextVarsta() {
		return textVarsta;
	}
	public void setTextVarsta(JTextField textVarsta) {
		this.textVarsta = textVarsta;
	}

	
	public JButton getAddButton() {
		return addButton;
	}
	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}
	public JButton getDeleteButton() {
		return deleteButton;
	}
	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}
	public JButton getSearchButton() {
		return searchButton;
	}
	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}
	public JButton getUndoButton() {
		return undoButton;
	}
	public void setUndoButton(JButton undoButton) {
		this.undoButton = undoButton;
	}
	
	public JTextField getPosText() {
		return posText;
	}
	public void setPosText(JTextField posText) {
		this.posText = posText;
	}
	
	public JButton getFirstButton() {
		return firstButton;
	}
	public void setFirstButton(JButton firstButton) {
		this.firstButton = firstButton;
	}
	
	public JButton getPreviousButton() {
		return previousButton;
	}
	public void setPreviousButton(JButton previousButton) {
		this.previousButton = previousButton;
	}
	
	public JButton getNextButton() {
		return nextButton;
	}
	public void setNextButton(JButton nextButton) {
		this.nextButton = nextButton;
	}
	
	public JButton getLastButton() {
		return lastButton;
	}
	public void setLastButton(JButton lastButton) {
		this.lastButton = lastButton;
	}
	
	public JButton getSaveButton() {
		return saveButton;
	}
	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}
	
	public JButton getEditButton() 
	{
		return editButton;
	}
	public void setEditButton(JButton editButton) {
		this.editButton = editButton;
	}
	
	private boolean frameState;
	
	public boolean getFrameState() 
	{
		return frameState;
	}
	public void setFrameState(boolean frameState) 
	{
		this.frameState = frameState;
	}

	private JButton sortItemsButton = new JButton("Sort");
	
	public JButton getSortItemsButton() {
		return sortItemsButton;
	}
	public void setSortItemsButton(JButton sortItemsButton) {
		this.sortItemsButton = sortItemsButton;
	}
	
	public MainFrame(String title) throws HeadlessException 
	{
		super(title);
		
		changeFrameState(false);
		
		getContentPane().setLayout(new BorderLayout());
		
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - 275, Toolkit.getDefaultToolkit().getScreenSize().height/2 - 250);
		
		setSize(450, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		firstButton.setIcon(new ImageIcon("Imagini/MoveFirst.png"));
		firstButton.setActionCommand("first");
		firstButton.setToolTipText("First");
		previousButton.setIcon(new ImageIcon("Imagini/MovePrevious.png"));
		previousButton.setActionCommand("previous");
		previousButton.setToolTipText("Previous");
		nextButton.setIcon(new ImageIcon("Imagini/MoveNext.png"));
		nextButton.setActionCommand("next");
		nextButton.setToolTipText("Next");
		lastButton.setIcon(new ImageIcon("Imagini/MoveLast.png"));
		lastButton.setActionCommand("last");
		lastButton.setToolTipText("Last");
		addButton.setIcon(new ImageIcon("Imagini/Add.png"));
		addButton.setActionCommand("add");
		addButton.setToolTipText("Add");
		editButton.setIcon(new ImageIcon("Imagini/Edit.png"));
		editButton.setActionCommand("edit");
		editButton.setToolTipText("Edit");
		deleteButton.setIcon(new ImageIcon("Imagini/Delete.png"));
		deleteButton.setActionCommand("delete");
		deleteButton.setToolTipText("Delete");
		searchButton.setIcon(new ImageIcon("Imagini/find.jpg"));
		searchButton.setActionCommand("search");
		searchButton.setToolTipText("Search");
		saveButton.setIcon(new ImageIcon("Imagini/save.jpg"));
		saveButton.setActionCommand("save");
		saveButton.setToolTipText("Save");
		undoButton.setIcon(new ImageIcon("Imagini/undo.jpg"));
		undoButton.setActionCommand("undo");
		undoButton.setToolTipText("Undo");
		
		posText.setHorizontalAlignment(JTextField.CENTER);
		
		tb.add(firstButton);
		tb.add(previousButton);
		tb.add(posText);
		tb.add(nextButton);
		tb.add(lastButton);
		tb.add(addButton);
		tb.add(editButton);
		tb.add(deleteButton);
		tb.add(searchButton);
		tb.add(saveButton);
		tb.add(undoButton);
		
		this.add(BorderLayout.NORTH,tb);
		
		Container centerSide = new Container();
		centerSide.setLayout(new BoxLayout(centerSide,BoxLayout.Y_AXIS));
		
		Container centerSideTop = new Container();
		centerSideTop.setLayout(new FlowLayout());
		Container centerSideBot = new Container();
		centerSideBot.setLayout(new BoxLayout(centerSideBot, BoxLayout.Y_AXIS));
		
		Container centerSideLeft = new Container();
		Container centerSideRight = new Container();
		
		centerSideLeft.setLayout(new BoxLayout(centerSideLeft, BoxLayout.Y_AXIS));
		centerSideRight.setLayout(new BoxLayout(centerSideRight, BoxLayout.Y_AXIS));
		
		centerSideLeft.add(Box.createVerticalStrut(20));
		centerSideLeft.add(lblId);
		centerSideLeft.add(Box.createVerticalStrut(7));
		centerSideLeft.add(lblNume);
		centerSideLeft.add(Box.createVerticalStrut(7));
		centerSideLeft.add(lblVarsta);
		
		Dimension prefTextSize = new Dimension(150,22);
		
		textId.setPreferredSize(prefTextSize);
		
		centerSideRight.add(Box.createVerticalStrut(20));
		centerSideRight.add(textId);
		centerSideRight.add(Box.createVerticalStrut(7));
		centerSideRight.add(textNume);
		centerSideRight.add(Box.createVerticalStrut(7));
		centerSideRight.add(textVarsta);
		
		centerSideTop.add(centerSideLeft);
		centerSideTop.add(Box.createHorizontalStrut(10));
		centerSideTop.add(centerSideRight);
		
		centerSideBot.add(sortItemsButton);
		centerSideBot.add(Box.createVerticalStrut(80));
		sortItemsButton.setAlignmentX(CENTER_ALIGNMENT);
		
		//centerSide.add(centerSideLeft);
		//centerSide.add(Box.createHorizontalStrut(10));
		//centerSide.add(centerSideRight);
		centerSide.add(centerSideTop);
		centerSide.add(centerSideBot);
		
		this.add(BorderLayout.CENTER,centerSide);
		
		editButton.addActionListener(new ButtonClicked(this));
		saveButton.addActionListener(new ButtonClicked(this));
		undoButton.addActionListener(new ButtonClicked(this));
		firstButton.addActionListener(new ButtonClicked(this));
		previousButton.addActionListener(new ButtonClicked(this));
		nextButton.addActionListener(new ButtonClicked(this));
		lastButton.addActionListener(new ButtonClicked(this));
		addButton.addActionListener(new ButtonClicked(this));
		deleteButton.addActionListener(new ButtonClicked(this));
		searchButton.addActionListener(new ButtonClicked(this));
		sortItemsButton.addActionListener(new ButtonClicked(this));
		setVisible(true);
	}
	
	public void changeFrameState(boolean frameState)
	{
		setFrameState(frameState);
		if(frameState == true) // se poate edita
		{
			firstButton.setEnabled(false);
			previousButton.setEnabled(false);
			nextButton.setEnabled(false);
			lastButton.setEnabled(false);
			addButton.setEnabled(false);
			editButton.setEnabled(false);
			deleteButton.setEnabled(false);
			searchButton.setEnabled(false);
			textId.setEditable(true);
			textNume.setEditable(true);
			textVarsta.setEditable(true);
			saveButton.setEnabled(true);
			undoButton.setEnabled(true);
			sortItemsButton.setEnabled(false);
		}
		else if(frameState == false) // nu se poate edita
		{
			sortItemsButton.setEnabled(true);
			firstButton.setEnabled(true);
			previousButton.setEnabled(true);
			nextButton.setEnabled(true);
			lastButton.setEnabled(true);
			addButton.setEnabled(true);
			editButton.setEnabled(true);
			deleteButton.setEnabled(true);
			searchButton.setEnabled(true);
			textId.setEditable(false);
			textNume.setEditable(false);
			textVarsta.setEditable(false);
			saveButton.setEnabled(false);
			undoButton.setEnabled(false);
		}
	}

	
}
