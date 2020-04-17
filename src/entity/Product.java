package entity;

public class Product {
	
	private int id;
	private String name;
	private String type;
	
	
	public Product(int id, String name, String type) {
		this.setId(id);
		this.setName(name);
		this.setType(type);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return "ID: " + this.id + " Name: " + this.name + " Type: " + this.type;
	}

}
