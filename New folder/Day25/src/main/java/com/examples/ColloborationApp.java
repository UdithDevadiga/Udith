package com.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ColloborationApp {
    public static void main(String[] args) {
        Laptop lp = new Laptop();
        lp.setLid(100);
        lp.setLname("Macbook Air m1");
        Estudiante es = new Estudiante();
        es.setCity("Bangalore");
        es.setId(1);
        es.setName("Rajendra Prasad");
        es.setLaptop(lp);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(es);
        session.save(lp);


        tx.commit();
    }
}
