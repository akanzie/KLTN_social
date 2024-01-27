package com.social.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.social.demo.constants.MessageStatus;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "message_type", discriminatorType = DiscriminatorType.STRING)
@Data
public abstract class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private UserEntity receiver;
    
    @ManyToOne
    @JoinColumn(name = "inbox_id")
    private InboxEntity inbox;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime sentDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageStatus status;

    // @ElementCollection
    // @CollectionTable(name = "message_emojis", joinColumns = @JoinColumn(name =
    // "message_id"))
    // @Column(name = "emoji")
    // private List<String> emojis;
}
