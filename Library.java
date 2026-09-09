package com.library.service;

import com.library.exception.BookNotAvailableException;
import com.library.exception.BookNotFoundException;
import com.library.exception.BorrowLimitExceededException;
import com.library.model.Book;
import com.library.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Core service class that manages books and members.
 * Encapsulates the internal collections and exposes safe, controlled
 * operations -> demonstrates ENCAPSULATION.
 */
public class Library {

    private final String name;
    private final List<Book> catalog = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        catalog.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public List<Book> getCatalog() {
        return catalog;
    }

    public List<Member> getMembers() {
        return members;
    }

    private Optional<Book> findBookByIsbn(String isbn) {
        return catalog.stream()
                .filter(b -> b.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }

    public void borrowBook(Member member, String isbn)
            throws BookNotFoundException, BookNotAvailableException, BorrowLimitExceededException {

        Book book = findBookByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException("No book found with ISBN: " + isbn));

        if (!book.isAvailable()) {
            throw new BookNotAvailableException("\"" + book.getTitle() + "\" is currently borrowed by someone else.");
        }

        if (!member.canBorrowMore()) {
            throw new BorrowLimitExceededException(
                    member.getName() + " has already reached the maximum borrow limit.");
        }

        book.borrow();
        member.addBorrowedBook(book);
    }

    public void returnBook(Member member, String isbn) throws BookNotFoundException {
        Book book = findBookByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException("No book found with ISBN: " + isbn));

        book.returnItem();
        member.removeBorrowedBook(book);
    }

    public List<Book> searchByTitle(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book b : catalog) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(b);
            }
        }
        return results;
    }
}
