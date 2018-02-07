/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDAO;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Adminis
 */
public class UserService {
    @Autowired
    UserDAO userDAO;
    public boolean insert(User user) {
        return userDAO.insertUser(user);
    }
    public User login(String email,String password) {
        return userDAO.login(email, password);
    }
    
}
