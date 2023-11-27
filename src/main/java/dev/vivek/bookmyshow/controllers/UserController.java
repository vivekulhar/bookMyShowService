package dev.vivek.bookmyshow.controllers;

import dev.vivek.bookmyshow.dtos.SignUpUserRequestDTO;
import dev.vivek.bookmyshow.dtos.SignUpUserResponseDTO;
import dev.vivek.bookmyshow.models.User;
import dev.vivek.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    public SignUpUserResponseDTO signUpUser(SignUpUserRequestDTO request){
        User user = userService.signUpUser(
            request.getEmail(), request.getPassword()
        );

        SignUpUserResponseDTO response = new SignUpUserResponseDTO();
        response.setUserId(user.getId());

        return response;
    }
}
