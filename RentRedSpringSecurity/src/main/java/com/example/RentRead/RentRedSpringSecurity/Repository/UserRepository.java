package com.example.RentRead.RentRedSpringSecurity.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import com.example.RentRead.RentRedSpringSecurity.Entity.User;

@Repository
public interface  UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);


}
