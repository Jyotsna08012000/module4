package Controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Dao.Userdao;

import model.User;
import services.Services;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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

		if (action.equalsIgnoreCase("register")) {
			User u1 = new User();
			u1.setFname(request.getParameter("fname"));
			u1.setLname(request.getParameter("lname"));
			u1.setEmail(request.getParameter("email"));
			u1.setMobile(Long.parseLong(request.getParameter("mobile")));
			u1.setPassword(request.getParameter("password"));
	       Userdao.insertUser(u1);
			request.setAttribute("msg", "Account register sucessfully");
			request.getRequestDispatcher("getotp.jsp").forward(request, response);
			
		}
			else if (action.equalsIgnoreCase("GET OTP")) {
				String email = request.getParameter("email");
				boolean flag = Userdao.checkEmail(email);
				System.out.println(flag);
				if (flag == true) {
					Services s = new Services();
					Random r = new Random();
					int num = r.nextInt(999999);
					System.out.println(num);
					s.sendMail(email, num);
					request.setAttribute("email", email);
					request.setAttribute("otp", num);
					request.getRequestDispatcher("Enterotp.jsp").forward(request, response);

				}
			} else if (action.equalsIgnoreCase("verify")) {
				String email = request.getParameter("email");
				int otp1 = Integer.parseInt(request.getParameter("otp1"));
				int otp2 = Integer.parseInt(request.getParameter("otp2"));
				if (otp1 == otp2) {
					request.setAttribute("email", email);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}

				else {
					request.setAttribute("email", email);
					request.setAttribute("otp", otp1);
					request.setAttribute("msg", "otp not matched");
					request.getRequestDispatcher("Enterotp.jsp").forward(request, response);
				}

	} else if (action.equalsIgnoreCase("login")) {
		     User u1 = new User();
			u1.setEmail(request.getParameter("email"));
			u1.setPassword(request.getParameter("password"));
			User u = Userdao.userLogin(u1);
			if (u == null) {
				request.setAttribute("msg", "password is incorrect");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("data", u);
				request.getRequestDispatcher("home.jsp").forward(request, response);

			}
		} else if (action.equalsIgnoreCase("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			User s = Userdao.getUserById(id);
			request.setAttribute("data", s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.getRequestDispatcher("Edit.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("update")) {
			User u = new User();
			u.setId(Integer.parseInt(request.getParameter("id")));
			u.setFname(request.getParameter("fname"));
			u.setLname(request.getParameter("lname"));
			u.setEmail(request.getParameter("email"));
			u.setMobile(Long.parseLong(request.getParameter("mobile")));
			u.setPassword(request.getParameter("password"));
			Userdao.editUser(u);
			response.sendRedirect("home.jsp");
		
	}
	
	}
}
