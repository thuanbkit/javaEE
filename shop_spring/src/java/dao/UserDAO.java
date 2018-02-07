/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Adminis
 */
public class UserDAO {

    public boolean insertUser(User user) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean checkEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from user where email = :email");
        query.setString("email", email);
        User user = (User) query.uniqueResult();
        transaction.commit();
        return user != null;
    }
    public User login(String email, String password) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from user where email = :email and password = :password");
            query.setString("email", email);
            query.setString("password", password);
            User user = (User) query.uniqueResult();
            transaction.commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
