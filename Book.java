package com.library.model;

/**
 * Represents a book in the library.
 * Implements Borrowable -> demonstrates ABSTRACTION + POLYMORPHISM
 * (Book can be treated as a Borrowable wherever needed).
 */
public class Book implements Borrowable {

    private final String isbn;
    private final String title;
    private final String author;
    private boolean available;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void borrow() {
        this.available = false;
    }

    @Override
    public void returnItem() {
        this.available = true;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" by %s (ISBN: %s) - %s",
                title, author, isbn, available ? "Available" : "Borrowed");
    }
}
