import javax.swing.*;

import org.apache.log4j.Logger;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EmployeeDeleteSchedule implements ActionListener{
	private JFrame frameEDS;
	private JPanel PanelEDS;
	private JButton Delete,Close;
	private JLabel Label;
	private JComboBox<String>Delete_Schedule;
	String TempUser;
	String[] ScheduleDate;
	int Count;
	static final Logger log = Logger.getLogger(EmployeeDeleteSchedule.class);

	public EmployeeDeleteSchedule() {
		// TODO Auto-generated constructor stub
	}

	public void EmployeeDelete(String TempUser1) {
		// TODO Auto-generated method stub
		TempUser = TempUser1;
		frameEDS = new JFrame("Delete Schedule");
		frameEDS.setSize(700,700);
		frameEDS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelEDS= new JPanel();
		
		Connection Mycon=null;
		SQL_SCH_CHECK(Mycon);
		Label = new JLabel("Schedule");
		Label.setBounds(100, 200, 200, 40);
		//Label.setOpaque(true);
		
		Delete_Schedule= new JComboBox<String>(ScheduleDate);
		Delete_Schedule.setBounds(200, 200, 200, 40);
		
		Delete = new JButton("DELETE");
		Delete.setBounds(200, 300, 200, 40);
		
		Close = new JButton("Back to Schedule");
		Close.setBounds(200, 400, 200, 40);
		
		frameEDS.add(Label);
		frameEDS.add(Delete_Schedule);
		frameEDS.add(Delete);
		frameEDS.add(Close);
		frameEDS.add(PanelEDS);
		
		Delete.setActionCommand("DELETE");
		Delete.addActionListener(this);
		
		Close.setActionCommand("CLOSE");
		Close.addActionListener(this);
		
		frameEDS.setVisible(true);
		
	}
	public String Combo_Delete(){
		return Delete_Schedule.getItemAt(Delete_Schedule.getSelectedIndex());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="DELETE"){
			if(Count==0){
				log.info("No Schedule Available for the Employee \n");
				JOptionPane.showMessageDialog(null,"NO SCHEDULE TO DELETE");
			}
			else{
				int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
	            dialogButton=JOptionPane.showConfirmDialog (null, "Are you sure about deleting this Schedule ?","Warning",dialogButton);
	            if(dialogButton == JOptionPane.YES_OPTION){
	            	Connection MyCon=null;
	            	Sql_Sch_Delete(MyCon);
	            	frameEDS.setVisible(false);
	            	
	    			EmployeeSchedule ES = new EmployeeSchedule();
	    			ES.EmployeeSch(TempUser);
	            }
	            if(dialogButton==JOptionPane.NO_OPTION||dialogButton==JOptionPane.CANCEL_OPTION){
	            	
	            }
				
			}
		}
		if(e.getActionCommand()=="CLOSE"){
			frameEDS.setVisible(false);
			EmployeeSchedule ES = new EmployeeSchedule();
			ES.EmployeeSch(TempUser);
		}
	}
	private void Sql_Sch_Delete(Connection myCon) {
		// TODO Auto-generated method stub
		try {
			String t = Combo_Delete();
			System.out.println("!@#!@3 "+t);
			myCon=DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement MyStmt = myCon.createStatement();
			String sql = "delete from schedule where empid ='"+TempUser+"'and duty_day ='"+t+"'";
			MyStmt.executeUpdate(sql);
			log.info("Schedule on "+t+" for the Employee "+TempUser+" deleted\n");
			JOptionPane.showMessageDialog(null, "Schedule Deleted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Error Occured in Deleting the Schedule\n");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR, CHECK AGAIN");
		}
		
	}

	public void SQL_SCH_CHECK(Connection Mycon){
		try {
		
			Mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement Mystmt=Mycon.createStatement();
			String sql ="select count(duty_day) from schedule where empid ='"+TempUser+"'";
			ResultSet result = Mystmt.executeQuery(sql);
			result.next();
			Count =result.getInt(1);
			System.out.println(Count);
			int i=0;
			String sql1="select duty_day from schedule where empid='"+TempUser+"'";
			ResultSet res = Mystmt.executeQuery(sql1);
			ScheduleDate  = new String[Count];
			while(res.next()){
				ScheduleDate[i]=res.getString(1);
				i++;
			}
			if(Count!=0)
				for(int j=0;j<ScheduleDate.length;j++){
					System.out.println(ScheduleDate[j]);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Error Occured While retrieving Schedules per week\n");
			e.printStackTrace();
		}
	}
}
