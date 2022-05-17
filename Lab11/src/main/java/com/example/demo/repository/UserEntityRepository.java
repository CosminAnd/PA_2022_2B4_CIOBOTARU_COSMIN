package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findAll();

    <U extends UserEntity> U save(U entity);

    UserEntity getUserByIdUser(Long idUser);

    void deleteUserByIdUser(Long idUser);
}
