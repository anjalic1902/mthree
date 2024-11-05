package com.example.librarayapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.bookapi.model.*;
import com.example.librarayapp.service.LibraryService;
@RestController
@RequestMapping("/api/books")
public class BookController {
    
    private final LibraryService libraryService;

    @Autowired
    public BookController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        libraryService.addBook(book);
    }

    @GetMapping("/{isbn}")
    public Book getBook(@PathVariable String isbn){
        return libraryService.getBook(isbn);
    }
}
