package com.spring.We_Fly_Project.DB_Repository.Service;

import com.spring.We_Fly_Project.DB_Repository.Repos.ContactUsRepo;
import com.spring.We_Fly_Project.DB_Repository.DTO.ContactUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactUsService {
    @Autowired
    ContactUsRepo repo;

    public List<ContactUs> getAllMessages(){
        ArrayList<ContactUs> messages = new ArrayList<>();
        repo.findAll().forEach(message->messages.add(message));
        return messages;
    }
    public ContactUs getById(long id){return repo.findById(id).get();}
    public void add_message(ContactUs message){repo.save(message);}
    public void remove_message(ContactUs message){repo.delete(message);}
    public void remove_message_by_id(long id){repo.deleteById(id);}



}
