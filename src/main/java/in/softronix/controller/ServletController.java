package in.softronix.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.softronix.entity.Student;
import in.softronix.factory.ServiceFactory;
import in.softronix.service.StudentService;


@WebServlet("/add")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    String buttonLabel = request.getParameter("button");
		
		RequestDispatcher rd=null;
		String status="";
		Student std=new Student();
		StudentService service=ServiceFactory.getService();
		
		if (buttonLabel != null) {
            buttonLabel = buttonLabel.trim();
        }
		
		if( buttonLabel != null && buttonLabel.equalsIgnoreCase("ADD"))
		{
			std.setSid(Integer.parseInt(request.getParameter("sid")));
			std.setSname(request.getParameter("sname"));
			std.setSmarks(Float.parseFloat(request.getParameter("smarks")));
			std.setSaddr(request.getParameter("saddr"));
			
			status=service.addstudent(std);
			if(status.equals("success"))
			{
				rd=request.getRequestDispatcher("./success.html");
				rd.forward(request, response);
			}
			if(status.equals("failure"))
			{
				rd=request.getRequestDispatcher("./failure.html");
				rd.forward(request, response);
			}
			
			
			
			
		}
		
		if( buttonLabel.equals("DISPLAY"))
		{
            List<Student> student = service.getStudent();
			
			if(student !=null)
			{
			
			    request.setAttribute("student", student);
			    rd=request.getRequestDispatcher("/display.jsp");
			    rd.forward(request, response);
			}
			else {
				
				rd=request.getRequestDispatcher("/empty.html");
			    rd.forward(request, response);
			}
			
		}
		
		
		
		
	}
	}


