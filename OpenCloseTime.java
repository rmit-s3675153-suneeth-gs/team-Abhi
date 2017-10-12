
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.apache.log4j.Logger;

public class OpenCloseTime implements ActionListener {
	private JFrame frameOCT;
	private JPanel PanelOCT;
	private JLabel Label;
	private JLabel Label1,Label2,Label3,Label4,Label5,Label6,Label7,Label8,Label9,Label10,Label11,Label12,Label13,Label14,Label15,Label16;
	private JButton Back;
	static private Logger log = Logger.getLogger(OpenCloseTime.class);
	public OpenCloseTime() {
		// TODO Auto-generated constructor stub
	}
	
	public void OpenClose() {
		// TODO Auto-generated method stub
		frameOCT = new JFrame("OpeningClosingTime");
		frameOCT.setSize(1000,1000);
		frameOCT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameOCT.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameOCT.setResizable(false);
		//frameOCT.setBackground(Color.black);
		PanelOCT = new JPanel();
		//PanelOCT.setBackground(Color.black);
		frameOCT.setContentPane(new JLabel(new ImageIcon("E://hydePark/openclosetime.jpg")));
		Label = new JLabel();
		
		Label1= new JLabel("<HTML><font face=helvetica color=black><font size =7><b>Opening Times</b>");
		Label1.setBounds(100, 10, 800, 70);			
		Label2= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>Hyde Park is open from 5:00 am until midnight all year round.</b>");
		Label2.setBounds(100, 50, 800, 70);	
		Label3= new JLabel("<HTML><font face=helvetica color=black><font size =7><b>Getting to Hyde Park</b>");
		Label3.setBounds(100, 150, 800, 70);	
		Label4= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>Hyde Park is highly accessible by public transport. There are also car parking facilities available but we recommend that visitors avoid coming by car as there are limited places.</b>");
		Label4.setBounds(100, 200, 800, 70);	
		Label5= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>If you are using a mobile device, the postcode for the park is W2 2UH, but note this is for guidance only as the park covers a large area.</b>");
		Label5.setBounds(100, 250, 800, 70);	
		Label6= new JLabel("<HTML><font face=helvetica color=black><font size =7><b>By Tube</b>");
		Label6.setBounds(100, 350, 800, 70);	
		Label7= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>The tube stations that surround Hyde Park are:</b>");
		Label7.setBounds(100, 400, 800, 70);	
		Label8= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>.   Lancaster Gate (Central Line)</b>");
		Label8.setBounds(100, 450, 800, 70);	
		Label9= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>.   Marble Arch (Central Line)</b>");
		Label9.setBounds(100, 500, 800, 70);	
		Label10= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>.  Hyde Park Corner (Piccadilly Line)</b>");
		Label10.setBounds(100, 550, 800, 70);
		Label11= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>.  Knightsbridge (Piccadilly Line)</b>");
		Label11.setBounds(100, 600, 800, 70);
		Label12= new JLabel("<HTML><font face=helvetica color=black><font size =7><b>By Bus</b>");
		Label12.setBounds(100, 700, 800, 70);
		Label13= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>.  North : C2, 6, 7, 10, 16, 19, 23, 36, 52, 73, 82, 98, 113, 274, 390, 414</b>");
		Label13.setBounds(100, 750, 800, 70);
		Label14= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>.  South : 2, 36, 137, 148, 159, 436</b>");
		Label14.setBounds(100, 800, 800, 70);
		Label15= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>.  West  : 9, 10, 14, 19, 22, 52, 74, 94, 148, 414</b>");
		Label15.setBounds(100, 850, 800, 70);
		Label16= new JLabel("<HTML><font face=helvetica color=black><font size =5><b>.  East  : 8,15, 23, 30, 38,274</b>");
		Label16.setBounds(100, 900, 800, 70);
		Back = new JButton("Back to Visitor Menu");
		Back.setBounds(750, 900, 200, 40);
		frameOCT.add(Label);
		frameOCT.add(Label1);
		frameOCT.add(Label2);
		frameOCT.add(Label3);
		frameOCT.add(Label4);
		frameOCT.add(Label5);
		frameOCT.add(Label6);
		frameOCT.add(Label7);
		frameOCT.add(Label8);
		frameOCT.add(Label9);
		frameOCT.add(Label10);
		frameOCT.add(Label11);
		frameOCT.add(Label12);
		frameOCT.add(Label13);
		frameOCT.add(Label14);
		frameOCT.add(Label15);
		frameOCT.add(Label16);
		
		Back.setActionCommand("BACK");
		Back.addActionListener(this);
		frameOCT.add(Back);
		frameOCT.add(PanelOCT);
		frameOCT.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="BACK"){
			frameOCT.setVisible(false);
			log.info("Back to Visitor Menu\n");
			NormalUserPage NUP = new NormalUserPage();
			NUP.NormalUser();
		}
	}

	
}
