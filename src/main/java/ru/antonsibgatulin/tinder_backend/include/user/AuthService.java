package ru.antonsibgatulin.tinder_backend.include.user;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.antonsibgatulin.tinder_backend.include.email.Email;

import java.util.Random;

@Data
@Getter
@Setter
@Entity
public class AuthService {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer code;


    @ManyToOne
    @JoinColumn(name ="email_id")
    private Email email;

    public AuthService() {
    }


    public void generateRandomCode(){
        setCode(100000+new Random().nextInt(900000-1));
    }



    public AuthService(Email email) {
        generateRandomCode();
        this.email = email;

    }
}
