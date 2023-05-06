package ru.antonsibgatulin.tinder_backend.controllers.auth;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.tinder_backend.include.email.Email;
import ru.antonsibgatulin.tinder_backend.include.email.repository.EmailRepository;
import ru.antonsibgatulin.tinder_backend.include.error.Error;
import ru.antonsibgatulin.tinder_backend.include.system.result.Response;
import ru.antonsibgatulin.tinder_backend.include.user.AuthService;
import ru.antonsibgatulin.tinder_backend.include.user.TokenUser;
import ru.antonsibgatulin.tinder_backend.include.user.repository.AuthServiceRepository;
import ru.antonsibgatulin.tinder_backend.include.user.repository.TokenUserRepository;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final EmailRepository emailRepository;
    private final AuthServiceRepository authServiceRepository;
    private final TokenUserRepository tokenUserRepository;

    public AuthController(EmailRepository emailRepository, AuthServiceRepository authServiceRepository, TokenUserRepository tokenUserRepository) {
        this.emailRepository = emailRepository;
        this.authServiceRepository = authServiceRepository;
        this.tokenUserRepository = tokenUserRepository;
    }

    @PostMapping("/")
    public Response authRequest(@RequestParam("email") String emailRequestParam){


        Email email = emailRepository.getEmailByEmail(emailRequestParam);
        if (email == null){
             email.generateRandomCode();

            emailRepository.save(email);

            return new Response("REG", Error.REG);

        }
        else{
            AuthService authService = new AuthService(email);
            authServiceRepository.save(authService);
            return new Response("OK",Error.OK);

        }
    }


    @PostMapping("/code")
    public Response authSendCode(@RequestParam("email") String emailRequestParam,@RequestParam("code") Integer code){
        Response response = null;

        Email email = emailRepository.getEmailByEmail(emailRequestParam);
        if (email == null){
            return new Response("EMAIL_UNREGISTERED",Error.EMAIL_UNREGISTERED);
        }else {
            AuthService authService = authServiceRepository.getAuthServiceByEmail(email);
            if (authService == null){
                return new Response("BAD_REQUEST",Error.BAD_REQUEST);

            }else{
                if(authService.getCode() == code){
                    TokenUser tokenUser = new TokenUser(email);
                    tokenUserRepository.save(tokenUser);
                    response = new Response("OK",Error.OK);
                    response.setTokenUser(tokenUser);
                }else{
                    response = new Response("",Error.INVALID_CODE);
                }
                return response;
            }
        }


    }


}
