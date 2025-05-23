package electricity.billing.system;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
//import java.util.*;

@SuppressWarnings("serial")
public class MeterInfo extends JFrame implements ActionListener
{
	JTextField tfname, tfaddress, tfstate, tfcity, tfemail, tfphone;
	JButton next, cancel;
	JLabel lblmeter;
	Choice meterLocation, metertype, phasecode, billtype;
	String meternumber;
	MeterInfo(String meternumber)
	{
		this.meternumber = meternumber;
		setSize(700, 500);
		setLocation(350, 150);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173, 216, 230));
		add(p);
		
		JLabel heading = new JLabel("Meter Information");
		heading.setBounds(100, 10, 200, 20);
		heading.setFont(new Font("Tahona", Font.PLAIN, 24));
		p.add(heading);
		
		JLabel lblname = new JLabel("Meter Number");
		lblname.setBounds(100, 80, 100, 20);
		p.add(lblname);
		
		JLabel lblmeternum = new JLabel(meternumber);
		lblmeternum.setBounds(240, 80, 100, 20);
		p.add(lblmeternum);
		
		JLabel lblmeterno = new JLabel("Meter Loaction");
		lblmeterno .setBounds(100, 120, 100, 20);
		p.add(lblmeterno );
		
		meterLocation = new Choice();
		meterLocation.add("Outside");
		meterLocation.add("Inside");
		meterLocation.setBounds(240, 120, 200, 20);
		p.add(meterLocation);
		
		JLabel lbladdress = new JLabel("Meter Type");
		lbladdress.setBounds(100, 160, 100, 20);
		p.add(lbladdress);
		
		metertype = new Choice();
		metertype.add("Electric Meter");
		metertype.add("Solar Meter");
		metertype.add("Smart Meter");
		metertype.setBounds(240,160,200,20);
		p.add(metertype);
		
		JLabel lblcity = new JLabel("Phase Code");
		lblcity.setBounds(100, 200, 100, 20);
		p.add(lblcity);
		
		phasecode = new Choice();
		phasecode.add("011");
		phasecode.add("022");
		phasecode.add("033");
		phasecode.add("044");
		phasecode.add("055");
		phasecode.add("066");
		phasecode.add("077");
		phasecode.add("088");
		phasecode.add("099");
		phasecode.setBounds(240,200,200,20);
		p.add(phasecode);
		
		JLabel lblstate = new JLabel("Bill Type");
		lblstate.setBounds(100, 240, 100, 20);
		p.add(lblstate);
		
		billtype = new Choice();
		billtype.add("Normal");
		billtype.add("Industrial");
		billtype.setBounds(240,240,200,20);
		p.add(billtype);
		
		JLabel lblemail = new JLabel("Days");
		lblemail.setBounds(100, 280, 100, 20);
		p.add(lblemail);
		
		JLabel lblemails = new JLabel("30 Days");
		lblemails.setBounds(240, 280, 100, 20);
		p.add(lblemails);
		
		JLabel lblphone = new JLabel("Note");
		lblphone.setBounds(100, 320, 100, 20);
		p.add(lblphone);
		
		JLabel lblphones = new JLabel("By default Bill is calculated for 30 days only");
		lblphones.setBounds(240, 320, 500, 20);
		p.add(lblphones);
		
		next = new JButton("Submit");
		next.setBounds(220, 390, 100, 25);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		p.add(next);
		
		setLayout(new BorderLayout());
		
		add(p, "Center");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hicon1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
		ImageIcon  i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image, "West");
		
		getContentPane().setBackground(Color.WHITE);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == next)
		{
			String meter = meternumber;
			String location = meterLocation.getSelectedItem();
			String type = metertype.getSelectedItem();
			String code = phasecode.getSelectedItem();
			String btype = billtype.getSelectedItem();
			String days = "30";
			
			String query = "insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+code+"', '"+btype+"','"+days+"')";
			
			try
			{
				Conn c = new Conn();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Meter Information Added Successfully");
				setVisible(false);
				
				//new Frame
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			setVisible(false);
		}
	}
	
	public static void main(String[] args)
	{
		new MeterInfo("");
	}
}
