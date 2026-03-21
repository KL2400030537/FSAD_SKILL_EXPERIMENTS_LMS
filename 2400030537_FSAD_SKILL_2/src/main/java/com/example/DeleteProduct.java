package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteProduct {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class,1);

        if(p!=null){
            session.remove(p);
        }

        tx.commit();
        session.close();

        System.out.println("Deleted");
    }
}