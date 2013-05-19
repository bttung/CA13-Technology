/*
 * Java6�܂ł̏������BJava7�ł͂����ƊȌ��ɏ�����B
 */

import java.sql.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DbAccess1 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String inputName = reader.readLine();
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/ca", "root", "");

			stmt = conn.createStatement();
			String sql = "SELECT * FROM user where name = '" + inputName + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			boolean isExist = false;
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String passwd = rs.getString("passwd");
				
				System.out.println(id + "\t" + name + "\t" + tel + "\t" + passwd);
				isExist = true;
			}
			if (!isExist)
				System.out.println(inputName + "�͑��݂��܂���B");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) { }
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) { }
			}
		}
	}
}
