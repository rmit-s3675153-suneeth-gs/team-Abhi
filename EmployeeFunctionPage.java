import java.awt.event.*;
import javax.swing.*;

import org.apache.log4j.Logger;
public class EmployeeFunctionPage implements ActionListener {
	private JFrame frameEpage;
	private JPanel PanelEpage;
	private JButton PassChange,Update,Schedule,SnapShot,Logout;
	private JLabel Hyde;
	String TempUser1;
	static private Logger log = Logger.getLogger(EmployeeFunctionPage.class);

	public EmployeeFunctionPage() {
		// TODO Auto-generated constructor stub
	}

	public String EmployeeFunction(String TempUser) {
		
		TempUser1=TempUser;
		// TODO Auto-generated method stub
		frameEpage = new JFrame("EMPLOYEE PAGE");
		frameEpage.setSize(800, 800);
		frameEpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameEpage.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameEpage.setResizable(false);
		
		PanelEpage= new JPanel();
		frameEpage.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde10.gif")));
		Hyde = new JLabel();
		frameEpage.add(Hyde);
		
		PassChange = new JButton("Change Password");
		PassChange.setBounds(300,150,200,40);
		Update = new JButton("Update Details");
		Update.setBounds(300,250,200,40);
		Schedule = new JButton("Duty Schedule");
		Schedule.setBounds(300,350,200,40);
		SnapShot = new JButton("SnapShot");
		SnapShot.setBounds(300,450,200,40);
		Logout = new JButton("Logout");
		Logout.setBounds(300,550,200,40);
		frameEpage.add(PassChange);
		frameEpage.add(Update);
		frameEpage.add(Schedule);
		frameEpage.add(SnapShot);
		frameEpage.add(Logout);	
		frameEpage.add(PanelEpage);
		
		PassChange.setActionCommand("PASS");
		Schedule.setActionCommand("SCHEDULE");
		Update.setActionCommand("UPDATE");
		Logout.setActionCommand("LOGOUT");
		SnapShot.setActionCommand("SNAPSHOT");
		
		frameEpage.setVisible(true);
		PassChange.addActionListener(this);
		Update.addActionListener(this);
		Schedule.addActionListener(this);
		SnapShot.addActionListener(this);
		Logout.addActionListener(this);
		return TempUser1;
	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="PASS"){
			
        	frameEpage.setVisible(false);
        	log.info("Entered Change Password Function - "+TempUser1+"\n");
        	EmployeePass Emp = new EmployeePass();
        	Emp.EmpPass(TempUser1);
            
			
			
		}
		if(e.getActionCommand()=="SCHEDULE"){
			frameEpage.setVisible(false);
			log.info("Entered Change Schedule Function - "+TempUser1+"\n");
			EmployeeSchedule EmpSch = new EmployeeSchedule();
			EmpSch.EmployeeSch(TempUser1);
			
		}
		
		if(e.getActionCommand()=="UPDATE"){
			frameEpage.setVisible(false);
			log.info("Entered Update Details Function - "+TempUser1+"\n");
			AdminUpdate Update = new AdminUpdate();
			Update.AdminPageUpdate(0,TempUser1);// a flag is set as 0 to identify between admin and employee
	
		}

		if(e.getActionCommand()=="LOGOUT"){
			
			int dialogButton = JOptionPane.YES_NO_OPTION;
            dialogButton=JOptionPane.showConfirmDialog (null, "Do you want to Logout?","Warning",dialogButton);
            if(dialogButton == JOptionPane.YES_OPTION){
            	frameEpage.setVisible(false);
            	log.info("Employee - "+TempUser1+" Logged out\n");
            	Window Log = new Window();
            	Log.WindowMenu();
            }
	
		}

		if(e.getActionCommand()=="SNAPSHOT"){
			frameEpage.setVisible(false);
			log.info("Entered Uploading Photo Function - "+TempUser1+"\n");
			EmployeeSnap Snap= new EmployeeSnap();
			Snap.EmpSnap(TempUser1);
			
		
		}

		
	}

}
