package com.example.springsecurityjwt.dao;

import com.example.springsecurityjwt.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by Ryan on 2021/1/5 18:56
 * Version 1.0
 * Description explain
 */
@Repository
public interface UserDao extends JpaRepository<Users, Long> {
}
