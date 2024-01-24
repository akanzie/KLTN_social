package com.social.demo.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    String saveFileUpload(String uploadDir, MultipartFile file) throws IOException;

    byte[] getFileBytes(String path, String fileName) throws IOException;

    void deleteFile(String path, String fileName) throws IOException;
}
