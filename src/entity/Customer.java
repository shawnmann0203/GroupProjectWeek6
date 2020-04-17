package entity;

public class Customer {
	
	private int id;
	private String first;
	private String last;
	
	public Customer(int customerId, String firstName, String lastName) {
		this.setId(customerId);
		this.setFirst(firstName);
		this.setLast(lastName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
	
	
	
	

}
