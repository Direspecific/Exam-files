public class ImportedProducts extends Product { // Child Class

	String brand;
	
	ImportedProducts(int productID, String productName, double price, int itemStock, String brand) { // Overriding Constructor
		super(productID, productName, price, itemStock); // Overrides and accesses the parent's constructor and its parameters/attributes
		this.brand = brand;
	}
	
	void printProduct() { // Overriding Methods
		super.printProduct(); // Retains the functionality from the Super Class
		System.out.println("Brand: " + brand); // Added functionality
	}
	
	void discount() {
		System.out.println();
		System.out.println("You added: " + getProductName() + " of " + brand.toUpperCase() +"!");
		System.out.println("There is a limited 12% discount on \nImported Products! Checkout now!");
	}

}
