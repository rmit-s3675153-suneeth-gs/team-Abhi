import javax.swing.*;

import org.apache.log4j.Logger;

import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Window extends Thread implements ActionListener {

	//private JFrame MainWind ;
		private JButton NormalUsers;
		private JButton Employee;
		private JButton Admin,time;
		private JFrame frameW;
		private JPanel PanelW;
		private JLabel Hyde,Welcome;
		//private JFrame Adm;
		//private JLabel UserNamLab , PassLab;
		//private JTextField UserField;
		//private JPasswordField PassField;
		//private JButton Button;
		//private JPanel PanAdm;
		private Thread DIG_CLOCK;
		private int icounter=0;
		final static Logger log = Logger.getLogger(Window.class);
		//
		/*
		public JFrame frameAcreate,frameAdel,frameAup;
		public JPanel PanelAcreate,PanelAdel,PanelAup;
		public JLabel LabelEmpID,LabelEmpName1,LabelEmpName2,LabelEmpProf,LabelDel,Hyde;
		public JTextField TextEmpID,TextEmpName1,TextEmpName2,TextEmpProf,TextDel;
		public JButton Create,Delete,CreateAcc,DeleteAcc,UpdateAcc;*/
	
		//public static void main(String[] args) {
		public static void main(String []args) throws SQLException{
			Window WinObj = new Window();
			
			//log.info("Warning");
			WinObj.WindowMenu();
			//WinObj.NormalUserPage();
			//WinObj.EmployeePage();
			//WinObj.AdminCreateage();
			//new SupAdmin();
			//new LoginAdmin();
		}
		public void run(){
		    try {  
		         for(;;) {  
		        	 Calendar cal = new GregorianCalendar();
		        	 Date f=cal.getTime();
		        	// int i =1;
		        	 //Random sc = new Random();
		        	 time.setText("<HTML><font face=helvetica color=black><font size =4><b>"+f+"</b>");
		        	 time.setBounds(220,100, 260, 40);
		        	// time.setBackground(Color.BLUE);
		        	 //counter = sc.nextInt(100);
		        /*	if(icounter<=450&&jcounter<=700){
		        			time.setBounds(icounter, jcounter, 250, 40);
		        			jcounter++;
		        	}
		        	if(jcounter>700){
		        			icounter +=450;
		        			jcounter=0;
	        				time.setBounds(icounter, jcounter, 250, 40);
		        	}if(icounter>450){
		        		icounter =0;
        				time.setBounds(icounter, jcounter, 250, 40);
		        	}*/
		        	 if(icounter<=700){
		        			Welcome.setBounds(icounter, 1, 1000, 40);
		        			icounter++;
		        	}
		        	if(icounter>700){
		 
		        			icounter=0;
	        				Welcome.setBounds(icounter, 1, 1000, 40);
		        	}
		        	
		        	
		        	 
		  
		        	 Thread.sleep( 10);  // interval given in milliseconds  
		        }  
		      }  
		      catch (Exception e) { }  
		 } 
			
		
		public void WindowMenu(){
				// TODO Auto-generated method stub
				//JFrame MainWindow = new JFrame("APPLICATION");

				//this.getInputContext();
				frameW = new JFrame();
				frameW.setTitle("PARK APP");
				frameW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameW.setSize(700,700);
				frameW.setLocation(600, 200);
				//framePI.setExtendedState(JFrame.MAXIMIZED_HORIZ);
				frameW.setResizable(false);
				//frame1.setLayout(new GridLayout(0,3));
				PanelW = new JPanel();
				
				
				
				//Panel.
				//Panel.setBackground(Color.DARK_GRAY);
				//Panel.se
				frameW.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde1.jpg")));
				Hyde = new JLabel();
				
				Welcome = new JLabel("<HTML><font face=helvetica color=black><font size =4><b>Welcome to  The Hyde and Kensington Park </b>");
				Welcome.setBounds(1, 1, 1000, 40);
				frameW.add(Hyde);
				
				NormalUsers = new JButton("Visitors");
				NormalUsers.setBounds(250, 200, 200, 40);
				//NormalUsers.setSize(100,500);
				frameW.add(NormalUsers);
				
				Employee= new JButton("Employee");
				Employee.setBounds(250, 300, 200, 40);
				frameW.add(Employee);
				
				Admin = new JButton("Admin");
				Admin.setBounds(250, 400, 200, 40);
				frameW.add(Admin);
				
				DIG_CLOCK= new Thread(this);  
				DIG_CLOCK.start(); 
				time = new JButton();
				
				//time.setBackground(Color.ORANGE);
				time.setOpaque(false);
				frameW.add(Welcome);
				frameW.add(PanelW);
				frameW.add(time);
				NormalUsers.setActionCommand("NormalUsers");
				NormalUsers.addActionListener(this);
				Employee.setActionCommand("Employee");
				Employee.addActionListener(this);
				Admin.setActionCommand("Admin");
				Admin.addActionListener(this);
				
				

				frameW.setVisible(true);
				
				
				//MainWindow.setVisible(false);
				//AdminCreateage();
				
				//Main
			
	
		}//constructor window end
		
		//public void NormalUserPage(){
		
			
			
		//user module
		//public void EmployeePage(){
			
		//}//employee module
		//public void AdminCreateage(){ //ADMIN CAN CREATE ACCOUNT FOR EMPLOYEE
			
			
			
						
		//}//admin module end
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand()=="NormalUsers"){
				log.info("Visitor Page\n");
				frameW.setVisible(false);
				NormalUserPage norm= new NormalUserPage();
				norm.NormalUser();
			}
			
			if(e.getActionCommand()=="Employee"){
				log.info("Entering Employee System\n");
				frameW.setVisible(false);
				EmployeeLoginPage Empl=new EmployeeLoginPage();
				Empl.EmployeeLog();
				
			}
			
			if(e.getActionCommand()=="Admin"){
				//System.out.println("PUDGE");
				log.info("Entering Admin System\n");
				frameW.setVisible(false);
				AdminLoginPage admin =new AdminLoginPage();
				admin.AdminLogin();
			//System.out.println("INVOKER");
				/*Button.setActionCommand("LOGIN");
				//AdminControl obj= new AdminControl();
				Button.addActionListener(this);*/
				
				
			
			}
			/*if(e.getActionCommand()=="Login"){
				String user = new String(UserField.getText());
				System.out.println("Username = "+ user);
				
			}*/
			
		}//action function for first frame
		public String TIME(){
			Calendar cal = new GregorianCalendar();
			Date f=cal.getTime();
			
			int hour = cal.get(Calendar.HOUR);
			int min = cal.get(Calendar.MINUTE);
			int sec = cal.get(Calendar.SECOND);
			int am_pm=cal.get(Calendar.AM_PM);
			String t;
			String StAm_pm = null;
			System.out.println("qweqwe  "+f+ "  "+cal.getTimeInMillis());

			switch(am_pm){
			case 0:StAm_pm ="am";			// have to check if the system is 24 hour format
					break;
			case 1:StAm_pm  ="pm";
					break;
			default: break;
			
			}
			if(StAm_pm=="pm"){
				hour+=12;
			}

				
			
			if(hour<=9){
				if(min<=9){
					if(sec <=9){
						t = "0"+String.valueOf(hour)+":0"+String.valueOf(min)+":0"+String.valueOf(sec);
						return t;
					}
					else{
						t = "0"+String.valueOf(hour)+":0"+String.valueOf(min)+':'+String.valueOf(sec);
						return t;
					}
				}
				else{
					if(sec <=9){
						t = "0"+String.valueOf(hour)+":"+String.valueOf(min)+":0"+String.valueOf(sec);
						return t;
					}
					else{
						t = "0"+String.valueOf(hour)+":"+String.valueOf(min)+':'+String.valueOf(sec);
						return t;
					}
				}
			}
			else{
				if(min<=9){
					if(sec <=9){
						t = String.valueOf(hour)+":0"+String.valueOf(min)+":0"+String.valueOf(sec);
						return t;
					}
					else{
						t = String.valueOf(hour)+":0"+String.valueOf(min)+':'+String.valueOf(sec);
						return t;
					}
				}
				else{
					if(sec <=9){
						t = String.valueOf(hour)+":"+String.valueOf(min)+":0"+String.valueOf(sec);
						return t;
					}
					else{
						t = String.valueOf(hour)+":"+String.valueOf(min)+':'+String.valueOf(sec);
						return t;
					}
				}
				
			}
		}
}