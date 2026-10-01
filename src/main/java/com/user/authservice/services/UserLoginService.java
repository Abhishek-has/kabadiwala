package com.user.authservice.services;

import com.user.authservice.dao.Users;
import com.user.authservice.repo.UserLoginRepo;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    private final UserLoginRepo userLoginRepo;

    public UserLoginService(UserLoginRepo userLoginRepo) {
        this.userLoginRepo = userLoginRepo;
    }

    public Users loginUser(String userName){

        Users user=userLoginRepo.findByUserName(userName);

        return user;
    }
}
