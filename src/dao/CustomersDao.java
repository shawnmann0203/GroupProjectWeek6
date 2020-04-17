package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomersDao {
	private Connection connection;
	private final String CREATE_CUSTOMER_QUERY = "Insert into customers (first_name, last_name) values (?,?)";

	
	public CustomersDao() {
		connection = DBConnection.getConnection();
	}
	
	public void createNewCustomer(String firstName, String lastName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_CUSTOMER_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.executeUpdate();
		
	}
}
