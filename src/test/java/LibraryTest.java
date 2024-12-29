import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void testAddBook() {
        Library library = new Library();
        library.addBook("123", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        assertTrue(library.isBookAvailable("123"));
    }
}
