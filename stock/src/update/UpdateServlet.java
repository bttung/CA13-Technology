package update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.ca.dao.StockDao;
import jp.co.ca.dao.StockDaoImpl;
import jp.co.ca.entity.Stock;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid = request.getParameter("id");
		String sname = request.getParameter("name");
		String squantity = request.getParameter("quantity");
		String sprice = request.getParameter("price");

		Stock stock = new Stock();
		int id = Integer.parseInt(sid);
		int quantity = Integer.parseInt(squantity);
		int price = Integer.parseInt(sprice);
		stock.setId(id);
		stock.setName(sname);
		stock.setQuantity(quantity);
		stock.setPrice(price);

		StockDao stockDao = new StockDaoImpl();
		int count = stockDao.update(stock);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/WEB-INF/jsp/update_result.jsp").forward(request, response);
	}

}
