package com.example.server.repository;

import com.example.server.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 文件Repository
 */
public interface FileRepository extends JpaRepository<File,Long> {
    List<File> findFileByFileName(String name);

    List<File> findFileByFileType(Integer type);

    List<File> findFileByNewsId(Long newsId);

    List<File> findFileByUserId(Long userId);

    List<File> findFileByOriginName(String originName);
}
