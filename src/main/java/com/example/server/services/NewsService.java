package com.example.server.services;

import com.example.server.domain.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {

    News saveOrUpdateNews(News news);

    List<News> getNewsByType(Integer type);

    List<News> getNewsByStatus(Integer status);

    List<News> getNewsByTitle(String title);

    List<News> getNewsByTypeAndStatus(Integer type,Integer status);

    Page<News> getNewsByTypeAndStatus(Integer type, Integer status, Pageable pageable);

    Page<News> getAllNews(Pageable pageable);

    News getNewsById(Long id);

    void removeNews(Long id);

    Page<News> getAllNewsByType(Integer type,Pageable pageable);

    List<News> getNewsByUserId(Long id);

    List<News> getNewsByUserIdAndNewsStatus(Long userId,Integer status);

    Page<News> getNewsByUserId(Long userId,Pageable pageable);

    List<News> getAllNews();

}
