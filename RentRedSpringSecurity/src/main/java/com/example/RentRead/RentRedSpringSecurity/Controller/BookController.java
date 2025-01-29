package com.example.RentRead.RentRedSpringSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.example.RentRead.RentRedSpringSecurity.Entity.Book;
import com.example.RentRead.RentRedSpringSecurity.Service.BookService;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private  BookService bookService;
    


    @GetMapping
    public ResponseEntity<List<Book>>  getBooks()
    {
        List<Book> book=bookService.getAvailableBook();
        return ResponseEntity.ok(book);
    }


    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book b)
    {
        Book create=bookService.createBook(b);
        return ResponseEntity.status(201).body(create);
    }
    @PutMapping("{id}")
public ResponseEntity<Book> updateBook(@PathVariable Long id,@RequestBody Book b)
{
      Book book=bookService.updatetheBook(id, b);
      return ResponseEntity.ok(book);
}    


@DeleteMapping("{id}")
public ResponseEntity<Void> deleteBook(@PathVariable  Long id)
{
    bookService.deleteBook(id);
    return ResponseEntity.noContent().build();

} 



}
