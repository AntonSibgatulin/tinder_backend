package ru.antonsibgatulin.tinder_backend.dto.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.antonsibgatulin.tinder_backend.dto.EmailDTO;
import ru.antonsibgatulin.tinder_backend.include.email.Email;

@Mapper(componentModel = "spring")
public interface EmailMapping {

    @Mapping(target = "email",source = "email")
    Email toNumberFromNumberDTO(EmailDTO numberDTO);

}
