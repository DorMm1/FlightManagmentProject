package com.spring.We_Fly_Project.DB_Repository.DAO;


import com.spring.We_Fly_Project.DB_Repository.PostgreSQLConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface DAO<T>{

    //mixing abit the sense of an interface when using constant attributes yet it was effective in run time,
    //easier to implement than opening another abstract class
    PostgreSQLConnection postgreSQLConnection = new PostgreSQLConnection();
    Connection connection = postgreSQLConnection.getConnection();

    T get(long id);
    List getAll();
    void add(T t);
    void remove(T t);
    void update(T t,long id);

    default Statement openStatement(){
        return postgreSQLConnection.getStatement();
    }
    default void closeStatement(Statement statement){
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) { /* Ignored */}
        }
    }

}
