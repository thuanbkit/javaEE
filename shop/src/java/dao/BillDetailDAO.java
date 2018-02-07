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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BillDetail;

/**
 *
 * @author Adminis
 */
public class BillDetailDAO {
    public void insert(BillDetail bDetail) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "INSERT INTO bill_detail VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ps.setLong(1,bDetail.getId());
            ps.setLong(2, bDetail.getBill_id());
            ps.setLong(3, bDetail.getProduct_id());
            ps.setDouble(4, bDetail.getPrice());
            ps.setLong(5,bDetail.getQuantity());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        new BillDetailDAO().insert(new BillDetail(1, 1, 1, 1, 1));
    }
    
}
