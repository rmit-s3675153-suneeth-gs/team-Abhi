import javax.swing.*;

import org.apache.log4j.Logger;

import java.awt.Color;
import java.awt.event.*;
public class VisCycPark implements ActionListener{
	private JFrame frameVCyP;
	private JLabel Label;
	private JButton Back;
	static final Logger log = Logger.getLogger(VisCycPark.class);

	public VisCycPark() {
		// TODO Auto-generated constructor stub
	}

	public void CycParkView() {
		// TODO Auto-generated method stub
		frameVCyP = new JFrame("CYCLEPARK MAP");
		frameVCyP.setSize(1200, 600);
		frameVCyP.setLocation(50, 80);
		frameVCyP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameVCyP.setContentPane(new JLabel(new ImageIcon("E://hydepark/hydecyclepark.jpg")));
		frameVCyP.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameVCyP.setResizable(false);
		Label = new JLabel();
		Back = new JButton("Back to Parking Page");
		Back.setBackground(Color.white);
		Back.setContentAreaFilled(true);
		Back.setBounds(100, 50, 200, 40);
		frameVCyP.add(Label);
		frameVCyP.add(Back);
		
		Back.setActionCommand("Back");
		Back.addActionListener(this);
		frameVCyP.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="Back"){
			frameVCyP.setVisible(false);
			log.info(" Back to Visitor Parking \n");
			ParkingVisitor NUP = new ParkingVisitor();
			NUP.Parking();
		}
		
		
	}
		
	

}
