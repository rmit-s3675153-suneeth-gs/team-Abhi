
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import org.apache.log4j.Logger;

import java.sql.*;

public class AdminUpdate implements ActionListener {
	private JFrame frameUp;
	private JLabel Hyde;
	private JPanel PanelUp;
	private JTextField TextUp;
	private JComboBox<String> ComboUp;
	private JButton Update,Close;
	String TempUser,ComboReturnString;
	String[] column = { "FIRSTNAME", "LASTNAME", "JOB", "ADDRESS","PHONE" };
	int AD_EM;
	static private Logger log = Logger.getLogger(AdminUpdate.class);
//	public static void main(String []args){
//		AdminUpdate asd=new AdminUpdate();
//		asd.AdminPageUpdate();
//	}
	public AdminUpdate() {
		// TODO Auto-generated constructor stub
	}
	public void AdminPageUpdate(int Con,String TempUser1) {
		// TODO Auto-generated method stub
		AD_EM=Con;
		TempUser=TempUser1;
		frameUp = new JFrame("UPDATE_ADMIN_EMPLOYEE");
		frameUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUp.setSize(800,800);
		frameUp.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde7.gif")));
		frameUp.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameUp.setResizable(false);
		Hyde = new JLabel();
		ComboUp = new JComboBox<String>(column);
		ComboUp.setBounds(300, 250, 200, 40);
		//ComboUp.addItem("FirstName");
		TextUp = new JTextField();
		TextUp.setBounds(300,350, 200, 40);
		frameUp.add(Hyde);
		PanelUp = new JPanel();
		
		Update =new JButton("UPDATE");
		Update.setBounds(300, 450, 200, 40);
		
		Close = new JButton("BACK");
		Close.setBounds(300, 550, 200, 40);
		
		
		frameUp.add(ComboUp);
		frameUp.add(Update);
		frameUp.add(Close);
		frameUp.add(PanelUp);
		frameUp.add(TextUp);
		
		Update.setActionCommand("UPDATE");
		Update.addActionListener(this);
		
		Close.setActionCommand("CLOSE");
		Close.addActionListener(this);
		//System.out.println(TempID);
		frameUp.setVisible(true);
		if(AD_EM==1){		// 1 is for admin
			TempUser = JOptionPane.showInputDialog(null, "Enter the Employee ID");
			log.info("Admin Update- "+TempUser+" Employee-ID is entered to Make changes \n");
		}
		
		
	}
	public int SqlIDcheck(Connection Mycon){
		try{
			Mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement Mystmt= Mycon.createStatement();
			String Sql = "select count(*) as total from employee where emp_id='"+TempUser+"'";
			ResultSet res = Mystmt.executeQuery(Sql);
			res.next();
			if(res.getInt("total")==1){
				log.info("Employee-ID Found in Database \n");
				return 1;
			}
			else{
				
				return 0;
				//System.out.println("2123123 == "+res.getInt("total"));
			}
		}catch(SQLException e1){
			log.error("Employee-ID not in Database \n");
			e1.printStackTrace();
			
		}
		return 0;
		
	}
	public String InpUpdate(){
		return ComboUp.getItemAt(ComboUp.getSelectedIndex());
		
	}
	public String UpdateText(){
		return TextUp.getText();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection Mycon=null;
		if(e.getActionCommand()=="UPDATE"){
			ComboReturnString =InpUpdate();
			//System.out.println("COMBO IS "+s);
			int condition =SqlIDcheck(Mycon);
			if(condition ==1){	
				SqlUpdateEmp(Mycon);
				//System.out.println("COMBO IS "+s);

			}
			else{
				//System.out.println("COMBO IS NOT "+s);
				if(AD_EM==1){
					JOptionPane.showMessageDialog(null,"ENTER A VALID EMPLOYEE ID");
					frameUp.setVisible(false);
					log.info("Employee-ID Not Found in Database - BACK TO ADMIN FUNCTION PAGE\n");
					AdminFunctionPage ALP = new AdminFunctionPage();
	    			ALP.AdminControl();
				}
				if(AD_EM==0){
					JOptionPane.showMessageDialog(null,"ENTER A VALID EMPLOYEE ID");
					frameUp.setVisible(false);
					log.info("Employee-ID Not Found in Database - BACK TO EMPLOYEE FUNCTION PAGE\n");
					EmployeeFunctionPage ALP = new EmployeeFunctionPage();
	    			ALP.EmployeeFunction(TempUser);
					
				}
 
			}	
			
		}
		if(e.getActionCommand()=="CLOSE"){
			if(AD_EM==1){
				frameUp.setVisible(false);
				log.info("Back to Admin Page - CLOSE\n");
				AdminFunctionPage ALP = new AdminFunctionPage();
    			ALP.AdminControl();
			}
			if(AD_EM==0){
				frameUp.setVisible(false);
				log.info("Back to Employee Page - CLOSE\n");
				EmployeeFunctionPage ALP = new EmployeeFunctionPage();
    			ALP.EmployeeFunction(TempUser);
				
			}
		}
		
	}
	public Connection SqlUpdateEmp(Connection Mycon) {
		try{
			Mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement Mystmt=Mycon.createStatement();
			String s=UpdateText();
			String sql;
			switch(ComboReturnString){
				case "FIRSTNAME": 	sql = "update employee set first_name ='"+s+"'where emp_id='"+TempUser+"'";
									Mystmt.executeUpdate(sql);
									log.info("Employee FIRST NAME updated - "+s+"\n");
									break;
				case "LASTNAME":	sql = "update employee set last_name ='"+s+"'where emp_id='"+TempUser+"'";
									Mystmt.executeUpdate(sql);
									log.info("Employee LAST NAME updated - "+s+"\n");
									break;
				case "JOB":			sql = "update employee set job='"+s+"'where emp_id='"+TempUser+"'";
									Mystmt.executeUpdate(sql);
									log.info("Employee JOB updated - "+s+"\n");
									break;
				case "ADDRESS":		sql = "update employee set address ='"+s+"'where emp_id='"+TempUser+"'";
									Mystmt.executeUpdate(sql);
									log.info("Employee ADDRESS updated - "+s+"\n");
									break;
				case "PHONE":		sql = "update employee set phone ='"+s+"'where emp_id='"+TempUser+"'";
									Mystmt.executeUpdate(sql);
									log.info("Employee PHONENUMBER updated - "+s+"\n");
									break;
//				case "PASSWORD":	sql = "update employee set password='"+s+"'where emp_id='"+TempID+"'";
//									Mystmt.executeUpdate(sql);
//									break;
				default:			if(AD_EM==1){
										JOptionPane.showMessageDialog(null,"ENTER A VALID EMPLOYEE ID");
										frameUp.setVisible(false);
										AdminFunctionPage ALP = new AdminFunctionPage();
						    			ALP.AdminControl();
									}
									if(AD_EM==0){
										JOptionPane.showMessageDialog(null,"ENTER A VALID EMPLOYEE ID");
										frameUp.setVisible(false);
										EmployeeFunctionPage ALP = new EmployeeFunctionPage();
						    			ALP.EmployeeFunction(TempUser);
									}
									break;
			
			}
			if(AD_EM==1){
				JOptionPane.showMessageDialog(null,"EMPLOYEE DETAILS UPDATED");
				frameUp.setVisible(false);
				log.info("Back to Admin Page\n");
				AdminFunctionPage ALP = new AdminFunctionPage();
    			ALP.AdminControl();
			}
			if(AD_EM==0){
				JOptionPane.showMessageDialog(null,"EMPLOYEE DETAILS UPDATED");
				frameUp.setVisible(false);
				log.info("Back to Employee Page\n");
				EmployeeFunctionPage ELP = new EmployeeFunctionPage();
    			ELP.EmployeeFunction(TempUser);
			}
			
			//String
			
		}catch(SQLException e1){
			log.error("Error while Updating Employee Details\n");
			e1.printStackTrace();
			
		}
		// TODO Auto-generated method stub
		return Mycon;
		
	}

	

}
