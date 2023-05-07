package Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.StudentDao;
import dto.Student;


@WebServlet("/insert")
public class InsertData extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String name=req.getParameter("name");
//		
//		long mobile=Long.parseLong(req.getParameter("mobile"));
//		
//		String email=req.getParameter("email");
//		
//		String gender=req.getParameter("gender");
//		
//		Date dob=Date.valueOf(req.getParameter("dob"));
//		
//		String address=req.getParameter("address");
//		
//		String[] language=req.getParameterValues("language");
//		
//		String country=req.getParameter("country");
		
//		res.getWriter().print("<h1>"
//				+ "Name:"+name
//				+ "<br>Mobile:"+mobile
//				+ "<br>Email:"+email
//				+ "<br>Gender:"+gender
//				+ "<br>DOB:"+dob
//				+ "<br>Addrerss:"+address
//				+ "<br>Langues:"+Arrays.toString(language)
//				+ "<br>Country:"+country
//				+ "</h1>");
		
		Student student=new Student();
		
		student.setAddress(req.getParameter("address"));
		student.setCountry(req.getParameter("country"));
		student.setDob(Date.valueOf(req.getParameter("dob")));
		student.setEmail(req.getParameter("email"));
		student.setGender(req.getParameter("gender"));
		student.setLanguage(req.getParameterValues("language"));
		student.setMobile(Long.parseLong(req.getParameter("mobile")));
		student.setName(req.getParameter("name"));
		
		StudentDao dao= new  StudentDao();
		
		dao.save(student);
		
		res.getWriter().print("<h1>Data saved sucessfully!!!</h1>");
		req.getRequestDispatcher("home.html").include(req, res);
		
	}

}
