
import javax.swing.*;

import org.apache.log4j.Logger;

import java.awt.event.*;
public class AdminFunctionPage implements ActionListener {

	
	private JLabel HydeA;
	private JFrame frameA;
	private JPanel PanelA;
	private JButton CreateAcc,DeleteAcc,UpdateAcc,ViewAcc,Logout;
	String TempUser = null;
	static final Logger log = Logger.getLogger(AdminFunctionPage.class);
	public void  AdminControl(){
		frameA = new JFrame("AdminOptions");
		frameA.setSize(800,800);
		frameA.setLocation(600, 200);
		frameA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameA.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameA.setResizable(false);
		//frameAcreate.setLayout(new GridLayout(0,3));
		PanelA = new JPanel();
		frameA.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde5.jpg")));
		HydeA = new JLabel();
		frameA.add(HydeA);
		
		CreateAcc = new JButton("Create Employee Account");
		CreateAcc.setBounds(300,150,200,40);
		DeleteAcc = new JButton("Delete Employee Account");
		DeleteAcc.setBounds(300,250,200,40);
		UpdateAcc = new JButton("Update Employee Account");
		UpdateAcc.setBounds(300,350,200,40);
		ViewAcc = new JButton("View Employee Account");
		ViewAcc.setBounds(300,450,200,40);
		Logout = new JButton("Logout");
		Logout.setBounds(300,550,200,40);
		frameA.add(CreateAcc);
		frameA.add(DeleteAcc);
		frameA.add(UpdateAcc);
		frameA.add(ViewAcc);
		frameA.add(Logout);
		frameA.add(PanelA);
		
		CreateAcc.setActionCommand("CREATE");
		DeleteAcc.setActionCommand("DELETE");
		UpdateAcc.setActionCommand("UPDATE");
		Logout.setActionCommand("LOGOUT");
		ViewAcc.setActionCommand("VIEW");
		
		CreateAcc.addActionListener(this);
		DeleteAcc.addActionListener(this);
		UpdateAcc.addActionListener(this);
		ViewAcc.addActionListener(this);
		Logout.addActionListener(this);
		
		frameA.setVisible(true);
		
		
		//
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e){
		 //new AdminControl();
		if(e.getActionCommand()=="CREATE"){
			frameA.setVisible(false);
			log.info("Creating Employee Account\n");
			AdminCreate Create = new AdminCreate();
			Create.AdminPageCreate();
		}
		if(e.getActionCommand()=="DELETE"){
			frameA.setVisible(false);
			log.info("Deleting a Current Employee Account\n");
			AdminDelete Delete = new AdminDelete();
			Delete.AdminPageDelete();
			
		}
		if(e.getActionCommand()=="UPDATE"){
			frameA.setVisible(false);
			log.info("Admin - Updating Employee Account\n");
			AdminUpdate Update = new AdminUpdate();
			Update.AdminPageUpdate(1,TempUser);
			
		}
		if(e.getActionCommand()=="VIEW"){
			frameA.setVisible(false);
			log.info("Viewed Employee Table\n");
			AdminViewEmp View = new AdminViewEmp();
			View.AdminEmpView();
		}
		if(e.getActionCommand()=="LOGOUT"){
			int dialogButton = JOptionPane.YES_NO_OPTION;
			dialogButton=JOptionPane.showConfirmDialog (null, "Do you want to Logout?","Warning",dialogButton);
			if(dialogButton ==JOptionPane.YES_OPTION){
				frameA.setVisible(false);
				log.info("Admin logged out\n");
				Window Log = new Window();
				Log.WindowMenu();
			}
		}
		//System.out.println("TEST2"+ e.getActionCommand());
		/*if(e.getActionCommand()=="LOGIN"){
			
			String username = getUserName();
			char[] password =getPass();
	         JOptionPane.showMessageDialog(null, username);
	        JOptionPane.showMessageDialog(null, password);
	        System.out.println("Username = "+ username);
			//System.out.println("Password = "+password[0]+password[1]+password[2]+password[3]);
			if(username.equals("admin") && new String(password).equals("123")){
				JOptionPane.showMessageDialog(null, "ADMIN LOGIN SUCCESSFUL");
				//frameW.setVisible(false);
				frameA.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "PLEASE CHECK YOUR USERNAME AND PASSWORD");
			}
			
		}//end of login action command*/
		
	}//actionperformed end
	
	

}
