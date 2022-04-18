package servlet;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.getLeave;
import tables.leave;

@SuppressWarnings("serial")
@WebServlet("/edit")

public class ShowEdit extends HttpServlet {
	
	
	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
			
		HttpSession session=request.getSession(true);	
        String lid=(String) session.getAttribute("lid");
        String error=(String) request.getAttribute("add");
        leave leave = null ;			
		String url;

	       	        				
			if (lid==null) {
				url = "/login.jsp"; 
			}
			
			if (lid != null && error != null) {
				
				leave = (tables.leave) request.getAttribute("leave");
				url = "/editLeave.jsp";
			}
			
			
			else  {
				
				try {					
					leave = getLeave.getUserData(lid);
					
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				
				
				url = "/editLeave.jsp"; 				
				request.setAttribute("leave", leave);
				
				
	
				}
				
		
			

			
							
							     
		
		
		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);
	}

	@Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doPost(request, response);
	}

}