package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import character.Player;

public class UpgradeButton {
	private int item; // 0 for weapon, 1 for item
	private JLabel name, upgradePrice;
	private JButton button;
	private Player currentPlayer;
	private ShopGUI GUI;

	/**
	 * 
	 * @param sg ShopGUI
	 * @param p Player in question
	 * @param num determine whether item is a weapon (1) or armor (1)
	 * @param x start x-coordinate of button
	 * @param y start y-coordinate of button
	 */
	public UpgradeButton(ShopGUI sg, Player p, int num, int x, int y) {

		GUI = sg;
		item = num;// 0 for Weapon, 1 for Armor
		button = new JButton();
		name = new JLabel();
		upgradePrice = new JLabel();
		button.setBounds(x, y, 200, 50);
		currentPlayer = p;
		if (item == 0) {
			button.setLayout(new BorderLayout());
			button.add(name, BorderLayout.NORTH);
			button.add(upgradePrice, BorderLayout.SOUTH);
			setButton();
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (currentPlayer.getWeaponLevel() < 3
							&& currentPlayer.getNeutronNum() >= currentPlayer
									.getWeaponPrice() + 200) {
						currentPlayer.weaponLevelUp();
						currentPlayer.subNeutrons(currentPlayer
								.getWeaponPrice() + 200);
						GUI.setNeutrons();
						setButton();
					}
				}
			});
		} else if (item == 1) {
			button.setLayout(new BorderLayout());
			button.add(name, BorderLayout.NORTH);
			button.add(upgradePrice, BorderLayout.SOUTH);
			setButton();
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (currentPlayer.getArmorLevel() < 3
							&& currentPlayer.getNeutronNum() >= currentPlayer
									.getArmorPrice() + 200) {
						currentPlayer.armorLevelUp();
						currentPlayer.subNeutrons(currentPlayer.getArmorPrice() + 200);
						GUI.setNeutrons();
						setButton();
					}
				}
			});
		}
	}

	private void setButton() {

		if (item == 0) {

			name.setText(currentPlayer.getWeaponName() + " to level "
					+ (currentPlayer.getWeaponLevel() + 1));
			upgradePrice.setText(Integer.toString(currentPlayer
					.getWeaponPrice() + 200));
			if (currentPlayer.getWeaponLevel() < 3
					&& currentPlayer.getNeutronNum() >= (currentPlayer
							.getWeaponPrice() + 200)) {

				button.setVisible(true);
			} else {

				button.setVisible(false);
			}

		} else if (item == 1) {

			name.setText(currentPlayer.getArmorName() + " to level "
					+ (currentPlayer.getArmorLevel() + 1));
			upgradePrice
					.setText(Integer.toString(currentPlayer.getArmorPrice() + 200));
			if (currentPlayer.getArmorLevel() < 3
					&& currentPlayer.getNeutronNum() >= (currentPlayer
							.getArmorPrice() + 200)) {
				button.setVisible(true);
			} else {
				button.setVisible(false);
			}
		} else {
			button.setVisible(false);
		}
	}

	public JButton getButton() {
		return this.button;
	}
}
