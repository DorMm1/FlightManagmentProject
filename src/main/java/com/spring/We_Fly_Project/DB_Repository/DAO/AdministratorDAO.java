package com.spring.We_Fly_Project.DB_Repository.DAO;

import com.spring.We_Fly_Project.DB_Repository.PostgreSQLConnection;
import com.spring.We_Fly_Project.DB_Repository.POCO.AdministratorPOCO;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdministratorDAO implements DAO<AdministratorPOCO> {


    List<AdministratorPOCO> adminsPOCOList;
    Statement stm;


    @Override
    public AdministratorPOCO get(long id) {
        AdministratorPOCO admin = null;
        stm = this.openStatement();
        try {
            var result = stm.executeQuery("SELECT * FROM administrators WHERE id =" + id);
            while (result.next()) {
                admin = new AdministratorPOCO(
                        result.getInt("id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getLong("user_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return admin;
    }

    @Override
    public List getAll() {
        try {
            stm = this.openStatement();
            this.adminsPOCOList = new ArrayList<>();
            var result = stm.executeQuery("SELECT * FROM administrators");
            while (result.next()) {
                adminsPOCOList.add(new AdministratorPOCO(
                        result.getInt("id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getLong("user_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return adminsPOCOList;
    }

    @Override
    public void add(AdministratorPOCO administratorPOCO) {
        int result = 0;
        stm = this.openStatement();
        try {
            result = stm.executeUpdate("INSERT INTO administrators (first_name,last_name,user_id) " +
                    "VALUES" +
                    "('" + administratorPOCO.first_name + "','" + administratorPOCO.last_name + "'," + administratorPOCO.user_id + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        if (result != 0)
            System.out.println("Admin added successfully");
        else
            System.out.println("Admin was not added to DB");
    }

    @Override
    public void remove(AdministratorPOCO administratorPOCO) {
        stm = this.openStatement();
        int result = 0;
        try {
            result = stm.executeUpdate("DELETE from administrators WHERE id = " + administratorPOCO.id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.closeStatement(stm);
        if (result == 0)
            System.out.println("Customer was not deleted from DB");
        else
            System.out.println("Customer deleted successfully");
    }

    @Override
    public void update(AdministratorPOCO administratorPOCO, long id) {
        stm = this.openStatement();
        int result = 0;
        try {
            result = stm.executeUpdate("UPDATE administrators SET" +
                    " first_name=" + administratorPOCO.first_name +
                    ", last_name=" + administratorPOCO.last_name +
                    ", user_id=" + administratorPOCO.user_id +
                    " where id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        if (result == 0)
            System.out.println("Admin was not updated from DB");
        else
            System.out.println("Admin updated successfully");
    }
    public AdministratorPOCO get_by_user_id(long id) {
        AdministratorPOCO admin = null;
        stm = this.openStatement();
        try {
            var result = stm.executeQuery("SELECT * FROM administrators WHERE user_id =" + id);
            while (result.next()) {
                admin = new AdministratorPOCO(
                        result.getInt("id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getLong("user_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return admin;
    }


}

