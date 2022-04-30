package com.spring.We_Fly_Project.DB_Repository.POCO;

import java.util.Objects;

public class CustomerPOCO implements POCO{

    public long id;
    public String first_name;
    public String last_name;
    public String address;
    public String phone_no;
    public String credit_card_no;
    public long user_id;

    public CustomerPOCO(long id, String first_name, String last_name, String address, String phone_no, String credit_card_no, long user_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.phone_no = phone_no;
        this.credit_card_no = credit_card_no;
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerPOCO)) return false;
        CustomerPOCO that = (CustomerPOCO) o;
        return id == that.id && user_id == that.user_id && Objects.equals(first_name, that.first_name) && Objects.equals(last_name, that.last_name) && Objects.equals(address, that.address) && Objects.equals(phone_no, that.phone_no) && Objects.equals(credit_card_no, that.credit_card_no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, address, phone_no, credit_card_no, user_id);
    }

    @Override
    public String toString() {
        return "CustomerPOCO{" +
                "customer_id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", credit_card_no='" + credit_card_no + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
