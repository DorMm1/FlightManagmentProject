package com.spring.We_Fly_Project.DB_Repository.POCO;

import java.util.Objects;

public class AirlineCompanyPOCO implements POCO{
    public long id;
    public String company_name;
    public int country_id;
    public long user_id;

    public AirlineCompanyPOCO(long id, String name, int country_id, long user_id) {
        this.id = id;
        this.company_name = name;
        this.country_id = country_id;
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirlineCompanyPOCO)) return false;
        AirlineCompanyPOCO that = (AirlineCompanyPOCO) o;
        return id == that.id && country_id == that.country_id && user_id == that.user_id && Objects.equals(company_name, that.company_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company_name, country_id, user_id);
    }

    @Override
    public String toString() {
        return "AirlineCompanyPOCO{" +
                "airline_id=" + id +
                ", name='" + company_name + '\'' +
                ", country_id=" + country_id +
                ", user_id=" + user_id +
                '}';
    }
}
