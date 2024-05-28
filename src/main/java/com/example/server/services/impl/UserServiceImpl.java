package com.example.server.services.impl;

import com.example.server.domain.User;
import com.example.server.repository.UserRepository;
import com.example.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }


    @Override
    public User getUserByLoginName(String login_name) {
        return userRepository.findByLoginName(login_name);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public List<User> getUserByType(Integer user_type) {
        return userRepository.findByUserType(user_type);
    }

    @Override
    public Page<User> getAllUser(Pageable pageable){return userRepository.findAll(pageable);}

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

}
