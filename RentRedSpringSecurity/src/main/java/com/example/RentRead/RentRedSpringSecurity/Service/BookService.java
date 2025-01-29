package com.example.RentRead.RentRedSpringSecurity.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentRead.RentRedSpringSecurity.Entity.Book;
import com.example.RentRead.RentRedSpringSecurity.Repository.BookRepository;

//import com.example.RentRead.RentRedSpringSecurity.Entity.Enum.AvialableStatus;
import java.util.*;

@Service
public class BookService
{
    @Autowired 
    private BookRepository bookRepository;


    public List<Book> getAvailableBook()
    {
        return  bookRepository.findByAvailableStatus(Book.AvialableStatus.AVAILABLE);
    }

    public Book createBook(Book b)
    {
        return bookRepository.save(b);
    }
    public void deleteBook(Long id)
    {
        bookRepository.deleteById(id);
    }

    public Book updatetheBook(Long id,Book b)
    {
        Optional<Book> existBook=bookRepository.findById(id);
        if(existBook.isPresent())
        {
            Book book=existBook.get();
            book.setTitle(b.getTitle());
            book.setAuthor(b.getAuthor());
            book.setGenre(b.getGenre());
            book.setAvailableStatus(b.getAvailableStatus());
            return bookRepository.save(book);

        }
        throw new IllegalArgumentException("Book not found");
    }


}