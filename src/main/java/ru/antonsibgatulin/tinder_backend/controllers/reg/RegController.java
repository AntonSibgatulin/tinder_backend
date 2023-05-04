package ru.antonsibgatulin.tinder_backend.controllers.reg;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.tinder_backend.dto.EmailDTO;
import ru.antonsibgatulin.tinder_backend.dto.mapping.EmailMapping;
import ru.antonsibgatulin.tinder_backend.include.email.Email;
import ru.antonsibgatulin.tinder_backend.include.email.repository.EmailRepository;
import ru.antonsibgatulin.tinder_backend.include.system.result.Response;
import ru.antonsibgatulin.tinder_backend.include.user.repository.UserRepository;

@RestController

@RequestMapping("/api/v1/reg")
public class RegController {

    private final UserRepository userRepository;
    private final EmailRepository emailRepository;
    private final EmailMapping emailMapping;

    public RegController(UserRepository userRepository, EmailRepository emailRepository, EmailMapping emailMapping) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
        this.emailMapping = emailMapping;
    }


    @PostMapping("/register")
    public Response reg(@Valid @RequestBody EmailDTO emailDTO){
        Response response = null;

        Email email = emailMapping.toNumberFromNumberDTO(emailDTO);
        email.generateRandomCode();

        emailRepository.save(email);
        response = new Response("Waiting code...",200);
        response.setEmail(email);

        return response;
    }

}
