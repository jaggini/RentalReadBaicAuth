package com.example.RentRead.RentRedSpringSecurity.Exchanges.Request;

import com.example.RentRead.RentRedSpringSecurity.Entity.User.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest
{
  private String firstName;
    private String lastName;
  private String email;
  private String password;
     private Role role;


}