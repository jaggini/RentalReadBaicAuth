
// package com.example.RentRead.RentRedSpringSecurity;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.*;

// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;

// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.http.ResponseEntity;

// import com.example.RentRead.RentRedSpringSecurity.Controller.RentalReadController;
// import com.example.RentRead.RentRedSpringSecurity.Entity.User;
// import com.example.RentRead.RentRedSpringSecurity.Service.BookService;
// import com.example.RentRead.RentRedSpringSecurity.Service.UserService;





// @WebMvcTest(RentalReadController.class)
// public class RentalRadTest {
//     @InjectMocks
//     private RentalReadController rentalRead;


//     @Mock
//     private BookService bookService;
//     @Mock
//     private UserService userService;

// @Test
// void rentBook() throws Exception
// {
// User u=new User(1L,"john","doe","john@gmail.com","password",User.Role.USER,null);
// when(userService.getUserByEmail("john@gmail.com")).thenReturn(u);

// ResponseEntity<String> res=rentalRead.rentBook(1L, "john@gmail.com");
// assertEquals(200,res.getStatusCode());
// assertEquals("Book rentes successfully",res.getBody());


// }

// @Test
// void returnBook() throws Exception
// {
//     User u=new User(1L,"john","doe","john@gmail.com","password",User.Role.USER,null);
//     when(userService.getUserByEmail("john@gmail.com")).thenReturn(u);
//     ResponseEntity<String> res=rentalRead.rentBook(1L, "john@gmail.com");
// assertEquals(200,res.getStatusCode());
// assertEquals("Book renturs successfully",res.getBody());
// }



// }
