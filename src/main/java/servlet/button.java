package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/selectleave")

public class button extends HttpServlet {
	
	
	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
		
		HttpSession session=request.getSession(true);		
        String id=(String) session.getAttribute("id");
        String action = request.getParameter("action");
        String lid = request.getParameter("id");	
		String url = "login";

	       	        				
			if (id==null) {
				url = "login"; 
			}
			
									
			
			if (action != null){
				
				if (action.contentEquals("apply")) {
					url = "addleave.jsp";
					session.setAttribute("id",id);
				}
				
				else if (lid == null) {
					url = "/userpage";
					String error = "Please Select Leave";
					request.setAttribute("error", error);	
					getServletContext()
					.getRequestDispatcher(url)
					.forward(request, response);
				}
				
				else if (action.contentEquals("edit")) {
					url = "edit";		
					session.setAttribute("lid", lid);
				}
				
				else if  (action.contentEquals("delete")) {
					url = "deleteleave";	
					session.setAttribute("lid", lid);
				}
				
			}

			
			
			
			
			
				
		
																				     				
			response.sendRedirect(url);  
	}

	@Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doPost(request, response);
	}

}