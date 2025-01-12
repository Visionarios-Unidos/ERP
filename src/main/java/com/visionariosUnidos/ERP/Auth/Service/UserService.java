package com.visionariosUnidos.ERP.Auth.Service;

import com.visionariosUnidos.ERP.Auth.Dto.UserDto;
import com.visionariosUnidos.ERP.Auth.Dto.UserLoginDto;
import com.visionariosUnidos.ERP.Auth.Entity.User;
import com.visionariosUnidos.ERP.Auth.Exception.UserAlreadyExistsException;
import com.visionariosUnidos.ERP.Auth.Mapper.UserMapper;
import com.visionariosUnidos.ERP.Auth.Repository.RoleRepository;
import com.visionariosUnidos.ERP.Auth.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private JwtService jwtService;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    AuthenticationManager authManager;
    UserRepository userRepository;
    RoleRepository roleRepository;


    public User register(UserDto userDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

        userDto.setPassword(encoder.encode(userDto.getPassword()));
        checkUserDoesNotExistInDB(userDto);

        User user = UserMapper.mapToUser(userDto, new User(), roleRepository);

        userRepository.save(user);

        return user;
    }

    private void checkUserDoesNotExistInDB(UserDto userDto){
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());

        if(user.isPresent()){
            throw new UserAlreadyExistsException("User with email: "
                    + userDto.getEmail()
                    + " already exists");
        }
    }

    public String verify(UserLoginDto userLoginDto) {
        log.info("Executing method verify ...");

        User user = UserMapper.mapToUser(userLoginDto, new User(), roleRepository);

        try {
            Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(user.getEmail());
            } else {
                return "fail";
            }
        }
        catch (Exception e){
            log.info(e.getMessage());
            return "User not Found";
        }

    }
}
