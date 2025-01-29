package com.example.RentRead.RentRedSpringSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

//import com.example.RentRead.RentRedSpringSecurity.Entity.Enum.Role;
import com.example.RentRead.RentRedSpringSecurity.Entity.User;
import com.example.RentRead.RentRedSpringSecurity.Exchanges.Request.AuthRequest;
import com.example.RentRead.RentRedSpringSecurity.Exchanges.Request.RegisterRequest;
import com.example.RentRead.RentRedSpringSecurity.Exchanges.Response.AuthResponse;
import com.example.RentRead.RentRedSpringSecurity.Repository.UserRepository;

public class AuthService  {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;
    

    public AuthResponse register(RegisterRequest request) {
        if (request.getRole() == null) {
            request.setRole(User.Role.USER);
        }

        User user = User.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(request.getRole())
        .build();
        userRepository.save(user);

        return AuthResponse.builder().build();
    }


    public AuthResponse login(AuthRequest request)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        return AuthResponse.builder().build();

    }



     


    
}
