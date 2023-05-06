package ru.antonsibgatulin.tinder_backend.include.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.tinder_backend.include.user.TokenUser;

public interface TokenUserRepository extends JpaRepository<TokenUser,Long> {
    TokenUser getTokenUserByCode(String code);
}
