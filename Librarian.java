package com.library.model;

/**
 * Represents a librarian who manages the library.
 * Another concrete subclass of Person -> shows POLYMORPHISM
 * when Person references point to different subclasses.
 */
public class Librarian extends Person {

    private final String employeeCode;

    public Librarian(String id, String name, String employeeCode) {
        super(id, name);
        this.employeeCode = employeeCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    @Override
    public String getRole() {
        return "Librarian";
    }
}
