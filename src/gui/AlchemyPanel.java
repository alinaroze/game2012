package gui;

import inventory.ElementCreator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ctrl.Controller;

public class AlchemyPanel extends JPanel implements ActionListener{
	private JLabel nProtonsLbl;
	private JButton H, He, Li, Be, B, C, N, O, F, Ne;
	private Controller ctrl;

	/**
	 * Create the panel.
	 * 
	 */
	public AlchemyPanel(Controller c) {
		super();
		ctrl = c;
		this.setLayout(new GridLayout(6, 2));

		nProtonsLbl = new JLabel("Protons: "
				+ ctrl.getGame().getPlayer().getProtonNum());
		add(nProtonsLbl);
		add(new JPanel());

		H = new JButton("H: "+ctrl.getGame().getPlayer().getElement(1));
		H.addActionListener(this);
		He = new JButton("He: "+ctrl.getGame().getPlayer().getElement(2));
		He.addActionListener(this);
		Li = new JButton("Li: "+ctrl.getGame().getPlayer().getElement(3));
		Li.addActionListener(this);
		Be = new JButton("Be: "+ctrl.getGame().getPlayer().getElement(4));
		Be.addActionListener(this);
		B = new JButton("B: "+ctrl.getGame().getPlayer().getElement(5));
		B.addActionListener(this);
		C = new JButton("C: "+ctrl.getGame().getPlayer().getElement(6));
		C.addActionListener(this);
		N = new JButton("N: "+ctrl.getGame().getPlayer().getElement(7));
		N.addActionListener(this);
		O = new JButton("O: "+ctrl.getGame().getPlayer().getElement(8));
		O.addActionListener(this);
		F = new JButton("F: "+ctrl.getGame().getPlayer().getElement(9));
		F.addActionListener(this);
		Ne = new JButton("Ne: "+ctrl.getGame().getPlayer().getElement(10));
		Ne.addActionListener(this);
		
		add(H);
		add(He);
		add(Li);
		add(Be);
		add(B);
		add(C);
		add(N);
		add(O);
		add(F);
		add(Ne);

	}
	

	/**
	 * Updates the labels with the current quantities of each element
	 */
	public void refresh() {
		nProtonsLbl.setText("Protons: "
				+ ctrl.getGame().getPlayer().getProtonNum());
		H.setText("H: " + ctrl.getGame().getPlayer().getElement(1));
		He.setText("He: " + ctrl.getGame().getPlayer().getElement(2));
		Li.setText("Li: " + ctrl.getGame().getPlayer().getElement(3));
		Be.setText("Be: " + ctrl.getGame().getPlayer().getElement(4));
		B.setText("B: " + ctrl.getGame().getPlayer().getElement(5));
		C.setText("C: " + ctrl.getGame().getPlayer().getElement(6));
		N.setText("N: " + ctrl.getGame().getPlayer().getElement(7));
		O.setText("O: " + ctrl.getGame().getPlayer().getElement(8));
		F.setText("F: " + ctrl.getGame().getPlayer().getElement(9));
		Ne.setText("Ne: " + ctrl.getGame().getPlayer().getElement(10));
	}

	/**
	 * Prompts an ElementCreator to try to give the Player a new Element.
	 */
	@Override
	public void actionPerformed(ActionEvent arg) {
		String sender = arg.getActionCommand();
		ElementCreator creator=new ElementCreator(ctrl.getGame().getPlayer());
		boolean success = false;
		switch(sender.charAt(0)){
		case 'H':
			if(sender.charAt(1)=='e')
				success=creator.tryAlchemy(2);
			else
				success=creator.tryAlchemy(1);
			break;
		case 'L':
			success=creator.tryAlchemy(3);
			break;
		case 'B':
			if(sender.charAt(1)=='e')
				success=creator.tryAlchemy(4);
			else
				success=creator.tryAlchemy(5);
			break;
		case 'C':
			success=creator.tryAlchemy(6);
			break;
		case 'N':
			if(sender.charAt(1)=='e')
				success=creator.tryAlchemy(10);
			else
				success=creator.tryAlchemy(7);
			break;
		case 'O':
			success=creator.tryAlchemy(8);
			break;
		case 'F':
			success=creator.tryAlchemy(9);
			break;
		}
		if(success){
			ctrl.getGmWindow().display("Alchemy Successful");
		}else
			ctrl.getGmWindow().display("Alchemy Failed");
	}
	
	}


