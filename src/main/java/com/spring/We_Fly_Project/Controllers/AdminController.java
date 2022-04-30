package com.spring.We_Fly_Project.Controllers;

import com.spring.We_Fly_Project.BusinessLogics.Facades.*;
import com.spring.We_Fly_Project.DB_Repository.DTO.InfoLogger;
import com.spring.We_Fly_Project.DB_Repository.POCO.*;
import com.spring.We_Fly_Project.DB_Repository.Service.InfoLoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    AdministratorFacade facade = new AdministratorFacade();
    @Autowired
    InfoLoggerService logService;
    @GetMapping("/customers")
    public List<CustomerPOCO> get_all_customers(){
        return facade.get_all_customers();
    }
    @GetMapping("/admins")
    public List<AdministratorPOCO> get_all_admins(){
        return facade.get_all_admins();
    }
    @PostMapping("/add-country")
    public void add_country(@RequestBody CountryPOCO country){
        facade.add_country(country);
    }
    @PostMapping("/add-airline")
    public void add_airline(@RequestBody AirlineCompanyPOCO airline){
        facade.add_airline(airline);
    }
    @PostMapping("/add-customer")
    public boolean add_customer(@RequestBody CustomerPOCO customer){
        return facade.add_customer(customer);
    }
    @PostMapping("/add-admin")
    public void add_admin(@RequestBody AdministratorPOCO admin){
        facade.add_administrator(admin);
    }
    @DeleteMapping("/remove-airline")
    public void remove_airline(@RequestBody AirlineCompanyPOCO airline){
        facade.remove_airline(airline);
    }
    @DeleteMapping("/remove-customer")
    public void remove_customer(@RequestBody CustomerPOCO customer){
        facade.remove_customer(customer);
    }
    @DeleteMapping("/remove-admin")
    public void remove_admin(@RequestBody AdministratorPOCO admin){
        facade.remove_administrator(admin);
    }
    //infoLog-Aspect:
    public static long logID = 1;
    public static void incrementLogId(){
        logID++;
    }
    @GetMapping("/logs")
    public List<InfoLogger> getAllLogs(){
       return logService.getAllLogs();
    }

}
