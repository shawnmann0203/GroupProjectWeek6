package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Customer;

public class CustomersDao {
	private Connection connection;
	private final String CREATE_CUSTOMER_QUERY = "Insert into customers (first_name, last_name) values (?,?)";
	private final String FIND_CUSTOMER_BY_ID_QUERY = "Select * from customers where id = ?";

	
	public CustomersDao() {
		connection = DBConnection.getConnection();
	}
	
	public void createNewCustomer(String firstName, String lastName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_CUSTOMER_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.executeUpdate();
		
	}
	
	public Customer findCustomer(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(FIND_CUSTOMER_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.execute();
		ResultSet rs = ps.executeQuery();
		rs.next();
		Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
		return customer;
	}
}
