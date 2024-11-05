package com.example.librarayapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookapi.model.*;
import com.example.librarayapp.service.BeanRetrievalService;
import com.example.librarayapp.service.LibraryService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    private final BeanRetrievalService beanRetrievalService;

    @Autowired
    public AdminController(BeanRetrievalService beanRetrievalService){
        this.beanRetrievalService =beanRetrievalService;
    }
    @PostMapping("/books")
    public void addBook(@RequestBody Book book){
        LibraryService libraryService =beanRetrievalService.getBean(LibraryService.class);
        libraryService.addBook(book);
    }

    @GetMapping("/books/{isbn}")
    public Book getBook(@PathVariable String isbn){
        LibraryService libraryService=beanRetrievalService.getBean(LibraryService.class);
        return libraryService.getBook(isbn);
    }
}
