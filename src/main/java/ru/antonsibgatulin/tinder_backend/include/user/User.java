package ru.antonsibgatulin.tinder_backend.include.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.antonsibgatulin.tinder_backend.include.interests.Interest;
import ru.antonsibgatulin.tinder_backend.include.target.Target;
import ru.antonsibgatulin.tinder_backend.include.user.image.Image;

import java.util.List;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
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

    @ManyToMany
    @JoinTable(name = "image_id")
    private List<Image> images;

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




    public User(){

    }

    public User( String name, String password, Long timeBirth, EUser gender, EUser genderToShow, boolean showMe, String email) {

        this.name = name;
        this.password = password;
        this.timeBirth = timeBirth;
        this.gender = gender;
        this.genderToShow = genderToShow;
        this.showMe = showMe;



        this.profile = new Profile();
        this.ban = 0;
        this.deleted = 0;
    }



    public void predict(){
        password = null;

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
}
