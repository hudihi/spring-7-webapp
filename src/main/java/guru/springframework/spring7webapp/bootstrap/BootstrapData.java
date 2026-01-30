package guru.springframework.spring7webapp.bootstrap;

import guru.springframework.spring7webapp.domain.Author;
import guru.springframework.spring7webapp.domain.Book;
import guru.springframework.spring7webapp.repository.AuthorRepository;
import guru.springframework.spring7webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Author author1 = new Author();
        author1.setFirstName("Edson");
        author1.setLastName("Ede");

        Book book1 = new Book();
        book1.setTitle("Domain Driven Design");
        book1.setIsbn("1234");

        Author author1Saved = authorRepository.save(author1);
        Book book1Saved = bookRepository.save(book1);


        Author author2 = new Author();
        author2.setFirstName("Yoweli");
        author2.setLastName("Enock");


        Book book2 = new Book();
        book2.setTitle("Software Engineering");
        book2.setIsbn("45678");

        Author auther2Saved = authorRepository.save(author2);
        Book book2Saved = bookRepository.save(book2);

        author1Saved.getBooks().add(book1Saved);
        auther2Saved.getBooks().add(book2Saved);
        book1Saved.getAuthors().add(author1Saved);
        book2Saved.getAuthors().add(auther2Saved);


        authorRepository.save(author1Saved);
        authorRepository.save(auther2Saved);
        bookRepository.save(book1Saved);
        bookRepository.save(book2Saved);


        System.out.println("In BootstrapData: ");

        System.out.println("Authors: " + authorRepository.count());
        System.out.println("Books: " + bookRepository.count());

    }
}
