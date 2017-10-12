import java.sql.*;
import javax.swing.*;

import org.apache.log4j.Logger;

import java.awt.event.*;
public class EmployeePass implements ActionListener {
	private JFrame frameEp;
	private JLabel OldPass,newPass1,newPass2,Hyde;
	private JPasswordField PassOld,PassNew1,PassNew2;
	private JPanel PanelEp;
	private JButton Change,Close;
	String TempOP,TempNP1,TempNP2,TempUser;
	static final Logger log = Logger.getLogger(EmployeePass.class);

	public EmployeePass() {
		// TODO Auto-generated constructor stub
	}
	public String EmpPass(String TempUser1) {
		
		TempUser=TempUser1;
		// TODO Auto-generated method stub
		frameEp = new JFrame("Change Password");
		frameEp.setSize(800, 800);
		frameEp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameEp.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde10.gif")));
		frameEp.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameEp.setResizable(false);
		Hyde = new JLabel();
		frameEp.add(Hyde);
		
		PanelEp = new JPanel();
		OldPass = new JLabel("                Old Password");
		OldPass.setBounds(100,200,200,40);
		OldPass.setOpaque(true);
		
		
		newPass1 = new JLabel("               Enter new Password");
		newPass1.setBounds(100,300,200,40);
		newPass1.setOpaque(true);
		
		newPass2 = new JLabel("            Confirm new Password");
		newPass2.setBounds(100,400,200,40); 
		newPass2.setOpaque(true);
		
		PassOld= new JPasswordField();
		PassOld.setBounds(400,200,200,40);
		
		PassNew1 = new JPasswordField();
		PassNew1.setBounds(400,300,200,40);
		
		PassNew2 = new JPasswordField();
		PassNew2.setBounds(400,400,200,40);
		
		Change = new JButton("Change Password");
		Change.setBounds(250, 500, 200, 40);
		
		Close = new JButton("Back to Employee Page");
		Close.setBounds(250, 600, 200, 40);
		
		frameEp.add(OldPass);
		frameEp.add(newPass1);
		frameEp.add(newPass2);
		frameEp.add(PassOld);
		frameEp.add(PassNew1);
		frameEp.add(PassNew2);
		frameEp.add(Change);
		frameEp.add(Close);
		frameEp.add(PanelEp);
	
		Change.setActionCommand("CHANGE");
		Change.addActionListener(this);
		
		Close.setActionCommand("CLOSE");
		Close.addActionListener(this);
		
		frameEp.setVisible(true);
		return TempUser1;
	}
	public char [] oldpass(){
		
		return PassOld.getPassword();
	}
	public char [] newpass1(){
		
		return PassNew1.getPassword();
	}
	public char [] newpass2(){
		
		return PassNew2.getPassword();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="CHANGE"){
			TempOP	 =	new String(oldpass());
			TempNP1	 =	new String(newpass1());
			TempNP2	 =	new String(newpass2());
			Connection Mycon=null;
			if(TempNP1.compareTo(TempNP2)==0){
				log.info("New passwords are equal\n");
				int condition =SqlPassCheck(Mycon);
				if(condition ==1){
					try {
						Mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
						Statement Mystmt = Mycon.createStatement();
						String sql = "update employee set password='"+TempNP1+"'where emp_id='"+TempUser+"'";
						Mystmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Password Changed");
						frameEp.setVisible(false);
						log.info("New password is made\n");
						EmployeeFunctionPage Obj = new EmployeeFunctionPage();
						Obj.EmployeeFunction(TempUser);
						
					}catch (SQLException e1) {
						// TODO Auto-generated catch block
						log.error("Error with database,while updating password\n");
						e1.printStackTrace();
					}
					
				}else{
					log.info("Old password is wrong\n");
					JOptionPane.showMessageDialog(null, "Enter the correct password, Please try again");
				}
				
				
			}
			else{
				log.info("Passwords doesnt match\n");
				JOptionPane.showMessageDialog(null, "New passwords doesn't match, Please try again");
			}
			
		}
		if(e.getActionCommand()=="CLOSE"){
			frameEp.setVisible(false);
			log.info("Back to Employee Page\n");
			EmployeeFunctionPage EFP = new EmployeeFunctionPage();
			EFP.EmployeeFunction(TempUser);
		}
	}
	public int SqlPassCheck(Connection Mycon) {
		
		try {
			Mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement Mystmt = Mycon.createStatement();
			String sql ="select password from employee where emp_id = '"+TempUser+"'";
			ResultSet result = Mystmt.executeQuery(sql);
			result.next();
			if(TempOP.compareTo(result.getString("password"))==0){
				return 1;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Error while checking  old password \n");
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

	

}
