package com.spring.We_Fly_Project.BusinessLogics.Facades;



import com.spring.We_Fly_Project.DB_Repository.DAO.*;
import com.spring.We_Fly_Project.DB_Repository.POCO.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;



public abstract class BaseFacade {
    @Autowired
    private FlightsDAO flights;
    @Autowired
    private AirlineCompanyDAO airlines;
    @Autowired
    private CountryDAO countries;
    @Autowired
    private UsersDAO users;

    protected BaseFacade() {
        this.airlines = new AirlineCompanyDAO();
        this.flights = new FlightsDAO();
        this.countries = new CountryDAO();
        this.users = new UsersDAO();
    }

    public List get_all_flights(){
        return flights.getAll();
    }
    public FlightPOCO get_flight_by_id(long id){
        return flights.get(id);
    }
    public List get_flights_by_parameters(int origin_country_id, int destination_country_id, String date){
        return flights.get_flights_by_parameters(origin_country_id,destination_country_id,date);
    }

    public List get_all_airlines(){
        return airlines.getAll();
    }
    public AirlineCompanyPOCO get_airline_by_id(long id){
        return airlines.get(id);
    }
    //by username
    public AirlineCompanyPOCO get_airline_by_parameters(String name){
        return airlines.get_airline_by_username(name);
    }

    public List get_all_countries(){
        return countries.getAll();
    }
    public CountryPOCO get_country_by_id(int id){
        return countries.get(id);
    }

    public void create_new_user(UserPOCO new_user){
        users.add(new_user);
    }



}
