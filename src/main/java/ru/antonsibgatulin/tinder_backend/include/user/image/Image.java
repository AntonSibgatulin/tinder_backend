package ru.antonsibgatulin.tinder_backend.include.user.image;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private Long userId;
    private Long timeLoad;
    private Integer deleted;

    public Image() {

    }

    public Image(String url, Long user_id, Long timeLoad, Integer deleted) {
        this.url = url;
        this.userId = user_id;
        this.timeLoad = timeLoad;
        this.deleted = deleted;
    }
}
