/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author Adminis
 */
public class ProductDAO {

    // get danh sach san pham theo category
    public ArrayList<Product> getListProductByCategory(long catid, long start, long limit) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "Select * from product where catid='" + catid + "' LIMIT ?,?";
        PreparedStatement ps;
        try {
            ps = cons.prepareCall(sql);
            ps.setLong(1, start);
            ps.setLong(2, limit);
            ResultSet rs = ps.executeQuery();
            ArrayList<Product> list = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCatid(rs.getInt("catid"));
                product.setImage(rs.getString("image"));
                product.setPrice(rs.getDouble("price"));
                list.add(product);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Product> ArrayList = new ArrayList<>();
        return ArrayList;

    }

    public long coutProductByCategory(long catid) {
        long count = 0;
        Connection cons = DBConnect.getConnecttion();
        String sql = "Select count(*) FROM product where catid = " + catid;
        PreparedStatement ps;
        try {
            ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getLong(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public Product getProductByID(long id) throws SQLException {
        Connection cons = DBConnect.getConnecttion();
        String sql = "Select * from product where id='" + id + "'";
        PreparedStatement ps = cons.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Product product = new Product();
        while (rs.next()) {
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setCatid(rs.getInt("catid"));
            product.setImage(rs.getString("image"));
            product.setPrice(rs.getDouble("price"));
        }
        return product;
    }

}
