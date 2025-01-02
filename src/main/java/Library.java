import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(String isbn, String title, String author, int year) {
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("Invalid ISBN.");
        }
        if (books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book with this ISBN already exists.");
        }
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty.");
        }
        if (books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book with this ISBN already exists.");
        }
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty.");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Year must be a positive number.");
        }
        books.put(isbn, new Book(isbn, title, author, year, true));
    }

    public boolean isBookAvailable(String isbn) {
        validateISBN(isbn);
        return books.containsKey(isbn) && books.get(isbn).isAvailable();
    }

    public void borrowBook(String isbn) {
        validateISBN(isbn);

        if (!books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book not found.");
        }
        Book book = books.get(isbn);
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is already borrowed.");
        }
        book.setAvailable(false); // Mark the book as borrowed
    }


    public void returnBook(String isbn) {
        if (!books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book not found.");
        }
        Book book = books.get(isbn);
        if (book.isAvailable()) {
            throw new IllegalStateException("Book is already returned.");
        }
        book.setAvailable(true); // Mark the book as returned
    }

    public List<Book> viewAvailableBooks() {
        return books.values().stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    private void validateISBN(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty.");
        }
    }
    public static boolean isEven(int num){
        return num%2 ==0;
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
