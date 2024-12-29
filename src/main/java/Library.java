import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(String isbn, String title, String author, int year) {
        System.out.println("Checking ISBN: " + isbn); // Debugging line
        if (books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book with this ISBN already exists.");
        }
        books.put(isbn, new Book(isbn, title, author, year, true));
    }

    public boolean isBookAvailable(String isbn) {
        return books.containsKey(isbn) && books.get(isbn).isAvailable();
    }

    public void borrowBook(String isbn) {
        if (!books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book not found.");
        }
        Book book = books.get(isbn);
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is already borrowed.");
        }
        book.setAvailable(false);
    }
    public void returnBook(String isbn) {
        if (!books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book not found.");
        }
        Book book = books.get(isbn);
        if (book.isAvailable()) {
            throw new IllegalStateException("Book is already returned.");
        }
        book.setAvailable(true);
    }



    public List<Book> viewAvailableBooks() {
        return books.values().stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }



}

class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book(String isbn, String title, String author, int year, boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
