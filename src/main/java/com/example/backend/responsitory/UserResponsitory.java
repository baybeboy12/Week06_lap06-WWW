package com.example.backend.responsitory;


import com.example.backend.modules.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserResponsitory extends JpaRepository<User,Long> {

    @Query("select us from User us where us.email = :email and us.passwordHash = :password")
    Optional<User> getloginAcount(String email, String password);
}
