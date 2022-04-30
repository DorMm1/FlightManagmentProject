package com.spring.We_Fly_Project.BusinessLogics.Facades;



import com.spring.We_Fly_Project.BusinessLogics.LoginToken;
import com.spring.We_Fly_Project.DB_Repository.DAO.CountryDAO;
import com.spring.We_Fly_Project.DB_Repository.POCO.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class AdministratorFacade extends AnonymousFacade{
    LoginToken user_token;
    AdministratorPOCO my_admin;
    @Autowired
    CountryDAO countryDAO = new CountryDAO();

    public AdministratorFacade() {
        super();
        this.user_token = new LoginToken(new UserPOCO(1,"Dor1234","abc1234","d@d.com",2));
        this.my_admin = new AdministratorPOCO(1,"dor","Mm",1);
    }

    public AdministratorFacade(LoginToken token, AdministratorPOCO adminPOCO) {
        super();
        this.user_token = token;
        this.my_admin = adminPOCO;
    }

    // As an admin you can add whatever values without validation.

    public List get_all_customers(){
        return super.customersDAO.getAll();
    }
    public List get_all_admins(){
        return super.administratorDAO.getAll();
    }
    public void add_country(CountryPOCO countryPOCO){
        this.countryDAO.add(countryPOCO);
    }
    public void add_airline(AirlineCompanyPOCO airline){
        super.airlineCompanyDAO.add(airline);
    }
    @Override
    public boolean add_customer(CustomerPOCO customer){
        super.customersDAO.add(customer);
        return true;
    }
    public void add_administrator(AdministratorPOCO new_admin){
        super.administratorDAO.add(new_admin);
    }
    public void remove_airline(AirlineCompanyPOCO airline){
        super.airlineCompanyDAO.remove(airline);
    }
    public void remove_customer(CustomerPOCO customer){
        super.customersDAO.remove(customer);
    }
    public void remove_administrator(AdministratorPOCO admin){
        super.administratorDAO.remove(admin);
    }

}
