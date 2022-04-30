//package com.spring.We_Fly_Project.DB_Repository.Repos;
//
//import com.spring.We_Fly_Project.DB_Repository.DAO.UsersDAO;
//import com.spring.We_Fly_Project.DB_Repository.POCO.UserPOCO;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.Optional;
//
//public interface UserRepo extends CrudRepository<UserPOCO, Long> {
//    UsersDAO userDAO = new UsersDAO();
//    default UserPOCO findbyUsername(String username){
//        return userDAO.get_user_by_username(username);
//    }
//
//}
