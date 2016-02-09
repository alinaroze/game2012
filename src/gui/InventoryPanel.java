package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import ctrl.Controller;

/**
 * Displays the Weapons and Armor currently controlled by the Player. 
 * 
 * Layout design by Grant, updating designed by Will
 * 
 * @author Will and Grant
 *
 */
public class InventoryPanel extends JPanel implements ActionListener{
	private Controller ctrl;

	private JList weaponList, armorList;
	private JList alcList;
	private JButton equipWeaponBtn, equipArmorBtn;
	private JButton useBtn;

	/**
	 * Create the panel.
	 */
	public InventoryPanel(Controller c) {
		super();
		ctrl = c;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		String[] weapons = new String[ctrl.getGame().getPlayer()
				.getNumStoredWeapons()+1];
		weapons[0] = ctrl.getGame().getPlayer().getWeaponName();
		if(weapons[0]==null)
			weapons[0]="No weapon";
		for (int i = 1; i < weapons.length; i++) {
			weapons[i] = ctrl.getGame().getPlayer().getStoredWeapon(i - 1)
					.getName();
		}
		weaponList = new JList(weapons);
		String[] armor = new String[ctrl.getGame().getPlayer()
				.getNumStoredArmor()+1];
		armor[0] = ctrl.getGame().getPlayer().getArmorName();
		if(armor[0]==null)
			armor[0]="No armor";
		for (int i = 1; i < armor.length; i++) {
			armor[i] = ctrl.getGame().getPlayer().getStoredArmor(i - 1)
					.getName();
		}
		armorList = new JList(armor);
		alcList = new JList(new String[] {
				ctrl.getGame().getPlayer().getProtonNum() + " Protons",
				ctrl.getGame().getPlayer().getNeutronNum() + " Neutrons" });

		equipWeaponBtn = new JButton("Equip Weapon");
		equipWeaponBtn.addActionListener(this);
		equipArmorBtn = new JButton("Equip");

		useBtn = new JButton("Use");


		add(weaponList);
		add(equipWeaponBtn);
		add(armorList);
		add(equipArmorBtn);
		add(alcList);
		add(useBtn);
	}

	/**
	 * Updates the lists to contain accurate information
	 */
	public void refresh() {
		removeAll();

		String[] weapons = new String[ctrl.getGame().getPlayer()
				.getNumStoredWeapons()+1];
		weapons[0] = ctrl.getGame().getPlayer().getWeaponName();
		for (int i = 1; i < weapons.length; i++) {
			weapons[i] = ctrl.getGame().getPlayer().getStoredWeapon(i - 1)
					.getName();
		}
		weaponList = new JList(weapons);
		if(weapons[0]==null)
			weapons[0]="No weapon";
		String[] armor = new String[ctrl.getGame().getPlayer()
				.getNumStoredArmor()+1];
		armor[0] = ctrl.getGame().getPlayer().getArmorName();
		if(armor[0]==null)
			armor[0]="No armor";
		for (int i = 1; i < armor.length; i++) {
			armor[i] = ctrl.getGame().getPlayer().getStoredArmor(i - 1)
					.getName();
		}
		armorList = new JList(armor);
		alcList = new JList(new String[] {
				ctrl.getGame().getPlayer().getProtonNum() + " Protons",
				ctrl.getGame().getPlayer().getNeutronNum() + " Neutrons" });

		equipWeaponBtn = new JButton("Equip Weapon");
		
		
		equipArmorBtn = new JButton("Equip Armor");

		useBtn = new JButton("Use");


		add(weaponList);
		add(equipWeaponBtn);
		add(armorList);
		add(equipArmorBtn);
		add(alcList);
		add(useBtn);

	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		if(arg.getActionCommand().equals(equipWeaponBtn.getText()))
					ctrl.getGame().getPlayer().swapWep(weaponList.getSelectedIndex());
		System.out.println("idx: " +weaponList.getSelectedIndex());
	}

}
