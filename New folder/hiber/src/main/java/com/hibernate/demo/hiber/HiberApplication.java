package com.hibernate.demo.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HiberApplication {

	public static void main(String[] args) {
//		Name n= new Name();
//		n.setFname("Shyam");
//		n.setMname("Shankar");
//		n.setLname("Shetty");
//		Studentos s =new Studentos();
//		s.setId(1);
//		s.setName(n);
//		s.setCity("Tiruvananthapuram");


		Configuration con= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Studentos.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(reg);

		Session session = sf.openSession();


		Transaction tx = session.beginTransaction();

//		session.save(s);
		Studentos s=(Studentos) session.get(Studentos.class,2);
		tx.commit();
		System.out.println(s);


	}

}
