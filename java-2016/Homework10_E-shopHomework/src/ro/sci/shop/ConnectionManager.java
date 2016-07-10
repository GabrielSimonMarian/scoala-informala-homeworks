package ro.sci.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		loadDriver();

		CustomerDaoImpl customer = new CustomerDaoImpl();

		customer.getAllCustomers();
		customer.getCustomerById(2);
		customer.createCustomer(8, "ionescu", "ionesc@yahoo.com");
		customer.getAllCustomers();
		customer.deleteCustomer(8);
		customer.getAllCustomers();
	}

	public static Connection getConnection(String type, String host, int port, String dbName, String user, String pw) {
		Connection connection = null;
		DriverManager.setLoginTimeout(60);
		try {
			String url = new StringBuilder().append("jdbc:").append(type).append("://").append(host).append(":").append(port).append("/").append(dbName).append("?user=")
					.append(user).append("&password=").append(pw).toString();
			// System.out.println("URL:" + url);
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("Cannot connect to the database: " + e.getMessage());
		}
		return connection;
	}

	private static void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
