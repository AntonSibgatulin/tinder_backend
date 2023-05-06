package ru.antonsibgatulin.tinder_backend.controllers.profile;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.tinder_backend.dto.AuthDTO;
import ru.antonsibgatulin.tinder_backend.include.email.Email;
import ru.antonsibgatulin.tinder_backend.include.email.repository.EmailRepository;
import ru.antonsibgatulin.tinder_backend.include.error.Error;
import ru.antonsibgatulin.tinder_backend.include.system.result.Response;
import ru.antonsibgatulin.tinder_backend.include.user.repository.TokenUserRepository;
import ru.antonsibgatulin.tinder_backend.include.user.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final UserRepository userRepository;
    private final EmailRepository emailRepository;
    private final TokenUserRepository tokenUserRepository;

    public ProfileController(UserRepository userRepository, EmailRepository emailRepository, TokenUserRepository tokenUserRepository) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
        this.tokenUserRepository = tokenUserRepository;
    }

    @PostMapping("/")
    public Response response(AuthDTO authDTO){

        if(authDTO.checkError()){
            return new Response("TOKEN_INVALID", Error.TOKEN_INVALID);
        }

        try {
            Email email = tokenUserRepository.getTokenUserByCode(authDTO.getToken()).getEmail();
            Response response = new Response("OK",Error.OK);
            response.setEmail(email);
            return response;
        }catch(Exception e){
            return new Response("USER_AUTH_FALSE",Error.USER_AUTH_FALSE);

        }

    }





}
