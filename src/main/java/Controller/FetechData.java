package Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


import dao.StudentDao;
import dto.Student;


@WebServlet("/fetechall")
public class FetechData extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		StudentDao dao=new StudentDao();
		List<Student> list=dao.fetechAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("FetechAllData.jsp").forward(req, res);
//		res.getWriter().print("<html><style>\r\n"
//				+ "table {\r\n"
//				+ "  font-family: arial, sans-serif;\r\n"
//				+ "  border-collapse: collapse;\r\n"
//				+ "  width: 100%;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ "td, th {\r\n"
//				+ "  border: 1px solid #dddddd;\r\n"
//				+ "  text-align: left;\r\n"
//				+ "  padding: 8px;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ "tr:nth-child(even) {\r\n"
//				+ "  background-color: #dddddd;\r\n"
//				+ "}\r\n"
//				+ "</style>"
//				+ "<body><table border='1'>"
//			
//				+ "<tr>"
//				+ "<th>Id</th>"
//				+ "<th>Name</th>"
//				+ "<th>Mobile</th>"
//				+ "<th>EmailID</th>"
//				+ "<th>Gender</th>"
//				+ "<th>DOB</th>"
//				+ "<th>Address</th>"
//				+ "<th>Languages</th>"
//				+ "<th>Country</th>"
//				+ "</tr>");
//		
//				StudentDao dao=new StudentDao();
//
//				List<Student> list=dao.fetechAll();
//				
//				for(Student student:list)
//				{
//					res.getWriter().print("<tr>"
//							+ "<td>"+student.getId()+"</td>"
//							+ "<td>"+student.getName()+"</td>"
//							+ "<td>"+student.getMobile()+"</td>"
//							+ "<td>"+student.getEmail()+"</td>"
//							+ "<td>"+student.getGender()+"</td>"
//							+ "<td>"+student.getDob()+"</td>"
//							+ "<td>"+student.getAddress()+"</td>"
//							+ "<td>"+Arrays.toString(student.getLanguage())+"</td>"
//							+ "<td>"+student.getCountry()+"</td>"
//							+ "</tr>");
//					
//					
//				}
//				
//				
//				res.getWriter().print("</table></body></html>");
//				
//		
	}
	

}
