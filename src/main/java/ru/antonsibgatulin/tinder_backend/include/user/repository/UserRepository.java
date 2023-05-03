package ru.antonsibgatulin.tinder_backend.include.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.tinder_backend.include.user.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
