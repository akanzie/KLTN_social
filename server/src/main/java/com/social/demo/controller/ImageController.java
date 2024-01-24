package com.social.demo.controller;


import java.io.IOException;
import java.nio.file.Files;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {
 

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok("{\"message\": \"File uploaded successfully\", \"imageName\": \""
                + file.getOriginalFilename() + "\"}");
    }

    @GetMapping("/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        try {
            // Đường dẫn đến thư mục lưu trữ ảnh (phải trùng với đường dẫn đã sử dụng khi
            // lưu ảnh)
            String uploadDir = "path/to/your/image/directory";
            Path imagePath = Paths.get(uploadDir, imageName);

            // Đọc dữ liệu ảnh và trả về như một mảng byte
            byte[] imageBytes = Files.readAllBytes(imagePath);

            // Thiết lập header để trình duyệt hiểu đúng loại nội dung
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
