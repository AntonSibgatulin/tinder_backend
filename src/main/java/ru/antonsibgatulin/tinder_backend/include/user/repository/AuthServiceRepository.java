package ru.antonsibgatulin.tinder_backend.include.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.tinder_backend.include.email.Email;
import ru.antonsibgatulin.tinder_backend.include.user.AuthService;

public interface AuthServiceRepository extends JpaRepository<AuthService,Long> {
    AuthService getAuthServiceByEmail(Email email);
}
