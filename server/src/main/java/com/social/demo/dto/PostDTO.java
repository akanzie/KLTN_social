package com.social.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class PostDTO {
    private String title;
    private String location;
    private String audio;
    private String status;
    private List<String> imageUrls;
}