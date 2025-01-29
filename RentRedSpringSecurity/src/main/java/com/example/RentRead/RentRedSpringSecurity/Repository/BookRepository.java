package com.example.RentRead.RentRedSpringSecurity.Repository;


import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RentRead.RentRedSpringSecurity.Entity.Book;
//import com.example.RentRead.RentRedSpringSecurity.Entity.Enum.AvialableStatus;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>
{
      List<Book> findByAvailableStatus(Book.AvialableStatus available);
}