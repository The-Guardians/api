package com.paigunna.api.rest;

import com.paigunna.api.domain.User;
import com.paigunna.api.dto.UserDto;
import com.paigunna.api.repository.UserRepo;
import com.paigunna.api.service.ProviderActiveService;
import com.paigunna.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author armme : 15/03/2018
 */

@RestController
@RequestMapping("/users")
public class UserRest {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    ProviderActiveService providerActiveService;

    @GetMapping
    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepo.findOne(id);
    }

    @GetMapping("/status")
    public List<UserDto> getByStatus(){
        return providerActiveService.findActiveProvider();
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }
}
