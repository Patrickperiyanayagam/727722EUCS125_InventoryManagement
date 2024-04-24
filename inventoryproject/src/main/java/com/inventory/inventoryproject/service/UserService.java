package com.inventory.inventoryproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.inventoryproject.model.UserModel;
import com.inventory.inventoryproject.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public UserModel userSave(UserModel usermodel){
        return userRepository.save(usermodel);
    }


}
