package ru.antonsibgatulin.tinder_backend.include.email;

import jakarta.persistence.*;
import lombok.Data;
import ru.antonsibgatulin.tinder_backend.include.user.User;

import java.util.Random;

@Entity
@Data
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    private Integer code;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void generateRandomCode(){
        setCode(100000+new Random().nextInt(900000-1));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
