package com.example.server.services;

import com.example.server.domain.File;

import java.util.List;

public interface FileService {

    File saveOrUpdateFile(File file);

    void removeFile(Long fileId);

    List<File> getAllFile();

    List<File> getFileByType(Integer type);

    List<File> getFileByUserId(Long userId);

    List<File> getFileByFileName(String fileName);

    List<File> getFileByOrginName(String orginName);

    File getFileById(Long newsId);

}
