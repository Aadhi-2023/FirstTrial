package registerclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegisterDAO 
{
	public String insert(List list) 
	{
		try {
			String sql = "insert into register values (?,?,?,?)";
			String url = "jdbc:mysql://localhost:3306/dolist";
			String username = "root";
			String password = "admin";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, list.getUname());
			ps.setString(2, list.getPassword());
			ps.setString(3, list.getEmail());
			ps.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
}
