package gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ctrl.Controller;

public class CharacterPanel extends JPanel {
	JLabel lblname, levelLbl, xpLbl, lblXp, healthLbl, lblHealth;
Controller ctrl;
	public CharacterPanel(Controller c) {
	ctrl = c;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		lblname = new JLabel(ctrl.getGame().getPlayer().getName());
		add(lblname);

		levelLbl = new JLabel("Level: " + ctrl.getGame().getPlayer().getLevel());
		add(levelLbl);
		
		xpLbl = new JLabel("XP:" + ctrl.getGame().getPlayer().getExperience());
		add(xpLbl);

		healthLbl = new JLabel("Health: ");
		add(healthLbl);

		lblHealth = new JLabel(ctrl.getGame().getPlayer().getHealth() + " / " + ctrl.getGame().getPlayer().getMaxHealth());
		add(lblHealth);
		setVisible(true);
		}
	
	public void refresh(){
		levelLbl.setText("Level: " + ctrl.getGame().getPlayer().getLevel());
		xpLbl.setText("XP:" + ctrl.getGame().getPlayer().getExperience());
		lblHealth.setText(ctrl.getGame().getPlayer().getHealth() + " / " + ctrl.getGame().getPlayer().getMaxHealth());
	}

}
