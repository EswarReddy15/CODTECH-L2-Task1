import java.sql.*;

public class adminservices {
    private String status;
    private Connection con;
  Statement st;
    public adminservices() {
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
    	     st=con.createStatement();
    	   }
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public String checkLogin(String name,String pwd)throws Exception{
    	ResultSet rs=st.executeQuery("select * from admin where ADMINNAME='"+name+"'and PASSWORD='"+pwd+"'");
    	if(rs.next()) {
    		status="sucess";
    	}
    	else {
    		status="failed";
    	}
    	return status;
    }
    public String RegLogin(int id,String name,int quan,double price)throws Exception {
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
    	    // st=con.createStatement();
    		PreparedStatement pst=con.prepareStatement("insert into products values(?,?,?,?)");
        	pst.setInt(1, id);
        	pst.setString(2, name);
        	pst.setInt(3, quan);
        	pst.setDouble(4, price);
        	int nr=pst.executeUpdate();
        	if(nr>0) {
        		status="sucess";
        	}
        	else {
        		status="failed";
        	}
    	   }
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return status;

    }                    
    
    public String Updatedata(int id,String name,int quan,double price)throws Exception{
    	
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
    	    
    	Statement st=con.createStatement();
    	int nr=st.executeUpdate("update products set id="+id+", quantity="+quan+", price="+price+" where name='"+name+"'");
        	if(nr>0) {
        		status="sucess";
        	}
        	else {
        		status="failed";
        	}
    	   }
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return status;
    }
    

    public static void main(String[] args) {
        adminservices adminService = new adminservices();
        try {
            String loginStatus = adminService.checkLogin("admin_name", "password");
            System.out.println("Login Status: " + loginStatus);
            
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
