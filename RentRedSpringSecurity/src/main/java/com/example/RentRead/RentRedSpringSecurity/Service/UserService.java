package com.example.RentRead.RentRedSpringSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RentRead.RentRedSpringSecurity.Entity.User;
import com.example.RentRead.RentRedSpringSecurity.Repository.UserRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService
{
 
    @Autowired
     UserRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found with the email"+email));
        if(user==null)
        {
            throw new UsernameNotFoundException("User not found with email"+email);
        }
                return user;
    }

    public User getUserByEmail(String email)
    {
        return userRepository.findByEmail(email).orElseThrow(()-> new IllegalArgumentException("User not found with email"+email));

    }
    
    public User saveUser(User u)
    {
        return userRepository.save(u);
    }

}