# Library Management System (Java OOP Demo)

A small console-based Library Management System written in plain Java,
built to demonstrate the four core pillars of Object-Oriented Programming:

- **Encapsulation** — private fields with controlled access via getters/setters (`Book`, `Member`, `Library`).
- **Abstraction** — the abstract class `Person` and the `Borrowable` interface define contracts without exposing implementation details.
- **Inheritance** — `Member` and `Librarian` both extend `Person`.
- **Polymorphism** — `Person` and `Borrowable` references are used to work with different concrete types interchangeably.

Custom checked exceptions (`BookNotFoundException`, `BookNotAvailableException`,
`BorrowLimitExceededException`) are used for clean, meaningful error handling.

## Project Structure

```
LibraryManagementSystem/
├── src/main/java/com/library/
│   ├── Main.java                      # Console app entry point / demo menu
│   ├── model/
│   │   ├── Person.java                # abstract class
│   │   ├── Member.java                # extends Person
│   │   ├── Librarian.java             # extends Person
│   │   ├── Borrowable.java            # interface
│   │   └── Book.java                  # implements Borrowable
│   ├── exception/
│   │   ├── BookNotFoundException.java
│   │   ├── BookNotAvailableException.java
│   │   └── BorrowLimitExceededException.java
│   └── service/
│       └── Library.java               # core business logic
└── README.md
```

## Features

- View the full book catalog with availability status
- View registered members and how many books each has borrowed
- Borrow a book (checks availability + per-member borrow limit)
- Return a book
- Search the catalog by title keyword

## How to Run

Requires JDK 17+ (tested with JDK 21).

```bash
# From the project root
find src -name "*.java" > sources.txt
javac -d out @sources.txt
java -cp out com.library.Main
```

You'll be greeted with a simple menu:

```
========= City Central Library =========
1. List all books
2. List all members
3. Borrow a book
4. Return a book
5. Search books by title
0. Exit
Choose an option:
```

Try borrowing a book using one of the seeded member IDs (`M001`, `M002`) and
book ISBNs shown in the catalog listing.

## Possible Extensions

- Persist data to a file or database instead of in-memory lists
- Add due dates and overdue fines
- Add a `Book` subclass hierarchy (e.g. `EBook`, `AudioBook`) to show further polymorphism
- Wrap with a REST API or JavaFX/Swing GUI

## License

Feel free to use this project for learning purposes.
