import java.io.*;


import java.sql.*;


import javax.servlet.*;

import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/us")
public class Userservlet extends HttpServlet {
	 public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	    	String name=req.getParameter("name");
	    	String pwd=req.getParameter("pwd");
	    	res.setContentType("text/html");
	        String status=null;
	        PrintWriter pw=res.getWriter();
	        try {
        		Class.forName("oracle.jdbc.driver.OracleDriver");
        		Connection con=DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:orcl","scott","tiger");
        		Statement st=con.createStatement();
        		ResultSet rs=st.executeQuery("select * from users where USERNAME='"+name+"'and PASSWORD='"+pwd+"'");
        		if(rs.next()) {
        			pw.println("<center><h1>Welcome To Digimart<h1></center>");
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
