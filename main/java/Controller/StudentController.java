package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.StudentDao;
import model.StudentModel;

/**
 * Servlet implementation class Student
 */
@WebServlet("/Student")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String action = request.getParameter("action");
       
        	 String fname = request.getParameter("fname");
        	 String lname = request.getParameter("lname");
             String email = request.getParameter("email");
             Long mobile = Long.parseLong(request.getParameter("mobile"));
             String gender = request.getParameter("gender");
             String password = request.getParameter("password");
              StudentModel s =new StudentModel();
             s.setFname(fname);
			s.setLname(lname);
			s.setEmail(email);
			s.setMobile(mobile);
			s.setGender(gender);
			s.setPassword(password);
			System.out.println(s);
			if (action.equalsIgnoreCase("register")) {
				StudentDao.insertstudent(s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.getRequestDispatcher("Student-Information.jsp").forward(request, response);
      
	}
}
}


