package com.spring.We_Fly_Project.DB_Repository.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("InfoLogger")
public class InfoLogger {
    @Id
    private long id;
    @Field("date_and_time")
    private String request_time;
    @Field("message")
    private String message;
}
