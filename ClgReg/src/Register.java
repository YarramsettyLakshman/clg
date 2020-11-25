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

@WebServlet("/Register")
public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("type/html");
		PrintWriter out=response.getWriter();
		
		String uno=request.getParameter("Sno");
		    int Sno=Integer.valueOf(uno);
		String un=request.getParameter("University");
		String unm=request.getParameter("UName");
		String ad=request.getParameter("College Address");
		String gd=request.getParameter("Graduation");
		String c1=request.getParameter("Courses");
		String c2=request.getParameter("Courses");
		String ct=request.getParameter("College Type");
		String st=request.getParameter("Status");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Ramu");
			PreparedStatement pst=con.prepareStatement("insert into CollegeForm values(?,?,?,?,?,?,?,?,?)");
		
			pst.setString(1, uno);
            pst.setString(2, un);
            pst.setString(3, unm);
            pst.setString(4, ad);
            pst.setString(5, gd);
            pst.setString(6, c1);
            pst.setString(7, c2);
            pst.setString(8, ct);
            pst.setString(9, st);
            int i=pst.executeUpdate();
            if(i>0)
            {System.out.println("Registered Succesfuuly!");}
		}
		catch(Exception e)
		{System.out.println(e);}
		 out.close();
		
		}
		
	}
