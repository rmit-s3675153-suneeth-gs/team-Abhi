import java.awt.event.*;
import javax.swing.*;

import org.apache.log4j.Logger;

import java.sql.*;
//import javax.swing.JMenu;

public class EmployeeSchedule implements ActionListener {
	private JFrame frameSch;
	private JPanel PanelSch;
	private JLabel Hyde,LabDay,LabStart,LabEnd;
	private JComboBox<String> TextStHour,TextEnHour;
	private JComboBox<String> TextStMin,TextEnMin;
	private JComboBox<String> TextStSec,TextEnSec;
	//private JTextField TextEnd;
	//private JMenu men;
	private JComboBox<String> TextDay;
	private JButton UpSched,Logout,Close,Delete;
	String ID,Day,Start,End,TempUser;
	String[] Days ={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	String[] Hour = new String[24];
	String[] Min = new String[60]; 
	String[] Sec = new String[60];
	
	static final Logger log = Logger.getLogger(EmployeeSchedule.class);
	
	/*public static void main(String[] args){
		EmployeeSchedule obj = new EmployeeSchedule();
		obj.EmployeeSch(TempUser);
		
	}*/
	public EmployeeSchedule() {
		// TODO Auto-generated constructor stub
	}
	public void EmployeeSch(String TempUser1) {
		// TODO Auto-generated method stub
		TempUser=TempUser1;
		frameSch = new JFrame("EMPLOYEE SCHEDULE");
		frameSch.setSize(800, 800);
		frameSch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelSch =  new JPanel();
		frameSch.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde8.jpg")));
		frameSch.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameSch.setResizable(false);
		Hyde = new JLabel();
		
		//men = new JMenu("QWETQWE");
		//men.setBounds(1, 1, 200, 100);
		//frameSch.add(men);
		
		//LabID = new JLabel("                          EmpID");
		//LabID.setBounds(100,100,200,40);
		//LabID.setOpaque(true);
		
		LabDay = new JLabel("                            Day");
		LabDay.setBounds(150,100,200,40);
		LabDay.setOpaque(true);
		
		
		LabStart = new JLabel("                        Duty Start");
		LabStart.setBounds(150,200,200,40);
		LabStart.setOpaque(true);
		
		LabEnd = new JLabel("                         Duty End");
		LabEnd.setBounds(150,300,200,40); 
		LabEnd.setOpaque(true);
		
		
		//TextID = new JTextField();
		//TextID.setBounds(400,100,200,40);
	
		Combo_Time_Start_End();
		
		TextDay= new JComboBox<String>(Days);
		TextDay.setBounds(500,100,200,40);
		System.out.println("!@!#$!");
		TextStHour = new JComboBox<String>(Hour);
		TextStHour.setBounds(500,200,40,40);
		TextStMin = new JComboBox<String>(Min);
		TextStMin.setBounds(585,200,40,40);
		TextStSec = new JComboBox<String>(Sec);
		TextStSec.setBounds(670,200,40,40);
		
		TextEnHour = new JComboBox<String>(Hour);
		TextEnHour.setBounds(500,300,40,40);
		TextEnMin = new JComboBox<String>(Min);
		TextEnMin.setBounds(585,300,40,40);
		TextEnSec = new JComboBox<String>(Sec);
		TextEnSec.setBounds(670,300,40,40);
		
		UpSched =new JButton("ENTER SCHEDULE");
		UpSched.setBounds(500,400,200,40);
		
		Delete=new JButton("DELETE SCHEDULE");
		Delete.setBounds(150,400,200,40);
		
		Logout = new JButton("LOGOUT");
		Logout.setBounds(300, 500, 200, 40);
		
		Close= new JButton("CLOSE");
		Close.setBounds(300, 600, 200, 40);
		//frameSch.add(LabID);
		frameSch.add(LabDay);
		frameSch.add(LabStart);
		frameSch.add(LabEnd);
		//frameSch.add(TextID);
		frameSch.add(TextDay);
		
		frameSch.add(TextStHour);
		frameSch.add(TextStMin);
		frameSch.add(TextStSec);
		frameSch.add(TextEnHour);
		frameSch.add(TextEnMin);
		frameSch.add(TextEnSec);
		
		frameSch.add(UpSched);
		frameSch.add(Hyde);
		frameSch.add(Logout);
		frameSch.add(Close);
		frameSch.add(Delete);
		frameSch.add(PanelSch);
		
		UpSched.setActionCommand("UPDATE");
		UpSched.addActionListener(this);
		
		Logout.setActionCommand("LOGOUT");
		Logout.addActionListener(this);
		
		Close.setActionCommand("CLOSE");
		Close.addActionListener(this);
		
		Delete.setActionCommand("DELETE");
		Delete.addActionListener(this);
		
		frameSch.setVisible(true);
	}
	/*public String getID(){
		return TextID.getText();
		
	}*/
//	public void ComboTIME_Start_End(){
//		String t,t1;
//		for(int i=0;i<=23;i++){
//			if(i<=9)
//				t='0'+String.valueOf(i);
//			else
//				t=String.valueOf(i);
//			System.out.println(t);
//		}
//		System.out.println("QAWSEQWRQWq");
//		
//		for(int i=0;i<=59;i++){
//			
//			if(i<=9){
//				t='0'+String.valueOf(i);
//				t1='0'+String.valueOf(i);
//			}
//			else{
//				t=String.valueOf(i);
//				t1=String.valueOf(i);
//			}
//		}
//	}
	public void Combo_Time_Start_End(){
		for(int i=5;i<=23;i++){
			if(i<=9)
				Hour[i]='0'+String.valueOf(i);
			else
				Hour[i]=String.valueOf(i);
			//System.out.println(Hour[i]);
		}
		//System.out.println("QAWSEQWRQWq");
		
		for(int i=0;i<=59;i++){
			
			if(i<=9){
				Min[i]='0'+String.valueOf(i);
				Sec[i]='0'+String.valueOf(i);
			}
			else{
				Min[i]=String.valueOf(i);
				Sec[i]=String.valueOf(i);
			}
		}
	}
	public String getDay(){
		return TextDay.getItemAt(TextDay.getSelectedIndex());
		
	}
	public String getStartHour(){
		return TextStHour.getItemAt(TextStHour.getSelectedIndex());
	}

	public String getStartMin(){
		return TextStMin.getItemAt(TextStMin.getSelectedIndex());
	}
	public String getStartSec(){
		return TextStSec.getItemAt(TextStSec.getSelectedIndex());
	}
	public String getEndHour(){
		return TextEnHour.getItemAt(TextEnHour.getSelectedIndex());
	}
	public String getEndMin(){
		return TextEnMin.getItemAt(TextEnMin.getSelectedIndex());
		
	}
	public String getEndSec(){
		return TextEnSec.getItemAt(TextEnSec.getSelectedIndex());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="UPDATE"){
			//ID=getID();
			Day=getDay();
			Start=getStartHour()+":"+getStartMin()+":"+getStartSec();
			End=getEndHour()+":"+getEndMin()+":"+getEndSec();
			Connection Mycon=null;
			SqlSchedule(Mycon);
			
		}
		if(e.getActionCommand()=="LOGOUT"){
			frameSch.setVisible(false);
        	log.info("Employee - "+TempUser+" Logged out\n");
			EmployeeLoginPage ELP= new EmployeeLoginPage();
			ELP.EmployeeLog();
			
		}
		if(e.getActionCommand()=="CLOSE"){
			frameSch.setVisible(false);
        	log.info("Back to Employee Page\n");
			EmployeeFunctionPage EMPAG=new EmployeeFunctionPage();
			EMPAG.EmployeeFunction(TempUser);
		}
		if(e.getActionCommand()=="DELETE"){
			frameSch.setVisible(false);
        	log.info("Delete The Employee Schedule\n");
			EmployeeDeleteSchedule EDS = new EmployeeDeleteSchedule();
			EDS.EmployeeDelete(TempUser);
		
		}
		
	}
	public Connection SqlSchedule(Connection Mycon) {
		try {
			Mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement Mystmt = Mycon.createStatement();
			System.out.println("!@#!@#!@#111");
			String Sql ="insert into schedule values('"+TempUser+"','"+Day+"','"+Start+"','"+End+"')";
			Mystmt.executeUpdate(Sql);
        	log.info("Employee Schedule Entered\n");
			JOptionPane.showMessageDialog(null, "Schedule Updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
        	log.error("Error ,While inserting Schedules details\n");
			JOptionPane.showMessageDialog(null, "Error,Enter Details Again");
			e.printStackTrace();
		}
		
		return Mycon;
		
		// TODO Auto-generated method stub
		
	}

	

}
