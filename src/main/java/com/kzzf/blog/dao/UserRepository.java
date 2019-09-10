package com.kzzf.blog.dao;

import com.kzzf.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO：data access object，数据访问对象
// JPA：Java Persistence API，持久层api

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
}
