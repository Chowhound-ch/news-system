package com.example.server.repository;

import com.example.server.domain.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 新闻Repository
 * @author ggg1235
 */

public interface NewsRepository extends JpaRepository<News,Long> {

    List<News> getNewsByNewsTitle(String title);

    List<News> getNewsByNewsStatus(Integer status);

    List<News> getNewsByNewsType(Integer type);

    List<News> getNewsByNewsTypeAndNewsStatus(Integer type,Integer status);

    Page<News> getNewsByNewsTypeAndNewsStatus(Integer type, Integer status, Pageable pageable);

    Page<News> getNewsByNewsType(Integer type,Pageable pageable);

    List<News> getNewsByUserId(Long userId);

    List<News> getNewsByUserIdAndNewsStatus(Long userId,Integer status);

    Page<News> getNewsByUserId(Long userId,Pageable pageable);

}
