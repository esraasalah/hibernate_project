/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import enitiy.Products;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author M.Gebaly
 */
public class ProductTableOperations {

    Session session;

    public boolean addProduct(Products product) {

        boolean retValue = true;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                System.out.println("Transaction is being rolled back.");
                session.getTransaction().rollback();
                retValue = false;
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return retValue;

    }

    public List<Products> getAllProducts() {

        session = HibernateUtil.getSessionFactory().openSession();
        Query getAllPro = session.createQuery("from Products");
        List result = getAllPro.list();
        session.close();
        return result;
    }

    public Products getSpecificProducts(String productId) {
        session = HibernateUtil.getSessionFactory().openSession();
        Products product = new Products();
        session.beginTransaction();
        Query getProductById = session.createQuery("from Products p where p.productId like :productId").setBigDecimal("productId", new BigDecimal(productId).setScale(1));
        List<Products> list = getProductById.list();
        product = list.get(0);
        session.getTransaction().commit();

        session.close();
        return product;

    }

    public void updateProduct(Products prouduct) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction update = session.beginTransaction();
        session.update(prouduct);
        update.commit();
        session.close();

    }



    public int deleteProduct(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete Products where productId= :id");//.setBigDecimal("id", new BigDecimal(id));
        query.setParameter("id", new BigDecimal(id));
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return id;
    }


}

