/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.log.Log;
import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Adminis
 */
public class UserDAO {

    public boolean checkEmail(String email) {
        Connection connection = DBConnect.getConnecttion();
        String sql = "Select * from user where email = '" + email + "'";
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    public boolean insert(User u) {
        Connection connection = DBConnect.getConnecttion();
        String sql = "INSERT INTO user VALUES (?,?,?,?) ";
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setLong(1, u.getId());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setBoolean(4, u.isRole());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public User login(String email, String password) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "Select * from user where email = '" + email + "'" + "and password ='" + password + "'";
        PreparedStatement ps;
        User user = new User();
        try {
            ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getBoolean("role"));
                cons.close();
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
