import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(id, title, author);
                    library.addBook(newBook);
                    break;
                case 2:
                    System.out.print("Enter book ID: ");
                    int searchId = scanner.nextInt();
                    Book foundBook = library.searchBook(searchId);
                    if (foundBook != null) {
                        System.out.println("Book found:");
                        System.out.println("Title: " + foundBook.getTitle());
                        System.out.println("Author: " + foundBook.getAuthor());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book ID: ");
                    int borrowId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter borrower's name: ");
                    String borrowerName = scanner.nextLine();
                    System.out.print("Enter borrower's contact info: ");
                    String contactInfo = scanner.nextLine();
                    Borrower borrower = new Borrower(borrowerName, contactInfo);
                    library.borrowBook(borrowId, borrower);
                    break;
                case 4:
                    System.out.print("Enter book ID: ");
                    int returnId = scanner.nextInt();
                    library.returnBook(returnId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
}
