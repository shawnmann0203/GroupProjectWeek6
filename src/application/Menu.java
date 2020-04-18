package application;

import java.sql.SQLException;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CustomersDao;
import dao.OrdersDao;
import dao.ProductsDao;
import entity.Customer;
import entity.Product;

public class Menu {
	private CustomersDao customerDao = new CustomersDao();
	private ProductsDao productsDao = new ProductsDao();
	private OrdersDao ordersDao = new OrdersDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display all Products",
			"Create Customer",
			"Delete an Order",
			"Edit Product",
			"Search for Customer",
			"Exit");
	
	
	public void start() {
		String selection = "";
				
		do {
			printMenu();
			selection = scanner.nextLine();
		
			try {
			if(selection.equals("1")) {
				displayProducts();
			} else if (selection.equals("2")) {
				createCustomer();
			} else if (selection.equals("3")) {
				deleteAnOrder();
			} else if (selection.equals("4")) {
				editProduct();
			} else if (selection.equals("5")) {
				findCustomer();
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Press enter to continue...");
			scanner.hasNextLine();
			
		} while(!selection.equals("6"));
		
	}

	private void editProduct() throws SQLException {
		displayProducts();
		String name = "";
		String type = "";
		int id = 0;
		
		System.out.print("Please select which product you would like to edit: ");
		id = Integer.parseInt(scanner.nextLine());
		do {
			System.out.print("What would you like to change the name to?");
			name = scanner.nextLine();
			if(name.isEmpty()) {
				System.out.println("Name cannot be empty. Please try again...");
			}
		}while(name.isEmpty());
		
		do {
			System.out.print("What would you like to change the type to?");
			type = scanner.nextLine();
			if(type.isEmpty()) {
				System.out.println("Type cannot be empty. Please try again...");
			}
		}while(type.isEmpty());
		
		productsDao.updateProductById(name, type, id);
		System.out.println("Product " + id + " has been successfully updated.\n");

		displayProducts();
			
		
	}

	private void deleteAnOrder() throws SQLException {
		int id = 0;
		
		displayOrders();
		
		do {
		System.out.print("Please enter the order Id number you'd like to delete:");
		
			id = Integer.parseInt(scanner.nextLine());
		} while(id <= 0);
		
		ordersDao.deleteOrderById(id);
		System.out.println("Deleted order number: " + id);
		
	}

	private void displayOrders() {
		
	}

	private void createCustomer() throws SQLException {
		String firstName = "";
		String lastName = "";
		do {
			System.out.print("First name of new customer: ");
			firstName = scanner.nextLine();
		} while(firstName.isEmpty());
		
		do {
			System.out.print("Last name of new customer: ");
			lastName = scanner.nextLine();			
		} while(lastName.isEmpty());
		
		customerDao.createNewCustomer(firstName, lastName);
		
		System.out.println("\nCustomer added: " + firstName + " " + lastName );
		
		
		
	}
	private void findCustomer() throws SQLException {
		System.out.print("Please enter your customer ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		Customer customer = customerDao.findCustomer(id);
		System.out.println("Customer ID: " + id + "Customer First Name: " +  customer.getFirst()  + "Customer Last Name: " + customer.getLast());
		

		
}

	private void displayProducts() throws SQLException {
		List<Product> products = productsDao.getAllProducts();
		for(Product product: products) {
			System.out.println(product.toString());
		}
	}

	private void printMenu() {
		int counter = 1;
		System.out.println("Please select an option: \n------------------------------------");
		for(String option : options) {
			System.out.println("[" + counter + "] " + option);
			counter++;
		}
		System.out.println("------------------------------------");
	}

}
