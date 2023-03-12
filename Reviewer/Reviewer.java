import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Reviewer {

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in); // scanner will be used for the user's input

			int[] myList = { 15, 30, 25, 19, 30, 40 }; // declaration of the array
			int element, x, y; //declaration of variables
			int size = 6;

			System.out.println(Arrays.toString(myList)); // to display the items in the array

			do { /* do-while loop will be used in order to execute endlessly until the condition of size > 0 is met 
			or in other words until the elements of the array is empty */
				
				System.out.print("Enter an element to delete: "); //for the user to input an item to delete
				try {
				element = scan.nextInt();

				for (x = 0; x < size; x++) { // in order to check the index of the element

					if (element == myList[x]) { //this will check the element's index in the array
						
						
						//This part will remove the element and arrange the orders without changing the index
						
						for (y = x; y < (size - 1); y++) {
							
							myList[y] = myList[y + 1];
							
							//15 30 25 19 30 40 (remove 25)
							
							//15 30 19 30 40 40 -> example of how this part works
						}

						size--; // these will decrement the value of the index whenever it changes
						
						x--;// to check all the elements in the array (this is especially used when both elements who are the same is next to each other
							// so that the program will not skip nothing, and will go back to index 0 to check every element in the array
						
						// 30 30 40
						
					}

				}
				
				//condition made in order to check if the user's input can be found in the array
				if ((element != 15) && (element != 30) && (element != 25) && (element != 19) && (element != 40)) { 

					System.out.println("Error! No Element Found");

				}
				System.out.print("New list: ");
				
				for (x = 0; x < size; x++) { // Condition to print the Array 
					
					System.out.print(myList[x] + " ");
					
				}
				
				System.out.println();
				}catch (InputMismatchException mistake) {
					System.out.println("Invalid input!");
					scan.next(); //clears input stream and resets back to data type of original input
				}

			} 
			while (size > 0); //Will stop the loop or the program when size is equal to 0
			
			System.out.println("Array is Empty"); // Will print to inform the user that the program has ended due to the array being empty

		}

	}
