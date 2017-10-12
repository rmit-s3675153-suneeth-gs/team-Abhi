import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

//import javafx.scene.shape.Shape3D;


public class EmployeeSnap implements ActionListener{
	private JFrame frameSnap;
	private JPanel PanelSnap;
	private JLabel label,Hyde;
	private JTextField Source;
	private JButton Button,Close;
	String TempUser;
	public EmployeeSnap() {
		// TODO Auto-generated constructor stub
	}
//	public static void main(String []args){
//		EmployeeSnap s = new EmployeeSnap();
//		s.EmpSnap();
	static final Logger log = Logger.getLogger(EmployeeSnap.class);
//	}
	public void EmpSnap(String TempUser1) {
		// TODO Auto-generated method stub
		TempUser=TempUser1;
		
		frameSnap = new JFrame("SnapShot");
		frameSnap.setSize(700,700);
		frameSnap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSnap.setResizable(false);
		frameSnap.setContentPane(new JLabel(new ImageIcon("E://hydePark/images.jpg")));
		Hyde = new JLabel();
		frameSnap.add(Hyde);
		PanelSnap = new JPanel();
		
		
		label = new JLabel("Enter the Address");
		label.setBounds(100,200,200,40);
		Source = new JTextField();
		Source.setBounds(300,200,300,40);
		Button = new JButton("Upload Photo");
		Button.setBounds(200,300,200,40);
		Close = new JButton("CLOSE");
		Close.setBounds(200, 400, 200, 40);
		
		frameSnap.add(label);
		frameSnap.add(Source);
		frameSnap.add(Button);
		frameSnap.add(Close);
		frameSnap.add(PanelSnap);
	
		
		Button.setActionCommand("BUTTON");
		Close.setActionCommand("CLOSE");
		Button.addActionListener(this);
		Close.addActionListener(this);
		frameSnap.setVisible(true);
		
		
	}
	public String AddressPhoto(){
		return Source.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="BUTTON"){
			String s = AddressPhoto();
			File s1 = new File(s);
			File s2 = new File("E://hyde_employee");
			if(s1.exists()){
				try {
					System.out.println("FILE NAME AND USER ID"+s1.getName()+ " "+TempUser);
//					String tempS = s1.getName();
//					char [] t = null;
//					for(int i =0;i<tempS.length();i++){
//						if(tempS.charAt(i)=='.'){
//							break;
//						}
//						t[i] = tempS.charAt(i);
//						
//					}
//					tempS=new String(t);
//					
					if(s1.getName().compareTo(TempUser+".jpg")==0){
						System.out.println("FILE NAME AND USER ID"+s1.getName()+ " "+TempUser);
						FileUtils.copyFileToDirectory(s1,s2);
						JOptionPane.showMessageDialog(null, "Photo Uploaded ","Done", 1);
						frameSnap.setVisible(false);
		            	log.info("Image of the employee has been uploaded in the Employee Photo Folder\n");
						EmployeeFunctionPage EFP = new EmployeeFunctionPage();
						EFP.EmployeeFunction(TempUser);
					}
					else{
		            	log.info("Rename The Photo, matching it with EmpId\n");
						JOptionPane.showMessageDialog(null, "Please Rename Your Photo to Employee ID","Done", 1);
					}
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
	            	log.error("Error while moving the Photo to the address\n");
					e1.printStackTrace();
					
				}
			}
			else{
            	log.info("Mentioned address not Found\n");
				JOptionPane.showMessageDialog(null, "Error File Not Found");
			}
			
		}
		if(e.getActionCommand()=="CLOSE"){
			frameSnap.setVisible(false);
        	log.info("Back to Employee Page\n");
			EmployeeFunctionPage EFP = new EmployeeFunctionPage();
			EFP.EmployeeFunction(TempUser);
			
		}
		
	}

	
}
