package com.example;

import org.hibernate.Session;

public class GetProduct {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Product p = session.get(Product.class,1);

        if(p!=null){
            System.out.println(p.getName()+" "+p.getPrice());
        }

        session.close();
    }
}