package com.library;

import com.library.exception.BookNotAvailableException;
import com.library.exception.BookNotFoundException;
import com.library.exception.BorrowLimitExceededException;
import com.library.model.Book;
import com.library.model.Librarian;
import com.library.model.Member;
import com.library.model.Person;
import com.library.service.Library;

import java.util.List;
import java.util.Scanner;

/**
 * Entry point of the Library Management System demo application.
 * Ties together all the OOP concepts:
 *   - Abstraction  (Person, Borrowable)
 *   - Encapsulation (private fields + getters/setters in model classes)
 *   - Inheritance  (Member, Librarian extend Person)
 *   - Polymorphism (Person references, Borrowable references)
 */
public class Main {

    private static final Library library = new Library("City Central Library");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedData();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> listBooks();
                case "2" -> listMembers();
                case "3" -> borrowBook();
                case "4" -> returnBook();
                case "5" -> searchBooks();
                case "0" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option, try again.\n");
            }
        }
        scanner.close();
    }

    private static void seedData() {
        library.addBook(new Book("978-0134685991", "Effective Java", "Joshua Bloch"));
        library.addBook(new Book("978-0596009205", "Head First Design Patterns", "Freeman & Robson"));
        library.addBook(new Book("978-0132350884", "Clean Code", "Robert C. Martin"));

        library.registerMember(new Member("M001", "Ayesha Rahman"));
        library.registerMember(new Member("M002", "Tanvir Hasan"));

        // Polymorphism in action: both stored/treated as Person
        Person librarian = new Librarian("L001", "Nadia Islam", "EMP-77");
        System.out.println("Welcome to " + library.getName() + "!");
        System.out.println("Today's librarian on duty: " + librarian);
        System.out.println();
    }

    private static void printMenu() {
        System.out.println("========= " + library.getName() + " =========");
        System.out.println("1. List all books");
        System.out.println("2. List all members");
        System.out.println("3. Borrow a book");
        System.out.println("4. Return a book");
        System.out.println("5. Search books by title");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static void listBooks() {
        System.out.println("\n--- Catalog ---");
        for (Book b : library.getCatalog()) {
            System.out.println(b);
        }
        System.out.println();
    }

    private static void listMembers() {
        System.out.println("\n--- Members ---");
        for (Member m : library.getMembers()) {
            System.out.println(m + " | Borrowed: " + m.getBorrowedBooks().size());
        }
        System.out.println();
    }

    private static Member findMemberById(String id) {
        for (Member m : library.getMembers()) {
            if (m.getId().equalsIgnoreCase(id)) {
                return m;
            }
        }
        return null;
    }

    private static void borrowBook() {
        System.out.print("Member ID: ");
        Member member = findMemberById(scanner.nextLine().trim());
        if (member == null) {
            System.out.println("Member not found.\n");
            return;
        }
        System.out.print("Book ISBN: ");
        String isbn = scanner.nextLine().trim();

        try {
            library.borrowBook(member, isbn);
            System.out.println("Success! " + member.getName() + " borrowed the book.\n");
        } catch (BookNotFoundException | BookNotAvailableException | BorrowLimitExceededException e) {
            System.out.println("Could not borrow: " + e.getMessage() + "\n");
        }
    }

    private static void returnBook() {
        System.out.print("Member ID: ");
        Member member = findMemberById(scanner.nextLine().trim());
        if (member == null) {
            System.out.println("Member not found.\n");
            return;
        }
        System.out.print("Book ISBN: ");
        String isbn = scanner.nextLine().trim();

        try {
            library.returnBook(member, isbn);
            System.out.println("Book returned. Thanks!\n");
        } catch (BookNotFoundException e) {
            System.out.println("Could not return: " + e.getMessage() + "\n");
        }
    }

    private static void searchBooks() {
        System.out.print("Keyword: ");
        String keyword = scanner.nextLine().trim();
        List<Book> results = library.searchByTitle(keyword);

        System.out.println("\n--- Search Results ---");
        if (results.isEmpty()) {
            System.out.println("No books matched.");
        } else {
            results.forEach(System.out::println);
        }
        System.out.println();
    }
}
