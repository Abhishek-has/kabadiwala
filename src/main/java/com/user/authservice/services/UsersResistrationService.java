package com.user.authservice.services;

import com.user.authservice.dao.Users;
import com.user.authservice.dto.UsersResistrationDTO;
import com.user.authservice.repo.UserResistrationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersResistrationService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final Logger log = LoggerFactory.getLogger(UsersResistrationService.class);
    private final UserResistrationRepo userResistrationRepo;

    // Constructor injection (Best practice, no @Autowired needed)
    public UsersResistrationService(UserResistrationRepo userResistrationRepo) {
        this.userResistrationRepo = userResistrationRepo;
    }

    public Users addUser(UsersResistrationDTO user){

        Users users=new Users(
                user.name(),
                passwordEncoder.encode( user.password()),
                user.email(),
                System.currentTimeMillis()
        );

       return userResistrationRepo.save(users);

}
}
