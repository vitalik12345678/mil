package com.data.mil.dto.user;

import com.data.mil.enums.GenderEnum;
import com.data.mil.enums.RankEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class UserEditDTO {

    @NotBlank
    @Pattern(regexp = "^[A-Za-zА-Яа-яіїєщІЇЄЩ]{3,20}+$",message = "Incorrect first name")
    private String firstName;

    @NotBlank
    @Pattern(regexp = "^[A-Za-zА-Яа-яіїєщІЇЄЩ]{3,20}+$",message = "Incorrect last name")
    private String lastName;

    @NotBlank
    private RankEnum rank;

    @NotBlank
    private GenderEnum gender;

    @NotBlank
    private LocalDate birthDate;

    @NotNull
    private Long height;

}
