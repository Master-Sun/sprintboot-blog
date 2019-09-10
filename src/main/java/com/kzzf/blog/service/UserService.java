package com.kzzf.blog.service;

import com.kzzf.blog.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
