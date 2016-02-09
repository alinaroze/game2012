package gui;

import inventory.Item;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import shop.ItemShop;

import character.Player;

/**
 * 
 * @author Steven ShopGUI contains the graphical version of the shop
 * 
 */
public class ShopGUI extends JDialog {

	// private final JPanel contentPanel = new JPanel();
	private final JFrame contentPanel = new JFrame("Item Shop");
	private HashMap<Item, Integer> playerInventory;
	private ArrayList<Item> shopInventory;
	private int numItems;
	private Item current = null;
	private Player currentPlayer;
	private JLabel currentNeutrons;
	private Item[] available;// = new Item[45];
	private ItemShop itemShop;
	private UpgradeButton upgradeWeapon, upgradeArmor;

	private JPanel panel1, panel2, panel3;
	private SellButton sellButton0, sellButton1, sellButton2, sellButton3,
			sellButton4, sellButton5, sellButton6, sellButton7, sellButton8,
			sellButton9, sellButton10, sellButton11, sellButton12,
			sellButton13, sellButton14, sellButton15, sellButton16,
			sellButton17, sellButton18, sellButton19, sellButton20,
			sellButton21, sellButton22, sellButton23, sellButton24,
			sellButton25, sellButton26, sellButton27, sellButton28,
			sellButton29, sellButton30, sellButton31, sellButton32,
			sellButton33, sellButton34, sellButton35, sellButton36,
			sellButton37, sellButton38, sellButton39, sellButton40,
			sellButton41, sellButton42, sellButton43, sellButton44;

	private BuyButton buyButton0, buyButton1, buyButton2, buyButton3,
			buyButton4, buyButton5, buyButton6, buyButton7, buyButton8,
			buyButton9, buyButton10, buyButton11, buyButton12, buyButton13,
			buyButton14;

