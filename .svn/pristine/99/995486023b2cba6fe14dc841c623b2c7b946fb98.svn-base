package gui;

import inventory.Item;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;

import shop.ItemShop;

public class BuyButton {
	private Item item, iteratorCurrent;
	private ShopGUI GUI;
	private ItemShop shop;
	private HashMap<Item, Integer> playerInventory;
	private JButton button;
	private SellButton temp = null;
	private JLabel name, buyPrice;
	private int slotNumber;

	/**
	 * 
	 * @param sg ShopGUI
	 * @param i Item
	 * @param is ItemShop
	 * @param inv player Inventory
	 */
	public BuyButton(ShopGUI sg, Item i, ItemShop is, HashMap<Item, Integer> inv) {
		GUI = sg;
		item = i;
		shop = is;
		playerInventory = inv;

		name = new JLabel(item.getName());

		buyPrice = new JLabel("Cost: " + Integer.toString(item.getPrice()));
		button = new JButton();
		button.setLayout(new BorderLayout());
		button.add(BorderLayout.NORTH, name);
		button.add(BorderLayout.SOUTH, buyPrice);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (shop.canBuyItem(item)) {
					boolean found = false;
					for (int i = 0; i < 45; i++) {
						if (GUI.getItem(i) != null) {
							if (item.getName().equals(GUI.getItem(i).getName())) {
								found = true;
								shop.buyItem(item);
								GUI.setButton(i, item);
							}
							if (found == true) {
								break;
							}
						}
						if (found == true) {
							break;
						}
					}
					if (found == false) {
						slotNumber = GUI.findNextAvailable();
						if (slotNumber >= 0) {
							GUI.setSlot(slotNumber, item);
							shop.buyItem(item);
							GUI.setButton(slotNumber, item);
						}
					}
				}
			}
		});
	}

	/**
	 * 
	 * @param x start x-coordinate of button
	 * @param y start y-coordinate of button
	 */
	public final void setBounds(int x, int y) {
		button.setBounds(x, y, 147, 56);
	}

	/**
	 * 
	 * @return button
	 */
	public JButton getButton() {
		return this.button;
	}

}
