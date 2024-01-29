package com.thuannluit.osahaneat.repository;

import com.thuannluit.osahaneat.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

//    List<Users> findUsersByUser_nameAndPassword(String username, String password);
    Users findByUsername(String username);

}

