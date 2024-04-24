package com.inventory.inventoryproject.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.inventoryproject.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Integer>{
    
    public List<UserModel> findByUsernameAndPassword(String username,String password);

    public List<UserModel> findByUseremailEndingWith(String email);

}
