package com.example.server.repository;

import com.example.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 用户Repository
 * @author ggg1235
 */

public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * @param
     * @return
     */
    User findByLoginName(String loginName);

    List<User> findByUserType(Integer userType);


}
