package com.example.demo.services;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService {
    private final UserEntityRepository userEntityRepository;

    @Autowired
    public UserEntityService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }


    public List<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();
    }

    public UserEntity addUser(UserEntity user) {
        userEntityRepository.save(user);
        return user;
    }

    public UserEntity changeName(long id, String nume) {
        UserEntity user = userEntityRepository.getUserByIdUser(id);
        user.setName(nume);
        userEntityRepository.save(user);
        return user;
    }

    public void deleteUser(long id) {
        UserEntity user = userEntityRepository.getUserByIdUser(id);
        userEntityRepository.deleteUserByIdUser(user.getIdUser());
    }
}
