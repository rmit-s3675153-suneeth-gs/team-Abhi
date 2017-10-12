
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Random;

public class AdminCreate implements ActionListener{

	
	private JLabel Hyde2;
	private JFrame frameAcreate;
	private JPanel PanelAcreate;
	private JLabel LabelEmpID,LabelEmpName1,LabelEmpName2,LabelEmpProf,LabelEmpAddress,LabelEmpPhone;
	private JTextField TextEmpID,TextEmpName1,TextEmpName2,TextEmpAddress,TextEmpPhone;
	private JButton Create,Close;
	private JComboBox<String> TextEmpProf;
	String TempID,TempFirst,TempLast,TempOccu,TempAdd,TempPhone,s; 
	String[] Occu ={"Royal","Government","Police"};
	static final Logger log = Logger.getLogger(AdminCreate.class);
	public AdminCreate() {
		// TODO Auto-generated constructor stub
	}
	//System.out.println("!@!@#!@#!@#");
	public void AdminPageCreate(){
		//System.out.println("!@!@#!@#!@#3");
		frameAcreate = new JFrame("Admin_Employee_Creation");
		frameAcreate.setSize(800,800);//frame creating
		frameAcreate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAcreate.setLocation(600,200 );
		//frameAcreate.setLayout(new GridLayout(0,3));
		PanelAcreate= new JPanel();
		frameAcreate.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde_admincreate.jpg")));//adding image on the background
		Hyde2 = new JLabel();
		frameAcreate.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		frameAcreate.setResizable(false);
		
		frameAcreate.add(Hyde2);
		LabelEmpID = new JLabel("                          EmpID");//Label for each attributes.
		LabelEmpID.setBounds(150,10,200,40);
		LabelEmpID.setOpaque(true);
		
		LabelEmpName1 = new JLabel("                  EmpFirstName");
		LabelEmpName1.setBounds(150,100,200,40);
		LabelEmpName1.setOpaque(true);
		
		
		LabelEmpName2 = new JLabel("                  EmpLastName");
		LabelEmpName2.setBounds(150,200,200,40);
		LabelEmpName2.setOpaque(true);
		
		LabelEmpProf = new JLabel("                   Occupation");
		LabelEmpProf.setBounds(150,300,200,40); 
		LabelEmpProf.setOpaque(true);
		
		LabelEmpAddress = new JLabel("                      Address");
		LabelEmpAddress.setBounds(150,400,200,40); 
		LabelEmpAddress.setOpaque(true);
		
		LabelEmpPhone = new JLabel("                        Phone");
		LabelEmpPhone.setBounds(150,500,200,40); 
		LabelEmpPhone.setOpaque(true);
		
		
		TextEmpID = new JTextField();						//textfield for each attributes
		TextEmpID.setBounds(450,10,200,40);
		
		TextEmpName1= new JTextField();
		TextEmpName1.setBounds(450,100,200,40);
		
		TextEmpName2 = new JTextField();
		TextEmpName2.setBounds(450,200,200,40);
		
		TextEmpProf = new JComboBox<String>(Occu);
		TextEmpProf.setBounds(450,300,200,40);
		
		TextEmpAddress = new JTextField();
		TextEmpAddress.setBounds(450,400,200,40);
		
		TextEmpPhone = new JTextField();
		TextEmpPhone.setBounds(450,500,200,40);
		
		Create = new JButton("Create Account");			//button
		Create.setBounds(300, 600, 200, 40);
		
		Close = new JButton("Back to Admin Function");
		Close.setBounds(300,700,200,40);
		
		
		//System.out.println("!@!@#!@#!@#4");
		
		frameAcreate.add(LabelEmpID);
		frameAcreate.add(LabelEmpName1);
		frameAcreate.add(LabelEmpName2);
		frameAcreate.add(LabelEmpProf);
		//System.out.println("!@!@#!@#!@#56");
		frameAcreate.add(LabelEmpAddress);
		frameAcreate.add(LabelEmpPhone);
		//frameAcreate.add(LabelDel);
		//System.out.println("!@!@#!@#!@#56");
		frameAcreate.add(TextEmpID);
		frameAcreate.add(TextEmpName1);
		frameAcreate.add(TextEmpName2);
		frameAcreate.add(TextEmpProf);
		frameAcreate.add(TextEmpAddress);
		frameAcreate.add(TextEmpPhone);
		//frameAcreate.add(TextDel);
		//System.out.println("!@!@#!@#!@#56");
		frameAcreate.add(Create);
		frameAcreate.add(Close);
		//frameAcreate.add(Delete);
		Create.setActionCommand("CREATE");
		Create.addActionListener(this);	
		//setting action command and actionlistener
		Close.setActionCommand("CLOSE");
		Close.addActionListener(this);
		//System.out.println("!@!@#!@#!@#5");
		 
		
		//System.out.println("!@!@#!@#!@#6");
		
		frameAcreate.add(PanelAcreate);
		//System.out.println("!@!@#!@#!@#4");
//		Window tim = new Window();
//		JLabel time = new JLabel(tim.TIME());
//		time.setBounds(10, 10, 200, 40);
//		frameAcreate.add(time);
		frameAcreate.setVisible(true);
		
		
	}//admin page Function end
	//public void actionPerformed(ActionEvent e,Window win){
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		Connection Mycon = null;
//		try {
//			Mycon = DriverManager.getConnection(null);
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		if(e.getActionCommand()=="CREATE"){
			//frameAcreate.setVisible(false);
			TempID 		= 	EMPID();
			TempFirst 	=	EMPFIRSTNAME();
			TempLast 	=	EMPLASTNAME();
			TempOccu	=	EMPOCCU();
			TempAdd		=	EMPADD();
			TempPhone	=	EMPPHO();
			
			char id;
			char oc;
			id=TempID.charAt(0);
			oc=Character.toLowerCase(TempOccu.charAt(0));
			//ID=new String(id);
			if(id!=oc){
				JOptionPane.showMessageDialog(null, "Royal - Employee ID should start with 'r'\nGoverment - Employee ID should start with 'g'\nPolice - Employee ID should start with 'p'");
				log.info("Entered wrong prefix for Employee ID while creating account ! \n");
			}else{
				s="";
				Random rand= new Random();
				for(int i=0;i<6;i++){//random function to create a six digit password for each employee.
					int number =1+rand.nextInt(9);
					System.out.println(number);
					
					s=s+number;
				}
				System.out.println(s);
				System.out.println(" qweqwe"+TempID+"1234");
				System.out.println(TempFirst);
				System.out.println(TempLast);
				System.out.println(TempOccu);
				System.out.println(TempAdd);
				System.out.println(TempPhone);
				System.out.println("!@!@#!@#!@#");
				//CreateAcc.addActionListener(new AdminCreate());
				SqlInsertEmp(Mycon);
				//AdminEMPCreate AdmEMPCreate= new AdminEMPCreate();
				//AdmEMPCreate.EmpCreate();
					//System.out.println("!@!@#!@#!@#2");
			}
			
		}
		if(e.getActionCommand()=="CLOSE"){
			frameAcreate.setVisible(false);
			log.info("Back to Admin Page ! \n");
			AdminFunctionPage ALP = new AdminFunctionPage();
			ALP.AdminControl();
		}
	}
	public String EMPID(){
	      return TextEmpID.getText();
	 }
	public String EMPFIRSTNAME(){
	      return TextEmpName1.getText();
	 }
	public String EMPLASTNAME(){
	      return TextEmpName2.getText();
	 }
	public String EMPOCCU(){
	      return TextEmpProf.getItemAt(TextEmpProf.getSelectedIndex());
	 }
	public String EMPADD(){
	      return TextEmpAddress.getText();
	 }
	public String EMPPHO(){
	      return TextEmpPhone.getText();
	 }
	public Connection SqlInsertEmp(Connection Mycon){
	
		try{
			/*if(TempID==" "||TempFirst==" "||TempLast==" "||TempOccu==" "||TempAdd==" "){
					JOptionPane.showMessageDialog(null,"Please enter every value");
				
			}else*/
					Mycon =DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
					Statement Mystmt = Mycon.createStatement();
					String Sql ="insert into employee values('"+TempID+"','"+TempFirst+"','"+TempLast+"','"+TempOccu+"','"+TempAdd+"','"+TempPhone+"','"+s+"')";
					Mystmt.executeUpdate(Sql);
					JOptionPane.showMessageDialog(null,"Employee Account Created");
					frameAcreate.setVisible(false);
					log.info("Employee Account Created EMP ID = "+ TempID +"\n");
					AdminFunctionPage ALP = new AdminFunctionPage();
					ALP.AdminControl();
			//}
		}catch(SQLException e1){
			log.error("Enter The Employee Details Again ! \n");
			JOptionPane.showMessageDialog(null,"Enter The Employee Details Again");
			e1.printStackTrace();
		}
		return Mycon;
				
		
	}
			

}

