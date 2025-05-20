package electricity.billing.system;

import java.sql.*;

public class Conn 
{
	Connection c;
	Statement s;
	Conn()
	{
		try 
		{
			c = DriverManager.getConnection("jdbc:mysql://localhost:3307/ebs", "root", "Sakshee@2104");
			s = c.createStatement();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
