import java.util.ArrayList;
import java.util.Scanner;

public class Product { // Super Class

	// Attributes of the product class
	int productID;
	String productName;
	double price;
	int itemStock;
	
	Product (int productID, String productName, double price, int itemStock){ // Constructor with parameters for the product to be accessed by the main method
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.itemStock = itemStock;
	}
	
	void printProduct() {
		System.out.println();
		System.out.println("Product ID: " + productID);
		System.out.println("Product Name: " + productName);
		System.out.println("Product Price: " + price);
		System.out.println("Stock/s: " + itemStock);
	}
	
	// getters and setters method to return the specified value when called
	public double getPayment() {
		return price * itemStock;	
	}

	public int getID() {
		return productID;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getItemStock() {
		return itemStock;
	}
	
	public String getProductName() {
		return productName;
	}
