package dev.vivek.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpUserRequestDTO {
    private String email;
    private String password;
}
