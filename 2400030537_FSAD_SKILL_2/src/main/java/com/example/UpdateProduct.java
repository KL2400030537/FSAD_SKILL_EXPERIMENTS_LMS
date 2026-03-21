package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateProduct {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class,1);

        if(p!=null){
            p.setPrice(80000);
        }

        tx.commit();
        session.close();

        System.out.println("Updated");
    }
}