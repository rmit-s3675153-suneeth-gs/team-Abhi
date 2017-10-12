
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

//import Window;

public class AdminLoginPage implements ActionListener {
	private JFrame Adm;
	private  JPanel PanAdm;
	private JLabel UserNamLab,PassLab;
	
	private JTextField UserField;
	private JPasswordField PassField;
	private JButton Button,Close;
	/*public static void main(String []args){
		AdminLoginPage AdMobj =new AdminLoginPage();
		//AdMobj.AdminLogin();;
		
	}*/
	static final Logger log = Logger.getLogger(AdminLoginPage.class);
	public void AdminLogin() {
		// TODO Auto-generated constructor stub
		System.out.println("Rhaegar");
		JLabel Hyde1;
		Adm = new JFrame();
		Adm.setTitle("Admin Window");
		Adm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Adm.setSize(800,800);
		Adm.setLocation(600, 200);
		Adm.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		Adm.setResizable(false);
					
		PanAdm = new JPanel();
		Adm.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde.jpg")));
		Hyde1 = new JLabel();
		
		Adm.add(Hyde1);
					
		UserNamLab = new JLabel("                   USERNAME");
		UserNamLab.setBounds(150,200,200,40);
		
		UserNamLab.setOpaque(true);
		UserNamLab.setBackground(Color.WHITE);			
		PassLab = new JLabel("                   PASSWORD");
		PassLab.setBounds(150,300,200,40);
		PassLab.setOpaque(true);
					
		UserField = new JTextField(20);
		UserField.setBounds(450,200,200,40);
					
		PassField = new JPasswordField(20);
		PassField.setBounds(450,300,200,40);
					
		Button = new JButton(("LOGIN"));
		Button.setBounds(300,400,200,40);
		
		Close = new JButton("CLOSE");
		Close.setBounds(300,500,200,40);
					 //System.out.print("USername = ");
		Adm.add(UserNamLab);
		Adm.add(PassLab);
		Adm.add(UserField);
		Adm.add(PassField);
		Adm.add(Button);
		Adm.add(Close);
		Adm.add(PanAdm);
		
		Button.setActionCommand("LOGIN");
		Button.addActionListener(this);
		
		Close.setActionCommand("CLOSE");
		Close.addActionListener(this);
		Adm.setVisible(true);
		System.out.println("Lyanna");
	}
	 public String getUserName(){
	      return UserField.getText();
	 }
	 public char[] getPass(){
		 return PassField.getPassword();
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="LOGIN"){
			String username = getUserName();
			char []password = getPass();
			Connection Mycon;
			try{
				//System.out.println("ASDASD  ");
				Mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
				Statement Mystmt = Mycon.createStatement();
				String sql ="select password from user where username = '"+username+"'";
				
				ResultSet result = Mystmt.executeQuery(sql);
				result.next();
				if(new String(password).compareTo(result.getString("password"))==0){
					JOptionPane.showMessageDialog(null, "ADMIN LOGGED IN ");
					//new AdminFunctionPage();
					Adm.setVisible(false);
					log.info("Admin Logged into the System - Admin ID = "+username+"\n");
					AdminFunctionPage admpag=new AdminFunctionPage();
					admpag.AdminControl();
					
				}
				else{
					log.error("Entered Wrong Admin Password, Please Check\n");
					JOptionPane.showMessageDialog(null,"Check you Password  ");
				}
				
				
				//System.out.println("ASDASD  "+result);
				
			}catch(SQLException e1){
				log.error("Admin ID not Found in Database,  "+e1.getMessage()+"\n");
				JOptionPane.showMessageDialog(null,"WRONG USERNAME and PASSWORD");
				e1.printStackTrace();
			}
		//Adm.setVisible(true);
		}
		if(e.getActionCommand()=="CLOSE"){
			Adm.setVisible(false);
			Window win = new Window();
			win.WindowMenu();
			
		}
		
	}
	 

}
