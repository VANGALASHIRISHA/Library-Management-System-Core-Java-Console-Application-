package librarymanagement;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found!");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isAvailable()) {
                    book.issueBook();
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book already issued!");
                }
                return;
            }
        }
        System.out.println("Book ID not found!");
    }

    public void returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.isAvailable()) {
                    book.returnBook();
                    System.out.println("✅ Book returned successfully!");
                } else {
                    System.out.println("❌ Book is not issued!");
                }
                return;
            }
        }
        System.out.println("❌ Book ID not found!");
    }

    public void searchBook(String keyword) {
        boolean found = false;
        keyword = keyword.toLowerCase();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword) ||
                book.getAuthor().toLowerCase().contains(keyword)) {

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ No matching books found!");
        }
    }
}