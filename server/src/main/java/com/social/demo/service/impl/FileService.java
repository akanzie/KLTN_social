package com.social.demo.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.social.demo.service.IFileService;

@Service
public class FileService implements IFileService {
    public String saveFileUpload(String uploadDir, MultipartFile file) throws IOException {
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // Tạo tên file duy nhất sử dụng UUID
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        // Lưu tệp lên server
        Path filePath = Paths.get(uploadDir, fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

    public byte[] getFileBytes(String path, String fileName) throws IOException {
        Path filePath = Paths.get(path, fileName);
        // Kiểm tra xem file có tồn tại không
        if (Files.exists(filePath)) {
            // Đọc dữ liệu file và trả về như một mảng byte
            return Files.readAllBytes(filePath);
        } else {
            throw new IOException("File not found: " + fileName);
        }
    }

    public void deleteFile(String path, String fileName) throws IOException {
        Path filePath = Paths.get(path, fileName);

        // Kiểm tra xem file có tồn tại không
        if (Files.exists(filePath)) {
            // Xóa file
            Files.delete(filePath);
        } else {
            throw new IOException("File not found: " + fileName);
        }
    }
}
