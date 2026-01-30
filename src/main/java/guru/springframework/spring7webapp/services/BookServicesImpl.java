package guru.springframework.spring7webapp.services;

import guru.springframework.spring7webapp.domain.Book;
import guru.springframework.spring7webapp.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServicesImpl implements BookServices{

    final private BookRepository bookRepository;

    public BookServicesImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
