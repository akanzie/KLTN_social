package com.social.demo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.social.demo.constants.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    public String firstName;

    @Column(nullable = false)
    public String lastName;

    private String bio;

    private String gender;

    private LocalDate birthday;

    private String avatarImage;

    @Column(unique = true)
    private String phone;

    @Column(nullable = false, unique = true)
    public String email;

    @Column(nullable = false)
    public UserStatus status;

    @JsonIgnore
    @Column(nullable = false)
    public String password;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDate createdDate;

    // @JsonIgnore
    // @Column
    // private String salt;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<PostEntity> posts = new ArrayList<>();
    @OneToMany(mappedBy = "follower", fetch = FetchType.LAZY)
    private List<UserFollowEntity> followers = new ArrayList<>();
    @OneToMany(mappedBy = "following", fetch = FetchType.LAZY)
    private List<UserFollowEntity> following = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "friends", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private List<UserEntity> friends = new ArrayList<>();

    public UserEntity() {

    }

    public UserEntity(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

        // this.salt = UUID.randomUUID().toString();
        this.password = new BCryptPasswordEncoder().encode(password);
        this.password = password;
    }

    // @JsonIgnore
    // public String getSalt() {
    // return salt;
    // }

    // @JsonProperty
    // public void setSalt(String salt) {
    // this.salt = salt;
    // }
}
