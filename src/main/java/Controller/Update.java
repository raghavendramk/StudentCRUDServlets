package Controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

@WebServlet("/update")
public class Update extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
Student student=new Student();
		student.setId(Integer.parseInt(req.getParameter("id")));
		student.setAddress(req.getParameter("address"));
		student.setCountry(req.getParameter("country"));
		student.setDob(Date.valueOf(req.getParameter("dob")));
		student.setEmail(req.getParameter("email"));
		student.setGender(req.getParameter("gender"));
		student.setLanguage(req.getParameterValues("language"));
		student.setMobile(Long.parseLong(req.getParameter("mobile")));
		student.setName(req.getParameter("name"));
		
		StudentDao dao= new  StudentDao();
		
		dao.update(student);
		
		res.getWriter().print("<h1>Data Updated sucessfully!!!</h1>");
		req.getRequestDispatcher("home.html").include(req, res);
	}

}
