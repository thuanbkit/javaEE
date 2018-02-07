/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Adminis
 */
public class CategoryDAO {

    public ArrayList<Category> getAllcategory() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = (Query) session.createQuery("from category");
        ArrayList<Category> list = (ArrayList<Category>) query.list();
        transaction.commit();
        return list;
    }
        public Category getcategory(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = (Query) session.createQuery("from category where name =:name");
        query.setParameter("name", name);
        Category list = (Category) query.uniqueResult();
        transaction.commit();
        return list;
    }
    public static void main(String[] args) {
       // System.out.println(new CategoryDAO().getAllcategory().size());
        System.out.println(new CategoryDAO().getcategory("abc"));
    }
}
