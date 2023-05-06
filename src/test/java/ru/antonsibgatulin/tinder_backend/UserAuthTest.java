package ru.antonsibgatulin.tinder_backend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.antonsibgatulin.tinder_backend.include.email.Email;
import ru.antonsibgatulin.tinder_backend.include.email.repository.EmailRepository;
import ru.antonsibgatulin.tinder_backend.include.user.AuthService;
import ru.antonsibgatulin.tinder_backend.include.user.repository.AuthServiceRepository;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class UserAuthTest {

    @Autowired
    private AuthServiceRepository authServiceRepository;
    @Autowired
    private EmailRepository emailRepository;

    @Test
    public void AuthServiceSave(){
        AuthService authService = new AuthService(new Email());
        authServiceRepository.save(authService);
        assert authService.getId()!=null;
    }

    @Test
    public void getAuthServiceByEmail(){
        Email email = new Email();
        email.setEmail("test@test.ru");
        emailRepository.save(email);
        AuthService authService = new AuthService(email);
        authServiceRepository.save(authService);


        authService = authServiceRepository.getAuthServiceByEmail(email);
        assert authService.getEmail()!=null;

    }

}
