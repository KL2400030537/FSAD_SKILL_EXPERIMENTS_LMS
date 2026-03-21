package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertProduct {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(new Product("Laptop","Electronics",75000,10));
        session.persist(new Product("Mouse","Electronics",500,50));

        tx.commit();
        session.close();

        System.out.println("Inserted Successfully");
    }
}