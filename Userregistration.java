import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/usn")
public class Userregistration extends HttpServlet {
	 public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	    	String name=req.getParameter("name");
	    	String pwd=req.getParameter("pwd");
	    	res.setContentType("text/html");
	        String status=null;
	        PrintWriter pw=res.getWriter();
	        try {
        		Class.forName("oracle.jdbc.driver.OracleDriver");
        		Connection con=DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:orcl","scott","tiger");
        		PreparedStatement pst=con.prepareStatement("insert into users values(?,?)");
        		pst.setString(1, name);
        		pst.setString(2, pwd);
        		ResultSet rs=pst.executeQuery();
        		if(rs.next()) {
        			pw.println("<center><h1>Welcome To Digimart<h1></center>");
        			for(int i=0;i<2555;i++) {
        			}
        			RequestDispatcher rd=req.getRequestDispatcher("user.html");
        			rd.forward(req,res);
        		}
        		else {
        			pw.println("<center><h1>Creation failed<h1></center>");
        			RequestDispatcher rd=req.getRequestDispatcher("login.html");
        			rd.include(req,res);
        		}
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
	 }
}

