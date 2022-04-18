package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@SuppressWarnings("serial")
@WebServlet("/logout")

public class LogoutHandler extends HttpServlet {
	
	
	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
		
           
            
         HttpSession session=request.getSession();  
         session.invalidate();  
         response.sendRedirect("login.jsp"); 
           
		
	}

	@Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doPost(request, response);
	}

}