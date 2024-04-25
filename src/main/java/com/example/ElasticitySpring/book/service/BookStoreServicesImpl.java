package com.example.ElasticitySpring.book.service;

import com.example.ElasticitySpring.book.model.Book;
import com.example.ElasticitySpring.book.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookStoreServicesImpl  implements BookStoreServices {

    private final BookRepository bookRepository;


    @Override
    public String createBook(Book book) {
        bookRepository.save(book);
        return "Book created successfully";
    }

    @Override
    public long getBookCount() {
        return bookRepository.count();
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }


    @Override
    public List<Book> findBooksByIds(List<String> ids) {
        return ids.stream().map(id ->
                bookRepository.findById(id).orElse(null))
                .toList();
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> findBooksBySynopsisAndTitle(String search) {
        return bookRepository.searchBySynopsisAndTitle(search);
    }

    @Override
    public List<Book> findBooksBySynopsisAndTitle_boost(String search) {
        return bookRepository.searchBySynopsisAndTitle_boost(search);
    }

    @Override
    public List<Book> findBooksByPhraseInSynopsis(String search) {
        return bookRepository.searchByPhraseInSynopsis(search);
    }

    @Override
    public List<Book> findBooksByTitlePrefix(String title) {
        return bookRepository.searchByTitlePrefix(title);
    }

    @Override
    public List<Book> findBooksByTitleFuzzy(String title) {
        return bookRepository.searchByTitleFuzzy(title);
    }

    @Override
    public List<Book> searchByEdition(int edition) {
        return bookRepository.searchByEdition_term(edition);
    }

    @Override
    public List<Book> searchByRatingRate(double min, double max) {
        return bookRepository.searchByAmazonRating_range(min, max);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAllBooks();
    }





}
