package ru.antonsibgatulin.tinder_backend.include.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import ru.antonsibgatulin.tinder_backend.include.interests.Interest;
import ru.antonsibgatulin.tinder_backend.include.target.Target;
import ru.antonsibgatulin.tinder_backend.include.user.symbol_zodiac.Symbols;

import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    private String password;

    private Long timeBirth;


    //private String gender;
    //private String genderToShow;


    private EUser gender;
    private EUser genderToShow;


    private boolean showMe;


    private String email;

    @ManyToOne
    @JoinColumn(name = "target_id")
    private Target target;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToMany
    @JoinTable(name = "interest_id")
    private List<Interest> interests;


    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;


    private Integer ban;
    private Integer deleted;


    public void predict(){
        setPassword(null);
        setEmail(null);
    }


}
