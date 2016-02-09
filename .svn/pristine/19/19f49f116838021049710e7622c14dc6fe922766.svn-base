package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ctrl.Controller;
import ctrl.Game;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTextPane;

public class ConfigFrame extends JFrame implements ActionListener {
	private static final int NUM_BOARDS = 3;
	private Controller ctrl;
	private JTextField txtCharactername;
	private JTextField txtBoardSize;
	private JPanel contentPane, buttonPane = new JPanel();
	private JLabel lblSelectDifficulty;
	private ButtonGroup diffButtonGroup = new ButtonGroup();
	private JRadioButton rdbtnEasy, rdbtnMedium, rdbtnHard;
	private JButton btnGo;

	/**
	 * Create the frame.
	 */
	public ConfigFrame(Controller c) {
		super("Configure");
		this.ctrl = c;
		c.setGame(null);
		
		contentPane = new JPanel();
		getContentPane().add(contentPane);

		BoxLayout boxLayout1 = new BoxLayout(buttonPane, BoxLayout.X_AXIS);
		BoxLayout boxLayout2 = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
		contentPane.setLayout(boxLayout2);

		txtCharactername = new JTextField();
		txtCharactername.setText("Character Name");
		txtCharactername.setColumns(10);

		txtBoardSize = new JTextField("Board Size");

		lblSelectDifficulty = new JLabel("Select Difficulty:");

		rdbtnEasy = new JRadioButton("Easy");
		rdbtnMedium = new JRadioButton("Medium");
		rdbtnHard = new JRadioButton("Hard");

		diffButtonGroup.add(rdbtnEasy);
		diffButtonGroup.add(rdbtnMedium);
		diffButtonGroup.add(rdbtnHard);

		btnGo = new JButton("GO!");

		contentPane.add(txtCharactername);
		contentPane.add(txtBoardSize);
		contentPane.add(lblSelectDifficulty);

		buttonPane.setLayout(boxLayout1);

		buttonPane.add(rdbtnEasy);
		buttonPane.add(rdbtnMedium);
		buttonPane.add(rdbtnHard);

		contentPane.add(buttonPane);
		contentPane.add(btnGo);
		btnGo.addActionListener(this);

		setSize(300, 150);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("GO!")) {
			boolean fail = false;
			int diff = 1;
			int size = 0;

			if (rdbtnEasy.isSelected()) {
				diff = 0;
			} else if (rdbtnHard.isSelected()) {
				diff = 2;
			}
			try {
				size = Integer.parseInt(txtBoardSize.getText());
			} catch (Exception err) {
				fail = true;
				txtBoardSize.setText("NOT VALID");
			}

			if (size < 5 || size > 30){
				fail = true;
				txtBoardSize.setText("NOT VALID");
			}
				

			if (!fail) {
				this.ctrl.setGame(new Game(txtCharactername.getText(),
						NUM_BOARDS, size, diff, ctrl));

				ctrl.getGame().getPlayer().setGame(ctrl.getGame());

				ctrl.getGmWindow().onGameInit();

				dispose();
			}

		}

	}

}
