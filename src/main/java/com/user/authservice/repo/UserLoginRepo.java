package com.user.authservice.repo;

import com.user.authservice.dao.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLoginRepo extends JpaRepository<Users,Long>{
    Users findByUserName(String username);
    Optional<Users> findByUserName(String userName, String password);
}
