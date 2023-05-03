package ru.antonsibgatulin.tinder_backend.include.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.tinder_backend.include.user.Profile;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
}
