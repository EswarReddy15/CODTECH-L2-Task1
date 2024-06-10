import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ad")

public class Adminservlet extends HttpServlet {
	 public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	    	String name=req.getParameter("name");
	    	String pwd=req.getParameter("pwd");
	    	res.setContentType("text/html");
	        String status=null;
	        PrintWriter pw=res.getWriter();
	        adminservices as=new adminservices();
	        try {
	        	status=as.checkLogin(name,pwd);
	        }
	        catch(Exception e){
	        	
	        	e.printStackTrace();
	        }
	        pw.println("<html>");
	        pw.println("<body bgcolor='lightblue'>");
	        pw.println("<center><br><br><br>");
	        if(status.equals("sucess")) {
	        
	        	pw.println("<h1>Login Success</h1>");
	        	res.sendRedirect("admin.html");
	       
	        }
	        else{
	        	
	        	pw.println("<h1>Login Failed</h1>");
	        	
	        }
	        pw.println("</center>");
	        pw.println("</body>");
	        pw.println("</html>");
	    }
}
