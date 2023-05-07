package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;

@WebServlet("/delete")
public class Delete extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	// TODO Auto-generated method stub
	int id=Integer.parseInt(req.getParameter("id"));
	
	StudentDao dao=new StudentDao();
	dao.Delete(id);
	
	res.getWriter().print("<h1>Delete data sucessfully</h1>");
	req.setAttribute("list", dao.fetechAll());
	req.getRequestDispatcher("FetechAllData.jsp").include(req, res);
}
}
