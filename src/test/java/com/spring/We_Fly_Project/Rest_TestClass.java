package com.spring.We_Fly_Project;

import com.spring.We_Fly_Project.DB_Repository.POCO.CustomerPOCO;
import com.spring.We_Fly_Project.DB_Repository.POCO.FlightPOCO;
import com.spring.We_Fly_Project.DB_Repository.POCO.TicketPOCO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class Rest_TestClass {
    @Test
    public void getFlight_AnonymousController_Test(){
        String url = "http://localhost:8080/flights/1";
        var current = new FlightPOCO(1,1,2,4,
                "2022-04-06 12:07:59.601261","2022-04-06 12:07:59.601261",85);
        System.out.println("Http_Response_Code:"+HttpTestManger.getHTPPResponseCode(url));
        var expected = HttpTestManger.getGETResponse(url,FlightPOCO.class);
        Assert.assertEquals(current,expected);
    }
    @Test
    public void getTickets_CustomerController_Test(){
        String url = "http://localhost:8080/customer/tickets/";
        var current = new TicketPOCO(55555,1,1);
        System.out.println("Http_Response_Code:"+HttpTestManger.getHTPPResponseCode(url));
        var expected = HttpTestManger.getGETResponse(url,TicketPOCO[].class);
        Assert.assertEquals(current, Arrays.stream(expected).findFirst().get());

    }
    @Test
    public void getFlight_AirlineController_Test(){
        String url = "http://localhost:8080/airline/flights";
        var current = new FlightPOCO(1,1,2,4,
                "2022-04-06 12:07:59.601261","2022-04-06 12:07:59.601261",85);
        System.out.println("Http_Response_Code:"+HttpTestManger.getHTPPResponseCode(url));
        var expected = HttpTestManger.getGETResponse(url,FlightPOCO[].class);
        Assert.assertEquals(current, Arrays.stream(expected).findFirst().get());


    }
    @Test public void getCustomer_AdminController_Test(){
        String url = "http://localhost:8080/admin/customers";
        var current = new CustomerPOCO(1,"gary","gershon","ramatgan","0521234123"
                ,"45808885588558",3);
        System.out.println("Http_Response_Code:"+HttpTestManger.getHTPPResponseCode(url));
        var expected = HttpTestManger.getGETResponse(url,CustomerPOCO[].class);
        Assert.assertEquals(current, Arrays.stream(expected).findFirst().get());
    }


}
