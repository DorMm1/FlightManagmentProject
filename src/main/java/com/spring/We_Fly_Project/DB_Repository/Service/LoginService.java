package com.spring.We_Fly_Project.DB_Repository.Service;

import com.spring.We_Fly_Project.DB_Repository.DAO.UsersDAO;
import com.spring.We_Fly_Project.DB_Repository.POCO.UserPOCO;
import com.spring.We_Fly_Project.Security.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailsService")
public class LoginService implements UserDetailsService {
    @Autowired
    UsersDAO usersDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPOCO current = usersDAO.get_user_by_username(username);
        if(current!=null) {
            int current_role = current.user_role;
            Roles role;
            switch (current_role) {
                default:
                    role = Roles.CUSTOMER;
                    break;
                case 1:
                    role = Roles.AIRLINE;
                    break;
                case 2:
                    role = Roles.ADMIN;
                    break;
            }
            var userBuilder = User.withUsername(current.username)
                    .password(current.userpassword)
                    .disabled(false)
                    .authorities(role.name())
                    .build();

            return userBuilder;
        }
        return null;
    }
}
