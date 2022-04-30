//package com.spring.We_Fly_Project.Security;
//
//import com.spring.We_Fly_Project.DB_Repository.DAO.UsersDAO;
//import com.spring.We_Fly_Project.DB_Repository.Service.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.sql.DataSource;
//
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Autowired
//    DataSource dataSource;
//    @Autowired
//    LoginService loginService;
//    @Autowired
//    UsersDAO userRepo;
//
//    @Override // Authentication
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("SELECT \"username\", \"userpassword\", true from \"users\" where \"username\"=?")
//                .authoritiesByUsernameQuery("SELECT \"users\".\"username\",\"user_roles\".\"role_name\" from \"users\"\n" +
//                        "join \"user_roles\" on \"users\".\"user_role\" =\"user_roles\".\"id\"\n" +
//                        "where username=?")
//                .rolePrefix("ROLE_");
//
////        try {
////            auth.userDetailsService(loginService);
////        }
////        catch (Exception e){
////            System.out.println("No such user/password");
////        }
//
//
////        auth.inMemoryAuthentication()
////                .withUser("customer")
////                .password("customer")
////                .roles(Roles.CUSTOMER.name())
////                .and()
////                .withUser("admin")
////                .password("admin")
////                .roles(Roles.ADMIN.name())
////                .and()
////                .withUser("airline")
////                .password("airline")
////                .roles(Roles.AIRLINE.name());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Override // Authorization
//    protected void configure(HttpSecurity http) throws Exception {
//        //super.configure(http);
//        //disable CSRF:
////        http.csrf().disable();
//        http.csrf()
//                .disable()
//                .httpBasic().disable();
//
//        // It's important to start from Admin -> user -> not registered
//        http.authorizeHttpRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/airline/**").hasAnyRole("AIRLINE","ADMIN")
//                .antMatchers("/customer/**").hasAnyRole("CUSTOMER","ADMIN")
//                .antMatchers("/").permitAll()
//                .and()
//                .formLogin();
//
//    }
//}
//
