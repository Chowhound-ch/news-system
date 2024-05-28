package com.example.server.repository;

import com.example.server.domain.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 新闻详情Repository
 */

public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {

    UserDetail findByUserId(Long userId);

    void removeByUserId(Long userId);

}
