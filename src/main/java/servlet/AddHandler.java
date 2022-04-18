package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.addDB;
import dao.checkDate;
import dao.formatDate;
import tables.leave;

@SuppressWarnings("serial")
@WebServlet("/applyleave") 
public class AddHandler extends HttpServlet {
	
	
	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
		String url="/login";
		HttpSession session=request.getSession(true);
		String id = (String) session.getAttribute("id");
		
		 if (id == null) {
			 		 
			 response.sendRedirect(url);  
			 
		 }
		
		
		 if (id != null ) {
			 
			String id1 = (String) session.getAttribute("id");
			String datefrom = request.getParameter("datefrom");
			String dateto= request.getParameter("dateto");
			String fdatefrom = formatDate.fdate(datefrom);
			String fdateto = formatDate.fdate(dateto);												
			String cdate = checkDate.cdate(fdatefrom,id1);
			String cdate1 = checkDate.cdate(fdateto,id1);		
			String bckoffice = request.getParameter("bckoffice");
			String offleave = request.getParameter("offleave"); 
			String reason = request.getParameter("reason");     
			String remark = request.getParameter("remark"); 
		
			leave leave = new leave(datefrom,dateto,bckoffice,reason,remark, id1,offleave);
	
				
			String message;
			
			
			if (cdate != null || cdate1 != null) {
				
				message ="Dates are given";
				url = "/addleave.jsp";
				request.setAttribute("add", message);
				request.setAttribute("leave", leave);
			}
			
			else if(id1 == null || datefrom == null ||dateto == null || bckoffice == null || offleave == null || reason == null || remark == null || id.isEmpty() ||
					datefrom.isEmpty() || dateto.isEmpty() ||bckoffice.isEmpty() ||
					reason.isEmpty() || offleave.isEmpty() || remark.isEmpty()) {
				
				message ="Please fill out all text boxes";
				url = "/addleave.jsp";
				request.setAttribute("add", message);
				request.setAttribute("leave", leave);
				
			}
			
			

			
		
					
		      else{
		      message = "Leave Successfully Added";
		      url="/addleave.jsp"; 
		      addDB.insert(leave);                 
		      request.setAttribute("add", message);        
				}
									
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