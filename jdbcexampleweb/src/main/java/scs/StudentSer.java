package scs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.Datahelper;

/**
 * Servlet implementation class StudentSer
 */
@WebServlet("/StudentSer")
public class StudentSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","nidhi@123");
			//Statement st = con.createStatement();
		//	int x = st.executeUpdate("insert into student(rno,name,branch,fees) values('"+request.getParameter("txtrno")+"','"+request.getParameter("txtname")+"','"+request.getParameter("txtbranch")+"','"+request.getParameter("txtfees")+"')");
			Datahelper obj = new Datahelper();
			obj.makeConnection();
			int x = obj.dmlRecord("insert into student(rno,name,branch,fees) values('"+request.getParameter("txtrno")+"','"+request.getParameter("txtname")+"','"+request.getParameter("txtbranch")+"','"+request.getParameter("txtfees")+"')");
			if(x!=0)
			{
				out.print("Data Inserted Successfully");
			}
		}
		catch(Exception ex)
		{
			out.print(ex.getMessage().toString());
		}
	}

}
