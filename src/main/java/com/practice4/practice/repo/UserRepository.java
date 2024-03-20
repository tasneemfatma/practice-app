package com.practice4.practice.repo;


import com.practice4.practice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    UserEntity findByUsername(String username);
    boolean existsByUsername(String username);

    boolean existsByPassword(String password);
}
