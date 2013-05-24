package insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.ca.dao.StockDao;
import jp.co.ca.dao.StockDaoImpl;
import jp.co.ca.entity.Stock;

/**
 * Servlet implementation class InsertServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));

		Stock stock = new Stock();
		stock.setName(name);
		stock.setQuantity(quantity);
		stock.setPrice(price);

		StockDao stockDao = new StockDaoImpl();
		int count = stockDao.insert(stock);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/WEB-INF/jsp/insert_result.jsp").forward(request, response);

	}

}
