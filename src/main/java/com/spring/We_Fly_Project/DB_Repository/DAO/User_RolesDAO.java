package com.spring.We_Fly_Project.DB_Repository.DAO;


import com.spring.We_Fly_Project.DB_Repository.PostgreSQLConnection;
import com.spring.We_Fly_Project.DB_Repository.POCO.User_RolesPOCO;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class User_RolesDAO implements DAO<User_RolesPOCO> {

    List<User_RolesPOCO> user_rolesPOCOList;
    Statement stm;


    @Override
    public User_RolesPOCO get(long id) {
        User_RolesPOCO user_role = null;
        this.stm = this.openStatement();
        try {
            var result = stm.executeQuery("SELECT * FROM user_roles WHERE id =" + id);
            while (result.next()) {
                user_role =
                        new User_RolesPOCO(result.getInt("id"),
                                result.getString("role_name")
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return user_role;
    }

    @Override
    public List getAll() {
        this.stm = this.openStatement();
        try {
            this.user_rolesPOCOList = new ArrayList<>();
            var result = stm.executeQuery("SELECT * FROM user_roles");
            while (result.next()) {
                user_rolesPOCOList.add(
                        new User_RolesPOCO(result.getInt("id"),
                                result.getString("role_name")
                        ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return user_rolesPOCOList;
    }

    @Override
    public void add(User_RolesPOCO user_rolesPOCO) {
        this.stm = this.openStatement();
        int result = 0;
        try {
            result = stm.executeUpdate("INSERT INTO user_roles (role_name) " +
                    "VALUES" +
                    "('" + user_rolesPOCO.role_name + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        if (result != 0)
            System.out.println("User_Role added successfully");
        else
            System.out.println("User_Role was not added to DB");
    }

    @Override
    public void remove(User_RolesPOCO user_rolesPOCO) {
        int result = 0;
        this.stm = this.openStatement();
        try {
            result = stm.executeUpdate("DELETE from user_roles WHERE id = " + user_rolesPOCO.id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.closeStatement(stm);
        if (result == 0)
            System.out.println("User_Role was not deleted from DB");
        else
            System.out.println("User_Role deleted successfully");
    }

    @Override
    public void update(User_RolesPOCO user_rolesPOCO, long id) {
        int result = 0;
        this.stm = this.openStatement();
        try {
            result = stm.executeUpdate("UPDATE users SET" +
                    " role_name=" + user_rolesPOCO.role_name +
                    " where id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        if (result == 0)
            System.out.println("User_Role was not updated from DB");
        else
            System.out.println("User_Role updated successfully");
    }
    //get role by username for JWT implementations.
    public String getRoleByUsername(String username){
        this.stm = this.openStatement();
        String role = "";
        try{
           var result = stm.executeQuery("SELECT CONCAT('ROLE_',user_roles.role_name) from users\n" +
                   "join user_roles on users.user_role =user_roles.id\n" +
                   "where username='"+username+"'");
           role.concat(result.getString("concat"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return role;
    }
}
