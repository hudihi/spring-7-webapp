package guru.springframework.spring7webapp.services;

import guru.springframework.spring7webapp.domain.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookServices {

    Iterable<Book> findAll();
}
