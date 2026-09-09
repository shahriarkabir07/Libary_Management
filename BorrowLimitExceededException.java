package com.library.exception;

/**
 * Thrown when a member tries to borrow more books than allowed.
 */
public class BorrowLimitExceededException extends Exception {
    public BorrowLimitExceededException(String message) {
        super(message);
    }
}
