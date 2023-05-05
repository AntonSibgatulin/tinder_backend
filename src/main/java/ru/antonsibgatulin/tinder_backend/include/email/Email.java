package ru.antonsibgatulin.tinder_backend.include.email;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.antonsibgatulin.tinder_backend.include.user.User;

import java.util.Random;

@Entity
@Data
@Getter
@Setter
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer code;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Email() {
        generateRandomCode();
    }

    public void generateRandomCode(){
        setCode(100000+new Random().nextInt(900000-1));
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", code=" + code +
                ", user=" + user +
                '}';
    }
}
