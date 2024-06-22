package com.professionalpractice.medicalbooking.security;


import com.professionalpractice.medicalbooking.entities.User;
import com.professionalpractice.medicalbooking.exceptions.NotFoundException;
import com.professionalpractice.medicalbooking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new NotFoundException("Cannot find user with email = " + email));
        return new CustomUserDetails(user);
    }
}
