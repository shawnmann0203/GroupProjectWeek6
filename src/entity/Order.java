package entity;

public class Order {
	
	private int id;
	private int customerId;
	private int productId;
	
	public Order(int id, int customerId, int productId) {
		this.setId(id);
		this.setCustomerId(customerId);
		this.setProductId(productId);
	}

	public int getId(id) {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
