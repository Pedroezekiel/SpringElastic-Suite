package com.example.ElasticitySpring.book.controllers;

import com.example.ElasticitySpring.book.model.Book;
import com.example.ElasticitySpring.book.service.BookStoreServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookStoreServices bookStoreServices;


    @PostMapping
    public String createBook(@RequestBody Book book) {
        return bookStoreServices.createBook(book);
    }

    @GetMapping("/count")
    public long getBookCount() {
        return bookStoreServices.getBookCount();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookStoreServices.getBookById(id);
    }

    @GetMapping("/ids")
    public List<Book> findBooksByIds(@RequestParam List<String> ids) {
        return bookStoreServices.findBooksByIds(ids);
    }

    @GetMapping("/author")
    public List<Book> findBooksByAuthor(@RequestParam String author) {
        return bookStoreServices.findBooksByAuthor(author);
    }

    @GetMapping("/title")
    public List<Book> findBooksByTitle(@RequestParam String title) {
        return bookStoreServices.findBooksByTitle(title);
    }

    @GetMapping("/synopsis-title")
    public List<Book> findBooksBySynopsisAndTitle(@RequestParam String search) {
        return bookStoreServices.findBooksBySynopsisAndTitle(search);
    }

    @GetMapping("/synopsis-title-boost")
    public List<Book> findBooksBySynopsisAndTitle_boost(@RequestParam String search) {
        return bookStoreServices.findBooksBySynopsisAndTitle_boost(search);
    }

    @GetMapping("/synopsis-phrase")
    public List<Book> findBooksByPhraseInSynopsis(@RequestParam String search) {
        return bookStoreServices.findBooksByPhraseInSynopsis(search);
    }

    @GetMapping("/title-prefix")
    public List<Book> findBooksByTitlePrefix(@RequestParam String title) {
        return bookStoreServices.findBooksByTitlePrefix(title);
    }

    @GetMapping("/title-fuzzy")
    public List<Book> findBooksByTitleFuzzy(@RequestParam String title) {
        return bookStoreServices.findBooksByTitleFuzzy(title);
    }

    @GetMapping("/edition")
    public List<Book> searchByEdition(@RequestParam int edition) {
        return bookStoreServices.searchByEdition(edition);
    }

    @GetMapping("/rating")
    public List<Book> searchByRatingRate(@RequestParam double min, @RequestParam double max) {
        return bookStoreServices.searchByRatingRate(min, max);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookStoreServices.getAllBooks();
    }
}