import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("\njws")
public class useraction extends HttpServlet{
public  void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException ,ServletException{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		int id=Integer.parseInt(req.getParameter("pid"));
		String name=req.getParameter("pna");
		int quant=Integer.parseInt(req.getParameter("pqu"));
		double price=Double.parseDouble(req.getParameter("pri"));
         PreparedStatement ps=con.prepareStatement("select * from products;");
		out.print("<table width=75% border=1>");
		out.print("<caption>Items available</caption>");
		ResultSet rs=ps.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		int totalcolumn=rsmd.getColumnCount();
		out.print("<tr>");
		for(int i=1;i<=totalcolumn;i++) {
			out.print("<th>"+rsmd.getColumnName(i)+"</th>");
			
		}
		out.print("<tr>");
		while(rs.next()) {
			out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getDouble(4)+"</td></tr>");
			
		}
		out.print("</table>");
	}catch(Exception e) 
	{
		e.printStackTrace();
	}
}
}
