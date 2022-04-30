package com.spring.We_Fly_Project.DB_Repository.Service;

import com.spring.We_Fly_Project.DB_Repository.DTO.InfoLogger;
import com.spring.We_Fly_Project.DB_Repository.Repos.InfoLoggerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoLoggerService {
    @Autowired
    InfoLoggerRepo logRepo;

    public List<InfoLogger> getAllLogs(){
        ArrayList<InfoLogger> info = new ArrayList<>();
        logRepo.findAll().forEach(info::add);
        return info;
    }
    public InfoLogger getById(long id){
        return logRepo.findById(id).get();
    }
    public void addLog(InfoLogger log){
        logRepo.save(log);
    }

}
