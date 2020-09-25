<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>welcome</title>
</head>
<body>
 <% 
 try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement pst=con.prepareStatement("select * from starting");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				out.println("Name:"+rs.getString(1));
				out.print("AdminName:"+rs.getString(2));
				out.print("Describe:"+rs.getString(3));
				out.print("PhoneNo:"+rs.getString(4));
				out.print("Email:"+rs.getString(5));
				out.println("Branch:"+rs.getString(6));
				out.println("YearOfStudy:"+rs.getString(7));	
							    
			}
			pst.close();
			con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
%>
</body>
</html>