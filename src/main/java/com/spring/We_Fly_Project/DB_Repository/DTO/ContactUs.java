package com.spring.We_Fly_Project.DB_Repository.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor

@Entity
public class ContactUs {
    @Id
    @Column(name = "message_id", nullable = false)
    private long messageID;
    @Column(name = "sender_name")
    private String senderName;
    private String content;

}
