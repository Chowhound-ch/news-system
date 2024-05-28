package com.example.server.services;

import com.example.server.domain.UserDetail;

public interface UserDetailService {

    UserDetail getUserDetailByUserId(Long userId);

    UserDetail saveOrUpdateUserDetail(UserDetail userDetail);

    void removeByUserId(Long userId);

    void removeById(Long id);
}
