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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Symbols getSymbol_of_zodiac() {
        return symbol_of_zodiac;
    }

    public void setSymbol_of_zodiac(Symbols symbol_of_zodiac) {
        this.symbol_of_zodiac = symbol_of_zodiac;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Smoking getSmoking() {
        return smoking;
    }

    public void setSmoking(Smoking smoking) {
        this.smoking = smoking;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public SocialNetwork getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public Sleep getSleep() {
        return sleep;
    }

    public void setSleep(Sleep sleep) {
        this.sleep = sleep;
    }
}
