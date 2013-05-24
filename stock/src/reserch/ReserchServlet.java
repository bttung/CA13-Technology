package reserch;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.ca.dao.StockDao;
import jp.co.ca.dao.StockDaoImpl;
import jp.co.ca.entity.Stock;

/**
 * Servlet implementation class ReserchServlet
 */
public class ReserchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/select.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StockDao stockDao = new StockDaoImpl();
		List<Stock> stock = stockDao.findAll();
		request.setAttribute("stocks", stock);
		request.getRequestDispatcher("/WEB-INF/jsp/select_result.jsp").forward(request, response);
	}

}
