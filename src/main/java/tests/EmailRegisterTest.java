package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.antonsibgatulin.tinder_backend.TinderBackendApplication;
import ru.antonsibgatulin.tinder_backend.controllers.reg.RegController;
import ru.antonsibgatulin.tinder_backend.dto.EmailDTO;
import ru.antonsibgatulin.tinder_backend.dto.mapping.EmailMapping;
import ru.antonsibgatulin.tinder_backend.include.email.Email;
import ru.antonsibgatulin.tinder_backend.include.email.repository.EmailRepository;
import ru.antonsibgatulin.tinder_backend.include.user.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes = TinderBackendApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class EmailRegisterTest {

    /*
    private UserRepository userRepository = Mockito.mock(UserRepository.class);
    private EmailRepository emailRepository = Mockito.mock(EmailRepository.class);
    private EmailMapping emailMapping = Mockito.mock(EmailMapping.class);
    private RegController regController;
     */


}
