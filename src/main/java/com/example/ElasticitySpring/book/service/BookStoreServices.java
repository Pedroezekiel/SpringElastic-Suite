package com.example.ElasticitySpring.book.service;

import com.example.ElasticitySpring.book.model.Book;

import java.util.List;

public interface BookStoreServices{
    String createBook(Book book);

    long getBookCount();

    Book getBookById(String id);

    List<Book> findBooksByIds(List<String> ids);

    List<Book> findBooksByAuthor(String author);

    List<Book> findBooksByTitle(String title);

    List<Book> findBooksBySynopsisAndTitle(String search);

    List<Book> findBooksBySynopsisAndTitle_boost(String search);

    List<Book> findBooksByPhraseInSynopsis(String search);

    List<Book> findBooksByTitlePrefix(String title);

    List<Book> findBooksByTitleFuzzy(String title);

    List<Book> searchByEdition(int edition);

    List<Book> searchByRatingRate(double min, double max);

    List<Book> getAllBooks();
}
