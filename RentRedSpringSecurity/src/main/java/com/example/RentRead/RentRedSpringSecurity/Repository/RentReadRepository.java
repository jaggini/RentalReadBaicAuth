package com.example.RentRead.RentRedSpringSecurity.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.RentRead.RentRedSpringSecurity.Entity.Enum.StatusRental;
import com.example.RentRead.RentRedSpringSecurity.Entity.RentalRead;
import com.example.RentRead.RentRedSpringSecurity.Entity.User;

@Repository
public interface RentReadRepository extends JpaRepository<RentalRead, Long> {
    
      List<RentalRead> findByUserAndIsReturned(User u,boolean isReturned);
      Optional<RentalRead> findByUserAndBookAndIsReturnde(User u,Long bookId,boolean isReturned);
}
