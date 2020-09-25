import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Insert extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			String n=req.getParameter("n");
			String an=req.getParameter("e");
			String d=req.getParameter("d");
			String ph=req.getParameter("p");
			String e=req.getParameter("m");
			String b=req.getParameter("b");
			String y=req.getParameter("y");			
			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement stmt=con.prepareStatement("insert into starting values(?,?,?,?,?,?,?)");
			stmt.setString(1,n);
			stmt.setString(2,an);
			stmt.setString(3,d);
			stmt.setString(4,ph);
			stmt.setString(5,e);
			stmt.setString(6,b);
			stmt.setString(7,y);
			stmt.executeUpdate();
			}
			catch(Exception x)
			{
			}
	}
}