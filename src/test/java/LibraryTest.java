import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void testAddBook() {
        Library library = new Library();
        library.addBook("123", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        assertTrue(library.isBookAvailable("123"));
    }
    @Test
    public void testBorrowBook() {
        Library library = new Library();
        library.addBook("123", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.borrowBook("123");
        assertFalse(library.isBookAvailable("123"));
    }
    @Test
    public void testReturnBook() {
        Library library = new Library();
        library.addBook("123", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.borrowBook("123");
        library.returnBook("123");
        assertTrue(library.isBookAvailable("123"));
    }
    @Test
    public void testViewAvailableBooks() {
        Library library = new Library();
        library.addBook("123", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.addBook("124", "1984", "George Orwell", 1949);
        library.borrowBook("123");

        assertEquals(1, library.viewAvailableBooks().size());
    }

}
