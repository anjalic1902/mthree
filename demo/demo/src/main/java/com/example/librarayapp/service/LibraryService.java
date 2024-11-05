package com.example.librarayapp.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.bookapi.model.*;
@Service
public class LibraryService {
    private Map<String,Book> books=new HashMap<String,Book>();
    public void addBook(Book book){
        books.put(book.getId(), book);
    }
    public Book getBook(String isbn){
        return books.get(isbn);
    }


}
