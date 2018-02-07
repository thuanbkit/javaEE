/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProductDAO;
import java.util.ArrayList;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Adminis
 */
public class ProductService {
    @Autowired
    ProductDAO productDAO;
    public ArrayList<Product> getProductByCategory(long id) {
        return productDAO.getProductByCategory(id);
    }
    public ArrayList<Product> getProductRandom() {
        return productDAO.getProductRandom();
    }
}
