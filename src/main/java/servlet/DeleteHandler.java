package servlet;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.deleteDB;

@SuppressWarnings("serial")	
@WebServlet("/deleteleave") 


public class DeleteHandler extends HttpServlet {
	
	

	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
		String url="/index.jsp";
		HttpSession session=request.getSession(true);
		String lid = (String) session.getAttribute("lid");

		if (lid == null) {
			url = "/userpage"; 
		}
		
		else if(lid != null){
			
			try {
				deleteDB.deleteUser(lid);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			String error = "Leave Deleted Succesfully";
			url="/userpage";
			request.setAttribute("error", error);
		
			
		}

		
		
		
		request.getRequestDispatcher(url)
		.forward(request, response);
	}

	@Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doPost(request, response);
	}

}