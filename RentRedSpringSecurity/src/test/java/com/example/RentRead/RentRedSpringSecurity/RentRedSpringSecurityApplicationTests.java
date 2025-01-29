package com.example.RentRead.RentRedSpringSecurity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.ResponseEntity;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.RentRead.RentRedSpringSecurity.Controller.AuthController;
import com.example.RentRead.RentRedSpringSecurity.Entity.User;
//import com.example.RentRead.RentRedSpringSecurity.Exchanges.Request.AuthRequest;
import com.example.RentRead.RentRedSpringSecurity.Exchanges.Request.RegisterRequest;
import com.example.RentRead.RentRedSpringSecurity.Exchanges.Response.AuthResponse;
import com.example.RentRead.RentRedSpringSecurity.Repository.UserRepository;
import com.example.RentRead.RentRedSpringSecurity.Service.AuthService;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RentRedSpringSecurityApplicationTests {


	

	@Mock
	private AuthService authservice;
	
	@InjectMocks
	private AuthController authController;

	@Mock
	private UserRepository userRepository;
	

	@Test
	void registerUser() throws Exception
	{
	RegisterRequest req=new RegisterRequest();
	req.setFirstName("John");
	req.setLastName("Deo");
	req.setEmail("john@gmail.com");
	req.setPassword("password");
	AuthResponse res=authservice.register(req);
	assertEquals("Success",res.getMessage());
	verify(userRepository,times(1)).save(any(User.class));

}

// @Test
// public void loginUser() 
// {
// 	   AuthRequest request=new AuthRequest("john@gmail.com","password");
// 	   when(authservice.login(any(AuthRequest.class))).thenReturn(new AuthResponse("Success"));
// 	   ResponseEntity<AuthResponse> res=authController.login(request);
// 	   assertEquals(200,res.getStatusCode());
// 	   assertEquals("Success",res.getBody().getMessage());
// }





	// @Test
	// void contextLoads() {
	// }

}
