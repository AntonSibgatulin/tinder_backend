package ru.antonsibgatulin.tinder_backend.controllers.reg;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.antonsibgatulin.tinder_backend.dto.EmailDTO;
import ru.antonsibgatulin.tinder_backend.dto.UserDTO;
import ru.antonsibgatulin.tinder_backend.dto.mapping.EmailMapping;
import ru.antonsibgatulin.tinder_backend.dto.mapping.UserMapping;
import ru.antonsibgatulin.tinder_backend.include.email.Email;
import ru.antonsibgatulin.tinder_backend.include.email.repository.EmailRepository;
import ru.antonsibgatulin.tinder_backend.include.error.Error;
import ru.antonsibgatulin.tinder_backend.include.system.result.Response;
import ru.antonsibgatulin.tinder_backend.include.user.TokenUser;
import ru.antonsibgatulin.tinder_backend.include.user.User;
import ru.antonsibgatulin.tinder_backend.include.user.repository.TokenUserRepository;
import ru.antonsibgatulin.tinder_backend.include.user.repository.UserRepository;

@RestController

@RequestMapping("/api/v1/reg")
public class RegController {

    private final UserRepository userRepository;
    private final EmailRepository emailRepository;
    private final TokenUserRepository tokenUserRepository;

    private final EmailMapping emailMapping;
    private final UserMapping userMapping;

    public RegController(UserRepository userRepository, EmailRepository emailRepository, EmailMapping emailMapping, TokenUserRepository tokenUserRepository, UserMapping userMapping) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
        this.emailMapping = emailMapping;
        this.tokenUserRepository = tokenUserRepository;
        this.userMapping = userMapping;
    }


    @PostMapping("/register")
    public Response reg(@Valid @RequestBody EmailDTO emailDTO){

        Email email = emailMapping.toNumberFromNumberDTO(emailDTO);
        email.generateRandomCode();

        emailRepository.save(email);

        Response response = new Response("OK", Error.OK);
        response.setEmail(email);

        return response;
    }

    @PostMapping("/checkcode")
    public Response checkCode(@RequestParam Integer code,@RequestParam String emailString){


        if(code<100000 || code >999999){
            return new Response("code unbelievable",Error.CODE_UNBELIEVABLE);
        }else{
            Email email = emailRepository.getEmailByEmail(emailString);
            if(email == null){
                return new Response("email unregistered",Error.EMAIL_UNREGISTERED);
            }
            else if(email.getCode() == 0){
                return new Response("Code is null",Error.CODE_IS_NULL);
            }else{

                if(email.getCode() != code){
                    return new Response("Code unbelievable",Error.CODE_UNBELIEVABLE);
                }else{
                    email.setCode(0);
                    emailRepository.save(email);
                    TokenUser tokenUser = new TokenUser(email);
                    tokenUserRepository.save(tokenUser);
                    Response response = new Response("OK",Error.OK);
                    response.setTokenUser(tokenUser);
                    return response;

                }

            }
        }


    }

    @PostMapping("/reguser")
    public Response regUser(@Valid @RequestBody UserDTO userDTO){

        if(userDTO.checkError()){
            return new Response("Invalid request",Error.INVALID_REQUEST);
        }


        try {
            Email email = tokenUserRepository.getTokenUserByCode(userDTO.token).getEmail();
            User user = userMapping.fromUserDTOtoUser(userDTO);
            user.setBan(1);
            userRepository.save(user);
            email.setUser(user);
            emailRepository.save(email);
            return new Response("OK",Error.OK);


        }catch (Exception e){
            return new Response("USER_AUTH_FALSE",Error.TOKEN_INVALID);


        }



    }



}
