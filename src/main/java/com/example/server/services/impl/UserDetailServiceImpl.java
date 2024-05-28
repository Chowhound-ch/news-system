package com.example.server.services.impl;

import com.example.server.domain.UserDetail;
import com.example.server.repository.UserDetailRepository;
import com.example.server.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetail getUserDetailByUserId(Long userId) {
        return userDetailRepository.findByUserId(userId);
    }

    @Override
    public UserDetail saveOrUpdateUserDetail(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    @Override
    public void removeByUserId(Long userId) {
        userDetailRepository.removeByUserId(userId);
    }

    @Override
    public void removeById(Long id) {

    }
}
