package com.lbuthman.exercises.bootstrap;

import com.lbuthman.exercises.model.Author;
import com.lbuthman.exercises.model.Book;
import com.lbuthman.exercises.repositories.AuthorRepository;
import com.lbuthman.exercises.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Author rothfuss = new Author("Patrick", "Rothfuss");
        Book nameOfWind = new Book("The Name of the Wind", "1234", "R Someone");
        rothfuss.getBooks().add(nameOfWind);
        nameOfWind.getAuthors().add(rothfuss);

        authorRepository.save(rothfuss);
        bookRepository.save(nameOfWind);

        Author tolkein = new Author("J.R.R", "Tolkein");
        Book lordRings = new Book("The Fellowship of the Ring", "2345", "T Someone");
        tolkein.getBooks().add(lordRings);
        lordRings.getAuthors().add(tolkein);

        authorRepository.save(tolkein);
        bookRepository.save(lordRings);
    }

}
