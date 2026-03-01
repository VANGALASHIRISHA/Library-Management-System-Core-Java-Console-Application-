package librarymanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;

            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input! Please enter numbers only.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();

                        library.addBook(new Book(id, title, author));
                        System.out.println(" Book added successfully!");

                    } catch (InputMismatchException e) {
                        System.out.println(" Invalid input! Please try again.");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    library.issueBook(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    library.returnBook(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter keyword: ");
                    sc.nextLine();
                    library.searchBook(sc.nextLine());
                    break;

                case 6:
                    System.out.println("Exiting Library System.Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}