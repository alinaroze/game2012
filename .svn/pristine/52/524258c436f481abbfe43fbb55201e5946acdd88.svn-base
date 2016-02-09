package gui;

import inventory.Item;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;

import shop.ItemShop;

public class SellButton {

	private Item item;
	private ShopGUI GUI;
	private ItemShop shop;
	private HashMap<Item, Integer> playerInventory;
	private JButton button;
	private JLabel name, quantity, sellPrice;
	private int slotNumber;
	private Item[] currentItems;// = new ArrayList<Item>(45);

	/**
	 * 
	 * @param sg ShopGUI
	 * @param is ItemShop
	 * @param sn slot Number
	 * 
	 * this constructor is used when there is not an item to use it
	 */
	public SellButton(ShopGUI sg, ItemShop is, int sn) {

		GUI = sg;
		currentItems = GUI.getAvailable();
		shop = is;
		slotNumber = sn;
		name = new JLabel("");
		quantity = new JLabel("");
		sellPrice = new JLabel("");
		button = new JButton();
		button.setLayout(new BorderLayout());
		button.add(BorderLayout.NORTH, name);
		button.add(BorderLayout.CENTER, quantity);
		button.add(BorderLayout.SOUTH, sellPrice);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerInventory = shop.getThePlayerInventory();
				try {
					if (playerInventory.get(item) > 1) {
						shop.sellItem(item);

						setButton(item);
						GUI.setNeutrons();
					} else {

						GUI.setSlot(slotNumber, null);
						GUI.setNeutrons();
					}
				} catch (Exception f) {
					button.setVisible(false);
					GUI.setSlot(slotNumber, null);
					GUI.setNeutrons();
				}

			}
		});
		button.setVisible(false);
	}

	/**
	 * 
	 * @param sg ShopGUI
	 * @param i Item
	 * @param is ItemShop
	 * @param inv player Inventory
	 * @param sn slot number
	 * this constructor is used when an item is available for its use
	 */
	public SellButton(ShopGUI sg, Item i, ItemShop is,
			HashMap<Item, Integer> inv, int sn) {

		GUI = sg;
		currentItems = GUI.getAvailable();
		item = i;
		shop = is;
		playerInventory = inv;
		slotNumber = sn;
		name = new JLabel(item.getName());
		quantity = new JLabel(Integer.toString(playerInventory.get(item)));
		sellPrice = new JLabel("Sell price: "
				+ Integer.toString(shop.sellPrice(item)));
		button = new JButton();
		button.setLayout(new BorderLayout());
		button.add(BorderLayout.NORTH, name);
		button.add(BorderLayout.CENTER, quantity);
		button.add(BorderLayout.SOUTH, sellPrice);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerInventory = shop.getThePlayerInventory();
				if (playerInventory.get(item) > 1) {
					shop.sellItem(item);
					setButton(item);
					GUI.setNeutrons();
				} else if (playerInventory.get(item) == 1) {
					shop.sellItem(item);
					GUI.setSlot(slotNumber, null);
					button.setVisible(false);
					GUI.setNeutrons();
				} else {
					playerInventory = shop.getThePlayerInventory();
					GUI.setSlot(slotNumber, null);
					button.setVisible(false);
					GUI.setNeutrons();
				}
			}
		});
	}

	/**
	 * 
	 * @param i sets an item for the button
	 */
	public void setButton(Item i) {

		playerInventory = shop.getThePlayerInventory();
		item = i;
		name.setText(item.getName());
		quantity.setText(Integer.toString(playerInventory.get(item)));
		sellPrice.setText("Sell price: "
				+ Integer.toString(shop.sellPrice(item)));
		GUI.setNeutrons();
		button.setVisible(true);

	}

	/**
	 * 
	 * @param x start x-coordinate of button
	 * @param y start y= corrdinate of button
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
