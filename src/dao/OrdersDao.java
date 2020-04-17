package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdersDao {
	private Connection connection;
	private String DELETE_ORDER_BY_ID_QUERY = "Delete from orders where id = ?";
	
	
	public OrdersDao() {
		connection = DBConnection.getConnection();
	}
	
	public void deleteOrderById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_ORDER_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

}
