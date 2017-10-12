
import javax.swing.*;

import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminDelete implements ActionListener{
	
	private JFrame frameAdel;
	private JLabel LabelDel,Hyde4;
	private JButton Delete,Close;
	private JPanel PanelAdel;
	//private JTextField TextDel;
	private JComboBox<String>TextDel;
	String TempID;
	String[] EmpList= null;
	static private Logger log = Logger.getLogger(AdminDelete.class);
//	public static void main(String []args){
//		AdminDelete a = new AdminDelete();
//		a.AdminPageDelete();
//	}

	public AdminDelete() {
		// TODO Auto-generated constructor stub
	}

	public void AdminPageDelete() {
		// TODO Auto-generated method stub
		frameAdel = new JFrame("Admin_Employee_Deletion");
		frameAdel.setSize(800,800);
		frameAdel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frameAcreate.setLayout(new GridLayout(0,3));
		PanelAdel= new JPanel();
		frameAdel.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde4.jpg")));
		Hyde4 = new JLabel();
		
		frameAdel.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameAdel.setResizable(false);
		frameAdel.add(Hyde4);
		LabelDel = new JLabel("            Enter the ID to delete");
		LabelDel.setBounds(0,250,200,40);
		LabelDel.setOpaque(true);
		Connection Mycon = null;
		Sql_Employee_List(Mycon);
		
		TextDel = new JComboBox<String>(EmpList);
		TextDel.setBounds(250,250,200,40);
		
		Close = new JButton("Close");
		Close.setBounds(500,600,200,40);
		
		Delete = new JButton("Delete Account");
		Delete.setBounds(500,250,200,40);
		
		frameAdel.add(LabelDel);
		frameAdel.add(TextDel);
		frameAdel.add(Delete);
		frameAdel.add(PanelAdel);
		frameAdel.add(Close);
		
		Delete.setActionCommand("DELETE");
		Delete.addActionListener(this);
		
		Close.setActionCommand("CLOSE");
		Close.addActionListener(this);
		
		frameAdel.setVisible(true);
		
	}
	public String DELEMP() {
		// TODO Auto-generated method stub
		return TextDel.getItemAt(TextDel.getSelectedIndex());
	}
	public void Sql_Employee_List(Connection Mycon){
		try {
			Mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement Mystmt = Mycon.createStatement();
			String Sql = "select count(emp_id) from employee ";
			ResultSet result = Mystmt.executeQuery(Sql);
			result.next();
			log.info("Checking Whether the Employee is in the Database\n");
			int count = result.getInt(1);
			if(count>0){
				int i =0;
				EmpList = new String[count];
				Statement Mystmt1 = Mycon.createStatement();
				String sql = "select emp_id from employee ";
				ResultSet res = Mystmt1.executeQuery(sql);
				while(res.next()){
					EmpList[i]=res.getString(1);
					i++;
				}
				log.info("Employee found inside the Database\n");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Database Error\n"+e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="DELETE"){
			System.out.println("AASDASDASDDELETE");
			
			TempID=DELEMP();
			System.out.println("21212113  "+TempID);
			//System.out.println("AASDASDASD");
			Connection Mycon=null;
			int Condition =SqlCheckEmp(Mycon);
			if (Condition ==1){
				int ChildCondition =SqlChildCheck(Mycon);
				if(ChildCondition==1){
					SqlDeleteChild(Mycon);
					log.info("Deleted the Employee details from the Schedule Table\n");
					SqlDeleteEmp(Mycon);
					log.info("Deleted the Employee details from the Employee Table\n");
				}
				else{
					SqlDeleteEmp(Mycon);
					log.info("Deleted the Employee details from the Employee Table - No Details in Schedule Table \n");
				}
			}
			else if(Condition ==0){
				log.info("Employee ID doesnt match inside the Database\n");
				JOptionPane.showMessageDialog(null, "WRONG EMPLOYEE ID,PLEASE ENTER A VALID ID");
				frameAdel.setVisible(false);
				AdminFunctionPage ALP = new AdminFunctionPage();
    			ALP.AdminControl();
				
			}
			
		}
		if(e.getActionCommand()=="CLOSE"){
			frameAdel.setVisible(false);
			AdminFunctionPage ALP=new AdminFunctionPage();
			ALP.AdminControl();
		}
	}

	public Connection SqlDeleteChild(Connection Mycon) {
		// TODO Auto-generated method stub
		try {
			Mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement Mystmt = Mycon.createStatement();
			String sql = "delete from schedule where empid = '"+TempID+"'";
			Mystmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Mycon;
		
	}

	public int SqlChildCheck(Connection Mycon) {
		// TODO Auto-generated method stub
		try {
			Mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement myStmt = Mycon.createStatement();
			String Sql = "select count(*) as total from schedule where empid ='"+TempID+"'";
			ResultSet rs = myStmt.executeQuery(Sql);
			rs.next();
			if(rs.getInt("total")>=1){
				System.out.println("FOUND CHILD = "+rs.getInt("total"));
				return 1;
			}
			else{
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int SqlCheckEmp(Connection Mycon) {
		
		try {
			Mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement myStmt = Mycon.createStatement();
			String Sql = "select count(*) as total from employee where emp_id ='"+TempID+"'";
			ResultSet rs = myStmt.executeQuery(Sql);
			rs.next();
			if(rs.getInt("total")==1){
				System.out.println("FOUND");
				return 1;
			}
			else{
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		// TODO Auto-generated method stub
		
	}

	public Connection SqlDeleteEmp(Connection Mycon) {
		try {
			int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
            dialogButton=JOptionPane.showConfirmDialog (null, "Are you sure about deleting the Employee Account?","Warning",dialogButton);
            if(dialogButton == JOptionPane.YES_OPTION){
            	Mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
				Statement myStmt = Mycon.createStatement();
				//jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false
				String Sql = "delete from employee where Emp_id ='"+TempID+"'";
				//"delete from bank where accno='"+name+"'";
				//DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste';
				myStmt.executeUpdate(Sql);
				JOptionPane.showMessageDialog(null, "Employee details successfully deleted from the database ");
				AdminFunctionPage ALP = new AdminFunctionPage();
            	frameAdel.setVisible(false);
    			ALP.AdminControl();
            }
            if(dialogButton == JOptionPane.NO_OPTION){
            	AdminFunctionPage ALP = new AdminFunctionPage();
            	frameAdel.setVisible(false);
    			ALP.AdminControl();
            }
		} 
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error");
			e1.printStackTrace();
			
		}
		return Mycon;
		// TODO Auto-generated method stub
		
	}


}
