package com.spring.We_Fly_Project.DB_Repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

@Component
public class PostgreSQLConnection {

    private Connection connection = null;
    private Statement statement = null;

    public PostgreSQLConnection() {}

    public Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/weFlyDB",
                    "postgres", "14522563"
            );
            Date date = new Date();
            System.out.println(date+"|| --- Connecting to ---->>> DATABASE");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Statement getStatement(){
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

}
