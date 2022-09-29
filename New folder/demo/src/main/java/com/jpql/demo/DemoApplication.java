package com.jpql.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_details");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("Select s.name from student s");
		@SuppressWarnings("unchecked")
		List<String> list = query.getResultList();
		System.out.println("Student Name : ");
		for(String s:list) {
			System.out.println(s);
		}
	}

}
