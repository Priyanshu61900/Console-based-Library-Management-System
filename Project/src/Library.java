import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer, Book> books;
    private Map<Integer, Borrower> borrowers;

    public Library() {
        books = new HashMap<>();
        borrowers = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public Book searchBook(int id) {
        return books.get(id);
    }

    public void borrowBook(int bookId, Borrower borrower) {
        if (books.containsKey(bookId)) {
            borrowers.put(bookId, borrower);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(int bookId) {
        if (borrowers.containsKey(bookId)) {
            borrowers.remove(bookId);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book not borrowed or not found.");
        }
    }
}
