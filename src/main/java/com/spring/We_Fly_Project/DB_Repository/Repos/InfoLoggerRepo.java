package com.spring.We_Fly_Project.DB_Repository.Repos;

import com.spring.We_Fly_Project.DB_Repository.DTO.InfoLogger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InfoLoggerRepo extends MongoRepository<InfoLogger,Long> {
}
