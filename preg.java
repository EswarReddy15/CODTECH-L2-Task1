import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/save")
public class preg extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
    	int id=Integer.parseInt(req.getParameter("pid"));
    	String name=req.getParameter("pna");
    	int quan=Integer.parseInt(req.getParameter("pqu"));
    	double price=Double.parseDouble(req.getParameter("pri"));
    	res.setContentType("text/html");
        String status=null;
        PrintWriter pw=res.getWriter();
        adminservices as=new adminservices();
        try {
        	status=as.RegLogin(id,name,quan,price);
        }
        catch(Exception e){
        	
        	e.printStackTrace();
        }
        pw.println("<html>");
        pw.println("<body bgcolor='lightblue'>");
        pw.println("<center><br><br><br>");
        if(status.equals("sucess")) {
        
        	pw.println("<h1>product Inserted</h1>");
        	
       
        }
        else{
        	
        	pw.println("<h1>Insertion fails</h1>");
        	res.sendRedirect("admin.html");
        }
        pw.println("</center>");
        pw.println("</body>");
        pw.println("</html>");
}
}
