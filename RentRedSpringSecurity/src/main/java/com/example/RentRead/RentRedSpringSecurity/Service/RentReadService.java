package com.example.RentRead.RentRedSpringSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentRead.RentRedSpringSecurity.Entity.Book;
import com.example.RentRead.RentRedSpringSecurity.Entity.RentalRead;
import com.example.RentRead.RentRedSpringSecurity.Entity.User;
import com.example.RentRead.RentRedSpringSecurity.Repository.BookRepository;
//import com.example.RentRead.RentRedSpringSecurity.Entity.Enum.StatusRental;
//import com.example.RentRead.RentRedSpringSecurity.Repository.BookRepository;
import com.example.RentRead.RentRedSpringSecurity.Repository.RentReadRepository;
//import com.example.RentRead.RentRedSpringSecurity.Repository.UserRepository;

import java.util.*;



@Service
public class RentReadService {

   
    @Autowired
    private RentReadRepository rentReadRepository;
    

    @Autowired 
    private BookRepository bookRepository;


public void  rentBook(Long  bookId,User u) throws Exception
{
    List<RentalRead> activeRentals=rentReadRepository.findByUserAndIsReturned(u, false);
    if(activeRentals.size()>=2)
    {
         throw new Exception("Cannot rent more than 3 books at a time");
    }
    Book b=bookRepository.findById(bookId).orElseThrow(()-> new IllegalArgumentException("Book not found"));
    RentalRead rent=RentalRead.builder().book(b).user(u).isReturned(false).build();
    rentReadRepository.save(rent);
}
    
public void returnBook(User user,Long bookId)
{

    RentalRead r=rentReadRepository.findByUserAndBookAndIsReturnde(user, bookId, false)
    .orElseThrow(()-> new IllegalArgumentException("Rental not found"));
    r.setReturned(true);
    rentReadRepository.save(r);
}
            
        
    }
    
    

