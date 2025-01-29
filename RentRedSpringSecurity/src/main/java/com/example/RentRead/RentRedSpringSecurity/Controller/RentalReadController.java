package com.example.RentRead.RentRedSpringSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RentRead.RentRedSpringSecurity.Entity.User;
import com.example.RentRead.RentRedSpringSecurity.Service.RentReadService;
import com.example.RentRead.RentRedSpringSecurity.Service.UserService;
@RestController
@RequestMapping("/rentRead")
public class RentalReadController {

    @Autowired
    private UserService userService;
      @Autowired
    private  RentReadService rentReadService;

  

    @PostMapping("/{bookId}/rent")
    public ResponseEntity<String> rentBook(@PathVariable Long bookId,@RequestParam String email) throws Exception
    {
        User u=userService.getUserByEmail(email);
        rentReadService.rentBook(bookId, u);
        
        return ResponseEntity.ok("Book rented successfully");

    }
    
    @PostMapping("/{bookId}/return")
    public ResponseEntity<String> returnBook(@PathVariable Long bookId,@RequestParam String email)
    {
        User user=userService.getUserByEmail(email);
        rentReadService.returnBook(user, bookId);
        return ResponseEntity.ok("Book returned Succesfully");
        

    }
}
