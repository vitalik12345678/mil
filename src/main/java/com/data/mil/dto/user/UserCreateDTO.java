package com.data.mil.dto.user;

import com.data.mil.dto.AllergicReactionDTO;
import com.data.mil.dto.ChronicleDTO;
import com.data.mil.dto.HolesDTO;
import com.data.mil.enums.RankEnum;
import com.data.mil.model_mapper.Convertable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UserCreateDTO implements Convertable {

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
