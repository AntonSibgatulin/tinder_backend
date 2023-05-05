package ru.antonsibgatulin.tinder_backend.controllers.reg;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.antonsibgatulin.tinder_backend.dto.EmailDTO;
import ru.antonsibgatulin.tinder_backend.dto.UserDTO;
import ru.antonsibgatulin.tinder_backend.dto.mapping.EmailMapping;
import ru.antonsibgatulin.tinder_backend.include.email.Email;
import ru.antonsibgatulin.tinder_backend.include.email.repository.EmailRepository;
import ru.antonsibgatulin.tinder_backend.include.error.Error;
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
        response = new Response("Waiting code...", Error.OK);
        response.setEmail(email);

        return response;
    }

    @PostMapping("/checkcode")
    public Response checkCode(@RequestParam Integer code,@RequestParam String emailString){
        Response response = null;

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
                    return new Response("OK",Error.OK);

                }

            }
        }


    }

    @PostMapping("/reguser")
    public Response regUser(@Valid @RequestBody UserDTO userDTO){
        Response response = null;

        Email email = emailRepository.getEmailByEmail(userDTO.email);
        if(email == null){
            return new Response("email unregistered",Error.EMAIL_UNREGISTERED);
        }


        return response;

    }



}
