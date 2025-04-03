package in.softronix.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.softronix.entity.Student;
import in.softronix.factory.ServiceFactory;
import in.softronix.service.StudentService;


@WebServlet("/edit/*")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
		
       RequestDispatcher rd = null;
		StudentService service = ServiceFactory.getService();

		String param = request.getPathInfo();
        
		
		if(param ==null || param.equals("/") || !param.substring(1).matches("\\d+"))
		{
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid student ID");
			return;
		}
		int sid = Integer.parseInt(param.substring(1));
          
		Student student=service.searchStudent(sid);
		
		
		
		if(student !=null)
		{
			request.setAttribute("students", student);
			rd =request.getRequestDispatcher("/display.jsp");
			rd.forward(request, response);
			
		}
		
		else {
			
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "student not found");
			
		    }
	}
}
		