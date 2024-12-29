# Incubyte TDD Assessment-Library Management System

This repository contains a simple implementation of a **Library Management System**, following the **Test-Driven Development (TDD)** approach. The system allows users to perform basic library operations such as adding books, borrowing books, returning books, and viewing available books.

The **Library** class provides methods to manage books and their availability.

## **Core Functionalities**

### **1. Add Books**
- Users can add new books to the library.
- Each book is uniquely identified by an **ISBN**.
- Books have properties like **Title**, **Author**, **Publication Year**, and **Availability Status**.

### **2. Borrow Books**
- Users can borrow books if they are available.
- Attempting to borrow an unavailable book raises an appropriate error.

### **3. Return Books**
- Users can return borrowed books.
- The system updates the availability status of the book.

### **4. View Available Books**
- Users can view a list of all currently available books.

## **Method Signatures**

```java
public void addBook(String isbn, String title, String author, int year);
public void borrowBook(String isbn);
public void returnBook(String isbn);
public List<Book> viewAvailableBooks();
```

## **Examples**

- Add a book:
```java
library.addBook("12345", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
```

- Borrow a book:
```java
library.borrowBook("12345");
```

- Return a book:
```java
library.returnBook("12345");
```

- View available books:
```java
List<Book> availableBooks = library.viewAvailableBooks();
```

## **Test Cases**

The **LibraryTest** class contains various test cases to ensure the functionality of the Library Management System. Each test validates different aspects of the implementation.

### **Tests Include:**
- Adding a book should store it in the library.
- Borrowing a book should update its availability.
- Returning a borrowed book should mark it as available after returning.
- Attempting to borrow an unavailable book should show  an error.
- Viewing available books should list only available books.

### **Key Methods:**
- `validateBookDetails` – Ensures valid book details are provided.
- `isBookAvailable` – Checks if a book is currently available.

## **Regarding Commits**
- Each step followed the **Red-Green-Refactor** cycle.
- commits were made to reflect TDD progress.


## **References:**
- **The Three Laws of TDD** – Uncle Bob
- **Test-Driven Development** – Fireship

---

This project emphasizes **clean code practices**, **SOLID principles**, and proper **TDD methodology** to build a robust and maintainable Library Management System.

## **Thankyou Incubyte**
- this helped me to understand TDD and perform this task helping me to  learn and explore this implementation methodology
