package com.social.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "status")
public class PostStatusEntity {

    @Id
    private String id;

    private String statusName;

}