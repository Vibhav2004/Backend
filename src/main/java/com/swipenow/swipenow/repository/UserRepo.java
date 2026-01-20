package com.swipenow.swipenow.repository;

import com.swipenow.swipenow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<User, Long> {

    User getByEmail(String email);


    User findByUsername(String username);
}
