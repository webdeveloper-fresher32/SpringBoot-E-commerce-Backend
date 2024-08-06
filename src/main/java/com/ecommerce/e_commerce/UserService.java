package com.ecommerce.e_commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public Optional<UserModel> findByUsername(String username){
        return  repo.findByUsername(username);
    }

    public Optional<UserModel> findByEmail(String email){
        return  repo.findByEmail(email);
    }

    public  Boolean existsByUsername(String username){
     return  repo.existsByUsername(username);
    }
    public Boolean existsByEmail(String email){
        return  repo.existsByEmail(email);
    }


    public  UserModel saveUser(UserModel user){
        user.setPassword(user.getPassword());
        return  repo.save(user);
    }
}
