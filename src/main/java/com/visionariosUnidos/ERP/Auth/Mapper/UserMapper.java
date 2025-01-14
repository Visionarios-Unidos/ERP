package com.visionariosUnidos.ERP.Auth.Mapper;

import com.visionariosUnidos.ERP.Auth.Dto.UserDto;
import com.visionariosUnidos.ERP.Auth.Dto.UserLoginDto;
import com.visionariosUnidos.ERP.Auth.Entity.Role;
import com.visionariosUnidos.ERP.Auth.Entity.User;
import com.visionariosUnidos.ERP.Auth.Repository.RoleRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserMapper {

    private RoleRepository roleRepository;

    public static User mapToUser(UserDto userDto, User user, RoleRepository roleRepository) {

        //Obtenemos el rol
        Role role = roleRepository.findByRole(userDto.getRole()).orElseThrow(() ->
                new RuntimeException("There is no role named: " + userDto.getRole()));

        user.setEmail(userDto.getEmail());
        user.setRoles(role);
        user.setPassword(userDto.getPassword());

        return user;
    }
    public static User mapToUser(UserLoginDto userLoginDto, User user, RoleRepository roleRepository) {

        user.setEmail(userLoginDto.getEmail());
        user.setPassword(userLoginDto.getPassword());

        return user;
    }
}
