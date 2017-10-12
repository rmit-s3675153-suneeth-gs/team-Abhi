import javax.swing.*;

import org.apache.log4j.Logger;

import java.awt.Color;
import java.awt.event.*;
public class VisitorMap implements ActionListener {
	private JFrame frameV;
	private JButton Back;
	private JLabel Label;
	static final Logger log = Logger.getLogger(VisitorMap.class);
	public VisitorMap() {
		// TODO Auto-generated constructor stub
	}

	public void VisMap() {
		// TODO Auto-generated method stub
		frameV = new JFrame("HYDEPARK MAP");
		frameV.setSize(1850, 850);
		frameV.setLocation(50, 80);
		frameV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameV.setContentPane(new JLabel(new ImageIcon("E://hydepark/hydeMap.jpg")));
		frameV.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameV.setResizable(false);
		Label = new JLabel();
		Back = new JButton("Back to Visitor Page");
		Back.setBackground(Color.white);
		Back.setContentAreaFilled(true);
		Back.setBounds(1600, 300, 200, 40);
		frameV.add(Label);
		frameV.add(Back);
		
		Back.setActionCommand("Back");
		Back.addActionListener(this);
		frameV.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="Back"){
			frameV.setVisible(false);
			log.info(" Back to Visitor Page \n");
			NormalUserPage NUP = new NormalUserPage();
			NUP.NormalUser();
		}
		
	}

}
