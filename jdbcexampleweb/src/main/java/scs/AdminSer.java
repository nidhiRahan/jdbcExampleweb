package scs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.Datahelper;

/**
 * Servlet implementation class AdminSer
 */
@WebServlet("/AdminSer")
public class AdminSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Datahelper obj = new Datahelper();
		PrintWriter out = response.getWriter();
		try {
			obj.makeConnection();
			ResultSet res = obj.dqlRecord("Select * from admin where userid='"+request.getParameter("txtuid")+"' and password='"+request.getParameter("txtpass")+"'");
			if(res.next()) {
				response.sendRedirect("viewstudent.jsp");
			}
			else
			{
				response.sendRedirect("login.jsp?q=invalid userid and password");
			}
		} catch (ClassNotFoundException e) {
			out.print(e.getMessage().toString());
			
		} catch (SQLException e) {
			out.print(e.getMessage().toString());
			
		}
		
				
	}

}
