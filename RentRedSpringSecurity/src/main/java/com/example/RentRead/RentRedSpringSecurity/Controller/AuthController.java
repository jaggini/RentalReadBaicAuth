package com.example.RentRead.RentRedSpringSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RentRead.RentRedSpringSecurity.Entity.User;
import com.example.RentRead.RentRedSpringSecurity.Exchanges.Request.AuthRequest;
import com.example.RentRead.RentRedSpringSecurity.Exchanges.Request.RegisterRequest;
import com.example.RentRead.RentRedSpringSecurity.Exchanges.Response.AuthResponse;
//import com.example.RentRead.RentRedSpringSecurity.Service.AuthService;
import com.example.RentRead.RentRedSpringSecurity.Service.AuthService;

@RestController

@RequestMapping("/users")

public class AuthController 
{
       @Autowired
       AuthService authservice;

@PostMapping("/register")
       public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
       {
              User u=new User();
               u.setFirstName(request.getFirstName());
               u.setLastName(request.getLastName());
               u.setEmail(request.getEmail());
               u.setPassword(request.getPassword());
               u.setRole(request.getRole());
               

               return ResponseEntity.ok(authservice.register(request));
       }

       @PostMapping("/login")
       public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request)
       {
            return ResponseEntity.ok(authservice.login(request));
       }

}