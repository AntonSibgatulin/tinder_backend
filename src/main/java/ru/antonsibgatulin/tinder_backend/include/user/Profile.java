package ru.antonsibgatulin.tinder_backend.include.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import ru.antonsibgatulin.tinder_backend.include.user.education.Education;
import ru.antonsibgatulin.tinder_backend.include.user.plane_on_family.Family;
import ru.antonsibgatulin.tinder_backend.include.user.symbol_zodiac.Symbols;

@Data
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Symbols symbol_of_zodiac;
    private Education education;
    private Family family;


}
