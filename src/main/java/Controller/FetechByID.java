package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import dao.StudentDao;
import dto.Student;

@WebServlet("/fetechbyid")
public class FetechByID  extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao dao =new StudentDao();
		Student student=dao.find(id);
		
		if(student==null) {
			res.setContentType("text/html");
			res.getWriter().print("<h1>No data Found with the ID:"+ id+"</h1>");
			req.getRequestDispatcher("home.html").include(req, res);
		}
		else
		{
			
			req.setAttribute("student", student);
			req.getRequestDispatcher("fetechbyid.jsp").forward(req, res);
//			res.getWriter().print("<html><style>\r\n"
//					+ "table {\r\n"
//					+ "  font-family: arial, sans-serif;\r\n"
//			s		+ "  border-collapse: collapse;\r\n"
//					+ "  width: 100%;\r\n"
//					+ "}\r\n"
//					+ "\r\n"
//					+ "td, th {\r\n"
//					+ "  border: 1px solid #dddddd;\r\n"
//					+ "  text-align: left;\r\n"
//					+ "  padding: 8px;\r\n"
//					+ "}\r\n"
//					+ "\r\n"
//					+ "tr:nth-child(even) {\r\n"
//					+ "  background-color: #dddddd;\r\n"
//					+ "}\r\n"
//					+ "</style>"
//					+ "<body><table border='1'>"
//				
//					+ "<tr>"
//					+ "<th>Id</th>"
//					+ "<th>Name</th>"
//					+ "<th>Mobile</th>"
//					+ "<th>EmailID</th>"
//					+ "<th>Gender</th>"
//					+ "<th>DOB</th>"
//					+ "<th>Address</th>"
//					+ "<th>Languages</th>"
//					+ "<th>Country</th>"
//					+ "</tr>");
//			
//			res.getWriter().print("<tr>"
//					+ "<td>"+student.getId()+"</td>"
//					+ "<td>"+student.getName()+"</td>"
//					+ "<td>"+student.getMobile()+"</td>"
//					+ "<td>"+student.getEmail()+"</td>"
//					+ "<td>"+student.getGender()+"</td>"
//					+ "<td>"+student.getDob()+"</td>"
//					+ "<td>"+student.getAddress()+"</td>"
//					+ "<td>"+Arrays.toString(student.getLanguage())+"</td>"
//					+ "<td>"+student.getCountry()+"</td>"
//					+ "</tr>");
//			res.getWriter().print("<h1>Data feteched Sucessfully</h1></body></html>");
			
		}
			
	}

}
