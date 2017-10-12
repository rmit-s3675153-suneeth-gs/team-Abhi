import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminViewEmp implements ActionListener {
	private JFrame frameVE;
	private JPanel PanelVE;
	private JButton IndividualEmp,Back;
	private JButton GroupView;
	private JComboBox <String> Combo;
	String[] Emp ;
	int Empno;
	
	public void AdminEmpView(){
		// TODO Auto-generated method stub
		frameVE= new JFrame("EMPLOYEE FULL VIEW");
		frameVE.setSize(700, 700);
		frameVE.setLocation(600, 200);
		frameVE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameVE.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameVE.setResizable(false);
//		frameV.setEditable(false);
		frameVE.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde8.jpg")));
		Connection Mycon =null;
		SqlFetchEmp(Mycon);
		PanelVE = new JPanel();
		Combo = new JComboBox<String>(Emp);
		Combo.setBounds(270, 150, 200, 40);
		IndividualEmp = new JButton("Individual Employee View");
		IndividualEmp.setBounds(270, 250, 200, 40);
		
		GroupView = new JButton("Group View");
		GroupView.setBounds(270, 350, 200, 40);
		
		Back = new JButton("Back");
		Back.setBounds(270, 450, 200, 40);
		
		frameVE.add(Combo);
		frameVE.add(IndividualEmp);
		frameVE.add(GroupView);
		frameVE.add(Back);
		frameVE.add(PanelVE);
		
		IndividualEmp.setActionCommand("IND");
		IndividualEmp.addActionListener(this);
		
		GroupView.setActionCommand("GROUP");
		GroupView.addActionListener(this);
		
		Back.setActionCommand("Back");
		Back.addActionListener(this);
		frameVE.setVisible(true);
		
	}
	private String[] SqlFetchEmp(Connection mycon) {
		// TODO Auto-generated method stub
		try {
			mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement MyStmt = mycon.createStatement();
			String sql="Select count(*) from employee";
			ResultSet res = MyStmt.executeQuery(sql);
			res.next();
			Empno=res.getInt(1);
			Emp = new String[Empno];
			Statement MyStmt1 = mycon.createStatement();
			String sql1="Select emp_id from employee";
			ResultSet res1 = MyStmt1.executeQuery(sql1);
			int i=0;
			while(res1.next()){
				Emp[i]=res1.getString(1);
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Emp;
		
	}
	private String getSelectedEmp(){
		return Combo.getItemAt(Combo.getSelectedIndex());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="IND"){
			frameVE.setVisible(false);
			AdminIndView View = new AdminIndView();
			View.AdminViewInd(getSelectedEmp());
			
		}
		if(e.getActionCommand()=="GROUP"){
			frameVE.setVisible(false);
			AdminView View = new AdminView();
			View.AdminPageView();
			
		}
		if(e.getActionCommand()=="Back"){
			frameVE.setVisible(false);
			AdminFunctionPage AFP = new AdminFunctionPage();
			AFP.AdminControl();
		}
		
	}

}
