package com.spring.We_Fly_Project.Controllers;

import com.spring.We_Fly_Project.BusinessLogics.Facades.*;
import com.spring.We_Fly_Project.DB_Repository.POCO.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class AnonymousController {
    AnonymousFacade facade = new AnonymousFacade();
    // BaseFacade Implementation:
    @GetMapping("/")
    public String welcomePage(){
        return "Welcome to We_Fly - flights marketplace";
    }
    @GetMapping("/flights")
    public List<FlightPOCO> get_all_flights(){
        return facade.get_all_flights();
    }
    @GetMapping("/flights/{id}")
    public FlightPOCO get_flight_by_id(@PathVariable long id){
        return facade.get_flight_by_id(id);
    }
    @GetMapping("/flights/{originC}/{destinationC}/{date}")
    public List<FlightPOCO> get_flight_by_parameters(@PathVariable int origin, @PathVariable int destination, @PathVariable String date){
        return facade.get_flights_by_parameters(origin,destination,date);
    }
    @GetMapping("/airlines")
    public List<AirlineCompanyPOCO> get_all_airlines(){
        return facade.get_all_airlines();
    }
    @GetMapping("/airline/{id}")
    public AirlineCompanyPOCO get_airline_by_id(@PathVariable long id){
        return facade.get_airline_by_id(id);
    }
    @GetMapping("/airline/{name}")
    public AirlineCompanyPOCO get_airline_by_username(@PathVariable String name){
        return facade.get_airline_by_parameters(name);
    }
    @GetMapping("/countries")
    public List<CountryPOCO> get_all_countries(){
        return facade.get_all_countries();
    }
    @GetMapping("/countries/{id}")
    public CountryPOCO get_country_by_id(@PathVariable int id){
        return facade.get_country_by_id(id);
    }
    @PostMapping("/create-user")
    public void create_new_user(@RequestBody UserPOCO new_user){
        facade.create_new_user(new_user);
    }
    @PostMapping("/create-user/{username}/{password}/{email}")
    public UserPOCO create_new_user_parameters(@PathVariable String username, @PathVariable String password, @PathVariable String email){
       return facade.create_new_user_account(username,password,email);
    }
    //AnonymousFacade Implementation:
    @PostMapping("/create-customer")
    public boolean create_new_customer(@RequestBody CustomerPOCO new_customer){
        return facade.add_customer(new_customer);
    }
    @GetMapping("/login/{username}/{password}")
    public void login(@PathVariable String username, @PathVariable String password){
        var new_facade = facade.login(username,password);
        if(new_facade instanceof CustomerFacade){
            //update token
            //redirect to customer_welcome_page
        }
        if(new_facade instanceof AirlineFacade){
            //update token
            //redirect to airline_welcome_page
        }
        if(new_facade instanceof AdministratorFacade){
            //update token
            //redirect to admin_welcome_page
        }
    }

}
