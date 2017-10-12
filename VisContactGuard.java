import javax.swing.*;

import org.apache.log4j.Logger;

import java.util.Vector;
import java.awt.event.*;
import java.util.Calendar;
//import java.util.Date;
import java.util.GregorianCalendar;
import java.sql.*;
public class VisContactGuard implements ActionListener {
	private JFrame frameVCG;
	//private JLabel Label;
	private JPanel PanelVCG;
	private JButton button,close;
	private JComboBox<String> Combo;
	String[] Incident={"Emergency","Query","Theft ","Criminal Reports","Other"};
	String[] Avail_EmpName;
	String PresDay,TimeDay;
	String am_pm;
	int Avail_Emp;
	//int ColumnNumber,RowNumber;
	//Vector<Object> ContValues= new Vector<Object>();
	Vector<String> ContValues= new Vector<String>();
	//Vector<Object>temp1 = new Vector<Object>();
	static final Logger log = Logger.getLogger(VisContactGuard.class);

	public VisContactGuard() {
		// TODO Auto-generated constructor stub
	}

	public void ContactGuard() {
		// TODO Auto-generated method stub
		frameVCG = new JFrame("Contact-Personnel");
		frameVCG.setSize(800, 800);
		frameVCG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameVCG.setResizable(false);
		
		PanelVCG = new JPanel();
		frameVCG.setContentPane(new JLabel(new ImageIcon("E://hydePark/contactguard.jpg")));
		//Label = new JLabel();
		button = new JButton("Press to see Available Employees ");
		button.setBounds(100, 300, 500, 40);
		frameVCG.add(button);
		close = new JButton("Back to Visitor Menu ");
		close.setBounds(100, 400, 500, 40);
		Combo = new JComboBox<String>(Incident);
		Combo.setBounds(100, 100, 200, 40);
		PresDay=Day();
		Window win = new Window();
		TimeDay = win.TIME();
		System.out.println("day "+PresDay+" "+TimeDay);
		
		//frameVCG.add(Label);
		frameVCG.add(Combo);
		frameVCG.add(close);
		frameVCG.add(PanelVCG);
		
		button.setActionCommand("PRESS");
		button.addActionListener(this);
		close.setActionCommand("CLOSE");
		close.addActionListener(this);
		frameVCG.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="PRESS"){
			Connection Mycon = null;
			//TIMECON24();
			SqlContact(Mycon);
			frameVCG.setVisible(false);
			for(int i =0;i<ContValues.size();i++){
				System.out.println(ContValues.get(i));
			}System.out.println("_________________________________________");
			log.info("Entering into Available Employee List");
			VisEmpList VEL = new VisEmpList();
			VEL.EmpList(ContValues);
		}
		if(e.getActionCommand()=="CLOSE"){
			frameVCG.setVisible(false);
			log.info("Back to Visitor Page\n");
			NormalUserPage NUP = new NormalUserPage();
			NUP.NormalUser();
		}
		
	}
	public String Day(){
		//int a;
		Calendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		String t = null;
		switch(day){
		case 1: t="SUNDAY";
				break;
		case 2: t="MONDAY";
				break;
		case 3: t="TUESDAY";
				break;
		case 4: t="WEDNESDAY";
				break;
		case 5: t="THURSDAY";
				break;
		case 6: t="FRIDAY";
				break;
		case 7: t="SATURDAY";
				break;
		}
		
		return t ;
	}
	
	//@SuppressWarnings("unchecked")
	public void SqlContact(Connection Mycon){
		try {
			String day = PresDay;
			String time = TimeDay;
			Mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			//Statement Mystmt1 = Mycon.createStatement();
			/*String sql1 = "select count(*) from schedule where duty_day = '"+day+"' and start_duty<= '"+time+"' and end_duty>='"+time+"'";
			ResultSet res1 = Mystmt1.executeQuery(sql1);
			res1.next();
			Avail_Emp =res1.getInt(1);
			System.out.print(" yut "+Avail_Emp);*/
			Statement Mystmt = Mycon.createStatement();
			String sql = "select empid from schedule where duty_day = '"+day+"' and start_duty<= '"+time+"' and end_duty>='"+time+"'";
			ResultSet res = Mystmt.executeQuery(sql);
			//ResultSetMetaData meta =  res.getMetaData();
			//ColumnNumber =meta.getColumnCount();
			//int i=0;
			while(res.next()){
				/*Vector<String>temp = new Vector<String>();
				for(int i=1;i<=ColumnNumber;i++)
					temp.addElement(res.getString(i));
				//System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3));
				ContValues.addElement(temp);
				RowNumber++;*/
				//for(int i =1;i<=Avail_Emp;i++)
				//System.out.println(res.getString(1));
				ContValues.addElement(res.getString(1));
				//Avail_EmpName[i]=res.getString(1);
				//i++;
			}
			//Avail_Emp=i-1;
			/*for(int j=0;j<ColumnNumber;j++){
				for(int i=0;i<RowNumber;i++){
					temp1.addElement(ContValues.get(i));
					System.out.print(((Vector<Vector<String>>) temp1.get(j)).get(i)+ " ");
				}
				System.out.print(j);
				System.out.println();
			}*/
			
				

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Error, while accessing Database\n");
			e.printStackTrace();
		}
		
	}
	
}
