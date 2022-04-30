package com.spring.We_Fly_Project.DB_Repository.POCO;

import java.util.Objects;

public class AdministratorPOCO implements POCO{

    public int id;
    public String first_name;
    public String last_name;
    public long user_id;

    public AdministratorPOCO(int id, String first_name, String last_name, long user_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdministratorPOCO)) return false;
        AdministratorPOCO that = (AdministratorPOCO) o;
        return id == that.id && user_id == that.user_id && Objects.equals(first_name, that.first_name) && Objects.equals(last_name, that.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, user_id);
    }

    @Override
    public String toString() {
        return "AdministratorPOCO{" +
                "admin_id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
