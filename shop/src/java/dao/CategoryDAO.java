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
import model.Category;

/**
 *
 * @author Adminis
 */
public class CategoryDAO {

    // get danh sach category
    public ArrayList<Category> getListCategory() throws SQLException {
        Connection connection = DBConnect.getConnecttion();
        String sql = "Select * from category";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Category> list = new ArrayList<>();
        while (rs.next()) {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            list.add(category);
        }
        return list;
    }
    // get categoryc
    public Category getItem(Long id) {
        Category category = new Category();
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM category where id = ?";
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                category.setId(rs.getLong("id"));
                category.setName(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }

    // them moi du lieu
    public boolean insert(Category category) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "INSERT INTO category (name) VALUES (?)";
        PreparedStatement ps;
        try {
            ps = cons.prepareCall(sql);
            ps.setString(1, category.getName());
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    // cập nhật dữ liệu
    public boolean update(Category category) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "UPDATE category SET name = ? WHERE id = ?";
        PreparedStatement ps;
        try {
            ps = cons.prepareCall(sql);
            ps.setString(1, category.getName());
            ps.setLong(2, category.getId());
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean destroy(Category category) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "DELETE FROM category where id = ?";
        PreparedStatement ps;
        try {
            ps = cons.prepareCall(sql);
            ps.setLong(1, category.getId());
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public static void main(String[] args) throws SQLException {
        CategoryDAO dao = new CategoryDAO();
        Category cate = new Category();
        cate.setName("Táo 2");
        dao.insert(cate);
    }

}
