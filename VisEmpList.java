import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

import org.apache.log4j.Logger;
public class VisEmpList implements ActionListener {
	private JFrame frameVEL;
	private JButton Button,Close;
	private JPanel PanelVEL;
	private JComboBox<String> Combo;
	private JLabel Hyde;
	Vector<String> contValuesNew= new Vector<String>();
	String[] Avail_EmpName;
	static final Logger log = Logger.getLogger(VisEmpList.class);
	public VisEmpList() {
		// TODO Auto-generated constructor stub
	}

	public void EmpList(Vector<String> contValues) {
		Avail_EmpName= new String[contValues.size()];
		// TODO Auto-generated method stub
		/*String s =contValues.get(0);
		System.out.println("red  "+s);
		System.out.println("red  "+contValues.get(1));
		System.out.println("red  "+contValues.get(2));*/
//		for(int i=0;i<contValues.size();i++){
//			String s = contValues.get(i);
//			contValuesNew.addElement(contValues.get(i));
//		}
		
		for(int i=0;i<contValues.size();i++){
			String s = contValues.get(i);
			Avail_EmpName[i]=s;
			contValuesNew.addElement(contValues.get(i));
		}
		for(int i=0;i<contValuesNew.size();i++){
			//String s = contValues.get(i);
			System.out.println(contValuesNew.get(i)+" "+Avail_EmpName[i]+" "+Avail_EmpName.length);
		}
		frameVEL = new JFrame("EMPLOYEE LIST");
		frameVEL.setSize(800, 800);
		frameVEL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameVEL.setResizable(false);
		
		PanelVEL = new JPanel();
		
		Combo = new JComboBox<String>(Avail_EmpName);
		Combo.setBounds(300, 200, 200, 40);
		
		Button = new JButton("Enter");
		Button.setBounds(300, 300, 200, 40);
		
		Close = new JButton("Back to Contact Guard");
		Close.setBounds(300, 400, 200, 40);
		
		frameVEL.setContentPane(new JLabel(new ImageIcon("E://hydePark/emplist.jpg")));
		Hyde = new JLabel();
		
		frameVEL.add(Combo);
		frameVEL.add(Hyde);
		frameVEL.add(Button);
		frameVEL.add(PanelVEL);
		frameVEL.add(Close);
		frameVEL.setVisible(true);
		
		Button.setActionCommand("ENTER");
		Button.addActionListener(this);
		
		Close.setActionCommand("CLOSE");
		Close.addActionListener(this);
	}
	public String ComboReturn(){
		return Combo.getItemAt(Combo.getSelectedIndex());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="ENTER"){
			frameVEL.setVisible(false);
			log.info(" Entering the Employee SnapShot Function\n");
			VisSnapShown VSS = new VisSnapShown();
			VSS.SnapShown(ComboReturn());
			
		}
		if(e.getActionCommand()=="CLOSE"){
			frameVEL.setVisible(false);
			log.info(" Back to Contact Guard  \n");
			VisContactGuard VSS = new VisContactGuard();
			VSS.ContactGuard();
			
		}
		
	}

}
