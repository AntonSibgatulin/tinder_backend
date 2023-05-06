package ru.antonsibgatulin.tinder_backend.include.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.tinder_backend.include.user.image.Image;

public interface ImageRepository extends JpaRepository<Image,Long> {
    Image getImageByUserId(Long id);

}
