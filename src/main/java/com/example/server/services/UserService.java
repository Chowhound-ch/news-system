package com.example.server.services;

import com.example.server.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User saveOrUpdateUser(User user);

    User registerUser(User user);

    User getUserById(Long id);

    User getUserByLoginName(String loginName);

    void removeUser(Long id);

    List<User> getUserByType(Integer userType);

    Page<User> getAllUser(Pageable pageable);

    List<User> getAllUser();

}
