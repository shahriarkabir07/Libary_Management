package com.library.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library member who can borrow books.
 * Demonstrates INHERITANCE by extending Person.
 */
public class Member extends Person {

    private static final int MAX_BOOKS_ALLOWED = 3;

    private final List<Book> borrowedBooks;

    public Member(String id, String name) {
        super(id, name);
        this.borrowedBooks = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "Member";
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean canBorrowMore() {
        return borrowedBooks.size() < MAX_BOOKS_ALLOWED;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }
}
