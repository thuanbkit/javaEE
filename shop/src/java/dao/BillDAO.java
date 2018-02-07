/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill;

/**
 *
 * @author Adminis
 */
public class BillDAO {

    public void insert(Bill b) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "INSERT INTO bill VALUES (?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = cons.prepareCall(sql);
            ps.setLong(1, b.getId());
            ps.setLong(2, b.getUser_id());
            ps.setDouble(3, b.getTotal());
            ps.setString(4, b.getPayment());
            ps.setString(5, b.getAddress());
            ps.setTimestamp(6, b.getDate());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void main(String[] args) {
        new BillDAO().insert(new Bill(1, 0, 0, "222", "222", new Timestamp(new Date().getTime())));
    }
}
