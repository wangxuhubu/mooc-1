package utility;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author: wuke 
 * @date  : 2016��7��4�� ����10:53:20
 * Title  : MySqlConn
 * Description : 
 */
public class MySqlConn {
	/**
	 *  �������ݿ�����
	 */
	public static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mooc";
		String username = "root";
		String password = "1234";
		Connection conn = null;
		try {
			Class.forName(driver); // ���ض�Ӧ����
			conn = DriverManager.getConnection(url,username,password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
