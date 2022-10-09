package com.data.mil.dto;

import com.data.mil.enums.GenderEnum;
import com.data.mil.enums.RankEnum;
import com.data.mil.model.Holes;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateUserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private RankEnum rank;
    private GenderEnum gender;
    private LocalDate date;
    private Long height;
    private Long weight;
    private AllergicReactionDTO allergicReactionDTO;
    private ChronicleDTO chronicleDTO;
    private HolesDTO holesDTO;
}
