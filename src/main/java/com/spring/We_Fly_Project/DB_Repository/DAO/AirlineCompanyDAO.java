package com.spring.We_Fly_Project.DB_Repository.DAO;

import com.spring.We_Fly_Project.DB_Repository.POCO.AdministratorPOCO;
import com.spring.We_Fly_Project.DB_Repository.PostgreSQLConnection;
import com.spring.We_Fly_Project.DB_Repository.POCO.AirlineCompanyPOCO;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class AirlineCompanyDAO implements DAO<AirlineCompanyPOCO> {

    List<AirlineCompanyPOCO> airlineCompanyPOCOList;
    Statement stm;

    @Override
    public AirlineCompanyPOCO get(long id) {
        stm = this.openStatement();
        AirlineCompanyPOCO airline = null;
        try {
            var result = stm.executeQuery("SELECT * FROM airline_companies WHERE id =" + id);
            while (result.next()) {
                airline = new AirlineCompanyPOCO(
                        result.getLong("id"),
                        result.getString("company_name"),
                        result.getInt("country_id"),
                        result.getLong("user_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return airline;
    }

    @Override
    public List getAll() {
        try {
            stm = this.openStatement();
            this.airlineCompanyPOCOList = new ArrayList<>();
            var result = stm.executeQuery("SELECT * FROM airline_companies");
            while (result.next()) {
                airlineCompanyPOCOList.add(new AirlineCompanyPOCO(
                        result.getLong("id"),
                        result.getString("company_name"),
                        result.getInt("country_id"),
                        result.getLong("user_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return airlineCompanyPOCOList;
    }

    @Override
    public void add(AirlineCompanyPOCO airlineCompanyPOCO) {
        int result = 0;
        stm = this.openStatement();
        try {
            result = stm.executeUpdate("INSERT INTO airline_companies (company_name,country_id,user_id) " +
                    "VALUES" +
                    "('" + airlineCompanyPOCO.company_name + "'," + airlineCompanyPOCO.country_id + "," + airlineCompanyPOCO.user_id + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        if (result != 0)
            System.out.println("Airline_Company added successfully");
        else
            System.out.println("Airline_Company was not added to DB");
    }

    @Override
    public void remove(AirlineCompanyPOCO airlineCompanyPOCO) {
        stm = this.openStatement();
        int result = 0;
        try {
            result = stm.executeUpdate("DELETE from airline_companies WHERE id = " + airlineCompanyPOCO.id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.closeStatement(stm);
        if (result == 0)
            System.out.println("Airline_Company was not deleted from DB");
        else
            System.out.println("Airline_Company deleted successfully");
    }

    @Override
    public void update(AirlineCompanyPOCO airlineCompanyPOCO, long id) {
        stm = this.openStatement();
        int result = 0;
        try {
            result = stm.executeUpdate("UPDATE airline_companies SET" +
                    " company_name=" + airlineCompanyPOCO.company_name +
                    ", country_id=" + airlineCompanyPOCO.country_id +
                    ", user_id=" + airlineCompanyPOCO.user_id +
                    " where id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        if (result == 0)
            System.out.println("Airline_Company was not updated from DB");
        else
            System.out.println("Airline_Company updated successfully");
    }

    public AirlineCompanyPOCO get_airline_by_username(String username){
        AirlineCompanyPOCO airline = null;
        stm = this.openStatement();
        try {
            var result = stm.executeQuery("SELECT * FROM get_airline_by_username("+username+")");
            while (result.next()) {
                airline = new AirlineCompanyPOCO(
                        result.getLong("id"),
                        result.getString("company_name"),
                        result.getInt("country_id"),
                        result.getLong("user_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return airline;
    }

}
