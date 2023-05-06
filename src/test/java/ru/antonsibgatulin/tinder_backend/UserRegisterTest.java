package ru.antonsibgatulin.tinder_backend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.antonsibgatulin.tinder_backend.include.email.repository.EmailRepository;
import ru.antonsibgatulin.tinder_backend.include.target.Target;
import ru.antonsibgatulin.tinder_backend.include.user.EUser;
import ru.antonsibgatulin.tinder_backend.include.user.Profile;
import ru.antonsibgatulin.tinder_backend.include.user.User;
import ru.antonsibgatulin.tinder_backend.include.user.desc.food.Food;
import ru.antonsibgatulin.tinder_backend.include.user.desc.socialnetwork.SocialNetwork;
import ru.antonsibgatulin.tinder_backend.include.user.image.Image;
import ru.antonsibgatulin.tinder_backend.include.user.repository.ImageRepository;
import ru.antonsibgatulin.tinder_backend.include.user.repository.ProfileRepository;
import ru.antonsibgatulin.tinder_backend.include.user.repository.TokenUserRepository;
import ru.antonsibgatulin.tinder_backend.include.user.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class UserRegisterTest {


    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  EmailRepository emailRepository;
    @Autowired
    private  ProfileRepository profileRepository;
    @Autowired
    private TokenUserRepository tokenUserRepository;
    @Autowired
    private ImageRepository imageRepository;


    @Test
    public void saveUser(){
        User user = new User("Anton","pass",System.currentTimeMillis(), EUser.MAN,
                EUser.WOMAN,true,"8987920@mail.ru");
        user.getProfile().setSocialNetwork(SocialNetwork.JUST_SEE);
        User userSaved = userRepository.save(user);
        assert userSaved.getId()!=null;


    }


    @Test
    public void saveProfile(){
        Profile profile = new Profile();
        Profile saveProfile = profileRepository.save(profile);
        saveProfile.setFood(Food.EAT_ALL);
        assert saveProfile.getId()!=null;
    }

    @Test
    public void saveImage(){
        Image image = new Image("url",1L,System.currentTimeMillis(),0);
        imageRepository.save(image);
        assert image.getId()!=null;
    }





}
