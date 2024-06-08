package Food;

import java.util.Scanner;

public class FoodOrderSystem {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        char choice;
	        do {
	            System.out.println("Main Menu :");
	            System.out.println("1. Order for food (S)");
	            System.out.println("2. Quit (Q)");
	            System.out.print("Enter your choice : ");
	            choice = scanner.next().charAt(0);

	            switch (choice) {
	                case 'S':
	                    displayOrderMenu(scanner);
	                    break;
	                case 'Q':
	                    System.out.println("Thanks for using Food Order and come back again.");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again!.");
	                    break;
	            }
	        } while (choice != 'Q');
	        
	        scanner.close();
	    }

	    public static void displayOrderMenu(Scanner scanner) {
	        char choice;
	        do {
	            System.out.println("Order Menu:");
	            System.out.println("1. Return to main menu (M)");
	            System.out.println("2. Order (O)");
	            System.out.print("Enter your choice : ");
	            choice = scanner.next().charAt(0);

	            switch (choice) {
	                case 'M':
	                    return;
	                case 'O':
	                    displayFoodMenu(scanner);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again!.");
	                    break;
	            }
	        } while (choice != 'M');
	    }

	    public static void displayFoodMenu(Scanner scanner) {
	        char choice;
	        do {
	            System.out.println("Food Menu :");
	            System.out.println("a. Biriyani (Rs 250) - (B)");
	            System.out.println("b. Burger (Rs 100) - (U)");
	            System.out.println("c. Fried Rice (Rs 70) - (F)");
	            System.out.println("d. Paneer Masala (Rs 60) - (P)");
	            System.out.println("e. Return to previous menu (R)");
	            System.out.print("Enter your choice: ");
	            choice = scanner.next().charAt(0);

	            switch (choice) {
	                case 'B':
	                    System.out.println("Thanks for placing the order for Biriyani.");
	                    break;
	                case 'U':
	                    System.out.println("Thanks for placing the order for Burger.");
	                    break;
	                case 'F':
	                    System.out.println("Thanks for placing the order for Fried Rice.");
	                    break;
	                case 'P':
	                    System.out.println("Thanks for placing the order for Paneer Masala.");
	                    break;
	                case 'R':
	                    return; 
	                default:
	                    System.out.println("Invalid choice. Please try again!.");
	                    break;
	            }

	            System.out.print("Press C to continue : ");
	            choice = scanner.next().charAt(0);
	        } while (choice == 'C');
	    }
}
