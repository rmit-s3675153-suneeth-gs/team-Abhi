import javax.swing.*;

import org.apache.log4j.Logger;

import java.awt.Color;
import java.awt.event.*;
public class VisDisPark implements ActionListener {
	private JFrame frameVDP;
	private JButton Back;
	private JLabel Label;
	static final Logger log = Logger.getLogger(VisDisPark.class);
	public VisDisPark() {
		// TODO Auto-generated constructor stub
	}

	public void DisParkView() {
		// TODO Auto-generated method stub
		frameVDP = new JFrame("CYCLEPARK MAP");
		frameVDP.setSize(1200, 600);
		frameVDP.setLocation(50, 80);
		frameVDP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameVDP.setContentPane(new JLabel(new ImageIcon("E://hydepark/hydedispark.jpg")));
		frameVDP.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameVDP.setResizable(false);
		Label = new JLabel();
		Back = new JButton("Back to Parking Page");
		Back.setBackground(Color.white);
		Back.setContentAreaFilled(true);
		Back.setBounds(100, 50, 200, 40);
		frameVDP.add(Label);
		frameVDP.add(Back);
		
		Back.setActionCommand("Back");
		Back.addActionListener(this);
		frameVDP.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="Back"){
			frameVDP.setVisible(false);
			log.info(" Back to Visitor Parking \n");
			ParkingVisitor NUP = new ParkingVisitor();
			NUP.Parking();
		}
		
		
	}
		
	

}
