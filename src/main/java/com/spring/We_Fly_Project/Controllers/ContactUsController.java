package com.spring.We_Fly_Project.Controllers;

import com.spring.We_Fly_Project.DB_Repository.DTO.ContactUs;
import com.spring.We_Fly_Project.DB_Repository.Service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactus")
public class ContactUsController {
    @Autowired
    ContactUsService service;
    @GetMapping("/all")
    public List<ContactUs> getAllMessages(){
        return service.getAllMessages();
    }
    @GetMapping("/{id}")
    public ContactUs getById(@PathVariable long id){
        return service.getById(id);
    }
    @PostMapping("")
    public void addContactUs(@RequestBody ContactUs message){
        service.add_message(message);
    }
    @GetMapping("")
    public String landing_page(){
        return "This is landing page for contact us platform";
    }
}
