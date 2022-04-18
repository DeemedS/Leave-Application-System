package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.getid;
import dao.loginDB;

@SuppressWarnings("serial")
@WebServlet("/login")

public class LoginHandler extends HttpServlet {
	
	
	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
		
		
			String url="/login.jsp";
			String action = request.getParameter("action");
			HttpSession session=request.getSession(); 
			String id1=(String) session.getAttribute("id"); 
	       
	        
				
			String message;
			
			if (action==null) {
				url = "login.jsp"; 
				
				if (id1 != null) {
					url = "userpage"; 
				}
			}
			
			
			else if (action.equals("login")) {
				
				String username = request.getParameter("username");
				String password = request.getParameter("password"); 			
				String id = getid.id(username,password);		
				session.setAttribute("id",id);
			
				if(loginDB.check(username,password)) {
				
				
			     url="userpage";                  
				
				}
				
				else{
			        message = "Incorrect Username or Password " ;
			        url="/login.jsp";                  			                  
					request.setAttribute("message", message);
					
					getServletContext()
					.getRequestDispatcher(url)
					.forward(request, response);
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