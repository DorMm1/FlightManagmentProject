package com.spring.We_Fly_Project.DB_Repository.POCO;

public class User_RolesPOCO {
    public int id;
    public String role_name;

    public User_RolesPOCO(int id, String role_name) {
        this.id = id;
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "User_RolesPOCO{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
