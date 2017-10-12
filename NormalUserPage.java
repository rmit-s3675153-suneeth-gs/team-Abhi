
import java.awt.event.*;
import javax.swing.*;

import org.apache.log4j.Logger;

public class NormalUserPage implements ActionListener {
	private JFrame User;
	private JPanel Pan;
	private JLabel Label;
	private JButton Map,OpenClos,Parking,Contact,Back,PayInfo;
	static final Logger log = Logger.getLogger(NormalUserPage.class);
	
	public NormalUserPage() {
		// TODO Auto-generated constructor stub
	}
	public void NormalUser(){
		
		User= new JFrame("Visitor");
		User.setVisible(true);
		User.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		User.setSize(700,700);
		User.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde8.jpg")));
		User.setLocation(600,200 );
		User.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		User.setResizable(false);
		//User.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde8.jpg")));
		Label = new JLabel();
		Pan = new JPanel();
		
		Map = new JButton("Map of Hyde Park");
		Map.setBounds(250, 50, 200, 40);
		Map.setOpaque(true);
		
		OpenClos = new JButton("Opening and Closing Time");
		OpenClos.setBounds(250, 150, 200, 40);
		OpenClos.setOpaque(true);
		
		Parking  = new JButton("Parking Facilities");
		Parking.setBounds(250, 250, 200, 40);
		Parking.setOpaque(true);
		
		Contact	 = new JButton("Contact Person-Incidents");
		Contact.setBounds(250, 350, 200, 40);
		Contact.setOpaque(true);
		
		PayInfo = new JButton("Pay and Display Information");
		PayInfo.setBounds(250, 450, 200, 40);
		PayInfo.setOpaque(true);
		
		Back = new JButton("Back to Main Page");
		Back.setBounds(250, 550, 200, 40);
		Back.setOpaque(true);
		//User.setBackground(Color.GREEN);
		User.add(Map);
		User.add(OpenClos);
		User.add(Parking);
		User.add(Contact);
		User.add(PayInfo);
		User.add(Back);
		
//		Pan.add(Map);
//		Pan.add(OpenClos);
//		Pan.add(Parking);
//		Pan.add(Contact);
//		Pan.add(Back);
//		Pan.add(comp, constraints);
		
		User.add(Pan);
		//JLabel Label = new JLabel("You clicked me !");
		User.add(Label);
		
		Map.setActionCommand("MAP");
		OpenClos.setActionCommand("OPENCLOSE");
		Parking.setActionCommand("PARKING");
		Contact.setActionCommand("CONTACT");
		PayInfo.setActionCommand("PAYINFO");
		Back.setActionCommand("BACK");
		
		Map.addActionListener(this);
		OpenClos.addActionListener(this);
		Parking.addActionListener(this);
		Contact.addActionListener(this);
		PayInfo.addActionListener(this);
		Back.addActionListener(this);
		
		User.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="MAP"){
			User.setVisible(false);
        	log.info("Map of Hyde Park invoked\n");
			VisitorMap VM = new VisitorMap();
			VM.VisMap();
			
		}
		if(e.getActionCommand()=="OPENCLOSE"){
			User.setVisible(false);
			log.info("Open Closing time invoked\n");
			OpenCloseTime OC = new OpenCloseTime();
			OC.OpenClose();
			
		}
		if(e.getActionCommand()=="PARKING"){
			User.setVisible(false);
			log.info("Parking Function is called\n");
			ParkingVisitor PV = new ParkingVisitor();
			PV.Parking();
	
		}
		if(e.getActionCommand()=="CONTACT"){
			User.setVisible(false);
			log.info("Contacting Guards is invoked\n");
			VisContactGuard VCG = new VisContactGuard();
			VCG.ContactGuard();
	
		}
		if(e.getActionCommand()=="PAYINFO"){
			User.setVisible(false);
			log.info("Payement information is called\n");
			PayDisplayInformation PI= new PayDisplayInformation();
			PI.PayDispInf();
			
		}
		if(e.getActionCommand()=="BACK"){
			User.setVisible(false);
			log.info("Back to Main Page\n");
			Window win = new Window();
			win.WindowMenu();
	
		}
	}

}
