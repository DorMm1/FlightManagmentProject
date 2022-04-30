package com.spring.We_Fly_Project;

import com.spring.We_Fly_Project.Controllers.AdminController;
import com.spring.We_Fly_Project.DB_Repository.POCO.CountryPOCO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication()
//@EnableAspectJAutoProxy(proxyTargetClass=true)
public class WeFlyProjectApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(WeFlyProjectApplication.class, args);
		//Aspect Testing:
//		AdminController ac = new AdminController();
//		var controller = context.getBean(AdminController.class);
//		controller.add_country(new CountryPOCO(78990,"c19"));

	}



}

