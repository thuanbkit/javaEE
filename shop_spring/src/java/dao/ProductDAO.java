/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

import model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Adminis
 */
public class ProductDAO {
    public ArrayList<Product> getProductByCategory(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = (Query) session.createQuery("from product where catid= :id");
        query.setLong("id", id);
        ArrayList<Product> list = (ArrayList<Product>) query.list();
        transaction.commit();
        return list; 
    }
    public ArrayList<Product> getProductRandom() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from product order by rand()");
        query.setMaxResults(6);
        ArrayList<Product> list = (ArrayList<Product>) query.list();
        transaction.commit();
        return list;
    }
            
    
}
