/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ellieearwood
 */
import java.util.Scanner;

public class LibrarySystemMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\nLIBRARY MANAGEMENT SYSTEM");
            System.out.println("1 - View Available Books");
            System.out.println("2 - Add a Book");
            System.out.println("3 - Borrow a Book");
            System.out.println("4 - Return a Book");
            System.out.println("5 - Exit");
            System.out.print("Choose an option: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Consume invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    FetchBooks.main(new String[]{});
                    break;
                case 2:
                    InsertBook.main(new String[]{});
                    break;
                case 3:
                    BorrowBook.main(new String[]{});
                    System.out.println("Returning to menu...");
                    break;
                case 4:
                    ReturnBook.main(new String[]{});
                    System.out.println("Returning to menu...");
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
