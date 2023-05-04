package ru.antonsibgatulin.tinder_backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.antonsibgatulin.tinder_backend.TinderBackendApplication;
import ru.antonsibgatulin.tinder_backend.controllers.reg.RegController;
import ru.antonsibgatulin.tinder_backend.dto.EmailDTO;
import ru.antonsibgatulin.tinder_backend.dto.mapping.EmailMapping;
import ru.antonsibgatulin.tinder_backend.dto.mapping.EmailMappingImpl;
import ru.antonsibgatulin.tinder_backend.include.email.Email;
import ru.antonsibgatulin.tinder_backend.include.email.repository.EmailRepository;
import ru.antonsibgatulin.tinder_backend.include.user.repository.UserRepository;
/*
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
*/

@ExtendWith(SpringExtension.class)
@DataJpaTest
//@EnableAutoConfiguration(exclude= AutoConfigureTestDatabase.class)
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class EmailRegisterTest {


   // @Autowired
    private EmailMapping emailMapping = new EmailMappingImpl();
    @Autowired
    private EmailRepository emailRepository;

    @Test
    public void registerEmail(){

        EmailDTO emailDTO = new EmailDTO("8987920@mail.ru");
        Email email = emailMapping.toNumberFromNumberDTO(emailDTO);
        Email emailSaved = emailRepository.save(email);
        assert emailSaved.getId()!=null;
    }
}
