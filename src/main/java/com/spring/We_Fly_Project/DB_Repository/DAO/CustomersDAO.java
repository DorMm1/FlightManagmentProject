package com.spring.We_Fly_Project.DB_Repository.DAO;

import com.spring.We_Fly_Project.DB_Repository.PostgreSQLConnection;
import com.spring.We_Fly_Project.DB_Repository.POCO.CustomerPOCO;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomersDAO implements DAO<CustomerPOCO> {

    List<CustomerPOCO> customersPOCOList;
    Statement stm;



    @Override
    public CustomerPOCO get(long id) {
        CustomerPOCO customer = null;
        stm = this.openStatement();
        try {
            var result = stm.executeQuery("SELECT * FROM customers WHERE id =" + id);
            while (result.next()) {
                customer = new CustomerPOCO(
                        result.getLong("id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("address"),
                        result.getString("phone_no"),
                        result.getString("credit_card_no"),
                        result.getLong("user_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return customer;
    }

    @Override
    public List getAll() {
        stm = this.openStatement();
        try {
            this.customersPOCOList = new ArrayList<>();
            var result = stm.executeQuery("SELECT * FROM customers");
            while (result.next()) {
                customersPOCOList.add(
                        new CustomerPOCO(
                                result.getLong("id"),
                                result.getString("first_name"),
                                result.getString("last_name"),
                                result.getString("address"),
                                result.getString("phone_no"),
                                result.getString("credit_card_no"),
                                result.getLong("user_id")
                        ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return customersPOCOList;
    }

    @Override
    public void add(CustomerPOCO customerPOCO) {
        stm = this.openStatement();
        int result = 0;
        try {
            result = stm.executeUpdate("INSERT INTO customers (first_name,last_name,address,phone_no," +
                    "credit_card_no,user_id) " +
                    "VALUES" +
                    "('" + customerPOCO.first_name + "','" + customerPOCO.last_name + "','"
                    + customerPOCO.address + "','" + customerPOCO.phone_no + "','"
                    + customerPOCO.credit_card_no + "'," + customerPOCO.user_id + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        if (result != 0)
            System.out.println("Customer added successfully");
        else
            System.out.println("Customer was not added to DB");

    }

    @Override
    public void remove(CustomerPOCO customerPOCO) {
        int result = 0;
        stm = this.openStatement();
        try {
            result = stm.executeUpdate("DELETE from customers WHERE id = " + customerPOCO.id);
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
    public void update(CustomerPOCO customerPOCO, long id) {
        int result = 0;
        stm = this.openStatement();
        try {
            result = stm.executeUpdate("UPDATE customers SET" +
                    " first_name=" + customerPOCO.first_name +
                    ", last_name=" + customerPOCO.last_name +
                    ", address=" + customerPOCO.address +
                    ", phone_no =" + customerPOCO.phone_no +
                    ", credit_card_no =" + customerPOCO.credit_card_no +
                    ", user_id =" + customerPOCO.user_id +
                    " where id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        if (result == 0)
            System.out.println("Customer was not updated from DB");
        else
            System.out.println("Customer updated successfully");
    }

    public CustomerPOCO get_customer_by_username(String username){
        CustomerPOCO customer = null;
        stm = this.openStatement();
        try {
            var result = stm.executeQuery("SELECT * FROM get_customer_by_username("+username+")");
            while (result.next()) {
                customer = new CustomerPOCO(
                        result.getLong("id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("address"),
                        result.getString("phone_no"),
                        result.getString("credit_card_no"),
                        result.getLong("user_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return customer;
    }
    public CustomerPOCO get_customer_by_user_id(long id) {
        CustomerPOCO customer = null;
        stm = this.openStatement();
        try {
            var result = stm.executeQuery("SELECT * FROM customers WHERE user_id =" + id);
            while (result.next()) {
                customer = new CustomerPOCO(
                        result.getLong("id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("address"),
                        result.getString("phone_no"),
                        result.getString("credit_card_no"),
                        result.getLong("user_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return customer;
    }

}
