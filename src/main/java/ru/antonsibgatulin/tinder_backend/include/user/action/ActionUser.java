package ru.antonsibgatulin.tinder_backend.include.user.action;


import jakarta.persistence.*;
import ru.antonsibgatulin.tinder_backend.include.user.User;

@Entity
public class ActionUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User userId;


    @ManyToOne
    @JoinColumn
    private User toUserId;

    private Action action;



}
