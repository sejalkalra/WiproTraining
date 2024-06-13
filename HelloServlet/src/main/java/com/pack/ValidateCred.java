package com.pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateCred
 */
@WebServlet("/ValidateCred")
public class ValidateCred extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ValidateCred() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//app
		ServletContext ctx = getServletContext();
		String s1= ctx.getInitParameter("n1");
		out.println("String is: "+s1);
		//con
		ServletConfig conf=getServletConfig();		
        String s2=conf.getInitParameter("x");
        out.println("String is: "+s2);
		
		String user = "admin", pass = "123";
		
		String uname = request.getParameter("uname");
		String upass= request.getParameter("pass");
		
		if(user.equals(uname) && pass.equals(upass)) {
			out.println("<html><body>");
			out.println("<h1 style=\"color:green;\">Login Sucessfull</h1>");
			out.println("</body></html>");
			
			RequestDispatcher rd=request.getRequestDispatcher("/success.html");  
			rd.include(request, response); 
		}
		else {
			out.println("<html><body>");
			out.println("<h1 style=\"color:red;\">Invalid!</h1>");
			out.println("</body></html>");
			
			RequestDispatcher rd=request.getRequestDispatcher("failure.html");  
			rd.include(request, response); 
		}
			
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
