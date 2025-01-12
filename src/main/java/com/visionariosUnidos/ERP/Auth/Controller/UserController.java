package com.visionariosUnidos.ERP.Auth.Controller;

import com.visionariosUnidos.ERP.Auth.Dto.ResponseDto;
import com.visionariosUnidos.ERP.Auth.Dto.UserDto;
import com.visionariosUnidos.ERP.Auth.Dto.UserLoginDto;
import com.visionariosUnidos.ERP.Auth.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody UserDto userDto) {

        userService.register(userDto);

        return ResponseEntity
                .ok()
                .body(new ResponseDto("200", "User registered successfully"));
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDto userLoginDto) {

        return userService.verify(userLoginDto);
    }

}
