import java.io.*;
import java.sql.*;
public class display
{
	public static void main(String args[]) throws Exception, SQLException
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			Statement stmt=con.createStatement();
			String sql="select * from starting";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String NAME=rs.getString("NAME");
				String ANAME=rs.getString("ADMIN_NAME");
				int  ID=rs.getInt("DESCRIBE");
				int PH_NO=rs.getInt("PHONE_NO");
				String EMAIL=rs.getString("EMAIL");
				String BRANCH=rs.getString("BRANCH");
				String YEAR=rs.getString("YEAR_STUDY");
				System.out.println("name:"+NAME);
				System.out.println("aname:"+ANAME);
				System.out.println("id:" +ID);
				System.out.println("ph_no:"+PH_NO);
				System.out.println("gender:" +EMAIL);
				System.out.println("job:" +BRANCH);
				System.out.println("name:"+YEAR);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}