package com.example.RentRead.RentRedSpringSecurity.Exchanges.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthRequest
{
    private String email;
    private String password;

    public void setPassword(String password)
    {
        this.password=password;
        
    }

}