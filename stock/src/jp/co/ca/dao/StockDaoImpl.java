
package jp.co.ca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jp.co.ca.entity.Stock;

public class StockDaoImpl implements StockDao {

	// SQLServer用
//	private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=ca";
//	private static final String ID = "sa";
//	private static final String PASS = "sa";

	// Oracle用
//	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
//	private static final String DB_URL = "jdbc:oracle:thin:@dbserver:1521:xe";
//	private static final String ID = "sys";
//	private static final String PASS = "orcl";

	// MySQL用
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/ca";
	private static final String ID = "root";
	private static final String PASS = "";

	// PostgreSQL用
//	private static final String DRIVER_NAME = "org.postgresql.Driver";
//	private static final String DB_URL = "jdbc:postgresql:ca";
//	private static final String ID = "postgres";
//	private static final String PASS = "postgres";

	private static final String DELETE = "DELETE FROM stock WHERE id=?";
	private static final String FIND_ALL = "SELECT * FROM stock ORDER BY id";
	private static final String FIND_BY_ID = "SELECT * FROM stock WHERE id=?";
	private static final String INSERT = "INSERT INTO stock(name, quantity, price) VALUES(?, ?, ?)";
	private static final String UPDATE = "UPDATE stock SET name=?, quantity=?, price=? WHERE id=?";


	public int delete(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, id);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(stmt);
			close(conn);
		}
	}

	public List<Stock> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Stock> list = new ArrayList<Stock>();

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(FIND_ALL);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Stock stock = new Stock();
				stock.setId(rs.getInt("id"));
				stock.setName(rs.getString("name"));
				stock.setQuantity(rs.getInt("quantity"));
				stock.setPrice(rs.getInt("price"));

				list.add(stock);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(stmt);
			close(conn);
		}

		return list;
	}

	public Stock findById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(FIND_BY_ID);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Stock stock = new Stock();
				stock.setId(rs.getInt("id"));
				stock.setName(rs.getString("name"));
				stock.setQuantity(rs.getInt("quantity"));
				stock.setPrice(rs.getInt("price"));

				return stock;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(stmt);
			close(conn);
		}
	}

	public int insert(Stock stock) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, stock.getName());
			stmt.setInt(2, stock.getQuantity());
			stmt.setInt(3, stock.getPrice());

			int result = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				stock.setId(rs.getInt(1));
			}

			return result;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(stmt);
			close(conn);
		}
	}

	public int update(Stock stock) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, stock.getName());
			stmt.setInt(2, stock.getQuantity());
			stmt.setInt(3, stock.getPrice());
			stmt.setInt(4, stock.getId());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(stmt);
			close(conn);
		}
	}

	/**
	 * caデータベースにアクセスするコネクションを取得します。
	 *
	 * @return DBコネクション
	 */
	private Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			return DriverManager.getConnection(DB_URL, ID, PASS);
		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 開いているDBコネクションを閉じます。
	 *
	 * @param con コネクション
	 */
	private static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * 開いているステートメントを閉じます。
	 *
	 * @param stmt ステートメント
	 */
	private static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

}
