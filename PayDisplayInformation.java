
import java.awt.event.*;

import javax.swing.*;

import org.apache.log4j.Logger;
public class PayDisplayInformation implements ActionListener {
	private JFrame framePI;
	private JLabel Label;
	private JLabel Label1,Label2,Label3,Label4,Label5,Label6,Label7,Label8,Label9;
	private JPanel PanelPI;
	private JButton Back;
	static final Logger log = Logger.getLogger(PayDisplayInformation.class);

	public PayDisplayInformation() {
		// TODO Auto-generated constructor stub
	}
	
	public void PayDispInf() {
		// TODO Auto-generated method stub
		framePI = new JFrame("PAY INFO");
		framePI.setSize(1000,1000);
		framePI.setLocation(500, 0);
		framePI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePI.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		framePI.setResizable(false);
		//framePI.setBackground(Color.black);
		PanelPI = new JPanel();
		//PanelPI.setBackground(Color.black);
		framePI.setContentPane(new JLabel(new ImageIcon("E://hydePark/paydisplay.jpg")));
		Label = new JLabel();
		
		Label1= new JLabel("<HTML><font face=helvetica color=black><font size =7><b>PAY AND DISPLAY INFORMATION</b>");
		Label1.setBounds(100, 100, 800, 70);			
		Label2= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>Every day: 8:30 am - 6:30 pm</b>");
		Label2.setBounds(100, 170, 800, 70);	
		Label3= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>Monday - Saturday: £2.40 per hour</b>");
		Label3.setBounds(100, 240, 800, 70);	
		Label4= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>Sunday and Public Holidays: £1.40 per hour (35p per 15 minutes, no maximum stay)</b>");
		Label4.setBounds(100, 310, 800, 70);	
		Label5= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>Disabled badge holders and motor cyclists park free of charge but are subject to 4 hours maximum stay Monday to Saturday.</b>");
		Label5.setBounds(100, 380, 800, 70);	
		Label6= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>No coaches or commercial vehicles.</b>");
		Label6.setBounds(100, 450, 800, 70);	
		Label7= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>Parking on double yellow lines is not permitted at any time. Excess charge: £80; 50% reduction for payment within 14 days.</b>");
		Label7.setBounds(100, 520, 800, 70);	
		Label8= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>In case of difficulties ring 08433 571 557 Monday - Friday during office hours or 07793 697 584 outside these times.</b>");
		Label8.setBounds(100, 590, 800, 70);	
		Label9= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>To pay an Excess Charge Notice call 0845 270 4591, Monday to Friday 9am to 5pm.</b>");
		Label9.setBounds(100, 660, 800, 70);	
		
		Back = new JButton("Back to Visitor Menu");
		Back.setBounds(10, 10, 200, 40);
		framePI.add(Label);
		framePI.add(Label1);
		framePI.add(Label2);
		framePI.add(Label3);
		framePI.add(Label4);
		framePI.add(Label5);
		framePI.add(Label6);
		framePI.add(Label7);
		framePI.add(Label8);
		framePI.add(Label9);
		framePI.add(Back);
		framePI.add(PanelPI);
		
		Back.setActionCommand("BACK");
		Back.addActionListener(this);
		framePI.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="BACK"){
			framePI.setVisible(false);
			log.info("Back to Visitor Page");
			NormalUserPage NUP = new NormalUserPage();
			NUP.NormalUser();
		}
		
	}

}
