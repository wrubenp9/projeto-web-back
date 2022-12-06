package com.br.userservice.repository;

import com.br.userservice.controller.dto.UserDto;
import com.br.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query("SELECT * FROM tb_user u WHERE u.id= ?1")
    Optional<User> findById(int id);
    Optional<User> findByEmail(String email);

}
