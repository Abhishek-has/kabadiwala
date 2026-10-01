package com.user.authservice.repo;

import com.user.authservice.dao.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResistrationRepo extends JpaRepository<Users,Long> {

}
