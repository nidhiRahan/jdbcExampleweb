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
 * Servlet implementation class StudentDeleteSer
 */
@WebServlet("/StudentDeleteSer")
public class StudentDeleteSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
		//	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","nidhi@123");
		//	Statement st = con.createStatement();
			//int x = st.executeUpdate("delete from student where rno='"+request.getParameter("txtrno")+"'");
			Datahelper obj = new Datahelper();
			obj.makeConnection();
			int x = obj.dmlRecord("delete from student where rno='"+request.getParameter("txtrno")+"'");
			if(x!=0)
			{
				response.sendRedirect("viewstudent.jsp");
			}
		}
		catch(Exception ex)
		{
			out.print(ex.getMessage().toString());
		}
	}

}
