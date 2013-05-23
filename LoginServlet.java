package jp.co.ca.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.ca.dao.UserDao;
import jp.co.ca.dao.UserDaoImpl;
import jp.co.ca.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String INPUT_PAGE = "login.jsp";
	private static final String NEXT_PAGE = "menu";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(INPUT_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<String> errors = new ArrayList<>();

		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");

		if (name == null || name.isEmpty()) {
			errors.add("名前を入力してください。");
		}

		if (passwd == null || passwd.isEmpty()) {
			errors.add("パスワードを入力してください。");
		}

		if (errors.isEmpty()){
			UserDao userDao = new UserDaoImpl();
			User user = userDao.findByNameAndPasswd(name, passwd);
			if (user == null) {
				errors.add("ログインできませんでした。");
			} else {
				request.getSession().setAttribute("user", user);
				response.sendRedirect(NEXT_PAGE);
				return;
			}
		}
		request.setAttribute("errors", errors);
		request.getRequestDispatcher(INPUT_PAGE).forward(request, response);
	}

}
