import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	 String uno=request.getParameter("Sno");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Ramu");
			PreparedStatement pst=con.prepareStatement("delete RegisteredCollegeDetails where Sno='"+uno+"'");
			int i=pst.executeUpdate();
			if(i>0)
			{out.print("Data is Successfully Deleted!");}
			else
			{out.print("Data is Not Successfully Deleted");}
		}
		catch(Exception e)
		{System.out.println(e);}
			
		}
	}

