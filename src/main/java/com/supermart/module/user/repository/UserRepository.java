package com.supermart.module.user.repository;

import com.supermart.module.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u.email FROM User u")
    List<String> findAllEmails();
    @Query("SELECT u.mobile FROM User u")
    List<String> findAllMobile();

    User findByMobile(String mobile);



}