	/**
	 * 
	 * @param i ItemShop
	 * @param inv Player Inventory
	 * @param shopInv shop Inventory (from ShopList)
	 * @param p Player
	 */
	public ShopGUI(ItemShop i, HashMap<Item, Integer> inv,
			ArrayList<Item> shopInv, Player p) {
		itemShop = i;
		playerInventory = inv;
		shopInventory = shopInv;
		numItems = shopInventory.size();
		currentPlayer = p;
		available = new Item[45];
		for (int h = 0; h < available.length; h++) {
			available[h] = null;
		}
		try {
			contentPanel.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		contentPanel.setBounds(100, 100, 1088, 514);
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		JLabel lblBuy = new JLabel("Buy");
		lblBuy.setBounds(219, 11, 92, 14);
		contentPanel.add(lblBuy);

		JLabel lblSell = new JLabel("Sell");
		lblSell.setBounds(797, 11, 92, 14);
		contentPanel.add(lblSell);
		JLabel lblCurrentNeutrons = new JLabel("Current neutrons: ");
		lblCurrentNeutrons.setBounds(726, 438, 107, 14);
		contentPanel.add(lblCurrentNeutrons);
		currentNeutrons = new JLabel(Integer.toString(currentPlayer
				.getNeutronNum()));
		currentNeutrons.setBounds(843, 438, 74, 14);
		contentPanel.add(currentNeutrons);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(556, 20, 506, 352);

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		tabbedPane.addTab("Items", null, panel1, null);
		tabbedPane.addTab("Items", null, panel2, null);
		tabbedPane.addTab("Items", null, panel3, null);
		panel1.setLayout(null);
		panel2.setLayout(null);
		panel3.setLayout(null);
		contentPanel.add(tabbedPane);

		// ----- Exit Button -----
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPanel.dispose();
			}
		});
		exitButton.setBounds(449, 427, 107, 36);
		contentPanel.add(exitButton);

		// ----- Upgrade Buttons -----//
		upgradeWeapon = new UpgradeButton(this, currentPlayer, 0, 20, 359);
		contentPanel.add(upgradeWeapon.getButton());
		upgradeArmor = new UpgradeButton(this, currentPlayer, 1, 280, 359);
		contentPanel.add(upgradeArmor.getButton());
		try {
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		} catch (Exception e) {
			e.printStackTrace();
		}



		// ----- Start Buy Buttons -----//
		Iterator<Item> it = shopInventory.iterator();
		current = null;
		int currentButton = 0;
		while (it.hasNext()) {
			current = (Item) it.next();
			switch (currentButton) {
			case 0:

				buyButton0 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton0.setBounds(20, 56);
				contentPanel.add(buyButton0.getButton());
				currentButton++;
				break;
			case 1:

				buyButton1 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton1.setBounds(177, 56);
				contentPanel.add(buyButton1.getButton());
				currentButton++;
				break;
			case 2:

				buyButton2 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton2.setBounds(334, 56);
				contentPanel.add(buyButton2.getButton());
				currentButton++;
				break;
			case 3:

				buyButton3 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton3.setBounds(20, 117);
				contentPanel.add(buyButton3.getButton());
				currentButton++;
				break;
			case 4:

				buyButton4 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton4.setBounds(177, 117);
				contentPanel.add(buyButton4.getButton());
				currentButton++;
				break;
			case 5:

				buyButton5 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton5.setBounds(334, 117);
				contentPanel.add(buyButton5.getButton());
				currentButton++;
				break;
			case 6:

				buyButton6 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton6.setBounds(20, 177);
				contentPanel.add(buyButton6.getButton());
				currentButton++;
				break;
			case 7:

				buyButton7 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton7.setBounds(177, 177);
				contentPanel.add(buyButton7.getButton());
				currentButton++;
				break;
			case 8:

				buyButton8 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton8.setBounds(334, 177);
				contentPanel.add(buyButton8.getButton());
				currentButton++;
				break;
			case 9:

				buyButton9 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton9.setBounds(20, 238);
				contentPanel.add(buyButton9.getButton());
				currentButton++;
				break;
			case 10:

				buyButton10 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton10.setBounds(177, 238);
				contentPanel.add(buyButton10.getButton());
				currentButton++;
				break;
			case 11:

				buyButton11 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton11.setBounds(334, 238);
				contentPanel.add(buyButton11.getButton());
				currentButton++;
				break;
			case 12:

				buyButton12 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton12.setBounds(20, 299);
				contentPanel.add(buyButton12.getButton());
				currentButton++;
				break;
			case 13:

				buyButton13 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton13.setBounds(177, 299);
				contentPanel.add(buyButton13.getButton());
				currentButton++;
				break;
			case 14:

				buyButton14 = new BuyButton(this, current, itemShop,
						playerInventory);
				buyButton14.setBounds(334, 299);
				contentPanel.add(buyButton14.getButton());
				currentButton++;
				break;

			default:
				break;
			}
		}

		Iterator pit = playerInventory.keySet().iterator();
		currentButton = 0;
		while (pit.hasNext()) {

			current = (Item) pit.next();
			switch (currentButton) {

			case 0:
				currentButton++;
				sellButton0 = new SellButton(this, current, itemShop,
						playerInventory, 0);
				sellButton0.setBounds(15, 11);
				setSlot(0, current);
				panel1.add(sellButton0.getButton());

				break;

			case 1:
				currentButton++;
				sellButton1 = new SellButton(this, current, itemShop,
						playerInventory, 1);
				sellButton1.setBounds(177, 11);

				setSlot(1, current);
				panel1.add(sellButton1.getButton());

				break;
			case 2:
				currentButton++;
				sellButton2 = new SellButton(this, current, itemShop,
						playerInventory, 2);
				sellButton2.setBounds(339, 11);
				setSlot(2, current);
				panel1.add(sellButton2.getButton());
				break;

			case 3:
				currentButton++;
				sellButton3 = new SellButton(this, current, itemShop,
						playerInventory, 3);

				sellButton3.setBounds(15, 72);
				setSlot(3, current);
				panel1.add(sellButton3.getButton());
				break;

			case 4:
				currentButton++;
				sellButton4 = new SellButton(this, current, itemShop,
						playerInventory, 4);

				sellButton4.setBounds(177, 72);
				setSlot(4, current);
				panel1.add(sellButton4.getButton());
				break;

			case 5:
				currentButton++;
				sellButton5 = new SellButton(this, current, itemShop,
						playerInventory, 5);

				sellButton5.setBounds(339, 72);
				setSlot(5, current);
				panel1.add(sellButton5.getButton());
				break;
			case 6:
				currentButton++;
				sellButton6 = new SellButton(this, current, itemShop,
						playerInventory, 6);

				sellButton6.setBounds(15, 133);
				setSlot(6, current);
				panel1.add(sellButton6.getButton());
				break;

			case 7:
				currentButton++;
				sellButton7 = new SellButton(this, current, itemShop,
						playerInventory, 7);

				sellButton7.setBounds(177, 133);
				setSlot(7, current);
				panel1.add(sellButton7.getButton());
				break;
			case 8:
				currentButton++;
				sellButton8 = new SellButton(this, current, itemShop,
						playerInventory, 8);

				sellButton8.setBounds(339, 133);
				setSlot(8, current);
				panel1.add(sellButton8.getButton());
				break;

			case 9:
				currentButton++;
				sellButton9 = new SellButton(this, current, itemShop,
						playerInventory, 9);

				sellButton9.setBounds(15, 194);
				setSlot(9, current);
				panel1.add(sellButton9.getButton());
				break;

			case 10:
				currentButton++;
				sellButton10 = new SellButton(this, current, itemShop,
						playerInventory, 10);

				sellButton10.setBounds(177, 194);
				setSlot(10, current);
				panel1.add(sellButton10.getButton());
				break;
			case 11:
				currentButton++;
				sellButton11 = new SellButton(this, current, itemShop,
						playerInventory, 11);

				sellButton11.setBounds(339, 194);
				setSlot(11, current);
				panel1.add(sellButton11.getButton());
				break;

			case 12:
				currentButton++;
				sellButton12 = new SellButton(this, current, itemShop,
						playerInventory, 12);

				sellButton12.setBounds(15, 255);
				setSlot(12, current);
				panel1.add(sellButton12.getButton());
				break;

			case 13:
				currentButton++;
				sellButton13 = new SellButton(this, current, itemShop,
						playerInventory, 13);

				sellButton13.setBounds(177, 255);
				setSlot(13, current);
				panel1.add(sellButton13.getButton());
				break;

			case 14:
				currentButton++;
				sellButton14 = new SellButton(this, current, itemShop,
						playerInventory, 14);

				sellButton14.setBounds(339, 255);
				setSlot(14, current);
				panel1.add(sellButton14.getButton());
				break;

			case 15:
				currentButton++;
				sellButton15 = new SellButton(this, current, itemShop,
						playerInventory, 15);

				sellButton15.setBounds(15, 11);
				setSlot(15, current);
				panel2.add(sellButton15.getButton());
				break;

			case 16:
				currentButton++;
				sellButton16 = new SellButton(this, current, itemShop,
						playerInventory, 16);

				sellButton16.setBounds(177, 11);
				setSlot(16, current);
				panel2.add(sellButton16.getButton());
				break;

			case 17:
				currentButton++;
				sellButton17 = new SellButton(this, current, itemShop,
						playerInventory, 17);

				sellButton17.setBounds(339, 11);
				setSlot(17, current);
				panel2.add(sellButton17.getButton());
				break;

			case 18:
				currentButton++;
				sellButton18 = new SellButton(this, current, itemShop,
						playerInventory, 18);

				sellButton18.setBounds(15, 72);
				setSlot(18, current);
				panel2.add(sellButton18.getButton());
				break;

			case 19:
				currentButton++;
				sellButton19 = new SellButton(this, current, itemShop,
						playerInventory, 19);

				sellButton19.setBounds(177, 72);
				setSlot(19, current);
				panel2.add(sellButton19.getButton());
				break;

			case 20:
				currentButton++;
				sellButton20 = new SellButton(this, current, itemShop,
						playerInventory, 20);

				sellButton20.setBounds(339, 72);
				setSlot(20, current);
				panel2.add(sellButton20.getButton());
				break;

			case 21:
				currentButton++;
				sellButton21 = new SellButton(this, current, itemShop,
						playerInventory, 21);

				sellButton21.setBounds(15, 133);
				setSlot(21, current);
				panel2.add(sellButton21.getButton());
				break;

			case 22:
				currentButton++;
				sellButton22 = new SellButton(this, current, itemShop,
						playerInventory, 22);

				sellButton22.setBounds(177, 133);
				setSlot(22, current);
				panel2.add(sellButton22.getButton());
				break;
			case 23:
				currentButton++;
				sellButton23 = new SellButton(this, current, itemShop,
						playerInventory, 23);

				sellButton23.setBounds(339, 133);
				setSlot(23, current);
				panel2.add(sellButton23.getButton());
				break;
			case 24:
				currentButton++;
				sellButton24 = new SellButton(this, current, itemShop,
						playerInventory, 24);

				sellButton24.setBounds(15, 194);
				setSlot(24, current);
				panel2.add(sellButton24.getButton());
				break;

			case 25:
				currentButton++;
				sellButton25 = new SellButton(this, current, itemShop,
						playerInventory, 25);
				sellButton25.setBounds(177, 194);
				setSlot(25, current);
				panel2.add(sellButton25.getButton());
				break;
			case 26:
				currentButton++;
				sellButton26 = new SellButton(this, current, itemShop,
						playerInventory, 26);

				sellButton26.setBounds(339, 194);
				setSlot(26, current);
				panel2.add(sellButton26.getButton());
				break;

			case 27:
				currentButton++;
				sellButton27 = new SellButton(this, current, itemShop,
						playerInventory, 27);

				sellButton27.setBounds(15, 255);
				setSlot(27, current);
				panel2.add(sellButton27.getButton());
				break;

			case 28:
				currentButton++;
				sellButton28 = new SellButton(this, current, itemShop,
						playerInventory, 28);

				sellButton28.setBounds(177, 255);
				setSlot(28, current);
				panel2.add(sellButton28.getButton());
				break;

			case 29:
				currentButton++;
				sellButton29 = new SellButton(this, current, itemShop,
						playerInventory, 29);

				sellButton29.setBounds(339, 255);
				setSlot(29, current);
				panel2.add(sellButton29.getButton());
				break;

			case 30:
				currentButton++;
				sellButton30 = new SellButton(this, current, itemShop,
						playerInventory, 30);

				sellButton30.setBounds(15, 11);
				setSlot(30, current);
				panel3.add(sellButton30.getButton());
				break;
			case 31:
				currentButton++;
				sellButton31 = new SellButton(this, current, itemShop,
						playerInventory, 31);

				sellButton31.setBounds(177, 11);
				setSlot(31, current);
				panel3.add(sellButton31.getButton());
				break;

			case 32:
				currentButton++;
				sellButton32 = new SellButton(this, current, itemShop,
						playerInventory, 32);

				sellButton32.setBounds(339, 11);
				setSlot(32, current);
				panel3.add(sellButton32.getButton());
				break;

			case 33:
				currentButton++;
				sellButton33 = new SellButton(this, current, itemShop,
						playerInventory, 33);

				sellButton33.setBounds(15, 72);
				setSlot(33, current);
				panel3.add(sellButton33.getButton());
				break;

			case 34:
				currentButton++;
				sellButton34 = new SellButton(this, current, itemShop,
						playerInventory, 34);

				sellButton34.setBounds(177, 72);
				setSlot(34, current);
				panel3.add(sellButton34.getButton());
				break;

			case 35:
				currentButton++;
				sellButton35 = new SellButton(this, current, itemShop,
						playerInventory, 35);

				setSlot(35, current);
				sellButton35.setBounds(339, 72);

				panel3.add(sellButton35.getButton());
				break;
			case 36:
				currentButton++;
				sellButton36 = new SellButton(this, current, itemShop,
						playerInventory, 36);

				setSlot(36, current);
				sellButton36.setBounds(15, 133);

				panel3.add(sellButton36.getButton());
				break;
			case 37:
				currentButton++;
				sellButton37 = new SellButton(this, current, itemShop,
						playerInventory, 37);

				setSlot(37, current);
				sellButton37.setBounds(177, 133);

				panel3.add(sellButton37.getButton());
				break;

			case 38:
				currentButton++;
				sellButton38 = new SellButton(this, current, itemShop,
						playerInventory, 38);

				setSlot(38, current);
				sellButton38.setBounds(339, 133);

				panel3.add(sellButton38.getButton());
				break;

			case 39:
				currentButton++;
				sellButton39 = new SellButton(this, current, itemShop,
						playerInventory, 39);

				setSlot(39, current);
				sellButton39.setBounds(15, 194);

				panel3.add(sellButton39.getButton());
				break;

			case 40:
				currentButton++;
				sellButton40 = new SellButton(this, current, itemShop,
						playerInventory, 40);

				setSlot(40, current);
				sellButton40.setBounds(177, 194);

				panel3.add(sellButton40.getButton());
				break;
			case 41:
				currentButton++;
				sellButton41 = new SellButton(this, current, itemShop,
						playerInventory, 41);

				setSlot(41, current);
				sellButton41.setBounds(339, 194);

				panel3.add(sellButton41.getButton());
				break;

			case 42:
				currentButton++;
				sellButton42 = new SellButton(this, current, itemShop,
						playerInventory, 42);

				setSlot(42, current);
				sellButton42.setBounds(15, 255);

				panel3.add(sellButton42.getButton());
				break;

			case 43:
				currentButton++;
				sellButton43 = new SellButton(this, current, itemShop,
						playerInventory, 43);

				setSlot(43, current);
				sellButton43.setBounds(177, 255);

				panel3.add(sellButton43.getButton());
				break;
			case 44:
				currentButton++;
				sellButton44 = new SellButton(this, current, itemShop,
						playerInventory, 44);

				setSlot(44, current);
				sellButton44.setBounds(339, 255);

				panel3.add(sellButton44.getButton());
				break;
			default:
				break;
			}
		}

		for (int j = currentButton; j < available.length; j++) {
			switch (j) {

			case 0:

				SellButton sellButton0 = new SellButton(this, itemShop, 0);
				setSlot(0, null);
				sellButton0.setBounds(15, 11);
				panel1.add(sellButton0.getButton());
				break;

			case 1:

				sellButton1 = new SellButton(this, itemShop, 1);
				setSlot(1, null);
				sellButton1.setBounds(177, 11);
				panel1.add(sellButton1.getButton());
				break;
			case 2:

				sellButton2 = new SellButton(this, itemShop, 2);
				setSlot(1, null);
				sellButton2.setBounds(339, 11);
				panel1.add(sellButton2.getButton());
				break;

			case 3:

				sellButton3 = new SellButton(this, itemShop, 3);
				setSlot(3, null);
				sellButton3.setBounds(15, 72);
				panel1.add(sellButton3.getButton());
				break;

			case 4:

				sellButton4 = new SellButton(this, itemShop, 4);
				setSlot(4, null);
				sellButton4.setBounds(177, 72);
				panel1.add(sellButton4.getButton());
				break;

			case 5:

				sellButton5 = new SellButton(this, itemShop, 5);
				setSlot(5, null);
				sellButton5.setBounds(339, 72);
				panel1.add(sellButton5.getButton());
				break;
			case 6:

				sellButton6 = new SellButton(this, itemShop, 6);
				setSlot(6, null);
				sellButton6.setBounds(15, 133);
				panel1.add(sellButton6.getButton());
				break;

			case 7:

				sellButton7 = new SellButton(this, itemShop, 7);
				setSlot(7, null);
				sellButton7.setBounds(177, 133);
				panel1.add(sellButton7.getButton());
				break;
			case 8:

				sellButton8 = new SellButton(this, itemShop, 8);
				setSlot(8, null);
				sellButton8.setBounds(339, 133);
				panel1.add(sellButton8.getButton());
				break;

			case 9:

				sellButton9 = new SellButton(this, itemShop, 9);
				setSlot(9, null);
				sellButton9.setBounds(15, 194);
				panel1.add(sellButton9.getButton());
				break;

			case 10:

				sellButton10 = new SellButton(this, itemShop, 10);
				setSlot(10, null);
				sellButton10.setBounds(177, 194);
				panel1.add(sellButton10.getButton());
				break;
			case 11:

				sellButton11 = new SellButton(this, itemShop, 11);
				setSlot(11, null);
				sellButton11.setBounds(339, 194);
				panel1.add(sellButton11.getButton());
				break;

			case 12:

				sellButton12 = new SellButton(this, itemShop, 12);
				setSlot(12, null);
				sellButton12.setBounds(15, 255);
				panel1.add(sellButton12.getButton());
				break;

			case 13:

				sellButton13 = new SellButton(this, itemShop, 13);
				setSlot(13, null);
				sellButton13.setBounds(177, 255);
				panel1.add(sellButton13.getButton());
				break;

			case 14:

				sellButton14 = new SellButton(this, itemShop, 14);
				setSlot(14, null);
				sellButton14.setBounds(339, 255);
				panel1.add(sellButton14.getButton());
				break;

			case 15:

				sellButton15 = new SellButton(this, itemShop, 15);
				setSlot(15, null);
				sellButton15.setBounds(15, 11);
				panel2.add(sellButton15.getButton());
				break;

			case 16:

				sellButton16 = new SellButton(this, itemShop, 16);
				setSlot(16, null);
				sellButton16.setBounds(177, 11);
				panel2.add(sellButton16.getButton());
				break;

			case 17:

				sellButton17 = new SellButton(this, itemShop, 17);
				setSlot(17, null);
				sellButton17.setBounds(339, 11);
				panel2.add(sellButton17.getButton());
				break;

			case 18:

				sellButton18 = new SellButton(this, itemShop, 18);
				setSlot(18, null);
				sellButton18.setBounds(15, 72);
				panel2.add(sellButton18.getButton());
				break;

			case 19:

				sellButton19 = new SellButton(this, itemShop, 19);
				setSlot(19, null);
				sellButton19.setBounds(177, 72);
				panel2.add(sellButton19.getButton());
				break;

			case 20:

				sellButton20 = new SellButton(this, itemShop, 20);
				setSlot(20, null);
				sellButton20.setBounds(339, 72);
				panel2.add(sellButton20.getButton());
				break;

			case 21:

				sellButton21 = new SellButton(this, itemShop, 21);
				setSlot(21, null);
				sellButton21.setBounds(15, 133);
				panel2.add(sellButton21.getButton());
				break;

			case 22:

				sellButton22 = new SellButton(this, itemShop, 22);
				setSlot(22, null);
				sellButton22.setBounds(177, 133);
				panel2.add(sellButton22.getButton());
				break;
			case 23:

				sellButton23 = new SellButton(this, itemShop, 23);
				setSlot(23, null);
				sellButton23.setBounds(339, 133);
				panel2.add(sellButton23.getButton());
				break;
			case 24:

				sellButton24 = new SellButton(this, itemShop, 24);
				setSlot(24, null);
				sellButton24.setBounds(15, 194);
				panel2.add(sellButton24.getButton());
				break;

			case 25:

				sellButton25 = new SellButton(this, itemShop, 25);
				setSlot(25, null);
				sellButton25.setBounds(177, 194);
				panel2.add(sellButton25.getButton());
				break;
			case 26:

				sellButton26 = new SellButton(this, itemShop, 26);
				setSlot(26, null);
				sellButton26.setBounds(339, 194);
				panel2.add(sellButton26.getButton());
				break;

			case 27:

				sellButton27 = new SellButton(this, itemShop, 27);
				setSlot(27, null);
				sellButton27.setBounds(15, 255);
				panel2.add(sellButton27.getButton());
				break;

			case 28:

				sellButton28 = new SellButton(this, itemShop, 28);
				setSlot(28, null);
				sellButton28.setBounds(177, 255);
				panel2.add(sellButton28.getButton());
				break;

			case 29:

				sellButton29 = new SellButton(this, itemShop, 29);
				setSlot(29, null);
				sellButton29.setBounds(339, 255);
				panel2.add(sellButton29.getButton());
				break;

			case 30:

				sellButton30 = new SellButton(this, itemShop, 30);
				setSlot(30, null);
				sellButton30.setBounds(15, 11);
				panel3.add(sellButton30.getButton());
				break;
			case 31:

				sellButton31 = new SellButton(this, itemShop, 31);
				setSlot(31, null);
				sellButton31.setBounds(177, 11);
				panel3.add(sellButton31.getButton());
				break;

			case 32:

				sellButton32 = new SellButton(this, itemShop, 32);
				setSlot(32, null);
				sellButton32.setBounds(339, 11);
				panel3.add(sellButton32.getButton());
				break;

			case 33:

				sellButton33 = new SellButton(this, itemShop, 33);
				setSlot(33, null);
				sellButton33.setBounds(15, 72);
				panel3.add(sellButton33.getButton());
				break;

			case 34:

				sellButton34 = new SellButton(this, itemShop, 34);
				setSlot(34, null);
				sellButton34.setBounds(177, 72);
				panel3.add(sellButton34.getButton());
				break;

			case 35:

				sellButton35 = new SellButton(this, itemShop, 35);
				setSlot(35, null);
				sellButton35.setBounds(339, 72);
				panel3.add(sellButton35.getButton());
				break;
			case 36:

				sellButton36 = new SellButton(this, itemShop, 36);
				setSlot(36, null);
				sellButton36.setBounds(15, 133);
				panel3.add(sellButton36.getButton());
				break;
			case 37:

				sellButton37 = new SellButton(this, itemShop, 37);
				setSlot(37, null);
				sellButton37.setBounds(177, 133);
				panel3.add(sellButton37.getButton());
				break;

			case 38:

				sellButton38 = new SellButton(this, itemShop, 38);
				setSlot(38, null);
				sellButton38.setBounds(339, 133);
				panel3.add(sellButton38.getButton());
				break;

			case 39:

				sellButton39 = new SellButton(this, itemShop, 39);
				setSlot(39, null);
				sellButton39.setBounds(15, 194);
				panel3.add(sellButton39.getButton());
				break;

			case 40:

				sellButton40 = new SellButton(this, itemShop, 40);
				setSlot(40, null);
				sellButton40.setBounds(177, 194);
				panel3.add(sellButton40.getButton());
				break;
			case 41:

				sellButton41 = new SellButton(this, itemShop, 41);
				setSlot(41, null);
				sellButton41.setBounds(339, 194);
				panel3.add(sellButton41.getButton());
				break;

			case 42:

				sellButton42 = new SellButton(this, itemShop, 42);
				setSlot(42, null);
				sellButton42.setBounds(15, 255);
				panel3.add(sellButton42.getButton());
				break;

			case 43:

				sellButton43 = new SellButton(this, itemShop, 43);
				setSlot(43, null);
				sellButton43.setBounds(177, 255);
				panel3.add(sellButton43.getButton());
				break;
			case 44:

				sellButton44 = new SellButton(this, itemShop, 44);
				setSlot(44, null);
				sellButton44.setBounds(339, 255);
				panel3.add(sellButton44.getButton());
				break;
			default:
				break;
			}
		}
		contentPanel.setVisible(true);
		contentPanel.setAlwaysOnTop(true);
	}// ----- End Sell Items -----//

	/**
	 * 
	 * @param index index of slot
	 * @param i Item to be placed in slot, or null for empty slot
	 */
	public void setSlot(int index, Item i) {
		available[index] = i;
	}

	/**
	 * 
	 * @param slot index location in availble[]
	 * @return item in slot
	 */
	public Item getItem(int slot) {
		return available[slot];
	}

	/**
	 * 
	 * @param shopInv
	 *            shop inventory to be implemented. sets the shop inventory in
	 *            the parameter to the inventory the GUI has.
	 */
	public void receiveInventoryData(ArrayList<Item> shopInv) {
		shopInventory = shopInv;
		numItems = shopInventory.size();
	}

	/**
	 * 
	 * @return slot location of next available free slot
	 */
	public int findNextAvailable() {

		for (int i = 0; i < available.length; i++) {
			if (available[i] != null) {

			} else {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param index location of button
	 * @param itemm Item to be placed in button
	 */
	public void setButton(int index, Item itemm) {

		switch (index) {
		case 0:
			sellButton0.setButton(itemm);
			break;
		case 1:
			sellButton1.setButton(itemm);
			break;
		case 2:
			sellButton2.setButton(itemm);
			break;
		case 3:
			sellButton3.setButton(itemm);
			break;
		case 4:
			sellButton4.setButton(itemm);
			break;
		case 5:
			sellButton5.setButton(itemm);
			break;
		case 6:
			sellButton6.setButton(itemm);
			break;
		case 7:
			sellButton7.setButton(itemm);
			break;
		case 8:
			sellButton8.setButton(itemm);
			break;
		case 9:
			sellButton9.setButton(itemm);
			break;
		case 10:
			sellButton10.setButton(itemm);
			break;
		case 11:
			sellButton11.setButton(itemm);
			break;
		case 12:
			sellButton12.setButton(itemm);
			break;
		case 13:
			sellButton13.setButton(itemm);
			break;
		case 14:
			sellButton14.setButton(itemm);
			break;
		case 15:
			sellButton15.setButton(itemm);
			break;
		case 16:
			sellButton16.setButton(itemm);
			break;
		case 17:
			sellButton17.setButton(itemm);
			break;
		case 18:
			sellButton18.setButton(itemm);
			break;
		case 19:
			sellButton19.setButton(itemm);
			break;
		case 20:
			sellButton20.setButton(itemm);
			break;
		case 21:
			sellButton21.setButton(itemm);
			break;
		case 22:
			sellButton22.setButton(itemm);
			break;
		case 23:
			sellButton23.setButton(itemm);
			break;
		case 24:
			sellButton24.setButton(itemm);
			break;
		case 25:
			sellButton25.setButton(itemm);
			break;
		case 26:
			sellButton26.setButton(itemm);
			break;
		case 27:
			sellButton27.setButton(itemm);
			break;
		case 28:
			sellButton28.setButton(itemm);
			break;
		case 29:
			sellButton29.setButton(itemm);
			break;
		case 30:
			sellButton30.setButton(itemm);
			break;
		case 31:
			sellButton31.setButton(itemm);
			break;
		case 32:
			sellButton32.setButton(itemm);
			break;
		case 33:
			sellButton33.setButton(itemm);
			break;
		case 34:
			sellButton34.setButton(itemm);
			break;
		case 35:
			sellButton35.setButton(itemm);
			break;
		case 36:
			sellButton36.setButton(itemm);
			break;
		case 37:
			sellButton37.setButton(itemm);
			break;
		case 38:
			sellButton38.setButton(itemm);
			break;
		case 39:
			sellButton39.setButton(itemm);
			break;
		case 40:
			sellButton40.setButton(itemm);
			break;
		case 41:
			sellButton41.setButton(itemm);
			break;
		case 42:
			sellButton42.setButton(itemm);
			break;
		case 43:
			sellButton43.setButton(itemm);
			break;
		case 44:
			sellButton44.setButton(itemm);
			break;
		default:

		}
	}

	/**
	 * refreshes neutrons when item is bought, sold, or weapon or armor is upgraded
	 */
	public void setNeutrons() {
		currentNeutrons
				.setText(Integer.toString(currentPlayer.getNeutronNum()));
	}

	/**
	 * 
	 * @return available list
	 */
	public Item[] getAvailable() {
		return this.available;
	}

}
