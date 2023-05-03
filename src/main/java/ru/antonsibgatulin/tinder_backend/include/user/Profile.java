package ru.antonsibgatulin.tinder_backend.include.user;

import jakarta.persistence.*;
import lombok.Data;
import ru.antonsibgatulin.tinder_backend.include.user.drink.Drink;
import ru.antonsibgatulin.tinder_backend.include.user.education.Education;
import ru.antonsibgatulin.tinder_backend.include.user.food.Food;
import ru.antonsibgatulin.tinder_backend.include.user.pets.Pet;
import ru.antonsibgatulin.tinder_backend.include.user.plane_on_family.Family;
import ru.antonsibgatulin.tinder_backend.include.user.sleep.Sleep;
import ru.antonsibgatulin.tinder_backend.include.user.smoking.Smoking;
import ru.antonsibgatulin.tinder_backend.include.user.socialnetwork.SocialNetwork;
import ru.antonsibgatulin.tinder_backend.include.user.sport.Sport;
import ru.antonsibgatulin.tinder_backend.include.user.styles.Style;
import ru.antonsibgatulin.tinder_backend.include.user.symbol_zodiac.Symbols;

@Data
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(500)")
    private String description;


    //Main description
    private Symbols symbol_of_zodiac;
    private Education education;
    private Family family;
    private Style style;

    //style of life
    private Pet pet;
    private Drink drink;
    private Smoking smoking;
    private Sport sport;
    private Food food;
    private SocialNetwork socialNetwork;
    private Sleep sleep;





}
