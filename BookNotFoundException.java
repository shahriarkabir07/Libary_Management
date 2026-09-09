package com.library.exception;

/**
 * Thrown when a requested book does not exist in the library catalog.
 */
public class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}
