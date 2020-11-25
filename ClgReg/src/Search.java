
import java.io.IOException;
import java.sql.ResultSetMetaData;



import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException,IOException{
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
     
		     String Slno=request.getParameter("Sno");
		     int Sno=Integer.valueOf(Slno);
		    try
		    {
		    	Class.forName("oracle.jdbc.driver.OracleDriver");
		         Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Ramu");
		         PreparedStatement pst=con.prepareStatement("select * from CollegeForm where Sno=?");
		         pst.setInt(1, Sno);
		         ResultSet rs=pst.executeQuery();
		        ResultSetMetaData rsmd=rs.getMetaData();
		        int total=rsmd.getColumnCount();
		        for(int i=1;i<=total;i++)
		        {
		        	rsmd.getColumnName(i);
		        }
		         
		   while(rs.next())
		        { 
		       out.print(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5)+rs.getString(6)+rs.getString(7)+rs.getString(8));
		        }
		    }
		   catch(Exception e)
		        {e.printStackTrace();}
		   finally
		         {out.close();}
	}
}