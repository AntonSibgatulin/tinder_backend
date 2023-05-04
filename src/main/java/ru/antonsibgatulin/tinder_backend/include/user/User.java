package ru.antonsibgatulin.tinder_backend.include.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import ru.antonsibgatulin.tinder_backend.include.interests.Interest;
import ru.antonsibgatulin.tinder_backend.include.target.Target;

import java.util.List;

@Entity
@Table(name = "users")
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

    public User(){

    }

    public User( String name, String password, Long timeBirth, EUser gender, EUser genderToShow, boolean showMe, String email) {

        this.name = name;
        this.password = password;
        this.timeBirth = timeBirth;
        this.gender = gender;
        this.genderToShow = genderToShow;
        this.showMe = showMe;
        this.email = email;


        this.profile = new Profile();
        this.ban = 0;
        this.deleted = 0;
    }

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
        password = null;
        email = null;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getTimeBirth() {
        return timeBirth;
    }

    public void setTimeBirth(Long timeBirth) {
        this.timeBirth = timeBirth;
    }

    public EUser getGender() {
        return gender;
    }

    public void setGender(EUser gender) {
        this.gender = gender;
    }

    public EUser getGenderToShow() {
        return genderToShow;
    }

    public void setGenderToShow(EUser genderToShow) {
        this.genderToShow = genderToShow;
    }

    public boolean isShowMe() {
        return showMe;
    }

    public void setShowMe(boolean showMe) {
        this.showMe = showMe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Integer getBan() {
        return ban;
    }

    public void setBan(Integer ban) {
        this.ban = ban;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
