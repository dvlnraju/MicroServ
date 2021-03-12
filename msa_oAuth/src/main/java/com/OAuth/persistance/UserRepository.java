package com.OAuth.persistance;

import com.OAuth.bean.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByUsername(String username);

    //Optional<AuthUser> findByUserNameOrEmail(String username, String email);
}
