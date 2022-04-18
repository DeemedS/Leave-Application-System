package servlet;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import tables.leave;
import tables.name;
import tables.num;
import dao.getNumday;
import dao.getname;
import dao.listDB;


@SuppressWarnings("serial")
@WebServlet("/userpage")


public class showleave extends HttpServlet {
	
	
	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		     throws ServletException, IOException{
		
		String url="/login.jsp";
		
		HttpSession session=request.getSession(true);		
        String id=(String) session.getAttribute("id"); 
        
		if (id != null) {
			
			
			

			ArrayList<leave> leave = null;
			ArrayList<num> num = null;
			name user = null;
			
			try {
				num = new ArrayList<num>(getNumday.getNum(id));
				leave = new ArrayList<leave>(listDB.getUsersList(id));
				user = getname.getUserData(id);
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			

		
			
			request.setAttribute("leave", leave);
			request.setAttribute("num", num);
			session.setAttribute("user", user);
			url="/userpage.jsp";
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