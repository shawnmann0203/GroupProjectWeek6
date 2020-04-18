package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Order;
import entity.Product;

public class OrdersDao {
	private Connection connection;
	private String DELETE_ORDER_BY_ID_QUERY = "Delete from orders where id = ?";
	private String DISPLAY_ALL_ORDERS_QUERY = "Select * from orders";
	
	
	public OrdersDao() {
		connection = DBConnection.getConnection();
	}
	
	public void deleteOrderById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_ORDER_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public List<Order> getAllOrders() throws SQLException{
		List<Order> orders = new ArrayList<Order>();
		PreparedStatement ps = connection.prepareStatement(DISPLAY_ALL_ORDERS_QUERY);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			orders.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
		}
		return orders;
	}

}
