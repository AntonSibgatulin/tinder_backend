package ru.antonsibgatulin.tinder_backend.include.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.tinder_backend.include.email.Email;

public interface EmailRepository extends JpaRepository<Email,Long> {
    Email getEmailByEmail(String email);
}
