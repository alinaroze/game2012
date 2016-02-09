package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ctrl.Controller;
import ctrl.Language;

public class MenuBar extends JMenuBar implements ActionListener {

	private JMenu mnGame, mnSettings, mnDifficulty, mnLanguage;
	private JMenuItem mntmNew, mntmLoad, mntmSave;
	private JCheckBox mntmHard, mntmMedium, mntmEasy;
	private ButtonGroup diffGroup = new ButtonGroup();
	private Language lang;
	 private Controller ctrl;

	public MenuBar(Controller c) {
		super();
		ctrl = c;
		lang = ctrl.getLang();
		mnGame = new JMenu(lang.GAME);
		add(mnGame);

		mntmNew = new JMenuItem(lang.NEW);
		mnGame.add(mntmNew);
		mntmNew.addActionListener(this);

		mntmLoad = new JMenuItem(lang.LOAD);
		mnGame.add(mntmLoad);
		mntmLoad.addActionListener(this);

		// JMenu mnLanguage = new JMenu(lang.LANGUAGE);
		// mnSettings.add(mnLanguage);

		// mntmEnglish = new JMenuItem(lang.ENGLISH);
		// mnLanguage.add(mntmEnglish);
		// mntmEnglish.addActionListener(this);

		// mntmTurkish = new JMenuItem(lang.TURKISH);
		// mnLanguage.add(mntmTurkish);
		// mntmTurkish.addActionListener(this);

		mntmSave = new JMenuItem(lang.SAVE);
		mntmSave.addActionListener(this);
		mnSettings = new JMenu(lang.SETTINGS);
		mnDifficulty = new JMenu(lang.DIFFICULTY);
		mntmHard = new JCheckBox(lang.HARD);
		mntmHard.addActionListener(this);
		mntmMedium = new JCheckBox(lang.MEDIUM);
		mntmMedium.addActionListener(this);
		mntmEasy = new JCheckBox(lang.EASY);
		mntmEasy.addActionListener(this);
		
		mnSettings.add(mnDifficulty);
		diffGroup.add(mntmHard);
		diffGroup.add(mntmMedium);
		diffGroup.add(mntmEasy);
		
		mnDifficulty.add(mntmHard);
		mnDifficulty.add(mntmMedium);
		mnDifficulty.add(mntmEasy);
		
	}

	public void onGameInit() {

		mnGame.add(mntmSave);
		add(mnSettings);

	

	}

	public void onGameOver(){
		mnGame.remove(mntmSave);
		remove(mnSettings);
		
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("New")) {
			ctrl.newGame();
		}
		if (e.getActionCommand().equals("Load")) {
			ctrl.loadGame();
		}
		if (ctrl.hasGame()) {
			if (e.getActionCommand().equals("Save")) {
				ctrl.saveGame();
			}
			if (e.getActionCommand().equals("Easy")) {

				ctrl.getGame().setDifficulty(0);
			}
			if (e.getActionCommand().equals("Medium")) {

				ctrl.getGame().setDifficulty(1);
			}
			if (e.getActionCommand().equals("Hard")) {

				ctrl.getGame().setDifficulty(2);
			}
		}
	}
}
