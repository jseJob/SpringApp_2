package com.practice.SpringApp_2.repos;

import com.practice.SpringApp_2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
