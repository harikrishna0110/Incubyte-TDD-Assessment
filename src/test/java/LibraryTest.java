import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void testAddBook() {
        Library library = new Library();
        library.addBook("123", "The Incubyte", "Uncle bob", 1925);
        assertTrue(library.isBookAvailable("123"));
    }
    @Test
    public void testBorrowBook() {
        Library library = new Library();
        library.addBook("123", "The Incubyte", "Uncle bob", 1925);
        library.borrowBook("123");
        assertFalse(library.isBookAvailable("123"));
    }
    @Test
    public void testReturnBook() {
        Library library = new Library();
        library.addBook("123", "The Incubyte", "Uncle bob", 1925);
        library.borrowBook("123");
        library.returnBook("123");
        assertTrue(library.isBookAvailable("123"));
    }
    @Test
    public void testViewAvailableBooks() {
        Library library = new Library();
        library.addBook("123", "The Incubyte", "Uncle bob", 1925);
        library.addBook("124", "1984", "George Orwell", 1949);
        library.borrowBook("123");

        assertEquals(1, library.viewAvailableBooks().size());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateBook() {
        Library library = new Library();
        library.addBook("123", "The Incubyte", "Uncle bob", 1925);

        library.addBook("123", "The Incubyte", "Uncle bob", 1925);
    }

    @Test
    public void testAddBookWithDuplicateISBN() {
        Library library = new Library();
        // Add the first book with ISBN "123"
        library.addBook("123", "The Incubyte", "Uncle bob", 1925);

        try {
            // Attempt to add a second book with the same ISBN, which should throw an IllegalArgumentException
            library.addBook("123", "The Incubyte", "Uncle bob", 1925);

            // If no exception is thrown, we manually fail the test
            fail("Expected IllegalArgumentException not thrown.");
        } catch (IllegalArgumentException e) {
            // This block will run if the exception is thrown (test passes)
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
    @Test(expected = IllegalStateException.class)
    public void testBorrowBookWhenNotAvailable() {
        Library library = new Library();
        library.addBook("1", "The Incubyte", "Uncle bob", 1925);
        library.borrowBook("1"); // Borrow the book first
        library.borrowBook("1"); // Try to borrow it again (should throw IllegalStateException)
    }
    @Test(expected = IllegalArgumentException.class)
    public void testBorrowNonExistentBook() {
        Library library = new Library();
        try {
            library.borrowBook("999"); // Should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReturnNonExistentBook() {
        Library library = new Library();
        try {
            library.returnBook("999"); // Should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public  void CheckNum(){
        Library library = new Library();
    assertTrue(Library.isEven(4));
    }


}
