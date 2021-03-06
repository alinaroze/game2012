package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import monster.BattleSys;
import ctrl.Controller;


public class BattlePanel extends JPanel implements ActionListener {
	private BattleSys battle;
	private JTextArea console;
	private JButton attack;
	private JMenu use;
	private JMenu elements;
	private JMenuBar bar;
	private JPanel battlePanel;
	private Controller ctrl;

	public BattlePanel(Controller ctrl) {
		battle = new BattleSys(ctrl);
	ctrl.getGmWindow().display("A wild " + battle.getMonster().getName() + " appears!!!");
		this.ctrl = ctrl;
		// battle = new BattleSys(ctrl);
		battlePanel = new JPanel(new GridLayout());

		attack = new JButton("ATTACK!!");
		attack.addActionListener(this);
		use = new JMenu("USE YOUR POWERS!!");
		
		add(attack);
		
		JMenuItem itmH = new JMenuItem("Hydrogen");
		itmH.addActionListener(this);
		JMenuItem itmHe = new JMenuItem("Helium");
		itmHe.addActionListener(this);
		JMenuItem itmLi = new JMenuItem("Lithium");
		itmLi.addActionListener(this);
		JMenuItem itmBe = new JMenuItem("Beryllium");
		itmBe.addActionListener(this);
		JMenuItem itmB = new JMenuItem("Boron");
		itmB.addActionListener(this);
		JMenuItem itmN = new JMenuItem("Nitrogen");
		itmN.addActionListener(this);
		JMenuItem itmC = new JMenuItem("Carbon");
		itmC.addActionListener(this);
		JMenuItem itmO = new JMenuItem("Oxygen");
		itmO.addActionListener(this);
		JMenuItem itmF = new JMenuItem("Flourine");
		itmF.addActionListener(this);
		JMenuItem itmNe = new JMenuItem("Neon");
		itmNe.addActionListener(this);
		
		
		
		battlePanel = new JPanel(new GridLayout());
		bar = new JMenuBar();
		attack = new JButton("ATTACK!!");

		
		bar.add(use);
		use.add(itmH);
		use.add(itmHe);
		use.add(itmLi);
		use.add(itmBe);
		use.add(itmB);
		use.add(itmN);
		use.add(itmC);
		use.add(itmO);
		use.add(itmF);
		use.add(itmNe);
		
		add(bar);
	
	
	}


	public void actionPerformed(ActionEvent click) {
		ctrl.getGmWindow().display(click.getActionCommand());
		if (click.getActionCommand().equals(attack.getText())) {
			battle.playerAttack();

		} else if (use.isSelected()) {

		}
		if(battle.getMonster().getHealth() < 0)
			battle.playerWins(battle.getMonster().getDrop());
		battle.monsterTurn();
	}
	
	public JButton getAttack(){
		return attack;
	}
}
