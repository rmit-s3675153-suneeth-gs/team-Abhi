import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Vector;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AdminIndView implements ActionListener {
	private String Empno;
	private JFrame frameAIV;
	private JPanel PanelAIV; 
	private JButton Back;
	private JLabel name,Labname,LabPhone,phone;
	private Vector<String> tab;
	private String firstname;
	private String lastname;
	private String Phoneno;
	public void AdminViewInd(String selectedEmp) {
		// TODO Auto-generated method stub
		Empno=selectedEmp;
		frameAIV = new JFrame(Empno);
		frameAIV.setSize(700, 700);
		frameAIV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Sqldetails();
		Labname = new JLabel("   \tName");
		Labname.setBounds(1, 1, 200, 40);
		LabPhone = new JLabel("   Phone");
		LabPhone.setBounds(200, 1, 200, 40);
		name = new JLabel("\t"+firstname+" "+lastname);
		name.setBounds(1, 20, 200, 40);
		phone = new JLabel(Phoneno);
		phone.setBounds(200, 20, 200, 40);
		PanelAIV = new JPanel();
		frameAIV.setContentPane(new JLabel(new ImageIcon("E://hyde_employee/"+Empno+".jpg")));
		Back = new JButton("Back");
		Back.setBounds(250,600, 200, 40);
		
		frameAIV.add(name);
		frameAIV.add(Labname);
		frameAIV.add(LabPhone);
		frameAIV.add(phone);
		frameAIV.add(Back);
		frameAIV.add(PanelAIV);
		
		Back.setActionCommand("Back");
		Back.addActionListener(this);
		frameAIV.setVisible(true);
	}

	private void Sqldetails() {
		// TODO Auto-generated method stub
		Connection Mycon;
		try {
			Mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement Mystmt = Mycon.createStatement();
			String sql = "Select first_name,last_name,phone from employee where emp_id='"+Empno+"'";
			ResultSet res = Mystmt.executeQuery(sql);
			res.next();
			firstname=res.getString(1);
			lastname=res.getString(2);
			Phoneno=res.getString(3);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="Back"){
			frameAIV.setVisible(false);
			AdminViewEmp ADE = new AdminViewEmp();
			ADE.AdminEmpView();
			
		}
		
	}

	

}
