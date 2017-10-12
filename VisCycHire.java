import javax.swing.*;

import org.apache.log4j.Logger;

import java.awt.Color;
import java.awt.event.*;
public class VisCycHire implements ActionListener {
	private JFrame frameVCH;
	private JLabel Label;
	private JButton Back;
	static final Logger log = Logger.getLogger(VisCycHire.class);
	public VisCycHire() {
		// TODO Auto-generated constructor stub
	}

	public void CycHireView() {
		// TODO Auto-generated method stub
		frameVCH = new JFrame("CYCLE HIRE MAP");
		frameVCH.setSize(1200, 600);
		frameVCH.setLocation(50, 80);
		frameVCH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameVCH.setContentPane(new JLabel(new ImageIcon("E://hydepark/hydecyclehire.jpg")));
		frameVCH.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameVCH.setResizable(false);
		Label = new JLabel();
		Back = new JButton("Back to Parking Page");
		Back.setBackground(Color.white);
		Back.setContentAreaFilled(true);
		Back.setBounds(100, 50, 200, 40);
		frameVCH.add(Label);
		frameVCH.add(Back);
		
		Back.setActionCommand("Back");
		Back.addActionListener(this);
		frameVCH.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="Back"){
			frameVCH.setVisible(false);
			log.info(" Back to Visitor Parking \n");
			ParkingVisitor NUP = new ParkingVisitor();
			NUP.Parking();
		}
		
		
	}
		
}

	

