package com.basicSecurity.repos;

import com.basicSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {


    User findUserByUsername(String username);
}
