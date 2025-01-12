package com.visionariosUnidos.ERP.Auth.Service;


import com.visionariosUnidos.ERP.Auth.Entity.User;
import com.visionariosUnidos.ERP.Auth.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //// Habrá que manejar las excepciones!!!
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User Not Found"));

        return new CustomUserDetails(user);
    }
}
