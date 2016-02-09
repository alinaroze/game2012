package gui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ctrl.Controller;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class MovePanel extends JPanel implements ActionListener {
private Controller ctrl;
private	JButton btnN, btnS, btnE, btnW;

	public MovePanel(Controller c) {
		ctrl = c;
		setLayout(new GridLayout(4, 4, 0, 0));
		
		btnN = new JButton("N");
		btnN.addActionListener(this);

		btnW = new JButton("W");
		btnW.addActionListener(this);

		btnE = new JButton("E");
		btnE.addActionListener(this);

		btnS = new JButton("S");
		btnS.addActionListener(this);

		add(new JPanel());
		add(btnN);
		add(new JPanel());//
		add(btnW);
		add(new JPanel());
		add(btnE);//
		add(new JPanel());
		add(btnS);
		add(new JPanel());//
		

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(ctrl.isMoveable()){
		int dy = 0, dx = 0;
		if(e.getActionCommand().equals("N"))
			dy = 1;
		if(e.getActionCommand().equals("E"))
			dx = 1;
		if(e.getActionCommand().equals("W"))
			dx = -1;
		if(e.getActionCommand().equals("S"))
			dy = -1;
	
ctrl.move(dy, dx);
		}
	}

}
