import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.apache.log4j.Logger;

import java.sql.*;

public class EmployeeLoginPage implements ActionListener {
	private JFrame frameEmp;
	private JPanel PanelEmp;
	private	JTextField TextEmp;
	private JPasswordField PassEmp;
	private JLabel TextLab,PassLab,Hyde;
	private JButton Login,Close;
	String TempUser;
	char [] TempPass;
	static final Logger log = Logger.getLogger(EmployeeLoginPage.class);

	public EmployeeLoginPage() {
		// TODO Auto-generated constructor stub
	}

	public void EmployeeLog() {
		// TODO Auto-generated method stub
		frameEmp=new JFrame("EMPLOYEE LOGIN");
		frameEmp.setSize(800, 800);
		frameEmp.setVisible(true);
		frameEmp.setLocation(600, 150);
		frameEmp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameEmp.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameEmp.setResizable(false);
		PanelEmp= new JPanel();
		frameEmp.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde_emplogin.jpg")));
		Hyde = new JLabel();
		
		frameEmp.add(Hyde);
					
		TextLab = new JLabel("                   USERNAME");
		TextLab.setBounds(150,200,200,40);
		
		TextLab.setOpaque(true);
		TextLab.setBackground(Color.WHITE);			
		PassLab = new JLabel("                   PASSWORD");
		PassLab.setBounds(150,300,200,40);
		PassLab.setOpaque(true);
					
		TextEmp = new JTextField(20);
		TextEmp.setBounds(450,200,200,40);
					
		PassEmp = new JPasswordField(20);
		PassEmp.setBounds(450,300,200,40);
					
		Login = new JButton(("LOGIN"));
		Login.setBounds(300,400,200,40);
		
		Close = new JButton("CLOSE");
		Close.setBounds(300, 500, 200, 40);
		
		frameEmp.add(Login);
		frameEmp.add(Close);
		frameEmp.add(PassEmp);
		frameEmp.add(TextEmp);
		frameEmp.add(PassLab);
		frameEmp.add(TextLab);
		frameEmp.add(PanelEmp);
		frameEmp.setVisible(true);
		
		Login.setActionCommand("LOGIN");
		Login.addActionListener(this);
		
		Close.setActionCommand("CLOSE");
		Close.addActionListener(this);
	
	}
	public String UserEmp(){
		return TextEmp.getText();
		
	}
	public char[] PassEmp(){
		return PassEmp.getPassword();
		
	}
	public int SqlFunction(Connection Mycon){

		try {
			Mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement Mystmt = Mycon.createStatement();
			String Sql = "select password from employee where emp_id='"+TempUser+"'";
			ResultSet result = Mystmt.executeQuery(Sql);
			result.next();
			if(new String(TempPass).compareTo(result.getString("password"))==0){
				log.info("Password is checked \n");
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Database Error\n");
			e.printStackTrace();
		}
		return 0;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="LOGIN"){
			TempUser = UserEmp();
			TempPass = PassEmp();
			Connection Mycon=null;
			int condition = SqlFunction(Mycon);
			if(condition ==1 ){
				JOptionPane.showMessageDialog(null, "EMPLOYEE LOGGED IN");
				log.info("Employee - "+TempUser+" logged in \n");
				frameEmp.setVisible(false);
				EmployeeFunctionPage EmpFun= new EmployeeFunctionPage();
				EmpFun.EmployeeFunction(TempUser);
				
			}
			else{
				log.info("Wrong Username or Password\n");
				JOptionPane.showMessageDialog(null, "Please Check Username and Password");
				
			}
			
		}
		if(e.getActionCommand()=="CLOSE"){
			frameEmp.setVisible(false);
			log.info("Back to Main Page\n");
			Window win = new Window();
			win.WindowMenu();
			
		}
		
	}

}
