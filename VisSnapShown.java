import javax.swing.*;

import org.apache.log4j.Logger;

import java.awt.event.*;
public class VisSnapShown implements ActionListener {
	private JFrame frameVSS;
	private JPanel PanelVSS;
	private JButton Close;
	private JLabel label;
	String Emp;
	static final Logger log = Logger.getLogger(VisSnapShown.class);
	public VisSnapShown() {
		// TODO Auto-generated constructor stub
	}
	
	public void SnapShown(String User) {
		// TODO Auto-generated method stub
		Emp=User;
		frameVSS = new JFrame("SNAPSHOT OF EMPLOYEE");
		frameVSS.setSize(700,700);
		frameVSS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameVSS.setContentPane(new JLabel(new ImageIcon("E://hyde_employee/"+Emp+".jpg")));
		label = new JLabel();
		frameVSS.setResizable(false);
		frameVSS.add(label);
		
		PanelVSS = new JPanel();
		
		Close = new JButton("CLOSE");
		Close.setBounds(250, 1, 150, 40);
		
		frameVSS.add(Close);
		frameVSS.add(PanelVSS);
		Close.setActionCommand("CLOSE");
		Close.addActionListener(this);
		frameVSS.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="CLOSE"){
			frameVSS.setVisible(false);
			log.info("Back to Contact Guard Menu");
			VisContactGuard VCG = new VisContactGuard();
			VCG.ContactGuard();
		}
		
	}

	

}
