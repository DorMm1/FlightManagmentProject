package com.spring.We_Fly_Project.DB_Repository.DAO;

import com.spring.We_Fly_Project.DB_Repository.PostgreSQLConnection;
import com.spring.We_Fly_Project.DB_Repository.POCO.UserPOCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@Primary
public class UsersDAO implements DAO<UserPOCO>, UserDetailsService {

    List<UserPOCO> usersPOCOList;
    Statement stm;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPOCO user = this.get_user_by_username(username);
        if(user==null)
            throw new UsernameNotFoundException("User not found in the DB");

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getAuthorities());
    }

    @Override
    public UserPOCO get(long id) {
        UserPOCO user = null;
        this.stm = this.openStatement();
        try {
            var result = stm.executeQuery("SELECT * FROM users WHERE id =" + id);
            while (result.next()) {
                user =
                        new UserPOCO(result.getLong("id"),
                                result.getString("username"),
                                result.getString("userpassword"),
                                result.getString("email"),
                                result.getInt("user_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return user;
    }

    @Override
    public List getAll() {
        this.stm = this.openStatement();
        try {
            this.usersPOCOList = new ArrayList<>();
            var result = stm.executeQuery("SELECT * FROM users");
            while (result.next()) {
                usersPOCOList.add(
                        new UserPOCO(result.getLong("id"),
                                result.getString("username"),
                                result.getString("userpassword"),
                                result.getString("email"),
                                result.getInt("user_role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return usersPOCOList;
    }

    @Override
    public void add(UserPOCO userPOCO) {
        int result = 0;
        this.stm = this.openStatement();
        userPOCO.userpassword = passwordEncoder.encode(userPOCO.getPassword()); // ENCODING USER PASSWORD FOR JWT
        try {
            result = stm.executeUpdate("INSERT INTO users (username,userpassword,email,user_role) " +
                    "VALUES" +
                    "('" + userPOCO.username + "','" + userPOCO.userpassword + "','" + userPOCO.email + "'," + userPOCO.user_role + ")");
        } catch (SQLException e) {
            System.out.println("please be more aware !!!!!!!!");
        }
        this.closeStatement(stm);
        if (result != 0)
            System.out.println("User added successfully");
        else
            System.out.println("User was not added to DB");
    }

    @Override
    public void remove(UserPOCO userPOCO) {
        this.stm = this.openStatement();
        int result = 0;
        try {
            result = stm.executeUpdate("DELETE from users WHERE id = " + userPOCO.id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.closeStatement(stm);
        if (result == 0)
            System.out.println("User was not deleted from DB");
        else
            System.out.println("User deleted successfully");
    }

    @Override
    public void update(UserPOCO userPOCO, long id) {
        int result = 0;
        this.stm = this.openStatement();
        userPOCO.userpassword = passwordEncoder.encode(userPOCO.getPassword()); // ENCODING USER PASSWORD FOR JWT
        try {
            result = stm.executeUpdate("UPDATE users SET" +
                    " username=" + userPOCO.username +
                    ", userpasword=" + userPOCO.userpassword +
                    ", email=" + userPOCO.email +
                    ", user_role =" + userPOCO.user_role +
                    " where id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        if (result == 0)
            System.out.println("User was not updated from DB");
        else
            System.out.println("User updated successfully");
    }

    public UserPOCO get_user_by_username(String username){
        UserPOCO user = null;
        this.stm = this.openStatement();
        try {
            var result = stm.executeQuery("SELECT * FROM get_user_by_username(\'"+username+"\')");
            while (result.next()) {
                user =
                        new UserPOCO(result.getLong("id"),
                                result.getString("username"),
                                result.getString("userpassword"),
                                result.getString("email"),
                                result.getInt("user_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return user;
    }

    public UserPOCO log_in(String username,String userpassword){
        UserPOCO user = null;
        this.stm = this.openStatement();
        String query = "SELECT * FROM users where username=\""+username+"\" AND userpassword=\""+userpassword+"\"";
        try {
            var result = stm.executeQuery(query);
            while (result.next()) {
                user =
                        new UserPOCO(result.getLong("id"),
                                result.getString("username"),
                                result.getString("userpassword"),
                                result.getString("email"),
                                result.getInt("user_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeStatement(stm);
        return user;
    }

}
