package com.library.exception;

/**
 * Thrown when a member tries to borrow a book that is already borrowed.
 */
public class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}
