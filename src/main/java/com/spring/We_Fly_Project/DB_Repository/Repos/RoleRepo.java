//package com.spring.We_Fly_Project.DB_Repository.Repos;
//
//import com.spring.We_Fly_Project.DB_Repository.DAO.User_RolesDAO;
//import org.springframework.data.repository.CrudRepository;
//
//public interface RoleRepo extends CrudRepository<String,Integer> {
//    User_RolesDAO user_roleDAO = new User_RolesDAO();
//    default String findByName(String username){
//        return user_roleDAO.getRoleByUsername(username);
//    }
//}
