package com.spring.We_Fly_Project.Controllers;

import com.spring.We_Fly_Project.BusinessLogics.Facades.*;
import com.spring.We_Fly_Project.DB_Repository.POCO.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    //need to use the customer details from the anon_facade
    CustomerFacade facade = new CustomerFacade();

@GetMapping("/create-customer")
    public String show_create_customer_page(){
    return "needs to show a form to fill your information - POST REQUEST with the body";
}
@PostMapping("/create-customer")
    public void create_customer(@RequestBody CustomerPOCO new_customer){
    facade.create_new_customer(new_customer.first_name,new_customer.last_name,new_customer.address
                                ,new_customer.phone_no,new_customer.credit_card_no);
}
@GetMapping("/update-customer")
    public String show_update_form(){
    return "needs to show a form to UPDATE your information - PUT REQUEST with the body";
}
@PutMapping("/update-customer/{id}")
    public void update_customer(@PathVariable long id, @RequestBody CustomerPOCO customer){
    facade.update_customer(customer,id);
}
@GetMapping("/tickets/")
    public List<TicketPOCO> get_all_tickets(){
    return facade.get_my_tickets();
}
@DeleteMapping("/tickets/remove")
    public void delete_ticket(@RequestBody TicketPOCO ticket){
    facade.remove_ticket(ticket);
}
@PostMapping("/tickets/add")
    public void add_ticket(@RequestBody TicketPOCO ticket){
    facade.add_ticket(ticket);
}

}
