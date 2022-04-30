package com.spring.We_Fly_Project.Controllers;

import com.spring.We_Fly_Project.BusinessLogics.Facades.*;
import com.spring.We_Fly_Project.DB_Repository.POCO.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airline")
public class AirlineController {
    AirlineFacade facade = new AirlineFacade();

    @GetMapping("/flights")
    public List<FlightPOCO> get_all_flights(){
       return facade.get_all_flights();
    }
    @PutMapping("/update-airline")
    public void update_airline(@RequestBody AirlineCompanyPOCO airline){
        facade.update_airline(airline);
    }
    @PostMapping("/flights/add")
    public void add_flight(@RequestBody FlightPOCO flight){
        facade.add_flight(flight);
    }
    @PutMapping("/flights/update")
    public void update_flight(@RequestBody FlightPOCO flight){
        facade.update_flight(flight);
    }
    @PutMapping("/flights/update/{id}")
    public void update_flight_by_id(@RequestBody FlightPOCO flight, @PathVariable long id){
        facade.update_flight_by_id(flight,id);
    }
    @DeleteMapping("/flights/remove")
    public void remove_flight(@RequestBody FlightPOCO flight){
        facade.remove_flight(flight);
    }
}
