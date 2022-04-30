package com.spring.We_Fly_Project.DB_Repository.POCO;

import java.util.Objects;

public class TicketPOCO implements POCO{

    public long id;
    public long flight_id;
    public long customer_id;

    public TicketPOCO(long id, long flight_id, long customer_id) {
        this.id = id;
        this.flight_id = flight_id;
        this.customer_id = customer_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketPOCO)) return false;
        TicketPOCO that = (TicketPOCO) o;
        return id == that.id && flight_id == that.flight_id && customer_id == that.customer_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flight_id, customer_id);
    }

    @Override
    public String toString() {
        return "TicketPOCO{" +
                "ticket_id=" + id +
                ", flight_id=" + flight_id +
                ", customer_id=" + customer_id +
                '}';
    }
}
