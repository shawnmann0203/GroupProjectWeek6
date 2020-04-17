package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductsDao {
	private Connection connection;
	private final String DISPLAY_ALL_PRODUCTS_QUERY = "Select * from products";
	private final String UPDATE_PRODUCT_BY_ID_QUERY = "Update products set name = ?, type = ? where id = ?";
	
	
	public ProductsDao() {
		connection = DBConnection.getConnection();
	}
	
	
	public List<Product> getAllProducts() throws SQLException{
		List<Product> products = new ArrayList<Product>();
		PreparedStatement ps = connection.prepareStatement(DISPLAY_ALL_PRODUCTS_QUERY);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			products.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		return products;
	}
	
	public void updateProductById(String name, String type, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUCT_BY_ID_QUERY);
		ps.setString(1, name);
		ps.setString(2, type);
		ps.setInt(3, id);
		ps.executeUpdate();
		
	}
	
}
