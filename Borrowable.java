package com.library.model;

/**
 * Interface implemented by any item that can be borrowed from the library.
 * Demonstrates ABSTRACTION through contracts (interfaces).
 */
public interface Borrowable {
    boolean isAvailable();
    void borrow();
    void returnItem();
}
