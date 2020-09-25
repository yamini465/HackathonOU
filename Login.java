import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException { 

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
out.println("welcome");
   try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "system", "system");
Statement s=con.createStatement();
out.println("CONNECTION OK");
	//creating statement	
String funame=request.getParameter("uname");
String fpwd=request.getParameter("pwd");
ResultSet rs=s.executeQuery("select * from admin where name='"+funame+"' and password='"+fpwd+"'");	//executing statement	
if(rs.next())
{
out.println("<h1>User logged in successfully</h1>");
}
else  
{
out.println("<h1>User Not Authorized</h1>");
}
con.close();	//closing connection	
out.close();

}catch(SQLException e)
{
out.println(e);
}
catch(ClassNotFoundException e)
 {out.println(e);
 }
   }
}