package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.checkDate;
import dao.editDB;
import dao.formatDate;
import tables.leave;

@SuppressWarnings("serial")
@WebServlet("/editleave") 
public class EditHandler extends HttpServlet {
	
	
	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
		String url="/editLeave.jsp";
		HttpSession session=request.getSession(true);
		String id = (String) session.getAttribute("id");		
		String datefrom = request.getParameter("datefrom");
		String dateto= request.getParameter("dateto");
		String fdatefrom = formatDate.fdate(datefrom);
		String fdateto = formatDate.fdate(dateto);
		String cdate = checkDate.cdate(fdatefrom,id);
		String cdate1 = checkDate.cdate(fdateto,id);
		
		System.out.println(datefrom);
		System.out.println(dateto);
		System.out.println(fdatefrom);
		System.out.println(fdateto);
		
		if (id != null) {
			
			String lid = request.getParameter("id");
			String bckoffice = request.getParameter("bckoffice");
			String offleave = request.getParameter("offleave"); 
			String reason = request.getParameter("reason");     
			String remark = request.getParameter("remark");     
										
			leave leave = new leave(datefrom,dateto,bckoffice,reason,remark, lid, offleave);
				
			String message;
			
			if(id.isEmpty() || datefrom.isEmpty() || dateto.isEmpty() ||bckoffice.isEmpty() ||
					reason.isEmpty() || offleave.isEmpty() || remark.isEmpty()) {
				
				message ="Please fill out all text boxes";
				url = "/edit";
				request.setAttribute("lid", lid);
				request.setAttribute("add", message);
				request.setAttribute("leave", leave);
			}
			
			if (cdate != null || cdate1 != null) {
				
				message ="Dates are given";
				url = "/edit";
				request.setAttribute("lid", lid);
				request.setAttribute("add", message);
				request.setAttribute("leave", leave);
			}
					
					
		
					
		      else{
		      message = "Leave Edited Succesfully";
		      url="/edit"; 
		      editDB.insert(leave);                 
		                 
		      request.setAttribute("leave", leave);
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