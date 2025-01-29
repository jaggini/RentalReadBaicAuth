package com.example.RentRead.RentRedSpringSecurity.Exchanges.Response;



// import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
// import lombok.NoArgsConstructor;


@Builder
@Data
public class AuthResponse
{
   private  String message;

   public AuthResponse(String message) {
      this.message=message;
   }

   
   
}