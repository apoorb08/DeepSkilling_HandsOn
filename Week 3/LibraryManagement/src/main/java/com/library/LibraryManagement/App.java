package library.LibraryManagement;

import com.library.repository.BookRepository;

public class App {

    // The private field to hold the dependency
    private BookRepository bookRepository;

    // The public setter method that Spring will use for injection
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("Spring is injecting the BookRepository bean now.");
        this.bookRepository = bookRepository;
    }

    public void addBook() {
        System.out.println("App: Calling the repository to save a book...");
        // This call will fail with a NullPointerException if the injection didn't work.
        bookRepository.save();
    }
}
