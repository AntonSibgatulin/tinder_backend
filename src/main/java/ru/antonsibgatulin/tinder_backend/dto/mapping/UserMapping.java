package ru.antonsibgatulin.tinder_backend.dto.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.antonsibgatulin.tinder_backend.dto.UserDTO;
import ru.antonsibgatulin.tinder_backend.include.user.User;

@Mapper(componentModel = "spring")
public interface UserMapping {

    @Mapping(target = "name",source = "name")
    @Mapping(target = "password",source = "password")
    @Mapping(target = "timeBirth",source = "timeBirth")
    @Mapping(target = "gender",source = "Egender")
    @Mapping(target = "genderToShow",source = "EgenderToShow")
    @Mapping(target = "showMe",source = "showMe")
    User fromUserDTOtoUser(UserDTO userDTO);


}
