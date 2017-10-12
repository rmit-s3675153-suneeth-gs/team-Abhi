import javax.swing.*;

import org.apache.log4j.Logger;

import java.awt.Color;
import java.awt.event.*;
public class VisCarPark implements ActionListener{
	private JFrame frameVCP;
	private JButton Back;
	private JLabel Label;
	static final Logger log = Logger.getLogger(VisCarPark.class);

	public VisCarPark() {
		// TODO Auto-generated constructor stub
	}

	public void ParkingView() {
		// TODO Auto-generated method stub
		frameVCP = new JFrame("CAR_PARK MAP");
		frameVCP.setSize(1200, 600);
		frameVCP.setLocation(50, 80);
		frameVCP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameVCP.setContentPane(new JLabel(new ImageIcon("E://hydepark/hydecar.jpg")));
		frameVCP.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameVCP.setResizable(false);
		Label = new JLabel();
		Back = new JButton("Back to Parking Page");
		Back.setBackground(Color.white);
		Back.setContentAreaFilled(true);
		Back.setBounds(100, 50, 200, 40);
		frameVCP.add(Label);
		frameVCP.add(Back);
		
		Back.setActionCommand("Back");
		Back.addActionListener(this);
		frameVCP.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="Back"){
			frameVCP.setVisible(false);
			log.info(" Back to Visitor Parking \n");
			ParkingVisitor PV = new ParkingVisitor();
			PV.Parking();
		}
		
		
	}

}
