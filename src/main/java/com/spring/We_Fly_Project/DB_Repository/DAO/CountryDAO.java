package com.spring.We_Fly_Project.DB_Repository.DAO;

import com.spring.We_Fly_Project.DB_Repository.PostgreSQLConnection;
import com.spring.We_Fly_Project.DB_Repository.POCO.CountryPOCO;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class CountryDAO  implements DAO<CountryPOCO> {

    List<CountryPOCO> countryPOCOList;
    Statement stm;

    @Override
    public CountryPOCO get(long id) {
        CountryPOCO country = null;
        stm = this.openStatement();
        try {
            var result = stm.executeQuery("SELECT * FROM countries WHERE id =" + id);
            while (result.next()) {
                country = new CountryPOCO(
                        result.getInt("id"),
                        result.getString("country_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return country;
    }

    @Override
    public List getAll() {
        stm = this.openStatement();
        try {
            this.countryPOCOList = new ArrayList<>();
            var result = stm.executeQuery("SELECT * FROM countries");
            while (result.next()) {
                countryPOCOList.add(new CountryPOCO(
                        result.getInt("id"),
                        result.getString("country_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return countryPOCOList;
    }

    @Override
    public void add(CountryPOCO countryPOCO) {
        int result = 0;
        stm = this.openStatement();
        try {
            result = stm.executeUpdate("INSERT INTO countries " +
                    "VALUES" +
                    "("+countryPOCO.id+",'" + countryPOCO.country_name + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        if (result != 0)
            System.out.println("Country added successfully");
        else
            System.out.println("Country was not added to DB");
    }

    @Override
    public void remove(CountryPOCO countryPOCO) {
        stm = this.openStatement();
        int result = 0;
        try {
            result = stm.executeUpdate("DELETE from countries WHERE id = " + countryPOCO.id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.closeStatement(stm);
        if (result == 0)
            System.out.println("Country was not deleted from DB");
        else
            System.out.println("Country deleted successfully");
    }

    @Override
    public void update(CountryPOCO countryPOCO, long id) {
        int result = 0;
        stm = this.openStatement();
        try {
            result = stm.executeUpdate("UPDATE countries SET" +
                    " country_name=" + countryPOCO.country_name +
                    " where id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        if (result == 0)
            System.out.println("Country was not updated from DB");
        else
            System.out.println("Country updated successfully");
    }
}
