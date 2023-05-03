package ru.antonsibgatulin.tinder_backend.include.user;

import jakarta.persistence.*;
import lombok.Data;
import ru.antonsibgatulin.tinder_backend.include.user.desc.drink.Drink;
import ru.antonsibgatulin.tinder_backend.include.user.desc.education.Education;
import ru.antonsibgatulin.tinder_backend.include.user.desc.food.Food;
import ru.antonsibgatulin.tinder_backend.include.user.desc.pets.Pet;
import ru.antonsibgatulin.tinder_backend.include.user.desc.plane_on_family.Family;
import ru.antonsibgatulin.tinder_backend.include.user.desc.sleep.Sleep;
import ru.antonsibgatulin.tinder_backend.include.user.desc.smoking.Smoking;
import ru.antonsibgatulin.tinder_backend.include.user.desc.socialnetwork.SocialNetwork;
import ru.antonsibgatulin.tinder_backend.include.user.desc.sport.Sport;
import ru.antonsibgatulin.tinder_backend.include.user.desc.styles.Style;
import ru.antonsibgatulin.tinder_backend.include.user.desc.symbol_zodiac.Symbols;

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
