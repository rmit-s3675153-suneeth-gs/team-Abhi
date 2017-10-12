
import java.awt.event.*;
import java.util.Vector;
import java.sql.*;

import javax.swing.*;

import org.apache.log4j.Logger;
public class AdminView implements ActionListener {
	private JFrame frameV;
	private JPanel PanelV;
	private JButton Close;
	Vector<String> TableName = new Vector<String>();
	int columnNumber,row=0;
	Vector<Vector<Object>> Data = new Vector<Vector<Object>>();
	static final Logger log = Logger.getLogger(AdminView.class);
	public AdminView() {
		// TODO Auto-generated constructor stub
	}
	public void AdminPageView(){
		// TODO Auto-generated method stub
		frameV= new JFrame("EMPLOYEE FULL VIEW");
		frameV.setSize(1300, 400);
		frameV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameV.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameV.setResizable(false);
//		frameV.setEditable(false);
		/*frameV.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde8.jpg")));
		LabelV= new JLabel();
		frameV.add(LabelV);*/
		
		PanelV = new JPanel();
		Close = new JButton("CLOSE");
		Close.setBounds(600, 300, 150, 40);
		frameV.add(Close);
		frameV.add(PanelV);
		Connection Mycon=null;
		SQLtoTABLE(Mycon);
		JTable table = new JTable(Data,TableName);
		JScrollPane scrollPane = new JScrollPane( table );
		frameV.add(scrollPane );
		table.setOpaque(true);
		table.editingStopped(null);
		Close.setActionCommand("close");
		
		Close.addActionListener(this);
		frameV.setVisible(true);
		
	}

	public Connection SQLtoTABLE(Connection Mycon) {
		try {
			Mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			
			Statement Mystmt = Mycon.createStatement();
			String Sql ="select * from employee";
			ResultSet result = Mystmt.executeQuery(Sql);
			ResultSetMetaData Meta = result.getMetaData();
			columnNumber=Meta.getColumnCount();
			for(int i=1;i<=columnNumber;i++){
				TableName.addElement(Meta.getColumnName(i));
				//System.out.print(" "+Meta.getColumnName(i));
			}
			for(int i=1;i<TableName.size();i++){
				
				System.out.print(" "+TableName.get(i));
			}
			System.out.println();
			
			while(result.next()){
				Vector<Object> temp = new Vector<Object>();
				for(int i=1;i<=columnNumber;i++){
					temp.addElement(result.getObject(i));
					//System.out.print(" "+result.getObject(i));
				}
				System.out.println();
				Data.addElement(temp);
				row++;
			}
			
				for(int j=1;j<row;j++){
					System.out.println(" "+Data.get(j));
				}
				System.out.println();
			
			

				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Mycon;
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="close"){
			frameV.setVisible(false);
			AdminFunctionPage ALP = new AdminFunctionPage();
			ALP.AdminControl();
			
		}
		// TODO Auto-generated method stub
		
	}
}
