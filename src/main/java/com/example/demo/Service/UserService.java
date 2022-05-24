package com.example.demo.Service;


import com.example.demo.Entities.Application;
import com.example.demo.Entities.Role;
import com.example.demo.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public com.example.demo.Entities.User findByUsername(String username){
        return userRepo.findByUsername(username);
    }

    public void addUser(com.example.demo.Entities.User user){
        userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.demo.Entities.User user = findByUsername(username);
        return new User(user.getUsername(), user.getPassword(), user.getRole_id());
    }

    public void addApplication(String username, Application application){
        userRepo.addApplication(username, application);
    }
}
