import javax.swing.*;

import org.apache.log4j.Logger;

import java.awt.event.*;

public class ParkingVisitor implements ActionListener {
	private JFrame framePV;
	private JLabel Hyde;
	private JPanel PanelPV;
	private JButton Car,DisCar,CyclePark,CycleHire,Back;
	static final Logger log = Logger.getLogger(ParkingVisitor.class);

	public ParkingVisitor() {
		// TODO Auto-generated constructor stub
	}

	public void Parking() {
		// TODO Auto-generated method stub
		
		framePV = new JFrame("PARKING-HIRE");
		framePV.setSize(800, 800);
		framePV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePV.setLocation(600, 150);
		framePV.setContentPane(new JLabel(new ImageIcon("E://hydepark/hyde7.jpg")));
		Hyde = new JLabel();
		framePV.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		framePV.setResizable(false);
		
		
		PanelPV = new JPanel();
		Car = new JButton("Car Parking Map");
		Car.setBounds(300, 100, 200, 40);
		Car.setOpaque(true);
		
		DisCar = new JButton("Disabled Parking Map");
		DisCar.setBounds(300, 200, 200, 40);
		DisCar.setOpaque(true);
		
		CyclePark  = new JButton("Cycle Parking Map");
		CyclePark.setBounds(300, 300, 200, 40);
		CyclePark.setOpaque(true);
		
		CycleHire	 = new JButton("Cycle Hire Map");
		CycleHire.setBounds(300, 400, 200, 40);
		CycleHire.setOpaque(true);
		
		Back = new JButton("Back to Visitor Page");
		Back.setBounds(300, 500, 200, 40);
		Back.setOpaque(true);
		
		Car.setActionCommand("CAR");
		DisCar.setActionCommand("DISABLED");
		CyclePark.setActionCommand("CYCLEPARK");
		CycleHire.setActionCommand("CYCLEHIRE");
		Back.setActionCommand("BACK");
		
		framePV.add(Hyde);
		framePV.add(Car);
		framePV.add(DisCar);
		framePV.add(CyclePark);
		framePV.add(CycleHire);
		framePV.add(Back);
		framePV.add(PanelPV);
		
		Car.addActionListener(this);
		DisCar.addActionListener(this);
		CyclePark.addActionListener(this);
		CycleHire.addActionListener(this);
		Back.addActionListener(this);
		
		framePV.setVisible(true);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="CAR"){
			framePV.setVisible(false);
			log.info("Car Parking Map\n");
			VisCarPark CP = new VisCarPark();
			CP.ParkingView();
			
		}
		if(e.getActionCommand()=="DISABLED"){
			framePV.setVisible(false);
			log.info("Disabled Parking Map\n");
			VisDisPark CP = new VisDisPark();
			CP.DisParkView();
			
		}
		if(e.getActionCommand()=="CYCLEPARK"){
			framePV.setVisible(false);
			log.info("Cycle Parking Map \n");
			VisCycPark CP = new VisCycPark();
			CP.CycParkView();
	
		}
		if(e.getActionCommand()=="CYCLEHIRE"){
			framePV.setVisible(false);
			log.info("CycleHire Map\n");
			VisCycHire CP = new VisCycHire();
			CP.CycHireView();
	
		}
		if(e.getActionCommand()=="BACK"){
			framePV.setVisible(false);
			log.info("Back to Visitor Page\n");
			NormalUserPage NUP = new NormalUserPage();
			NUP.NormalUser();
	
		}
		
	}

}
