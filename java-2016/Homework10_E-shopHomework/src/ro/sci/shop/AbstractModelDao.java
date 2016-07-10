package ro.sci.shop;

import java.sql.Connection;

public abstract class AbstractModelDao {

	protected Connection getDbConnection() {

		Connection connection = ConnectionManager.getConnection("mysql", "localhost", 3306, "eshop", "root", "panzer");

		return connection;
	}

}
