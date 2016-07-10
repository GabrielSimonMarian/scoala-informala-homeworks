package ro.sci.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl extends AbstractModelDao implements CustomerDao {

	private int id;
	private String name;
	private String email;
	private Connection conn;

	public CustomerDaoImpl() {
		conn = getDbConnection();
	}

	protected Connection getDbConnection() {
		return super.getDbConnection();
	}

	public CustomerDaoImpl(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Override
	public void createCustomer(int index, String name, String email) {

		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("INSERT INTO customer " + "VALUES(?, ?, ?)");

			ps.setInt(1, index);
			ps.setString(2, name);
			ps.setString(3, email);

			ps.executeUpdate();
			System.out.println("Inserted records into the table...");

		} catch (SQLException e) {
			System.err.println("Cannot insert data: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
				}
		}

	}

	@Override
	public void getCustomerById(int custormerId) {

		final String format = "%10s%20s%30s\n";

		String sqlQuery = "SELECT * FROM customer WHERE id=?";

		Connection conn = getDbConnection();

		try (PreparedStatement ps = conn.prepareStatement(sqlQuery);) {

			ps.setInt(1, custormerId);

			try (ResultSet rs = ps.executeQuery();) {
				boolean hasResults = rs.next();

				if (hasResults) {
					System.out.format(format, "id", "name", "email");

					do {
						System.out.println("The customer with the ID: " + custormerId + "  is: ");
						System.out.format(format, rs.getInt("id"), rs.getString("name"), rs.getString("email"));
					} while (rs.next());
				} else {
					System.out.println("No results");
				}
			}

		} catch (SQLException e) {
			System.err.println("Cannot execute query: " + e.getMessage());
		}
	}

	@Override
	public void getAllCustomers() {
		final String format = "%10s%20s%30s\n";

		String sqlQuery = "SELECT * FROM customer";

		Connection conn = getDbConnection();

		try (PreparedStatement ps = conn.prepareStatement(sqlQuery);) {

			// ps.setInt(1, custormerId);

			try (ResultSet rs = ps.executeQuery();) {
				boolean hasResults = rs.next();

				if (hasResults) {
					System.out.format(format, "id", "name", "email");

					do {
						System.out.format(format, rs.getInt("id"), rs.getString("name"), rs.getString("email"));
					} while (rs.next());
				} else {
					System.out.println("No results");
				}
				System.out.println("");
			}

		} catch (SQLException e) {
			System.err.println("Cannot execute query: " + e.getMessage());
		}

	}

	public void deleteCustomer(int custormerId) {

		Connection conn = getDbConnection();

		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("DELETE FROM customer WHERE id=?");

			ps.setInt(1, custormerId);

			ps.executeUpdate();
			System.out.println("Inserted records into the table: ");

		} catch (SQLException e) {
			System.err.println("Cannot insert data: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
				}
		}
	}

	@Override
	public void readAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%10s%12s%20s\n";

		try {
			String sqlQuery = "SELECT * FROM customer";
			ps = conn.prepareStatement(sqlQuery);
			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {

				System.out.format(format, "id", "name", "email");
				do {
					System.out.format(format, rs.getInt("id"), rs.getString("name"), rs.getString("email"));
				} while (rs.next());

			} else {
				System.out.println("No results");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
