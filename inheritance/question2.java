import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class question2 {

	private Scanner scan = new Scanner(System.in); // Instantiated Scanner Object
	private ArrayList<String> userCart = new ArrayList<String>(); // ArrayList that holds the user's products

	
	private Product product1 = new Product(1, "Shampoo", 120.50, 5);
	private Product product2 = new Product(2, "Toothpaste", 75.25, 10);
	private Product product3 = new Product(3, "Soap", 45.00, 2);
	private ImportedProducts product4 = new ImportedProducts(4, "Cleanser", 2021.00, 5, "Lifeline"); // Instantiated ImportedProduct Class
	private ImportedProducts product5 = new ImportedProducts(5, "Serum", 500.00, 3, "Luxe Organix");
	
	
	private int userInput; // Holds the user's input
	private int numShampoo = 0, numToothpaste = 0, numSoap = 0, numCleanser = 0, numSerum = 0; // Holds the number of products that the user wants
	private double userPayment = 0; // User's total payment
	
	
	void start() {
		try { 
			while(true) {
				printMenu();
				userInput = scan.nextInt();
				if(userInput == 1) {
					printList();
				}
				else if(userInput == 2) {
					System.out.print("Please Enter Product ID: ");
					userInput = scan.nextInt();
					if(userInput == 1) {
						System.out.print("Please Enter Quantity: ");
						userInput = scan.nextInt();
						if(userInput <= 0) {
							System.out.println("Try Again!\n");
						}
						else if(userInput <= product1.getItemStock()) {
								userCart.add("1"); // Adding a string value to the arraylist of user cart
								numShampoo += userInput; // Adds an amount to this variable of how much product the user have entered
								product1.setItemStock(product1.getItemStock() - userInput); // Sets the product's stock to be decreased by the user's input e.g. updatedStock = (stock - userInput)
								userPayment += userInput * product1.getPrice(); // Updates the user's payment by multiplying userInput and the price of the product
								System.out.println("\nProduct Name: " + product1.getProductName());
								System.out.println("Price per item: " + product1.getPrice());
								System.out.println("Total: " + product1.getPrice() * userInput);
								System.out.println("Added to Cart");
						}
						else {
							System.out.println("There is/are " + product1.getItemStock() + " stocks left!\n");
						}
					}
					else if(userInput == 2) {
						System.out.print("Please Enter Quantity: ");
						userInput = scan.nextInt();
						if(userInput <= 0) {
							System.out.println("Try Again!\n");
						}
						else if(userInput <= product2.getItemStock()) {
								userCart.add("2");
								numToothpaste += userInput;
								product2.setItemStock(product2.getItemStock() - userInput);
								userPayment += userInput * product2.getPrice();
								System.out.println("\nProduct Name: " + product2.getProductName());
								System.out.println("Price per item: " + product2.getPrice());
								System.out.println("Total: " + product2.getPrice() * userInput);
								System.out.println("Added to Cart");
						}
						else {
							System.out.println("There is/are " + product2.getItemStock() + " stocks left!\n");
						}
					}
					else if(userInput == 3) {
						System.out.print("Please Enter Quantity: ");
						userInput = scan.nextInt();
						if(userInput <= 0) {
							System.out.println("Try Again!\n");
						}
						else if(userInput <= product3.getItemStock()) {
								userCart.add("3"); 
								numSoap += userInput; 
								product3.setItemStock(product3.getItemStock() - userInput); 
								userPayment += userInput * product3.getPrice();
								System.out.println("\nProduct Name: " + product3.getProductName());
								System.out.println("Price per item: " + product3.getPrice());
								System.out.println("Total: " + product3.getPrice() * userInput);
								System.out.println("Added to Cart");
						}
						else {
							System.out.println("There is/are " + product3.getItemStock() + " stocks left!\n");
						}
					}
					else if(userInput == 4) {
						System.out.print("Please Enter Quantity: ");
						userInput = scan.nextInt();
						if(userInput <= 0) {
							System.out.println("Try Again!\n");
						}
						else if(userInput <= product4.getItemStock()) {
								userCart.add("4");
								numCleanser += userInput;
								product4.setItemStock(product4.getItemStock() - userInput); 
								userPayment += product4.getPrice() - (product4.getPrice() * 12 / 100) * userInput;
								product4.discount();
								System.out.println("\nProduct Name: " + product4.getProductName());
								System.out.println("Price per item: " + product4.getPrice());
								System.out.println("Total: " + (product4.getPrice() - (product4.getPrice() * 12 / 100)) * userInput);
								System.out.println("Added to Cart");
						}
						else {
							System.out.println("There is/are " + product4.getItemStock() + " stocks left!\n");
						}
					}
					else if(userInput == 5) {
						System.out.print("Please Enter Quantity: ");
						userInput = scan.nextInt();
						if(userInput <= 0) {
							System.out.println("Try Again!\n");
						}
						else if(userInput <= product5.getItemStock()) {
								userCart.add("5");
								numSerum += userInput;
								product5.setItemStock(product5.getItemStock() - userInput); 
								userPayment += product5.getPrice() - (product5.getPrice() * 12 / 100) * userInput;
								product5.discount();
								System.out.println("\nProduct Name: " + product5.getProductName());
								System.out.println("Price per item: " + product5.getPrice());
								System.out.println("Total: " + (product5.getPrice() - (product5.getPrice() * 12 / 100)) * userInput);
								System.out.println("Added to Cart");
						}
						else {
							System.out.println("There is/are " + product5.getItemStock() + " stocks left!\n");
						}
					}
				}
				else if(userInput == 3) { // If there are no products, display the message, then, print the Cart
					System.out.println("**********CURRENT CART**********");
					if(userCart.isEmpty()) {
						System.out.println("You don't have any products in your cart!\n");
					}
					else {
						printCart(); // Accessing the printCart method
					}
				}
				else if(userInput == 4) { // If there are no products, display the message, Otherwise, print the Checkout
					System.out.println("**********CHECKOUT**********");
					System.out.println();
					if(userCart.isEmpty()) { 
						System.out.println("You don't have any products in your cart!");
					}
					else {
						printCheckout(); // Calling the printCheckout Method
					}
				}
				else if(userInput == 5) {
					System.out.println("Thank you for shopping!");
					break;
				}
			}
		}
		catch(InputMismatchException e) { // To avoid any errors when the user inputs an invalid input, it prints the display below
			System.out.println("Invalid Input! Please Try Again!");
		}
		
	}
	
	void printMenu() {
		System.out.println("\n**********POS MENU**********");
		System.out.println("1. Show Products");
		System.out.println("2. Add to Cart by ID");
		System.out.println("3. Show Cart");
		System.out.println("4. Checkout");
		System.out.println("5. Exit");
		System.out.print("> ");
	}
	
	void printList() {

		System.out.println("\nList of Products:");
		product1.printProduct();
		product2.printProduct();
		product3.printProduct();
		product4.printProduct();
		product5.printProduct();
	}
	
	void printCart() {
		System.out.println();
		if(userCart.contains("1")) {
			System.out.println();
			System.out.println("Product ID: " + product1.getID());
			System.out.println("Product Name: " + product1.getProductName());
			System.out.println("Product Price: " + product1.getPrice());
			System.out.println("Quantity: " + numShampoo);
			System.out.println();
		}
		if(userCart.contains("2")){
			System.out.println();
			System.out.println("Product ID: " + product2.getID());
			System.out.println("Product Name: " + product2.getProductName());
			System.out.println("Product Price: " + product2.getPrice());
			System.out.println("Quantity: " + numToothpaste);
			System.out.println();
		}
		if(userCart.contains("3")) {
			System.out.println();
			System.out.println("Product ID: " + product3.getID());
			System.out.println("Product Name: " + product3.getProductName());
			System.out.println("Product Price: " + product3.getPrice());
			System.out.println("Quantity: " + numSoap);
			System.out.println();
		}
		if(userCart.contains("4")) {
			System.out.println();
			System.out.println("Product ID: " + product4.getID());
			System.out.println("Product Name: " + product4.getProductName());
			System.out.println("Product Price: " + product4.getPrice());
			System.out.println("Quantity: " + numCleanser);
			System.out.println();
		}
		if(userCart.contains("5")) {
			System.out.println();
			System.out.println("Product ID: " + product5.getID());
			System.out.println("Product Name: " + product5.getProductName());
			System.out.println("Product Price: " + product5.getPrice());
			System.out.println("Quantity: " + numSerum);
			System.out.println();
		}
	}
	
	void printCheckout() {
		System.out.println();
		if(userCart.contains("1")) {
			System.out.println("Product Name: " + product1.getProductName());
			System.out.println("Product Price: " + product1.getPrice());
			System.out.println("Quantity: " + numShampoo);
			System.out.println();
		}
		if(userCart.contains("2")){
			System.out.println("Product Name: " + product2.getProductName());
			System.out.println("Product Price: " + product2.getPrice());
			System.out.println("Quantity: " + numToothpaste);
			System.out.println();
		}
		if(userCart.contains("3")) {
			System.out.println("Product Name: " + product3.getProductName());
			System.out.println("Product Price: " + product3.getPrice());
			System.out.println("Quantity: " + numSoap);
			System.out.println();
		}
		if(userCart.contains("4")) {
			System.out.println("Product Name: " + product4.getProductName());
			System.out.println("Product Price: " + product4.getPrice() + " w/ 12% Discount");
			System.out.println("Quantity: " + numCleanser);
			System.out.println();
		}
		if(userCart.contains("5")) {
			System.out.println("Product Name: " + product5.getProductName());
			System.out.println("Product Price: " + product5.getPrice() + " w/ 12% Discount");
			System.out.println("Quantity: " + numSerum);
			System.out.println();
		}
		   
		System.out.println("--");
		System.out.println("Your total is: " + userPayment);
		System.out.println();
			
	}
	
}
