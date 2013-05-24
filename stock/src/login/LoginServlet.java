package login;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.ca.dao.UserDao;
import jp.co.ca.dao.UserDaoImpl;
import jp.co.ca.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sname = request.getParameter("name");
		String spasswd = request.getParameter("passwd");

		String msg; //出力メッセージ
		String url; //出力先URL



		//名前もパスも空の場合
		if ("".equals(sname) && "".equals(spasswd)) {
			request.setAttribute("checked", "checked=\"checked\"");
			String nameError = "名前を入力してください！！";
			String passError = "パスワードを入力してください！！";
			msg = nameError + passError;
			url = "login.jsp";
			requestMsg(request, response, msg, url);
			return;
		}
		//パスが空の場合
		if (!sname.isEmpty() && spasswd.isEmpty()) {
			request.setAttribute("name", sname);
			msg = "パスワードを入力してください！！";
			url = "login.jsp";
			requestMsg(request, response, msg, url);
			return;
		}
		//名前が空の場合
		if (sname.isEmpty() && !spasswd.isEmpty()) {
			msg = "名前を入力してください！！";
			url = "login.jsp";
			requestMsg(request, response, msg, url);
			return;
		}

		UserDao userDao = new UserDaoImpl();
		List<User> users = userDao.findAll();

		for (Iterator<User> it = users.iterator(); it.hasNext();) {
			User user = it.next();
			String name = user.getName();
			String passwd = user.getPasswd();

			//ログイン成功処理
			if (name.equals(sname) && passwd.equals(passwd)) {
				msg = name + "さんこんにちは！！";
				url = "/WEB-INF/jsp/menu.jsp";
				HttpSession session = request.getSession();
				session.setAttribute("msg", msg);
				request.getRequestDispatcher(url).forward(request, response);
				return;
			}
		}

		msg = "ログインできませんでした！！";
		url = "login.jsp";
		requestMsg(request, response, msg, url);

//		//ログイン失敗処理
//		if (!(users.get(i).getName()).equals(name) || !(users.get(i).getPasswd()).equals(passwd)) {
//			request.setAttribute("name", name);
//			msg = "ログインできませんでした！！";
//			url = "login.jsp";
//			requestMsg(request, response, msg, url);
//			return;
//		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	public void requestMsg(HttpServletRequest request, HttpServletResponse response, String msg, String url) throws ServletException, IOException {
		request.setAttribute("msg", msg);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
