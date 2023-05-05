package ru.antonsibgatulin.tinder_backend.include.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class TokenUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String string;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public TokenUser() {
    }
}
