package com.data.mil.dto;

import com.data.mil.enums.GenderEnum;
import com.data.mil.enums.RankEnum;
import com.data.mil.model.Holes;
import com.data.mil.model_mapper.Convertable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CreateUserDTO implements Convertable {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String gender;
    private RankEnum rank;
    private LocalDate birthDate;
    private Long height;
    private Long weight;
    private List<AllergicReactionDTO> allergicReactionDTO;
    private List<ChronicleDTO> chronicleDTO;
    private List<HolesDTO> holesDTO;

}
